package co.rsk.rnssdk;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class PublicResolver extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405160208061072f8339810180604052602081101561003057600080fd5b8101908080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505061069e806100916000396000f3fe6080604052600436106100555760003560e01c806301ffc9a71461005a5780632dff6941146100cc5780633b3b57de1461011b57806341b9dc2b14610196578063c3d014d6146101f3578063d5fa2b0014610238575b600080fd5b34801561006657600080fd5b506100b26004803603602081101561007d57600080fd5b8101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610293565b604051808215151515815260200191505060405180910390f35b3480156100d857600080fd5b50610105600480360360208110156100ef57600080fd5b81019080803590602001909291905050506102f5565b6040518082815260200191505060405180910390f35b34801561012757600080fd5b506101546004803603602081101561013e57600080fd5b8101908080359060200190929190505050610312565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101a257600080fd5b506101d9600480360360408110156101b957600080fd5b81019080803590602001909291908035906020019092919050505061034f565b604051808215151515815260200191505060405180910390f35b3480156101ff57600080fd5b506102366004803603604081101561021657600080fd5b810190808035906020019092919080359060200190929190505050610434565b005b34801561024457600080fd5b506102916004803603604081101561025b57600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610536565b005b6000633b3b57de60e01b827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614806102ee575063d8389dc560e01b827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b9050919050565b600060026000838152602001908152602001600020549050919050565b60006001600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60007f6164647200000000000000000000000000000000000000000000000000000000821480156103e05750600073ffffffffffffffffffffffffffffffffffffffff166001600085815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b8061042c57507f68617368000000000000000000000000000000000000000000000000000000008214801561042b57506000801b600260008581526020019081526020016000205414155b5b905092915050565b813373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156104be57600080fd5b505afa1580156104d2573d6000803e3d6000fd5b505050506040513d60208110156104e857600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461051957600080fd5b816002600085815260200190815260200160002081905550505050565b813373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156105c057600080fd5b505afa1580156105d4573d6000803e3d6000fd5b505050506040513d60208110156105ea57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461061b57600080fd5b816001600085815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505056fea165627a7a723058207486e0889ed666dd6ee8a5a32c968be4c6aa5bc936df418968fdcc39ea43729b0029";

    public static final String FUNC_HAS = "has";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_ADDR = "addr";

    public static final String FUNC_SETADDR = "setAddr";

    public static final String FUNC_CONTENT = "content";

    public static final String FUNC_SETCONTENT = "setContent";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected PublicResolver(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PublicResolver(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PublicResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PublicResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> has(byte[] node, byte[] kind) {
        final Function function = new Function(FUNC_HAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(kind)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceID) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> addr(byte[] node) {
        final Function function = new Function(FUNC_ADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setAddr(byte[] node, String addrValue) {
        final Function function = new Function(
                FUNC_SETADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.Address(addrValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> content(byte[] node) {
        final Function function = new Function(FUNC_CONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setContent(byte[] node, byte[] hash) {
        final Function function = new Function(
                FUNC_SETCONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PublicResolver load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PublicResolver(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PublicResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PublicResolver(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PublicResolver load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PublicResolver(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PublicResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PublicResolver(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PublicResolver> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String rnsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rnsAddr)));
        return deployRemoteCall(PublicResolver.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PublicResolver> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String rnsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rnsAddr)));
        return deployRemoteCall(PublicResolver.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PublicResolver> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String rnsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rnsAddr)));
        return deployRemoteCall(PublicResolver.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PublicResolver> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String rnsAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rnsAddr)));
        return deployRemoteCall(PublicResolver.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
