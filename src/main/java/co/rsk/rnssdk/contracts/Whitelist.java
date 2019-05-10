package co.rsk.rnssdk.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class Whitelist extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506201518060038190555061073c8061006a6000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80638f6ca87c116100665780638f6ca87c14610215578063903eab921461026d578063ac18de431461028b578063c0cc365d146102cf578063f3ae2415146102fd5761009e565b806310154bad146100a3578063291d9549146100e75780632d06177a1461012b5780633af32abf1461016f5780638da5cb5b146101cb575b600080fd5b6100e5600480360360208110156100b957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610359565b005b610129600480360360208110156100fd57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506103fa565b005b61016d6004803603602081101561014157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610498565b005b6101b16004803603602081101561018557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061054b565b604051808215151515815260200191505060405180910390f35b6101d3610596565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6102576004803603602081101561022b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105bb565b6040518082815260200191505060405180910390f35b6102756105d3565b6040518082815260200191505060405180910390f35b6102cd600480360360208110156102a157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105d9565b005b6102fb600480360360208110156102e557600080fd5b810190808035906020019092919050505061068d565b005b61033f6004803603602081101561031357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106f0565b604051808215151515815260200191505060405180910390f35b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff166103af57600080fd5b6003544201600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1661045057600080fd5b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146104f157600080fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b600042600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054119050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60026020528060005260406000206000915090505481565b60035481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461063257600080fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146106e657600080fd5b8060038190555050565b60016020528060005260406000206000915054906101000a900460ff168156fea165627a7a7230582082bbc85ad208966bb409ac2dbb97cc2a7d03ead1845ab309114bba8c974412c00029";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_WHITELISTEDUNTIL = "whitelistedUntil";

    public static final String FUNC_WHITELISTEDTIME = "whitelistedTime";

    public static final String FUNC_ISMANAGER = "isManager";

    public static final String FUNC_ADDMANAGER = "addManager";

    public static final String FUNC_REMOVEMANAGER = "removeManager";

    public static final String FUNC_ADDWHITELISTED = "addWhitelisted";

    public static final String FUNC_REMOVEWHITELISTED = "removeWhitelisted";

    public static final String FUNC_ISWHITELISTED = "isWhitelisted";

    public static final String FUNC_SETEXPIRATIONTIME = "setExpirationTime";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Whitelist(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Whitelist(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Whitelist(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Whitelist(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> whitelistedUntil(String param0) {
        final Function function = new Function(FUNC_WHITELISTEDUNTIL,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> whitelistedTime() {
        final Function function = new Function(FUNC_WHITELISTEDTIME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isManager(String param0) {
        final Function function = new Function(FUNC_ISMANAGER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> addManager(String manager) {
        final Function function = new Function(
                FUNC_ADDMANAGER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(manager)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeManager(String manager) {
        final Function function = new Function(
                FUNC_REMOVEMANAGER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(manager)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addWhitelisted(String whitelisted) {
        final Function function = new Function(
                FUNC_ADDWHITELISTED,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(whitelisted)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeWhitelisted(String whitelisted) {
        final Function function = new Function(
                FUNC_REMOVEWHITELISTED,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(whitelisted)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isWhitelisted(String whitelisted) {
        final Function function = new Function(FUNC_ISWHITELISTED,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(whitelisted)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setExpirationTime(BigInteger time) {
        final Function function = new Function(
                FUNC_SETEXPIRATIONTIME,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(time)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Whitelist load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Whitelist(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Whitelist load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Whitelist(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Whitelist load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Whitelist(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Whitelist load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Whitelist(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Whitelist> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Whitelist.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Whitelist> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Whitelist.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Whitelist> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Whitelist.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Whitelist> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Whitelist.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
