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
public class PriceSubdomainRegistrar extends Contract {
    private static final String BINARY = "0x6080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604051610050906101e7565b604051809103906000f08015801561006c573d6000803e3d6000fd5b50600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550670de0b6b3a76400006006553480156100c557600080fd5b506040516080806115cf833981018060405260808110156100e557600080fd5b810190808051906020019092919080519060200190929190805190602001909291908051906020019092919050505083600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060058190555081600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505050506101f4565b6105908061103f83390190565b610e3c806102036000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c8063a035b1fe11610066578063a035b1fe146101d3578063d22057a9146101f1578063f851a4401461023f578063faff50a814610289578063fc0c546a146102a75761009e565b80631d7876e7146100a35780636341ca0b146100ad578063663b44c51461011157806391b7f5ed1461015b57806393e59dc114610189575b600080fd5b6100ab6102f1565b005b61010f600480360360408110156100c357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610430565b005b61011961057a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101876004803603602081101561017157600080fd5b81019080803590602001909291905050506105a0565b005b610191610603565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101db610629565b6040518082815260200191505060405180910390f35b61023d6004803603604081101561020757600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061062f565b005b610247610dbe565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610291610de4565b6040518082815260200191505060405180910390f35b6102af610dea565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461034a57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635b0fc9c36005546000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561041657600080fd5b505af115801561042a573d6000803e3d6000fd5b50505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461048957600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636341ca0b83836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b15801561055e57600080fd5b505af1158015610572573d6000803e3d6000fd5b505050505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146105f957600080fd5b8060068190555050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60065481565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633af32abf336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156106ce57600080fd5b505afa1580156106e2573d6000803e3d6000fd5b505050506040513d60208110156106f857600080fd5b810190808051906020019092919050505061071257600080fd5b6000600554836040516020018083815260200182815260200192505050604051602081830303815290604052805190602001209050600073ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156107d257600080fd5b505afa1580156107e6573d6000803e3d6000fd5b505050506040513d60208110156107fc57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461082d57600080fd5b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16630178b8bf6005546040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156108a457600080fd5b505afa1580156108b8573d6000803e3d6000fd5b505050506040513d60208110156108ce57600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff166301ffc9a7633b3b57de60e01b6040518263ffffffff1660e01b815260040180827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200191505060206040518083038186803b15801561097757600080fd5b505afa15801561098b573d6000803e3d6000fd5b505050506040513d60208110156109a157600080fd5b81019080805190602001909291905050506109bb57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166306ab592360055486306040518463ffffffff1660e01b8152600401808481526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050600060405180830381600087803b158015610a6e57600080fd5b505af1158015610a82573d6000803e3d6000fd5b505050508073ffffffffffffffffffffffffffffffffffffffff1663d5fa2b0083856040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015610b0d57600080fd5b505af1158015610b21573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635b0fc9c383856040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015610bce57600080fd5b505af1158015610be2573d6000803e3d6000fd5b50505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663291d9549336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610c8757600080fd5b505af1158015610c9b573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663beabacc884600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166006546040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b158015610da057600080fd5b505af1158015610db4573d6000803e3d6000fd5b5050505050505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60055481565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168156fea165627a7a72305820e004692ecaccfe45d729c1e43dc1336cd29451b4e627986757740a00dc3099ae00296080604052336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034801561005057600080fd5b50610530806100606000396000f3fe6080604052600436106100345760003560e01c80636341ca0b1461009e5780638da5cb5b1461010f578063beabacc814610166575b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f1935050505015801561009b573d6000803e3d6000fd5b50005b3480156100aa57600080fd5b5061010d600480360360408110156100c157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506101e1565b005b34801561011b57600080fd5b506101246103be565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561017257600080fd5b506101df6004803603606081101561018957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506103e3565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461023a57600080fd5b60008173ffffffffffffffffffffffffffffffffffffffff166370a08231306040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156102b957600080fd5b505afa1580156102cd573d6000803e3d6000fd5b505050506040513d60208110156102e357600080fd5b810190808051906020019092919050505090508173ffffffffffffffffffffffffffffffffffffffff1663a9059cbb84836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561037d57600080fd5b505af1158015610391573d6000803e3d6000fd5b505050506040513d60208110156103a757600080fd5b810190808051906020019092919050505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461043c57600080fd5b8173ffffffffffffffffffffffffffffffffffffffff1663a9059cbb84836040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156104c357600080fd5b505af11580156104d7573d6000803e3d6000fd5b505050506040513d60208110156104ed57600080fd5b81019080805190602001909291905050505050505056fea165627a7a723058206f4287b07bbd0a4b4d10f09e82820e36a38822d887e2abe73ae3dde1e97c8d100029";

    public static final String FUNC_RNS = "rns";

    public static final String FUNC_WHITELIST = "whitelist";

    public static final String FUNC_PRICE = "price";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_ROOTNODE = "rootNode";

    public static final String FUNC_TOKEN = "token";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_SETPRICE = "setPrice";

    public static final String FUNC_RETRIEVETOKENS = "retrieveTokens";

    public static final String FUNC_TRANSFERBACK = "transferBack";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected PriceSubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PriceSubdomainRegistrar(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PriceSubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PriceSubdomainRegistrar(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> rns() {
        final Function function = new Function(FUNC_RNS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> whitelist() {
        final Function function = new Function(FUNC_WHITELIST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> price() {
        final Function function = new Function(FUNC_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
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

    public RemoteCall<String> token() {
        final Function function = new Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> register(byte[] label, String addr) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(label), 
                new org.web3j.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPrice(BigInteger _price) {
        final Function function = new Function(
                FUNC_SETPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> retrieveTokens(String receiver, String _token) {
        final Function function = new Function(
                FUNC_RETRIEVETOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(receiver), 
                new org.web3j.abi.datatypes.Address(_token)), 
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
    public static PriceSubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PriceSubdomainRegistrar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PriceSubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PriceSubdomainRegistrar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PriceSubdomainRegistrar load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PriceSubdomainRegistrar(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PriceSubdomainRegistrar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PriceSubdomainRegistrar(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PriceSubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _rns, String _whitelist, String _token, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_whitelist), 
                new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(PriceSubdomainRegistrar.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PriceSubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _rns, String _whitelist, String _token, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_whitelist), 
                new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(PriceSubdomainRegistrar.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PriceSubdomainRegistrar> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _rns, String _whitelist, String _token, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_whitelist), 
                new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(PriceSubdomainRegistrar.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PriceSubdomainRegistrar> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _rns, String _whitelist, String _token, byte[] _rootNode) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_whitelist), 
                new org.web3j.abi.datatypes.Address(_token), 
                new org.web3j.abi.datatypes.generated.Bytes32(_rootNode)));
        return deployRemoteCall(PriceSubdomainRegistrar.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
