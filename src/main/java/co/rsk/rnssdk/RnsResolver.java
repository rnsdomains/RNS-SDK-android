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

import co.rsk.rnssdk.contracts.PublicResolver;
import co.rsk.rnssdk.contracts.RNS;
import co.rsk.rnssdk.contracts.ResolverInterface;

public class RnsResolver {

    private final Web3j web3;
    private final RNS rns;
    private String publicResolverAddress;
    public final static String EMPTY_ADDRESS = "0x0000000000000000000000000000000000000000";
    private PublicResolver publicResolver;

    //The default resolver is to MainNet
    public RnsResolver() {
        this(BuildConfig.NODE, BuildConfig.RESOLVER_ADDRESS, BuildConfig.RNS_ADDRESS);
    }

    public RnsResolver(String nodeDir, String publicResolverAddress, String rnsAddress) {
        this(Web3j.build(new HttpService(nodeDir)), publicResolverAddress, rnsAddress);
    }

    public RnsResolver(Web3j web3, String publicResolverAddress, String rnsAddress) {
        this.web3 = web3;
        this.publicResolverAddress = publicResolverAddress;
        ClientTransactionManager transactionManager = new ClientTransactionManager(web3,null);
        this.rns = RNS.load(
                rnsAddress,
                web3,
                transactionManager,
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT);
    }

    @VisibleForTesting
    public ResolverInterface getResolver(String name, String from) {
        return loadResolver(name, from);
    }

    public boolean setAddress(String name, String address, String from) throws Exception {
        ResolverInterface resolver = loadResolver(name, from);
        return resolver.setAddr(NameHash.nameHashAsBytes(name), address).send().getStatus().equals("0x1");
    }

    public String getAddress(String name) throws Exception {
        if (isValidRnsName(name)) {
            return loadResolver(name,null).addr(NameHash.nameHashAsBytes(name)).send();
        }
        return name;
    }

    Map<String, ResolverInterface> cache = new HashMap<>();

    private ResolverInterface loadResolver(String node, String from) {
        ResolverInterface resolver = cache.get(node+":"+from);
        if (resolver == null) {
            ClientTransactionManager transactionManager = new ClientTransactionManager(web3,from);

            String resolverAddress;
            try {
                resolverAddress = rns.resolver(NameHash.nameHashAsBytes(node)).send();
                resolverAddress = resolverAddress.equals(EMPTY_ADDRESS)?publicResolverAddress:resolverAddress;
            } catch (Exception e) {
                resolverAddress = publicResolverAddress;
            }

            resolver = ResolverInterface.load(
                    resolverAddress,
                    web3,
                    transactionManager,
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT);
            cache.put(node+":"+from, resolver);
        }

        /*cache.put(from,resolver);*/
        return resolver;
    }

    private boolean isValidRnsName(String input) {
        return input != null && (input.contains(".") || !WalletUtils.isValidAddress(input));
    }

    public void setContent(String name, byte[] hash, String from) throws Exception {
        loadResolver(name, from).setContent(NameHash.nameHashAsBytes(name), hash).send();
    }

    public byte[] content(String name) throws Exception {
        return loadResolver(name, null).content(NameHash.nameHashAsBytes(name)).send();
    }

    public Boolean has(String name, String kind) throws Exception {
        return loadResolver(name, null).has(NameHash.nameHashAsBytes(name), NameHash.nameHashAsBytes(kind)).send();
    }

    public Boolean supportsInterface(String name, String interfaceID) throws Exception {
        return loadResolver(name, null).supportsInterface(Hex.decode(interfaceID)).send();
    }

}
