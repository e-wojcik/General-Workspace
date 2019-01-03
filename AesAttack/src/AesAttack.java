import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author WojcikEricM
 */
public class AesAttack {
	/**
	 * Attempts to decrypt a ciphertext with AES-256 cipher, CBC crypto mode,
	 * and PKCS7 padding scheme.
	 * 
	 * @param c
	 *            ciphertext in hexadecimal string format.
	 * @return true if decryption was successful; false otherwise.
	 */
	public static boolean paddingOracle(String c) {
		try {
			URL url = new URL("http://www.z4nd3r.com/sec/paddingOracle?cipher=" + c);
			URLConnection conn = url.openConnection();
			String line;
			InputStreamReader r = new InputStreamReader(conn.getInputStream());
			BufferedReader input = new BufferedReader(r);
			while ((line = input.readLine()) != null) {
				if (line.equals("1")) {
					input.close();
					return true;
				}
			}
			input.close();
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static void main(String args[]) {
		// System.out.println("Padding boolean: "
		// +
		// paddingOracle("289ae9f358fea214f1fb90887c4c9f89a07aba41d4efa99394a08cea97a02e98"));
		System.out.println("Original ciphertext byte array: " + Arrays
				.toString(Convert.hexToBytes("289ae9f358fea214f1fb90887c4c9f89a07aba41d4efa99394a08cea97a02e98")));
		System.out.println("Original ciphertext byte array length: "
				+ Convert.hexToBytes("289ae9f358fea214f1fb90887c4c9f89a07aba41d4efa99394a08cea97a02e98").length);
		
		System.out.println("Resulting hex byte for the IV: " + findByte("fa"));
		
		String modifiedIV = "28e58cc32f81c624889fa19d69598a9c" + "a07aba41d4efa99394a08cea97a02e98";
		byte[] modCipher = Convert.hexToBytes(modifiedIV);
		
		for (int i = -128; i < 128; i++){
			modCipher[0] = (byte) i;
			if (paddingOracle(Convert.bytesToHex(modCipher))){
				System.out.println("Byte that provides correct padding: " + modCipher[0]);
				byte[] foundByte = new byte[1];
				foundByte[0] = modCipher[0];
				System.out.println("Found byte in hex format: " + Convert.bytesToHex(foundByte));
				System.out.println("New cipher with proper padding: " + Convert.bytesToHex(modCipher));
			}
		}
	}
	
	public static String findByte(String b){
		byte[] newIV = new byte[1];
		newIV[0] = (byte) (Convert.hexToBytes(b)[0] ^ Convert.hexToBytes("0f")[0] ^ Convert.hexToBytes("10")[0]);
		return Convert.bytesToHex(newIV);
	}
}
