package co.rsk.rnssdk;

import android.support.annotation.VisibleForTesting;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.WalletUtils;
import org.web3j.ens.NameHash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.HashMap;
import java.util.Map;

import co.rsk.rnssdk.contracts.AbstractMultiChainResolver;
import co.rsk.rnssdk.contracts.AbstractResolver;
import co.rsk.rnssdk.contracts.RNS;
import co.rsk.rnssdk.contracts.ResolverInterface;

public class RnsResolver {

    public static final byte[] CHAIN_ADDR_INTERFACE = Hex.decode("8be4b5f6");
    public static final byte[] ADDR_INTERFACE = Hex.decode("3b3b57de");
    public static final byte[] RSK_CHAIN_ID = Hex.decode("80000089");
    public static final String OK_STATUS = "0x1";

    private final Web3j web3;
    private final RNS rns;
    private String defaultResolver;
    public final static String EMPTY_ADDRESS = "0x0000000000000000000000000000000000000000";

    //The default resolver is to MainNet
    public RnsResolver() {
        this(BuildConfig.NODE, BuildConfig.RESOLVER_ADDRESS, BuildConfig.RNS_ADDRESS);
    }

    public RnsResolver(String nodeDir, String publicResolverAddress, String rnsAddress) {
        this(Web3j.build(new HttpService(nodeDir)), publicResolverAddress, rnsAddress);
    }

    public RnsResolver(Web3j web3, String defaultResolver, String rnsAddress) {
        this.web3 = web3;
        this.defaultResolver = defaultResolver;
        ClientTransactionManager transactionManager = new ClientTransactionManager(web3,null);
        this.rns = RNS.load(
                rnsAddress,
                web3,
                transactionManager,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
    }

    @VisibleForTesting
    public AbstractResolverResult getResolver(String name, String from) {
        return loadResolver(name, from);
    }

    //Backwards compatibility
    public boolean setAddress(String name, String address, String from) throws Exception {
        return setAddress(name, address, from, RSK_CHAIN_ID);
    }

    //TODO: refactor with strategy pattern
    public boolean setAddress(String name, String address, String from, byte[] chainId) throws Exception {
        AbstractResolverResult result = loadResolver(name, from);
        if (chainId == null || chainId.length != 4) {
            chainId = RSK_CHAIN_ID;
        }
        byte[] node = NameHash.nameHashAsBytes(name);
        if (result.getResolver().supportsInterface(CHAIN_ADDR_INTERFACE).send()) {
            AbstractMultiChainResolver multi = AbstractMultiChainResolver.load(result.getResolverAddress(),
                    web3,
                    result.getClientTransactionManager(),
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT);
            return  multi.setChainAddr(node, chainId, address).send().getStatus().equals(OK_STATUS);
        } else if (result.getResolver().supportsInterface(ADDR_INTERFACE).send()) {
            ResolverInterface noMulti = ResolverInterface.load(result.getResolverAddress(),
                    web3,
                    result.getClientTransactionManager(),
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT);
            return noMulti.setAddr(node, address).send().getStatus().equals(OK_STATUS);
        }
        return false;
    }

    //backwards compatibility
    public String getAddress(String name) throws Exception {
        return getAddress(name, RSK_CHAIN_ID);
    }

    //TODO: refactor with strategy pattern
    public String getAddress(String name, byte[] chainId) throws Exception {
        if (isValidRnsName(name)) {
            AbstractResolverResult result = loadResolver(name, null);
            byte[] node = NameHash.nameHashAsBytes(name);
            if (result.getResolver().supportsInterface(CHAIN_ADDR_INTERFACE).send()) {
                AbstractMultiChainResolver multi = AbstractMultiChainResolver.load(result.getResolverAddress(),
                        web3,
                        result.getClientTransactionManager(),
                        DefaultGasProvider.GAS_PRICE,
                        DefaultGasProvider.GAS_LIMIT);
                return multi.chainAddr(node, chainId).send();
            } else if (result.getResolver().supportsInterface(ADDR_INTERFACE).send()) {
                ResolverInterface noMulti = ResolverInterface.load(result.getResolverAddress(),
                        web3,
                        result.getClientTransactionManager(),
                        DefaultGasProvider.GAS_PRICE,
                        DefaultGasProvider.GAS_LIMIT);
                return noMulti.addr(node).send();
            }
        }
        return Hex.toHexString(new byte[0]);
    }

    Map<String, AbstractResolverResult> cache = new HashMap<>();

    private AbstractResolverResult loadResolver(String node) {
        return loadResolver(node, null);
    }

    private AbstractResolverResult loadResolver(String node, String from) {
        AbstractResolverResult result = cache.get(node+":"+from);
        String resolverAddress;
        if (result == null) {
            ClientTransactionManager transactionManager = new ClientTransactionManager(web3,from);

            try {
                resolverAddress = rns.resolver(NameHash.nameHashAsBytes(node)).send();
                resolverAddress = resolverAddress.equals(EMPTY_ADDRESS)? this.defaultResolver :resolverAddress;
            } catch (Exception e) {
                resolverAddress = this.defaultResolver;
            }

            AbstractResolver resolver = AbstractResolver.load(
                    resolverAddress,
                    web3,
                    transactionManager,
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT);
            result = new AbstractResolverResult(resolver, resolverAddress, transactionManager);
            cache.put(node+":"+from, result);
        }

        return result;
    }

    private boolean isValidRnsName(String input) {
        return input != null && (input.contains(".") || !WalletUtils.isValidAddress(input));
    }

    public void setContent(String name, byte[] hash, String from) throws Exception {
        AbstractResolverResult result = loadResolver(name, from);
        ResolverInterface resolver = ResolverInterface.load(
                result.getResolverAddress(),
                web3,
                result.getClientTransactionManager(),
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
        resolver.setContent(NameHash.nameHashAsBytes(name), hash).send();
    }

    public byte[] content(String name) throws Exception {
        AbstractResolverResult result = loadResolver(name);
        ResolverInterface resolver = ResolverInterface.load(
                result.getResolverAddress(),
                web3,
                result.getClientTransactionManager(),
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
        return resolver.content(NameHash.nameHashAsBytes(name)).send();
    }

    public Boolean has(String name, String kind) throws Exception {
        AbstractResolverResult result = loadResolver(name);
        ResolverInterface resolver = ResolverInterface.load(
                result.getResolverAddress(),
                web3,
                result.getClientTransactionManager(),
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
        return resolver.has(NameHash.nameHashAsBytes(name), NameHash.nameHashAsBytes(kind)).send();
    }

    public Boolean supportsInterface(String name, String interfaceID) throws Exception {
        AbstractResolverResult result = loadResolver(name);
        ResolverInterface resolver = ResolverInterface.load(
                result.getResolverAddress(),
                web3,
                result.getClientTransactionManager(),
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
        return resolver.supportsInterface(Hex.decode(interfaceID)).send();
    }

}
