package co.rsk.rnssdk;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class SubdomainRegistrar extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516040806105548339810180604052604081101561003057600080fd5b810190808051906020019092919080519060200190929190505050816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060018190555033600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050610470806100e46000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631d7876e714610051578063663b44c51461005b578063e1fa8e84146100a5578063faff50a8146100d3575b600080fd5b6100596100f1565b005b610063610231565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6100d1600480360360208110156100bb57600080fd5b8101908080359060200190929190505050610256565b005b6100db61043e565b6040518082815260200191505060405180910390f35b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461014b57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635b0fc9c3600154600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561021757600080fd5b505af115801561022b573d6000803e3d6000fd5b50505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600154826040516020018083815260200182815260200192505050604051602081830303815290604052805190602001209050600073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561031557600080fd5b505afa158015610329573d6000803e3d6000fd5b505050506040513d602081101561033f57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461037057600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166306ab592360015484336040518463ffffffff1660e01b8152600401808481526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b15801561042257600080fd5b505af1158015610436573d6000803e3d6000fd5b505050505050565b6001548156fea165627a7a7230582087b3c0cdf8ab5dcf6324935906a3b7a5e254997b8063393322450827cbbffeb70029";

    public static final String FUNC_RNS = "rns";

    public static final String FUNC_ROOTNODE = "rootNode";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_TRANSFERBACK = "transferBack";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected SubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> rns() {
        final Function function = new Function(FUNC_RNS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> rootNode() {
        final Function function = new Function(FUNC_ROOTNODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> register(byte[] label) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(label)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferBack() {
        final Function function = new Function(
                FUNC_TRANSFERBACK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SubdomainRegistrar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SubdomainRegistrar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SubdomainRegistrar(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SubdomainRegistrar(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _rns, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(SubdomainRegistrar.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<SubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _rns, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(SubdomainRegistrar.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _rns, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(SubdomainRegistrar.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _rns, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(SubdomainRegistrar.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
