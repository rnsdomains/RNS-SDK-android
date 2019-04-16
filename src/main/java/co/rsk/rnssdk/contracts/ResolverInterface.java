package co.rsk.rnssdk.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
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
 * <p>Generated with web3j version 4.1.1.
 */
public class ResolverInterface extends Contract {
    private static final String BINARY = "";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_CONTENT = "content";

    public static final String FUNC_ADDR = "addr";

    public static final String FUNC_HAS = "has";

    public static final String FUNC_SETCONTENT = "setContent";

    public static final String FUNC_SETADDR = "setAddr";

    public static final String FUNC_PUBLICRESOLVER = "PublicResolver";

    @Deprecated
    protected ResolverInterface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ResolverInterface(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ResolverInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ResolverInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceID) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<byte[]> content(byte[] node) {
        final Function function = new Function(FUNC_CONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> addr(byte[] node) {
        final Function function = new Function(FUNC_ADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> has(byte[] node, byte[] kind) {
        final Function function = new Function(FUNC_HAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(kind)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setContent(byte[] node, byte[] hashValue) {
        final Function function = new Function(
                FUNC_SETCONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(hashValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setAddr(byte[] node, String addrValue) {
        final Function function = new Function(
                FUNC_SETADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.Address(addrValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> PublicResolver(String rnsAddr) {
        final Function function = new Function(
                FUNC_PUBLICRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rnsAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ResolverInterface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ResolverInterface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ResolverInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ResolverInterface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ResolverInterface load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ResolverInterface(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ResolverInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ResolverInterface(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ResolverInterface> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ResolverInterface.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ResolverInterface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ResolverInterface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ResolverInterface> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ResolverInterface.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ResolverInterface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ResolverInterface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
