package co.rsk.rnssdk.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
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
public class AbstractMultiChainResolver extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_ADDR = "addr";

    public static final String FUNC_SETADDR = "setAddr";

    public static final String FUNC_CHAINADDR = "chainAddr";

    public static final String FUNC_SETCHAINADDR = "setChainAddr";

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
    protected AbstractMultiChainResolver(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AbstractMultiChainResolver(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AbstractMultiChainResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AbstractMultiChainResolver(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
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
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ChainAddrChangedEventResponse>() {
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
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddrChangedEventResponse>() {
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

    public RemoteCall<String> chainAddr(byte[] node, byte[] chain) {
        final Function function = new Function(FUNC_CHAINADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setChainAddr(byte[] node, byte[] chain, String addrValue) {
        final Function function = new Function(
                FUNC_SETCHAINADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes4(chain), 
                new org.web3j.abi.datatypes.Utf8String(addrValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AbstractMultiChainResolver load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AbstractMultiChainResolver(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AbstractMultiChainResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AbstractMultiChainResolver(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AbstractMultiChainResolver load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AbstractMultiChainResolver(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AbstractMultiChainResolver load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AbstractMultiChainResolver(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AbstractMultiChainResolver> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AbstractMultiChainResolver.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AbstractMultiChainResolver> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AbstractMultiChainResolver.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AbstractMultiChainResolver> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AbstractMultiChainResolver.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AbstractMultiChainResolver> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AbstractMultiChainResolver.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
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
