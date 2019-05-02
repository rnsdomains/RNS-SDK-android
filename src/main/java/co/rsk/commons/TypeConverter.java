package co.rsk.commons;

import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class TypeConverter {

    private TypeConverter() {
        throw new IllegalAccessError("Utility class");
    }

    public static BigInteger stringNumberAsBigInt(String input) {
        if (input.startsWith("0x")) {
            return TypeConverter.stringHexToBigInteger(input);
        } else {
            return TypeConverter.stringDecimalToBigInteger(input);
        }
    }

    public static BigInteger stringHexToBigInteger(String input) {
        String hexa = input.substring(2);
        return new BigInteger(hexa, 16);
    }

    private static BigInteger stringDecimalToBigInteger(String input) {
        return new BigInteger(input);
    }

    public static byte[] stringHexToByteArray(String x) {
        String result = x;
        if (x.startsWith("0x")) {
            result = x.substring(2);
        }
        if (result.length() % 2 != 0) {
            result = "0" + result;
        }
        return Hex.decode(result);
    }

    public static byte[] stringToByteArray(String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

    public static String toJsonHex(byte[] x) {
        String result = "0x" + Hex.toHexString(x == null ? ByteUtil.EMPTY_BYTE_ARRAY : x);

        if ("0x".equals(result)) {
            return "0x00";
        }

        return result;
    }

    public static String toJsonHex(String x) {
        return "0x"+x;
    }

    public static String toJsonHex(long n) {
        return "0x" + Long.toHexString(n);
    }

    public static String toJsonHex(BigInteger n) {
        return "0x"+ n.toString(16);
    }

    /**
     * Converts "0x876AF" to "876AF"
     */
    public static String removeZeroX(String str) {
        return str.substring(2);
    }

    public static long JSonHexToLong(String x) {
        if (!x.startsWith("0x")) {
            throw new NumberFormatException("Incorrect hex syntax");
        }
        x = x.substring(2);
        return Long.parseLong(x, 16);
    }
}
