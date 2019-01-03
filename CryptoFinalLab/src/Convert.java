import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

/**
 * Program to convert back and forth between ASCII strings, hex strings, and
 * byte arrays.
 * 
 * @author Eric Wojcik
 * @version 16 January 2017
 */
public class Convert {
	/**
	* Converts ASCII string to byte array.
	* @param s given ASCII string.
	* @return equivalent array of bytes.
	*/
	public static byte[] stringToBytes(String str) {
		return str.getBytes();
	}

	/**
	* Converts ASCII string to hexadecimal string.
	* @param s given ASCII string.
	* @return equivalent hexadecimal string.
	*/
	public static String stringToHex(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}


	/**
	* Converts hexadecimal string to array of bytes.
	* @param hex given hexadecimal string.
	* @return equivalent array of bytes.
	*/
	public static byte[] hexToBytes(String hex) {
		int len = hex.length();
		byte[] bytes = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			bytes[i / 2] = (byte)((Character.digit(hex.charAt(i), 16) << 4) + 
					Character.digit(hex.charAt(i + 1), 16));
		}
		return bytes;
	}

	/**
	* Converts hexadecimal string to ASCII string.
	* @param hex given hexadecimal string.
	* @return equivalent ASCII string.
	*/
	public static String hexToString(String hex) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < hex.length(); i += 2) {
			String str = hex.substring(i, i + 2);
			buffer.append((char)Integer.parseInt(str, 16));
		}
		return buffer.toString();
	}

	/**
	* Converts byte array to ASCII string.
	* @param bytes given byte array.
	* @return equivalent ASCII string.
	*/
	public static String bytesToString(byte[] bytes) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			buffer.append((char)bytes[i]);
		}
		return new String(buffer);
	}

	/**
	* Converts byte array to hexadecimal string.
	* @param bytes given byte array.
	* @return equivalent hexadecimal string.
	*/
	public static String bytesToHex(byte[] bytes) {
		char[] hexArray = "0123456789abcdef".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int i = 0; i < bytes.length; i++) {
			int v = bytes[i] & 0xFF;
			hexChars[i * 2] = hexArray[v >>> 4];
			hexChars[i * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
