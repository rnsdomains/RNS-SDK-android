package co.rsk.commons;

import org.junit.Assert;
import org.junit.Test;
import org.bouncycastle.util.encoders.DecoderException;

public class RskAddressTest {

    @Test
    public void testEquals() {
        RskAddress senderA = new RskAddress("0000000000000000000000000000000001000006");
        RskAddress senderB = new RskAddress("0000000000000000000000000000000001000006");
        RskAddress senderC = new RskAddress("0000000000000000000000000000000001000008");
        RskAddress senderD = RskAddress.nullAddress();
        RskAddress senderE = new RskAddress("0x00002000f000000a000000330000000001000006");

        Assert.assertEquals(senderA, senderB);
        Assert.assertNotEquals(senderA, senderC);
        Assert.assertNotEquals(senderA, senderD);
        Assert.assertNotEquals(senderA, senderE);
    }

    @Test
    public void zeroAddress() {
        RskAddress senderA = new RskAddress("0000000000000000000000000000000000000000");
        RskAddress senderB = new RskAddress("0x0000000000000000000000000000000000000000");
        RskAddress senderC = new RskAddress(new byte[20]);

        Assert.assertEquals(senderA, senderB);
        Assert.assertEquals(senderB, senderC);
        Assert.assertNotEquals(RskAddress.nullAddress(), senderC);
    }

    @Test
    public void nullAddress() {
        Assert.assertArrayEquals(RskAddress.nullAddress().getBytes(), new byte[0]);
    }

    @Test(expected = RuntimeException.class)
    public void invalidLongAddress() {
        new RskAddress("00000000000000000000000000000000010000060");
    }

    @Test(expected = RuntimeException.class)
    public void invalidShortAddress() {
        new RskAddress("0000000000000000000000000000000001006");
    }

    @Test
    public void oddLengthAddressPaddedWithOneZero() {
        new RskAddress("000000000000000000000000000000000100006");
    }

    @Test(expected = DecoderException.class)
    public void invalidHexAddress() {
        new RskAddress("000000000000000000000000000000000100000X");
    }

    @Test(expected = NullPointerException.class)
    public void invalidNullAddressBytes() {
        new RskAddress((byte[]) null);
    }

    @Test(expected = NullPointerException.class)
    public void invalidNullAddressString() {
        new RskAddress((String) null);
    }

    @Test(expected = RuntimeException.class)
    public void invalidShortAddressBytes() {
        new RskAddress(new byte[19]);
    }

    @Test(expected = RuntimeException.class)
    public void invalidLongAddressBytes() {
        new RskAddress(new byte[21]);
    }

}
