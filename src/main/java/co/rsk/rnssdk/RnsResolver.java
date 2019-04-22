package co.rsk.rnssdk;

import android.support.annotation.VisibleForTesting;

import org.bouncycastle.util.encoders.Hex;
import org.web3j.compat.Compat;
import org.web3j.crypto.WalletUtils;
import org.web3j.ens.NameHash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.HashMap;
import java.util.Map;

import co.rsk.rnssdk.contracts.PublicResolver;

public class RnsResolver {

    private final Web3j web3;
    private String publicResolverAddress;
    private PublicResolver publicResolver;

    //The default resolver is to MainNet
    public RnsResolver() {
        this(BuildConfig.NODE, BuildConfig.RESOLVER_ADDRESS);
    }

    public RnsResolver(String nodeDir, String publicResolverAddress) {
        this(Web3j.build(new HttpService(nodeDir)), publicResolverAddress);
    }

    public RnsResolver(Web3j web3, String publicResolverAddress) {
        this.web3 = web3;
        this.publicResolverAddress = publicResolverAddress;
    }

    @VisibleForTesting
    public PublicResolver getResolver(String from) {
        return loadPublicResolver(from);
    }

    public boolean setAddress(String nameDomain, String address, String from) throws Exception {
        PublicResolver resolver = loadPublicResolver(from);
        return resolver.setAddr(NameHash.nameHashAsBytes(nameDomain), address).send().getStatus().equals("0x1");
    }

    public String getAddress(String name) throws Exception {
        if (isValidRnsName(name)) {
            return loadPublicResolver(null).addr(NameHash.nameHashAsBytes(name)).send();
        }
        return name;
    }

    Map<String, PublicResolver> cache = new HashMap<>();

    private PublicResolver loadPublicResolver(String from) {
        /*PublicResolver resolver = cache.get(from);
        if (resolver != null) {
            return resolver;
        }*/
        PublicResolver resolver = cache.get(from);
        if (resolver == null) {
            ClientTransactionManager transactionManager = new ClientTransactionManager(web3,from);
            resolver = PublicResolver.load(
                    publicResolverAddress,
                    web3,
                    transactionManager,
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT);
            cache.put(from, resolver);
        }

        /*cache.put(from,resolver);*/
        return resolver;
    }

    private boolean isValidRnsName(String input) {
        return input != null && (input.contains(".") || !WalletUtils.isValidAddress(input));
    }

    public void setContent(String name, byte[] hash, String from) throws Exception {
        loadPublicResolver(from).setContent(NameHash.nameHashAsBytes(name), hash).send();
    }

    public byte[] content(String name) throws Exception {
        return loadPublicResolver(null).content(NameHash.nameHashAsBytes(name)).send();
    }

    public Boolean has(String name, String kind) throws Exception {
        return loadPublicResolver(null).has(NameHash.nameHashAsBytes(name), NameHash.nameHashAsBytes(kind)).send();
    }

    public Boolean supportsInterface(String interfaceID) throws Exception {
        return loadPublicResolver(null).supportsInterface(Hex.decode(interfaceID)).send();
    }
}
