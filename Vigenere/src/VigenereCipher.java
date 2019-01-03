import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Program to break the Vigenere Cipher by first finding the key length and then
 * finding the key based on the length discovered
 * 
 * @author Eric Wojcik
 * @version 21 February 2017
 */
public class VigenereCipher {
	private final static byte[] cipherText = Convert.hexToBytes(
			"7d37997a7a45fd6652398374674afa321e019868284ce8655b78956f674fec7d1e2c9f782872e0745b36926f6d04ea7a4e30926f2604c17c4e3d91686448f03f1e3991696d56a97b5f2e9e736f04eb61513392732850e1761e1b96787b45fb336d309e7b7c04ea7a4e30926f2404fd7b5b78b8736d09dd7a533dda4d6940a97057289f787a04fe7a4a30d7766d5da9615b2d84782404e87d5a7899727f04fd7b5b78a1746f41e7764c3dd77e6154e1764c74d7646751a97b5f2e923d6746fa764c2e92792842e0614d2c9f7c6640a9721e2e926f7104e07e4e378569694afd334e2a986d6d56fd6a1e37913d614afa765d2d85782847fb6a4e2c983d7b47e176533d84332866ec705f2d84782841ff764c21d76e614aee7f5b789b7c6643fc72593dd7746604fd7b5b7880727a48ed335639843d6150fa335a318469614aea671e3492697c41fb3e582a926c7d41e770477884746f4ae8674b2a9231284dfd33572bd76b6d56f03e483d8564284ce8615a7891727a04e8335a3d83787a49e07d572b83746b04ea7a4e30926f2850e6335c3dd76e6d47fc615b78df787047ec634a3198737b04ec6b572b83312857fc705678966e286bdd431e2f9e696004e8334d31997a6441a9785b21d7687b41a03d1e19843d644be7741e39843d6904fa70563d9a78284dfa335037833d7a45e77751359e676d40a533523d83696d56a9754c3d86686d4aea6a1e3983696947e2601e3b96732845e5645f21843d6a41a9704c3991696d40a97259399e737b50a97a4a74d7686450e07e5f2c92717104fb764d2d9b69614aee335736d7747c57a9775b359e6e6d0a");

	/**
	 * Given potential key length, computes the sum of byte frequencies over a
	 * ciphertext encrypted with modified Vigenere cipher.
	 * 
	 * @param len
	 *            potential key length to compute sum of byte frequencies for.
	 * @return sum of byte frequencies for the given key length.
	 */
	public static double compFreqSum(int len) {
		ArrayList<Byte> currentArray = new ArrayList<Byte>();
		int start = 0;
		double num, frequency = 0, sum = 0;
		while (start < len) {
			for (int i = start; i < cipherText.length; i += len) {
				currentArray.add(cipherText[i]);
			}

			for (int j = 0; j < currentArray.size(); j++) {
				num = Collections.frequency(currentArray, currentArray.get(j));
				frequency = Math.pow((num / currentArray.size()), 2);

			}
			sum += frequency;
			currentArray.clear();
			start++;
		}
		return sum;
	}

	/**
	 * https://deveshsharma.info/2013/07/16/find-most-common-element-in-a-list-in-java/
	 * 
	 * @param list
	 *            specific ArrayList to inspect
	 * @return element with the most number of occurrences
	 */
	private static byte mostCommonElement(ArrayList<Byte> list) {

		HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

		for (int i = 0; i < list.size(); i++) {

			Integer frequency = map.get(list.get(i));
			if (frequency == null) {
				map.put(list.get(i), 1);
			} else {
				map.put(list.get(i), frequency + 1);
			}
		}

		Byte mostCommonKey = null;
		int maxValue = -1;
		for (HashMap.Entry<Byte, Integer> entry : map.entrySet()) {

			if (entry.getValue() > maxValue) {
				mostCommonKey = entry.getKey();
				maxValue = entry.getValue();
			}
		}

		return mostCommonKey;
	}

