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
public class PublicSubdomainRegistrar extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516020806107a48339810180604052602081101561003057600080fd5b8101908080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610713806100916000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806318e7726d1461005c5780632f926732146100a2578063663b44c5146100da5780639d38ed0714610124578063c3254c2314610152575b600080fd5b6100886004803603602081101561007257600080fd5b8101908080359060200190929190505050610180565b604051808215151515815260200191505060405180910390f35b6100d8600480360360408110156100b857600080fd5b8101908080359060200190929190803590602001909291905050506101ec565b005b6100e26103d1565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101506004803603602081101561013a57600080fd5b81019080803590602001909291905050506103f6565b005b61017e6004803603602081101561016857600080fd5b81019080803590602001909291905050506105ac565b005b60008073ffffffffffffffffffffffffffffffffffffffff166001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614159050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be384846040516020018083815260200182815260200192505050604051602081830303815290604052805190602001206040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561028e57600080fd5b505afa1580156102a2573d6000803e3d6000fd5b505050506040513d60208110156102b857600080fd5b81019080805190602001909291905050509050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161461030457600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166306ab59238484336040518463ffffffff1660e01b8152600401808481526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b1580156103b457600080fd5b505af11580156103c8573d6000803e3d6000fd5b50505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b806001600082815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461046257600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635b0fc9c3836001600086815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561053d57600080fd5b505af1158015610551573d6000803e3d6000fd5b5050505060006001600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b803073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561063657600080fd5b505afa15801561064a573d6000803e3d6000fd5b505050506040513d602081101561066057600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461069157600080fd5b336001600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505056fea165627a7a72305820f5c224410b8b2aad978c149fc10dca7cd926acee5e646fdc0790463fde3412d80029";

    public static final String FUNC_RNS = "rns";

    public static final String FUNC_DELEGATE = "delegate";

    public static final String FUNC_ISDELEGATED = "isDelegated";

    public static final String FUNC_TRANSFERBACK = "transferBack";

    public static final String FUNC_REGISTER = "register";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected PublicSubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PublicSubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PublicSubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PublicSubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> rns() {
        final Function function = new Function(FUNC_RNS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> delegate(byte[] node) {
        final Function function = new Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isDelegated(byte[] node) {
        final Function function = new Function(FUNC_ISDELEGATED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transferBack(byte[] node) {
        final Function function = new Function(
                FUNC_TRANSFERBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> register(byte[] node, byte[] label) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(label)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PublicSubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PublicSubdomainRegistrar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PublicSubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PublicSubdomainRegistrar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PublicSubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PublicSubdomainRegistrar(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PublicSubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PublicSubdomainRegistrar(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PublicSubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _rns) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns)));
        return deployRemoteCall(PublicSubdomainRegistrar.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PublicSubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _rns) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns)));
        return deployRemoteCall(PublicSubdomainRegistrar.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PublicSubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _rns) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns)));
        return deployRemoteCall(PublicSubdomainRegistrar.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PublicSubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _rns) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns)));
        return deployRemoteCall(PublicSubdomainRegistrar.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
