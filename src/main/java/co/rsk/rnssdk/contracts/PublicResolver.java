package co.rsk.rnssdk.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
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
 * <p>Generated with web3j version 4.1.1.
 */
public class PublicResolver extends org.web3j.tx.Contract {

    private static final String BINARY = "608060405234801561001057600080fd5b506040516020806104fb833981016040525160008054600160a060020a03909216600160a060020a03199092169190911790556104a9806100526000396000f3006080604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166301ffc9a781146100895780632dff6941146100d45780633b3b57de146100fe57806341b9dc2b14610132578063c3d014d61461014d578063d5fa2b001461016a575b34801561008357600080fd5b50600080fd5b34801561009557600080fd5b506100c07bffffffffffffffffffffffffffffffffffffffffffffffffffffffff196004351661018e565b604080519115158252519081900360200190f35b3480156100e057600080fd5b506100ec600435610221565b60408051918252519081900360200190f35b34801561010a57600080fd5b50610116600435610233565b60408051600160a060020a039092168252519081900360200190f35b34801561013e57600080fd5b506100c060043560243561024e565b34801561015957600080fd5b506101686004356024356102de565b005b34801561017657600080fd5b50610168600435600160a060020a0360243516610399565b60007f3b3b57de000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff198316148061021b57507fd8389dc5000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff198316145b92915050565b60009081526002602052604090205490565b600090815260016020526040902054600160a060020a031690565b60007f6164647200000000000000000000000000000000000000000000000000000000821480156102955750600083815260016020526040902054600160a060020a031615155b806102d757507f6861736800000000000000000000000000000000000000000000000000000000821480156102d7575060008381526002602052604090205415155b9392505050565b60008054604080517f02571be300000000000000000000000000000000000000000000000000000000815260048101869052905185933393600160a060020a0316926302571be39260248083019360209383900390910190829087803b15801561034757600080fd5b505af115801561035b573d6000803e3d6000fd5b505050506040513d602081101561037157600080fd5b5051600160a060020a03161461038657600080fd5b5060009182526002602052604090912055565b60008054604080517f02571be300000000000000000000000000000000000000000000000000000000815260048101869052905185933393600160a060020a0316926302571be39260248083019360209383900390910190829087803b15801561040257600080fd5b505af1158015610416573d6000803e3d6000fd5b505050506040513d602081101561042c57600080fd5b5051600160a060020a03161461044157600080fd5b50600091825260016020526040909120805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911790555600a165627a7a72305820f8edfb69dc0d40dd800b8ed92b16c6de12fbe0ce767cba9a6d32fb5175f5db820029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_CONTENT = "content";

    public static final String FUNC_ADDR = "addr";

    public static final String FUNC_HAS = "has";

    public static final String FUNC_SETCONTENT = "setContent";

    public static final String FUNC_SETADDR = "setAddr";

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

    public RemoteCall<TransactionReceipt> setContent(byte[] node, byte[] hash) {
        final Function function = new Function(
                FUNC_SETCONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
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
}