	/**
	 * counts the number of specified bytes in an ArrayList of bytes
	 * 
	 * @param list
	 *            list to check
	 * @param b
	 *            byte to check for
	 * @return number of occurrences of b in list
	 */
	public static int countBytes(ArrayList<Byte> list, byte b) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(b)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Recovers the complete key that was used in the modified Vigenere cipher.
	 * 
	 * @param len
	 *            length of the key to be cracked.
	 * @return hex-encoded string of the recovered key.
	 */
	public static String crackVigenereKey(int len) {
		ArrayList<Byte> currentArray = new ArrayList<Byte>();
		byte[] key = new byte[len];

		byte spaceAscii = 32;
		byte eLetter = 101;
		byte tLetter = 116;
		byte aLetter = 97;

		int start = 0;
		double percentage = 0;

		while (start < len) {
			for (int i = start; i < cipherText.length; i += len) {
				currentArray.add(cipherText[i]);
			}

			percentage = ((double) countBytes(currentArray, mostCommonElement(currentArray)) / currentArray.size())
					* 100;

			// System.out.println(percentage);

			key[start] = (byte) (mostCommonElement(currentArray) ^ spaceAscii);

			if (percentage >= 11 && percentage <= 14.7) {
				currentArray.removeAll(Arrays.asList(mostCommonElement(currentArray)));
				key[start] = (byte) (mostCommonElement(currentArray) ^ eLetter);
			}

			if (percentage > 15 && percentage <= 16 && start != 0) {
				currentArray.removeAll(Arrays.asList(mostCommonElement(currentArray)));
				currentArray.removeAll(Arrays.asList(mostCommonElement(currentArray)));
				currentArray.removeAll(Arrays.asList(mostCommonElement(currentArray)));
				key[start] = (byte) (mostCommonElement(currentArray) ^ tLetter);
			}

			if (percentage >= 13 && percentage <= 14.7) {
				currentArray.removeAll(Arrays.asList(mostCommonElement(currentArray)));
				key[start] = (byte) (mostCommonElement(currentArray) ^ aLetter);
			}

			currentArray.clear();
			start++;
		}

		System.out.println("Hex Key: " + Convert.bytesToHex(key));
		System.out.println("Byte Array of Key After xor: " + Arrays.toString(key));
		return Convert.bytesToHex(key);
	}

	/**
	 * Decrypts the modified version of the Vigenere cipher with proper key.
	 * 
	 * @param c
	 *            array of ciphertext bytes to be decrypted.
	 * @param k
	 *            array of key bytes.
	 * @return ASCII plaintext message string.
	 */
	public static String decryptModifiedVigenere(byte[] c, byte[] k) {
		byte[] decryptedMessage = new byte[c.length];

		for (int i = 0; i < c.length; i++) {
			decryptedMessage[i] = (byte) (c[i] ^ k[i % k.length]);
		}
		// System.out.println("Original Cipher Byte Array: " +
		// Arrays.toString(cipherText));
		// System.out.println("Byte Array of Xor-ed Cipher: " +
		// Arrays.toString(decryptedMessage));
		return Convert.bytesToString(decryptedMessage);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// System.out.println(Arrays.toString(cipherText));
		// System.out.println("Length 5: " + compFreqSum(5));
		// System.out.println("Length 6: " + compFreqSum(6));
		// System.out.println("Length 7: " + compFreqSum(7));
		System.out.println("Key Length 8: " + compFreqSum(8));
		// System.out.println("Length 9: " + compFreqSum(9));
		// System.out.println("Length 10: " + compFreqSum(10));
		// System.out.println("Length 11: " + compFreqSum(11));
		// System.out.println("Length 12: " + compFreqSum(12));
		// System.out.println("Length 13: " + compFreqSum(13));
		// System.out.println("Length 14: " + compFreqSum(14));
		// System.out.println("Length 15: " + compFreqSum(15));

		// System.out.println(Convert.bytesToString(cipherText));
		// System.out.println("\n" + crackVigenereKey(8));
		System.out.println(
				"\nPlainText Message: " + decryptModifiedVigenere(cipherText, Convert.hexToBytes(crackVigenereKey(8))));
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) + " ns");
	}
}
