import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 * HelperMethodsTest class.
 * 
 * Designed to test helper methods for converting data between ASCII strings,
 * hexadecimal strings, and byte arrays. Methods to be tested: stringToHex,
 * hexToString, hexToBytes, bytesToHex, stringToBytes, and bytesToString
 * 
 * @author Mikhail Sudakov
 * @version December 15, 2016
 */
public class HelperMethodsTest extends TestCase {
	/**
	 * Tests stringToHex method that converts an ASCII string into a hex string.
	 */
	public void testStringToHex() {
		assertEquals(Convert.stringToHex("Hello, world!"), "48656c6c6f2c20776f726c6421");
	}

	/**
	 * Tests hexToString method that converts a hex string into an ASCII string.
	 */
	public void testHexToString() {
		assertEquals(Convert.hexToString("48656c6c6f2c20776f726c6421"), "Hello, world!");
	}

	/**
	 * Tests hexToBytes method that converts a hex string into a byte array.
	 */
	public void testHexToBytes() {
		byte[] bytes = { 72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33 };
		assertArrayEquals(Convert.hexToBytes("48656c6c6f2c20776f726c6421"), bytes);
	}

	/**
	 * Tests bytesToHex method that converts a byte array into a hex string.
	 */
	public void testBytesToHex() {
		byte[] bytes = { 72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33 };
		assertEquals(Convert.bytesToHex(bytes), "48656c6c6f2c20776f726c6421");
	}

	/**
	 * Tests stringToBytes method that converts an ASCII string into a byte
	 * array.
	 */
	public void testStringToBytes() {
		byte[] bytes = { 72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33 };
		assertArrayEquals(Convert.stringToBytes("Hello, world!"), bytes);
	}

	/**
	 * Tests bytesToString method that converts a byte array into an ASCII
	 * string.
	 */
	public void testBytesToString() {
		byte[] bytes = { 72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33 };
		assertEquals(Convert.bytesToString(bytes), "Hello, world!");
	}
}