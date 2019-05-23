package co.rsk.rnssdk;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Bytes4;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class MultiChainResolver extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516040806122e28339810180604052604081101561003057600080fd5b810190808051906020019092919080519060200190929190505050816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040516100d89061013c565b604051809103906000f0801580156100f4573d6000803e3d6000fd5b50600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050610149565b6107b680611b2c83390190565b6119d4806101586000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c80638be4b5f6116100715780638be4b5f6146102fb578063b34e8cd6146103cb578063c3d014d614610436578063d278b4001461046e578063d5fa2b001461055c578063e335bee4146105aa576100a9565b806301ffc9a7146100ae578063245d4d9a146101135780632dff6941146101745780633b3b57de146101b657806382e3bee614610224575b600080fd5b6100f9600480360360208110156100c457600080fd5b8101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909291905050506106a2565b604051808215151515815260200191505060405180910390f35b6101726004803603606081101561012957600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916906020019092919080359060200190929190505050610791565b005b6101a06004803603602081101561018a57600080fd5b8101908080359060200190929190505050610967565b6040518082815260200191505060405180910390f35b6101e2600480360360208110156101cc57600080fd5b8101908080359060200190929190505050610a4a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6102796004803603604081101561023a57600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610d2d565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b838110156102bf5780820151818401526020810190506102a4565b50505050905090810190601f1680156102ec5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b6103506004803603604081101561031157600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610e43565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610390578082015181840152602081019050610375565b50505050905090810190601f1680156103bd5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610420600480360360408110156103e157600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610f47565b6040518082815260200191505060405180910390f35b61046c6004803603604081101561044c57600080fd5b810190808035906020019092919080359060200190929190505050610fb3565b005b61055a6004803603606081101561048457600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190803590602001906401000000008111156104d457600080fd5b8201836020820111156104e657600080fd5b8035906020019184600183028401116401000000008311171561050857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506110f4565b005b6105a86004803603604081101561057257600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611507565b005b6106a0600480360360808110156105c057600080fd5b810190808035906020019092919080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909291908035906020019064010000000081111561061057600080fd5b82018360208201111561062257600080fd5b8035906020019184600183028401116401000000008311171561064457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190505050611801565b005b6000633b3b57de60e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916148061073b5750632dff694160e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b8061078a5750638be4b5f660e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b9050919050565b823373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561081b57600080fd5b505afa15801561082f573d6000803e3d6000fd5b505050506040513d602081101561084557600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461087657600080fd5b81600460008681526020019081526020016000206000857bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff19168152602001908152602001600020600001819055507f92c52f77ad49286096555eb922ca7a09249e8dd525cf58cd162fb1165686fad484848460405180848152602001837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19168152602001828152602001935050505060405180910390a150505050565b600080600360008481526020019081526020016000205490506000801b81146109935780915050610a45565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632dff6941846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b158015610a0657600080fd5b505afa158015610a1a573d6000803e3d6000fd5b505050506040513d6020811015610a3057600080fd5b81019080805190602001909291905050509150505b919050565b60006060600460008481526020019081526020016000206000638000008960e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff191681526020019081526020016000206001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b4a5780601f10610b1f57610100808354040283529160200191610b4a565b820191906000526020600020905b815481529060010190602001808311610b2d57829003601f168201915b50505050509050600081511115610c7657600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166315706fdf826040518263ffffffff1660e01b81526004018080602001828103825283818151815260200191508051906020019080838360005b83811015610be9578082015181840152602081019050610bce565b50505050905090810190601f168015610c165780820380516001836020036101000a031916815260200191505b509250505060206040518083038186803b158015610c3357600080fd5b505afa158015610c47573d6000803e3d6000fd5b505050506040513d6020811015610c5d57600080fd5b8101908080519060200190929190505050915050610d28565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633b3b57de846040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b158015610ce957600080fd5b505afa158015610cfd573d6000803e3d6000fd5b505050506040513d6020811015610d1357600080fd5b81019080805190602001909291905050509150505b919050565b6060600080600460008681526020019081526020016000206000857bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff191681526020019081526020016000209050806001018160000154818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e305780601f10610e0557610100808354040283529160200191610e30565b820191906000526020600020905b815481529060010190602001808311610e1357829003601f168201915b5050505050915092509250509250929050565b6060600460008481526020019081526020016000206000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff191681526020019081526020016000206001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f3a5780601f10610f0f57610100808354040283529160200191610f3a565b820191906000526020600020905b815481529060010190602001808311610f1d57829003601f168201915b5050505050905092915050565b6000600460008481526020019081526020016000206000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060000154905092915050565b813373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561103d57600080fd5b505afa158015611051573d6000803e3d6000fd5b505050506040513d602081101561106757600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff161461109857600080fd5b8160036000858152602001908152602001600020819055507f0424b6fe0d9c3bdbece0e7879dc241bb0c22e900be8b6c168b4ee08bd9bf83bc8383604051808381526020018281526020019250505060405180910390a1505050565b823373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561117e57600080fd5b505afa158015611192573d6000803e3d6000fd5b505050506040513d60208110156111a857600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff16146111d957600080fd5b81600460008681526020019081526020016000206000857bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff19168152602001908152602001600020600101908051906020019061124e929190611903565b50638000008960e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141561141d576000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166315706fdf846040518263ffffffff1660e01b81526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561132c578082015181840152602081019050611311565b50505050905090810190601f1680156113595780820380516001836020036101000a031916815260200191505b509250505060206040518083038186803b15801561137657600080fd5b505afa15801561138a573d6000803e3d6000fd5b505050506040513d60208110156113a057600080fd5b81019080805190602001909291905050509050847f52d7d861f09ab3d26239d492e8968629f95e9e318cf0b73bfddc441522a15fd282604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a250611501565b837f6a3e28813f2e2e5bcd0436779f8c5cb179ceadf0379291a818b9078e772b178d848460405180837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200180602001828103825283818151815260200191508051906020019080838360005b838110156114c55780820151818401526020810190506114aa565b50505050905090810190601f1680156114f25780820380516001836020036101000a031916815260200191505b50935050505060405180910390a25b50505050565b813373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561159157600080fd5b505afa1580156115a5573d6000803e3d6000fd5b505050506040513d60208110156115bb57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff16146115ec57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16635e57966d836040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060006040518083038186803b15801561168b57600080fd5b505afa15801561169f573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f8201168201806040525060208110156116c957600080fd5b8101908080516401000000008111156116e157600080fd5b828101905060208101848111156116f757600080fd5b815185600182028301116401000000008211171561171457600080fd5b5050929190505050600460008581526020019081526020016000206000638000008960e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191677ffffffffffffffffffffffffffffffffffffffffffffffff191681526020019081526020016000206001019080519060200190611797929190611903565b50827f52d7d861f09ab3d26239d492e8968629f95e9e318cf0b73bfddc441522a15fd283604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a2505050565b833373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302571be3836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561188b57600080fd5b505afa15801561189f573d6000803e3d6000fd5b505050506040513d60208110156118b557600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff16146118e657600080fd5b6118f18585856110f4565b6118fc858584610791565b5050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061194457805160ff1916838001178555611972565b82800160010185558215611972579182015b82811115611971578251825591602001919060010190611956565b5b50905061197f9190611983565b5090565b6119a591905b808211156119a1576000816000905550600101611989565b5090565b9056fea165627a7a72305820bdafcdf97b819202bfa9498e48e8560be21f96915aff5cc85a4c4b16c580be8e0029608060405234801561001057600080fd5b50610796806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806315706fdf146100465780635e57966d14610141578063b7312707146101fe575b600080fd5b6100ff6004803603602081101561005c57600080fd5b810190808035906020019064010000000081111561007957600080fd5b82018360208201111561008b57600080fd5b803590602001918460018302840111640100000000831117156100ad57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610240565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101836004803603602081101561015757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610493565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101c35780820151818401526020810190506101a8565b50505050905090810190601f1680156101f05780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61022a6004803603602081101561021457600080fd5b810190808035906020019092919050505061069f565b6040518082815260200191505060405180910390f35b60006060829050602881511415801561025b5750602a815114155b1561026557600080fd5b60008090506000809050602a8351141561041557600290507f30000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916836000815181106102cd57fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161461030457600080fd5b7f78000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19168360018151811061035457fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415801561040a57507f58000000000000000000000000000000000000000000000000000000000000007effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916836001815181106103da57fe5b602001015160f81c60f81b7effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614155b1561041457600080fd5b5b6000806000856020015190508392505b602083101561044e5780831a915061043c8261069f565b60108602019450826001019250610425565b85604001519050600092505b836008018310156104855780831a91506104738261069f565b6010860201945082600101925061045a565b849650505050505050919050565b606080602a6040519080825280601f01601f1916602001820160405280156104ca5781602001600182028038833980820191505090505b5090507f3000000000000000000000000000000000000000000000000000000000000000816000815181106104fb57fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f78000000000000000000000000000000000000000000000000000000000000008160018151811061055857fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535060008090505b60148110156106955760008160130360080260020a8573ffffffffffffffffffffffffffffffffffffffff16816105c057fe5b0460f81b9050600060108260f81c60ff16816105d857fe5b0460f81b905060008160f81c6010028360f81c0360f81b90506105fa82610717565b85600286600202018151811061060c57fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535061064481610717565b85600386600202018151811061065657fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350505050808060010191505061058d565b5080915050919050565b6000603082101580156106b3575060398211155b156106c357603082039050610712565b606182101580156106d5575060668211155b156106e857606182600a01039050610712565b604182101580156106fa575060468211155b1561070d57604182600a01039050610712565b600080fd5b919050565b6000600a60f81b827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191610156107585760308260f81c0160f81b9050610765565b60578260f81c0160f81b90505b91905056fea165627a7a72305820bfe456ea2233945757513bdf1bea83d3af12841dcb646430932569de146a51f40029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_ADDR = "addr";

    public static final String FUNC_SETADDR = "setAddr";

    public static final String FUNC_CONTENT = "content";

    public static final String FUNC_SETCONTENT = "setContent";

    public static final String FUNC_CHAINADDR = "chainAddr";

    public static final String FUNC_SETCHAINADDR = "setChainAddr";

    public static final String FUNC_CHAINMETADATA = "chainMetadata";

    public static final String FUNC_SETCHAINMETADATA = "setChainMetadata";

    public static final String FUNC_CHAINADDRANDMETADATA = "chainAddrAndMetadata";

    public static final String FUNC_SETCHAINADDRWITHMETADATA = "setChainAddrWithMetadata";

    public static final Event CONTENTCHANGED_EVENT = new Event("ContentChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event CHAINMETADATACHANGED_EVENT = new Event("ChainMetadataChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes4>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event CHAINADDRCHANGED_EVENT = new Event("ChainAddrChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes4>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event ADDRCHANGED_EVENT = new Event("AddrChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MultiChainResolver(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiChainResolver(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MultiChainResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MultiChainResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ContentChangedEventResponse> getContentChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTENTCHANGED_EVENT, transactionReceipt);
        ArrayList<ContentChangedEventResponse> responses = new ArrayList<ContentChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContentChangedEventResponse typedResponse = new ContentChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.content = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ContentChangedEventResponse> contentChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ContentChangedEventResponse>() {
            @Override
            public ContentChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTENTCHANGED_EVENT, log);
                ContentChangedEventResponse typedResponse = new ContentChangedEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.content = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ContentChangedEventResponse> contentChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTENTCHANGED_EVENT));
        return contentChangedEventFlowable(filter);
    }

    public List<ChainMetadataChangedEventResponse> getChainMetadataChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHAINMETADATACHANGED_EVENT, transactionReceipt);
        ArrayList<ChainMetadataChangedEventResponse> responses = new ArrayList<ChainMetadataChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChainMetadataChangedEventResponse typedResponse = new ChainMetadataChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.chain = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.metadata = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChainMetadataChangedEventResponse> chainMetadataChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChainMetadataChangedEventResponse>() {
            @Override
            public ChainMetadataChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHAINMETADATACHANGED_EVENT, log);
                ChainMetadataChangedEventResponse typedResponse = new ChainMetadataChangedEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.chain = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.metadata = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChainMetadataChangedEventResponse> chainMetadataChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHAINMETADATACHANGED_EVENT));
        return chainMetadataChangedEventFlowable(filter);
    }

    public List<ChainAddrChangedEventResponse> getChainAddrChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHAINADDRCHANGED_EVENT, transactionReceipt);
        ArrayList<ChainAddrChangedEventResponse> responses = new ArrayList<ChainAddrChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChainAddrChangedEventResponse typedResponse = new ChainAddrChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.chain = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ChainAddrChangedEventResponse> chainAddrChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ChainAddrChangedEventResponse>() {
            @Override
            public ChainAddrChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHAINADDRCHANGED_EVENT, log);
                ChainAddrChangedEventResponse typedResponse = new ChainAddrChangedEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.chain = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ChainAddrChangedEventResponse> chainAddrChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHAINADDRCHANGED_EVENT));
        return chainAddrChangedEventFlowable(filter);
    }

    public List<AddrChangedEventResponse> getAddrChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDRCHANGED_EVENT, transactionReceipt);
        ArrayList<AddrChangedEventResponse> responses = new ArrayList<AddrChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddrChangedEventResponse typedResponse = new AddrChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddrChangedEventResponse> addrChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddrChangedEventResponse>() {
            @Override
            public AddrChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDRCHANGED_EVENT, log);
                AddrChangedEventResponse typedResponse = new AddrChangedEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddrChangedEventResponse> addrChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDRCHANGED_EVENT));
        return addrChangedEventFlowable(filter);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> addr(byte[] node) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setAddr(byte[] node, String addrValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.Address(addrValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> content(byte[] node) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setContent(byte[] node, byte[] contentValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCONTENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(contentValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> chainAddr(byte[] node, byte[] chain) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHAINADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setChainAddr(byte[] node, byte[] chain, String addrValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCHAINADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain), 
                new org.web3j.abi.datatypes.Utf8String(addrValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> chainMetadata(byte[] node, byte[] chain) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHAINMETADATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setChainMetadata(byte[] node, byte[] chain, byte[] metadataValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCHAINMETADATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain), 
                new org.web3j.abi.datatypes.generated.Bytes32(metadataValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<String, byte[]>> chainAddrAndMetadata(byte[] node, byte[] chain) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHAINADDRANDMETADATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple2<String, byte[]>>(
                new Callable<Tuple2<String, byte[]>>() {
                    @Override
                    public Tuple2<String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, byte[]>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setChainAddrWithMetadata(byte[] node, byte[] chain, String addrValue, byte[] metadataValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCHAINADDRWITHMETADATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain), 
                new org.web3j.abi.datatypes.Utf8String(addrValue), 
                new org.web3j.abi.datatypes.generated.Bytes32(metadataValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MultiChainResolver load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiChainResolver(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MultiChainResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiChainResolver(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MultiChainResolver load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MultiChainResolver(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MultiChainResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MultiChainResolver(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MultiChainResolver> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _rns, String _publicResolver) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_publicResolver)));
        return deployRemoteCall(MultiChainResolver.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiChainResolver> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _rns, String _publicResolver) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_publicResolver)));
        return deployRemoteCall(MultiChainResolver.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiChainResolver> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _rns, String _publicResolver) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_publicResolver)));
        return deployRemoteCall(MultiChainResolver.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiChainResolver> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _rns, String _publicResolver) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_rns), 
                new org.web3j.abi.datatypes.Address(_publicResolver)));
        return deployRemoteCall(MultiChainResolver.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ContentChangedEventResponse {
        public Log log;

        public byte[] node;

        public byte[] content;
    }

    public static class ChainMetadataChangedEventResponse {
        public Log log;

        public byte[] node;

        public byte[] chain;

        public byte[] metadata;
    }

    public static class ChainAddrChangedEventResponse {
        public Log log;

        public byte[] node;

        public byte[] chain;

        public String addr;
    }

    public static class AddrChangedEventResponse {
        public Log log;

        public byte[] node;

        public String addr;
    }
}
