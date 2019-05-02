package co.rsk.commons;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

import java.io.Serializable;

public class ByteArrayWrapper implements Comparable<ByteArrayWrapper>, Serializable {

    private final byte[] data;
    private int hashCode = 0;

    public ByteArrayWrapper(byte[] data) {
        if (data == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = data;
        this.hashCode = Arrays.hashCode(data);
    }

    public boolean equals(Object other) {
        if (!(other instanceof ByteArrayWrapper)) {
            return false;
        }
        byte[] otherData = ((ByteArrayWrapper) other).data;
        return ByteUtil.fastEquals(data, otherData);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public int compareTo(ByteArrayWrapper o) {
        return FastByteComparisons.compareTo(
                data, 0, data.length,
                o.data, 0, o.data.length);
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return Hex.toHexString(data);
    }

    public boolean equalsToByteArray(byte[] otherData) {
        return otherData != null && ByteUtil.fastEquals(data, otherData);
    }
}
