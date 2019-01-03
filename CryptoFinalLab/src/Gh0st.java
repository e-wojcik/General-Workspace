import java.util.Arrays;

public class Gh0st {

	public static void main(String args[]) {
		byte[] cipher = Convert.hexToBytes("23ebbf16");
		// byte[] cipher = Convert.hexToBytes("cc61c594");
		System.out.println("Bytes of the cipher: " + Arrays.toString(cipher));

		byte[] falsePlain = Convert.stringToBytes("FALS");
		System.out.println("Bytes of the 'FALS': " + Arrays.toString(falsePlain));

		byte[] truePlain = Convert.stringToBytes("TRUE");
		System.out.println("Bytes of the 'TRUE': " + Arrays.toString(truePlain));

		byte[] xorFirstPass = new byte[4];
		for (int i = 0; i < 4; i++) {
			xorFirstPass[i] = (byte) (cipher[i] ^ falsePlain[i]);
		}

		byte[] xorSecondPass = new byte[4];
		for (int j = 0; j < 4; j++) {
			xorSecondPass[j] = (byte) (xorFirstPass[j] ^ truePlain[j]);
		}

		System.out.println("Bytes of changed Pad: " + Arrays.toString(xorSecondPass));
		System.out.println("...in Hex: " + Convert.bytesToHex(xorSecondPass));
	}

}
