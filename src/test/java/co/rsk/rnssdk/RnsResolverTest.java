package co.rsk.rnssdk;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.web3j.compat.Compat;
import org.web3j.crypto.Hash;
import org.web3j.ens.NameHash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import co.rsk.commons.FastByteComparisons;
import co.rsk.rnssdk.contracts.MultiChainResolver;
import co.rsk.rnssdk.contracts.PublicResolver;
import co.rsk.rnssdk.contracts.RNS;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RnsResolverTest {

    private static final long GAS_LIMIT = 6721975l;
    private static final byte[] HASH = Hex.decode("89ad40fcd44690fb5aa90e0fa51637c1b2d388f8056d68430d41c8284a6a7d5e");
    private static final byte[] TEST_CHAIN_ID = Hex.decode("12345678"); // TEST_CHAIN_ID
    private static final String RSK_TLD = "rsk";
    private static final String RIF_TLD = "rif";
    private static final String MULTI_TLD = "multi";
    private static final String FOO = "foo";


    private byte[] BYTES_FOR_TEST = new byte[32];
    private RnsResolver resolver;
    private RnsResolver multiChainResolver;
    private String mainAccountAddress;
    private String alternateAccountAddress;
    private String anotherAlternateAccountAddress;

    //Test helpers
    private String fooName(String tld) {
        return FOO + "." + tld;
    }

    private void setSubowner(RNS rns, String tld, String previousOwner, String subnodeOwner) throws Exception {
        byte[] tldHash = Hash.sha3(tld.getBytes(Compat.UTF_8));
        byte[] fooHash = Hash.sha3(FOO.getBytes(Compat.UTF_8));
        rns.setSubnodeOwner(new byte[32], tldHash, previousOwner).send();
        rns.setSubnodeOwner(NameHash.nameHashAsBytes(tld), fooHash, subnodeOwner).send();
    }

    @Before
    public void setUp() {
        //HttpService defaults to http://localhost:8545/ if you want to change this put the URI in
        //the HttpService constructor

        Web3jService httpService = new HttpService();
        //Uncoment this line to conect to your regtest node from RSK
        //Web3jService httpService = new HttpService("http://localhost:4444/");
        Web3j web3 = Web3j.build(httpService);
        try {

            SecureRandom random = new SecureRandom();
            random.nextBytes(BYTES_FOR_TEST);

            EthAccounts ethAccounts = web3.ethAccounts().send();
            List<String> ACCOUNTS = ethAccounts.getAccounts();
            assertTrue(ACCOUNTS.size() >= 3);
            //here we define the FROM address for every transaction;
            mainAccountAddress = ACCOUNTS.get(0);
            alternateAccountAddress = ACCOUNTS.get(1);
            anotherAlternateAccountAddress = ACCOUNTS.get(2);

            ClientTransactionManager transactionManagerFromAlternateAccount =
                    new ClientTransactionManager(web3, alternateAccountAddress);
            ClientTransactionManager transactionManagerFromMainAccount =
                    new ClientTransactionManager(web3, mainAccountAddress);
            RNS rnsContractFromMainAccount = RNS.deploy(web3,
                    transactionManagerFromMainAccount,
                    BigInteger.valueOf(1000000l),
                    BigInteger.valueOf(GAS_LIMIT)).send();
            RNS rnsContractFromAlternateAccount =  RNS.load(
                    rnsContractFromMainAccount.getContractAddress(),
                    web3,
                    transactionManagerFromAlternateAccount,
                    new DefaultGasProvider());
            PublicResolver resolverContract = PublicResolver.deploy(
                    web3,
                    transactionManagerFromMainAccount,
                    BigInteger.valueOf(1000000l),
                    BigInteger.valueOf(GAS_LIMIT),
                    rnsContractFromMainAccount.getContractAddress()).send();
            PublicResolver anotherResolverContract = PublicResolver.deploy(
                    web3,
                    transactionManagerFromAlternateAccount,
                    BigInteger.valueOf(1000000l),
                    BigInteger.valueOf(GAS_LIMIT),
                    rnsContractFromMainAccount.getContractAddress()).send();
            MultiChainResolver multiChainResolverContract = MultiChainResolver.deploy(
                        web3,
                        transactionManagerFromMainAccount,
                        BigInteger.valueOf(1000000l),
                        BigInteger.valueOf(GAS_LIMIT),
                        rnsContractFromMainAccount.getContractAddress(),
                        resolverContract.getContractAddress()).send();

            byte[] nodeFooDotRsk = NameHash.nameHashAsBytes(fooName(RSK_TLD));
            byte[] nodeForAnotherResolver = NameHash.nameHashAsBytes(fooName(RIF_TLD));
            byte[] nodeForMultiResolver = NameHash.nameHashAsBytes(fooName(MULTI_TLD));

            String rnsAddress = rnsContractFromMainAccount.getContractAddress();
            String resolverAddress = resolverContract.getContractAddress();
            String multiChainResolverContractContractAddress = multiChainResolverContract.getContractAddress();

            setSubowner(rnsContractFromMainAccount, RSK_TLD, mainAccountAddress, mainAccountAddress);
            setSubowner(rnsContractFromMainAccount, RIF_TLD, mainAccountAddress, alternateAccountAddress);
            setSubowner(rnsContractFromMainAccount, MULTI_TLD, mainAccountAddress, mainAccountAddress);

            rnsContractFromMainAccount.setResolver(nodeFooDotRsk, resolverAddress).send();
            rnsContractFromAlternateAccount.setResolver(nodeForAnotherResolver, anotherResolverContract.getContractAddress()).send();
            rnsContractFromMainAccount.setResolver(nodeForMultiResolver, multiChainResolverContractContractAddress).send();

            anotherResolverContract.setAddr(nodeForAnotherResolver, alternateAccountAddress).send();
            resolverContract.setAddr(nodeFooDotRsk, mainAccountAddress).send();
            assertEquals(resolverContract.addr(nodeFooDotRsk).send(), mainAccountAddress);
            resolverContract.setContent(nodeFooDotRsk, BYTES_FOR_TEST).send();
            resolver = new RnsResolver(web3, resolverAddress, rnsAddress);
            multiChainResolver = new RnsResolver(web3, multiChainResolverContractContractAddress, rnsAddress);
            multiChainResolverContract.setChainAddr(nodeForMultiResolver, TEST_CHAIN_ID, ACCOUNTS.get(2)).send();
            multiChainResolverContract.setChainAddr(nodeForMultiResolver, RnsResolver.RSK_CHAIN_ID, ACCOUNTS.get(0)).send();

            assertTrue("rns contract is not valid", rnsContractFromMainAccount.isValid());
            assertTrue("resolver contract is not valid", resolverContract.isValid());
        } catch (IOException e) {
            fail("IOException: " + e.getMessage() + " make sure node is in localhost:8545");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testMultiCripto() {
        try {
            String expectedAccount = mainAccountAddress;
            String name = fooName(MULTI_TLD);
            String account = multiChainResolver.getAddress(name);
            assertEquals("The first call should be from the PublicResolver", expectedAccount, account);
            expectedAccount = anotherAlternateAccountAddress;
            account = multiChainResolver.getAddress(name, TEST_CHAIN_ID);
            assertEquals("The second call we specified chainId, so it should be another", expectedAccount, account);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testSetAddress() {
        try {
            String expectedAccount = alternateAccountAddress;
            String name = fooName(RSK_TLD);
            assertTrue(resolver.setAddress(name, expectedAccount, mainAccountAddress));
            String address = resolver.getAddress(name);
            assertEquals(expectedAccount, address);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSetNotOwnedAddress() {
        try {
            String expectedAccount = alternateAccountAddress;
            assertTrue(resolver.setAddress(fooName(RSK_TLD), expectedAccount, mainAccountAddress));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSetContent() {
        try {
            String name = fooName(RSK_TLD);
            resolver.setContent(name, HASH, mainAccountAddress);
            byte[] result = resolver.content(name);
            assertTrue(FastByteComparisons.equalBytes(result, HASH));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSetContentToNotOwnedAddress() {
        try {
            resolver.setContent(fooName(RSK_TLD), HASH, alternateAccountAddress);
            fail("An exception should rise");
        } catch (Exception e) {
            String msg = "VM Exception while processing transaction: revert";
            assertTrue(e.getMessage().indexOf(msg) != -1);
        }
    }

    //Ignored by now
    @Ignore
    @Test
    public void testImplementHasWithAddr() {
        try {
            boolean result = resolver.has(fooName(RSK_TLD), "addr");
            assertTrue(result);
        } catch (Exception e) {

        }
    }

    @Test
    public void testFunctionNotImplementedHas() {
        try {
            boolean result = resolver.has(fooName(RSK_TLD), "Kboom");
            assertFalse(result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testShouldResolveName() {
        try {
            String result = resolver.getAddress(fooName(RSK_TLD));
            assertEquals(mainAccountAddress, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDifferentResolverPublicResolver() {
        try {
            String result = resolver.getAddress(fooName(RIF_TLD));
            assertEquals(alternateAccountAddress, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testShouldResolveContent() {
        try {
            byte[] result = resolver.content(fooName(RSK_TLD));
            assertTrue(FastByteComparisons.equalBytes(result, BYTES_FOR_TEST));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testShouldntResolveName() {
        try {
            String result = resolver.getAddress("foo");
            assertEquals("0x0000000000000000000000000000000000000000", result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testShouldImplementSupportsInterface() {
        try {
            String name = fooName(RSK_TLD);
            assertTrue(resolver.supportsInterface(name,"3b3b57de") &&
                    resolver.supportsInterface(name,"d8389dc5"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}