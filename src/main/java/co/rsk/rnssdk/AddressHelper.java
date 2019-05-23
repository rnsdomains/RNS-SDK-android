package co.rsk.rnssdk;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
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
public class AddressHelper extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50610796806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806315706fdf146100465780635e57966d14610141578063b7312707146101fe575b600080fd5b6100ff6004803603602081101561005c57600080fd5b810190808035906020019064010000000081111561007957600080fd5b82018360208201111561008b57600080fd5b803590602001918460018302840111640100000000831117156100ad57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610240565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101836004803603602081101561015757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610493565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101c35780820151818401526020810190506101a8565b50505050905090810190601f1680156101f05780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61022a6004803603602081101561021457600080fd5b810190808035906020019092919050505061069f565b6040518082815260200191505060405180910390f35b60006060829050602881511415801561025b5750602a815114155b1561026557600080fd5b60008090506000809050602a8351141561041557600290507f30000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916836000815181106102cd57fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161461030457600080fd5b7f78000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19168360018151811061035457fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415801561040a57507f58000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916836001815181106103da57fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614155b1561041457600080fd5b5b6000806000856020015190508392505b602083101561044e5780831a915061043c8261069f565b60108602019450826001019250610425565b85604001519050600092505b836008018310156104855780831a91506104738261069f565b6010860201945082600101925061045a565b849650505050505050919050565b606080602a6040519080825280601f01601f1916602001820160405280156104ca5781602001600182028038833980820191505090505b5090507f3000000000000000000000000000000000000000000000000000000000000000816000815181106104fb57fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f78000000000000000000000000000000000000000000000000000000000000008160018151811061055857fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535060008090505b60148110156106955760008160130360080260020a8573ffffffffffffffffffffffffffffffffffffffff16816105c057fe5b0460f81b9050600060108260f81c60ff16816105d857fe5b0460f81b905060008160f81c6010028360f81c0360f81b90506105fa82610717565b85600286600202018151811061060c57fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535061064481610717565b85600386600202018151811061065657fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350505050808060010191505061058d565b5080915050919050565b6000603082101580156106b3575060398211155b156106c357603082039050610712565b606182101580156106d5575060668211155b156106e857606182600a01039050610712565b604182101580156106fa575060468211155b1561070d57604182600a01039050610712565b600080fd5b919050565b6000600a60f81b827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191610156107585760308260f81c0160f81b9050610765565b60578260f81c0160f81b90505b91905056fea165627a7a72305820bfe456ea2233945757513bdf1bea83d3af12841dcb646430932569de146a51f40029";

    public static final String FUNC_ADDRESSTOSTRING = "addressToString";

    public static final String FUNC_STRINGTOADDRESS = "stringToAddress";

    public static final String FUNC_FROMHEXCHAR = "fromHexChar";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected AddressHelper(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressHelper(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressHelper(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> addressToString(String data) {
        final Function function = new Function(FUNC_ADDRESSTOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(data)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> stringToAddress(String s) {
        final Function function = new Function(FUNC_STRINGTOADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> fromHexChar(BigInteger c) {
        final Function function = new Function(FUNC_FROMHEXCHAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(c)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static AddressHelper load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressHelper(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressHelper(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressHelper load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressHelper(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressHelper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressHelper(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressHelper> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressHelper.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressHelper> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressHelper.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressHelper> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressHelper.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressHelper> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressHelper.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
