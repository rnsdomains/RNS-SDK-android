package co.rsk.rnssdk;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint64;
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
public class AbstractRNS extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RESOLVER = "resolver";

    public static final String FUNC_TTL = "ttl";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_SETSUBNODEOWNER = "setSubnodeOwner";

    public static final String FUNC_SETRESOLVER = "setResolver";

    public static final String FUNC_SETTTL = "setTTL";

    public static final Event NEWOWNER_EVENT = new Event("NewOwner", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}));
    ;

    public static final Event NEWRESOLVER_EVENT = new Event("NewResolver", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>() {}));
    ;

    public static final Event NEWTTL_EVENT = new Event("NewTTL", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint64>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected AbstractRNS(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AbstractRNS(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AbstractRNS(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AbstractRNS(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NewOwnerEventResponse> getNewOwnerEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWOWNER_EVENT, transactionReceipt);
        ArrayList<NewOwnerEventResponse> responses = new ArrayList<NewOwnerEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewOwnerEventResponse typedResponse = new NewOwnerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.label = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.ownerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewOwnerEventResponse> newOwnerEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewOwnerEventResponse>() {
            @Override
            public NewOwnerEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWOWNER_EVENT, log);
                NewOwnerEventResponse typedResponse = new NewOwnerEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.label = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.ownerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewOwnerEventResponse> newOwnerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWOWNER_EVENT));
        return newOwnerEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ownerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ownerAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<NewResolverEventResponse> getNewResolverEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWRESOLVER_EVENT, transactionReceipt);
        ArrayList<NewResolverEventResponse> responses = new ArrayList<NewResolverEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewResolverEventResponse typedResponse = new NewResolverEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.resolverAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewResolverEventResponse> newResolverEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewResolverEventResponse>() {
            @Override
            public NewResolverEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWRESOLVER_EVENT, log);
                NewResolverEventResponse typedResponse = new NewResolverEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.resolverAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewResolverEventResponse> newResolverEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWRESOLVER_EVENT));
        return newResolverEventFlowable(filter);
    }

    public List<NewTTLEventResponse> getNewTTLEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWTTL_EVENT, transactionReceipt);
        ArrayList<NewTTLEventResponse> responses = new ArrayList<NewTTLEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewTTLEventResponse typedResponse = new NewTTLEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ttlValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewTTLEventResponse> newTTLEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewTTLEventResponse>() {
            @Override
            public NewTTLEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWTTL_EVENT, log);
                NewTTLEventResponse typedResponse = new NewTTLEventResponse();
                typedResponse.log = log;
                typedResponse.node = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ttlValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewTTLEventResponse> newTTLEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWTTL_EVENT));
        return newTTLEventFlowable(filter);
    }

    public RemoteCall<String> owner(byte[] node) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> resolver(byte[] node) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> ttl(byte[] node) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TTL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setOwner(byte[] node, String ownerAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.Address(ownerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setSubnodeOwner(byte[] node, byte[] label, String ownerAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSUBNODEOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Bytes32(label), 
                new org.web3j.abi.datatypes.Address(ownerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setResolver(byte[] node, String resolverAddress) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETRESOLVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.Address(resolverAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setTTL(byte[] node, BigInteger ttlValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETTTL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(node), 
                new org.web3j.abi.datatypes.generated.Uint64(ttlValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AbstractRNS load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AbstractRNS(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AbstractRNS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AbstractRNS(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AbstractRNS load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AbstractRNS(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AbstractRNS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AbstractRNS(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AbstractRNS> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AbstractRNS.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AbstractRNS> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AbstractRNS.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AbstractRNS> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AbstractRNS.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AbstractRNS> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AbstractRNS.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class NewOwnerEventResponse {
        public Log log;

        public byte[] node;

        public byte[] label;

        public String ownerAddress;
    }

    public static class TransferEventResponse {
        public Log log;

        public byte[] node;

        public String ownerAddress;
    }

    public static class NewResolverEventResponse {
        public Log log;

        public byte[] node;

        public String resolverAddress;
    }

    public static class NewTTLEventResponse {
        public Log log;

        public byte[] node;

        public BigInteger ttlValue;
    }
}
