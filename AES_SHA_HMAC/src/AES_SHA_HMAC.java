import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_SHA_HMAC {

	private static byte[] AES_KEY = Convert.hexToBytes("03b1d45002ddd3c2b29ee39e846a6d1f");
	private static byte[] SHA_KEY = Convert
			.hexToBytes("d43d9c00a8cf711791d60576f93170c78da08fc84261dfa5837b0da90bdfbb55");
	private static byte[] sign;

	/**
	 * Signs a message with HMAC-SHA-256 algorithm.
	 * 
	 * @param k
	 *            byte array of signing key.
	 * @param m
	 *            message to be signed with the key.
	 * @return byte array of message's hash signature.
	 * @throws NoSuchAlgorithmException
	 * 
	 *             http://stackoverflow.com/questions/7124735/hmac-sha256-algorithm-for-signature-calculation
	 */
	public static byte[] sign(byte[] k, byte[] m) throws NoSuchAlgorithmException {
		final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		final SecretKeySpec secret_key = new SecretKeySpec(k, "HmacSHA256");
		try {
			sha256_HMAC.init(secret_key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		final byte[] mac_data = sha256_HMAC.doFinal(m);
		String result = "";
		for (final byte element : mac_data) {
			result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
		}

		return Convert.hexToBytes(result);
	}

	/**
	 * Verifies HMAC-SHA-256 signature on a message.
	 * 
	 * @param k
	 *            byte array of signing key.
	 * @param h
	 *            hash signature being challenged.
	 * @param m
	 *            message signed with the key.
	 * @return true is signature computes; false otherwise.
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean verify(byte[] k, byte[] h, byte[] m) throws NoSuchAlgorithmException {
		byte[] h1 = sign(k, m);
		String h01 = Convert.bytesToHex(h1);
		String origH = Convert.bytesToHex(h);

		if (h01.equals(origH)) {
			return true;
		}
		return false;
	}

	/**
	 * Encrypts a message with AES-128 algorithm.
	 * 
	 * @param m
	 *            message to be encrypted.
	 * @param k1
	 *            byte array of AES key.
	 * @param k2
	 *            byte array of SHA key.
	 * @return H(iv + c) + iv + c, where: iv - initialization vector for
	 *         encryption; H - authenticated hash signature of ciphertext; c -
	 *         ciphertext from encryption.
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws IOException
	 * 
	 *             http://code.runnable.com/VnHq6GZPubRF5u27/aes-encryption-for-java
	 */
	public static byte[] encrypt(byte[] m, byte[] k1, byte[] k2)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {

		SecretKeySpec skeySpec = new SecretKeySpec(k1, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(m);
		byte[] iv = cipher.getIV();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(iv);
		outputStream.write(encrypted);
		byte[] encryptedData = outputStream.toByteArray();
		sign = sign(k2, encryptedData);
		return encryptedData;
	}

	/**
	 * Decrypts a ciphertext with AES-128 algorithm.
	 * 
	 * @param c
	 *            ciphertext to be decrypted.
	 * @param k1
	 *            byte array of AES key.
	 * @param k2
	 *            byte array of SHA key.
	 * @return byte array of decrypted plaintext.
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * 
	 *             http://code.runnable.com/VnHq6GZPubRF5u27/aes-encryption-for-java
	 */
	public static byte[] decrypt(byte[] c, byte[] k1, byte[] k2)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		if (verify(k2, sign, c)) {
			SecretKeySpec skeySpec = new SecretKeySpec(k1, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = Arrays.copyOfRange(c, 0, 16);
			byte[] cipherText = Arrays.copyOfRange(c, 16, c.length);
			IvParameterSpec iv_specs = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);
			byte[] decryptedBytes = cipher.doFinal(cipherText);
			return decryptedBytes;
		}

		else {
			return c;
		}
	}

	public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {

		String data = "Hello, world!";
		System.out.println("String before encryption: " + data);
		byte[] encrypted = encrypt(Convert.stringToBytes(data), AES_KEY, SHA_KEY);
		System.out.println("AES encryption: " + Convert.bytesToHex(encrypted));
		byte[] decrypted = decrypt(encrypted, AES_KEY, SHA_KEY);
		System.out.println("Decrypted plaintext: " + Convert.bytesToString(decrypted));

		System.out.println("\nThe SHA256 checksum: " + Convert.bytesToHex(sign));

		// byte[] sampleDecrypt = decrypt(
		// Convert.hexToBytes(
		// "4aadc1df26ee77f027667cb7655d98db4d998573a765395a4e01c3033855325ccd365a11a937ef01640cc401ec7359e2131d307d0b54e32cbfb068c8c2d026b751db89829c283c26f4af62450be34e4fcdfa5cdfd27e82927f9371eea9825edabacda21b45951d323b71a66d9ae17a837d7bf9675068e5fb8122220f3db01f5e90bcfa4b86ac2a334766a50ff7295ba88da19a2cc6cbda5e84652ed088370f85e460ef4862c4c5bfcf339379425786fbfa644f2c02e0ed8682f971cb1f22817212c7610542b0bc456087c82651315c3e91e9172b670ec7856f02077ba533c7923595b94b05e6075f980285288a8598615fd89b32e98ef581dde90beb91ae104084b24be4a2f393644b7e515cd5ba305d0d4d3c1a9cff3f8faa963abab72803e5"),
		// AES_KEY, SHA_KEY);
		// System.out.println("Decryption of sample encrypted message: " +
		// Convert.bytesToString(sampleDecrypt));
	}
}