
import java.util.Arrays;

/**
 * Helper methods for breaking the Many Time Pad cipher
 *
 * @author Eric Wojcik
 * @version 06 Febraury 2017
 *
 */
public class ManyTimePad {

	public static final byte[] CIPHER_1 = Convert.hexToBytes(
			"e028b758f93266f9ad6e5044b9bd2d1fd709cfc965fe286dc1fe241b5a1e5b30a6c7dad04efe223383de9e0647d8663e74da768747322b9e8d963fb7dcaea29595aa94b930be26d3cd78");
	public static final byte[] CIPHER_2 = Convert
			.hexToBytes("e169a75cf0252ce4e143185ebcbc6c3f8211c29231aa0928d9b3691b594a0f38f3c8c79409f0213b8d");
	public static final byte[] CIPHER_3 = Convert.hexToBytes(
			"fc21b113cc3228e7e81a7c44b9bc6e39cb13cfd32cf96066d7aa69045c190f77b286dbd11abf213983c8840550d8733e44c123ce5a772fdadd8a39fbd1afa88496f3daec25f02d9dc97667f40a89e09c8a24042f85136eb3f231fffd98394d889a7bc7cd4cbc361ed6a4035782b180955c70fd0f0bac2ec1b3d7be918fc811ee4a75bd2ae1f222a0c06246576572834abbb12bd2a5e72a22fabc82cafd4b92408f484d293e4d6fadef4db82944c8e963113c9eb21a1b2536cfdbac9d4c6b4be215edf96768fd6828c0d12351e330e4eacff6a42dfc746a8cc8db8c7226ce2437b6d6de7cad6035f0f8a1585b0c29dd29619acfcadb7d2f7b8400cc10d92d5fcb07de9d4734b739e9ae1e42c71cf6e713641d68bfcab538a8ce03ac0b3224e25808b0bc");
	public static final byte[] CIPHER_4 = Convert.hexToBytes(
			"f126a113ff212fe4e24e185daaaa7e6c822c8a9228aa2128cbbb3b1848040f77bcc088c006fa6e0cc6d9830c418b1b777fd02f875e3e2b96c98722b7d1bae78096efd6aa28ff24d8883977b1399eaf8dcb762f2593472dbdf23abea9f0205f8f86279eb94cb8655ac7a4070181bcd2911b66fd0d47ed2ecae796b88687cf5dba5b7bbc26b6fc2bafc871034a233fb740a5b66b96c2e16434fead8f8ffb41c11490441912764d2baefd1feb504fd8bf651c3d80b80a1b363ecac1ee");
	public static final byte[] CIPHER_5 = Convert.hexToBytes(
			"fc21b113da2f33e9e81a515eebae652cd645cd9a33ef3328d9fe030b4d035b3fbad588c401e82b2d8d9ab81d12d87d7f639566c94c2529838d8439f2d2b8e7978cef97b821fa69dfd17670fd14d0ac96933f182dc61326b5f233a2f3f0194adc867ccc9f4ba82b5ad5f61952c7b4ce901b61f10f4eb932c4e7d3aad093d50aba4b60e968fff423bd85604b4065788348b1a03c96f1e12333eba681dda1");
	public static final byte[] CIPHER_6 = Convert.hexToBytes(
			"fc21b113d92e28ede05b1840aaba6524cc00d9d332ef326d98bf691d4c181232a086c7d24efa223ac0ce830618c6387d65d46dce4a3622dadf8d24f8ccfca49d8ee293be64f328dec03f7ff40bd0a49a93331a2596022afcfd3ab5fda5235b98d560d0cd50b5201ec3b71e4d9ef880805431f9084fe034d2f6d8ad9983d259ba4171a77ee3e83eeed17b035537709641b3ac65d5eae32933edad8dcee302c1049151552e734d3ba8e91eaa67448df26f113a9ab60c42663cd6dfad8158635cea0eeaba2928b20d2bc8c23a55b167edf698bfbd3ef5763e80c28f8b6572d3233cf3f59b7aa8602ff0f4a14b57102add2924b5dedb93653c22f701c1598b3b5edb548c994061af25ffae1a5ec61cf0ef45520073b2ccf916e9d84a9644");
	public static final byte[] CIPHER_7 = Convert.hexToBytes(
			"e23cb85ae93361c9ec5f4b4cb9f97a2cd145cbd317e52d69d6fe390145030f3eb0cfc9da42bf293acddf830859877d7f63d123c946232f98c18770f6cba8af9b8caa99aa64d228c9c13831e10a9fb39acb763e2fc61722bde531b5fdb1705d8e9c7dd78e45b1654cc9ba09018ebb80805374b4045da82ed1e096ad9887d211f64770e97ef9ba33a6c034474028769141f0b72396f1e62176cda189cee10eb30588545b2d774f6fa0e45aeb7d48c8bf7414208bf7115d662bd1d7e0a659675ee55ac6b8376fe02d6b");
	public static final byte[] CIPHER_8 = Convert.hexToBytes(
			"eb3bad43e82f2de5ea431844b8f97925c745da8124e93461dbbb690f470e5b24a7d3cccd4ef0287fd7df92015bc22c6b68c623c146256e89c88125e5dbfca49b93e783a22dfd28c9c1397fb1119ee08b8d33563a94023db9f237b4fdbf361e889d60cc8904ad244cd2bf0952c7b6c1985774f0414aa936c0e1c5b8828fc342b40259a678f3ba20abcb71514429739b08f0bb37cff5fa2b31edaf94c7f60e8813d8405b2e6b586fa2e550b87d52d8fc72143d89f71f55227fd8dca1984f7056e51da3a53569e62726cec92414e578edf198a6a12de67d249186db817520c36b29b2c08a61a07261bfe3ef58561b6fc82e6698c5ccdb763c6dc942db59983d5ec0408c884628ad2ceeeb5f5dc74fece802601c2f");
	public static final byte[] CIPHER_9 = Convert.hexToBytes(
			"e228a252bc2932aaec1a5f48a5bc7f2cce48da8637fa2f7bddfe2a01441a0e23b6d488c41cf0292dc2d79c005bcc7d726cdb64d248302bdad98a31e39eb5b4d49de598af31ec3bd8c6223db11b9ca18c967b142b95022af0bc3bb3b7b5334ad19a7bd7884aa9205a8af60d4f83f5d3845e72fd0742ae21c9ffcff99483d558fd4c71ad2ae2f567a6c4624605246cc242b5af65dfe8fe2833f2ab8adbee5a880f96015d246e4921a5ef50a86045debf670e739eb80d482f3dd5d7ee");
	public static final byte[] CIPHER_10 = Convert.hexToBytes("e528ad13e82824aacb554a4eaef96f288212c3872daa3967cdf0");
	public static final byte[] TARGET_CIPHER = Convert.hexToBytes(
			"ff2cb85fbc242ee4e81b1864ebb1623dc745c49c32aa3967cdfe3a0b4c4a1338a486cdc20bf16e3e83ca941b53ce3e6a61cc23d44c343c9fd9c233e5c7acb39bdef995a421f32c9dce377dfd0bd0a18f8424026a850823acf031a5b8bc291e8b9d6cd0cd4db03552c3bb094f93b0c4d4527ff70e59bf25c6e7daa0dec6f454f74779ab6fe4ba33a6cc670d");

	/**
	 * main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "";
		for (int i = 0; i < 256; i++) {
			if (isPossibleKeyByte(1, (byte) i, 32, 126)) {
				byte[] key = new byte[1];
				key[0] = (byte) i;
				str += Convert.bytesToHex(key);

			}
		}

		// System.out.println(Arrays.toString(Convert.hexToBytes(str)));
		byte[] tryKey = new byte[139];
		tryKey[0] = (byte) -88;
		// First Character: -88
		tryKey[1] = (byte) 73;
		// Second Character: 73
		tryKey[2] = (byte) -44;
		tryKey[3] = (byte) 51;
		tryKey[4] = (byte) -100;
		// Fifth Chracter: -100
		tryKey[5] = (byte) 64;
		// Sixth Character: 64
		tryKey[6] = (byte) 65;
		// Seventh Character: 65
		tryKey[7] = (byte) -118;
		// Eight Character: -118
		tryKey[8] = (byte) -115;
		// Ninth Character: -115
		tryKey[9] = (byte) 58;
		// Tenth Character: 58
		tryKey[10] = (byte) 56;
		tryKey[11] = (byte) 45;
		tryKey[12] = (byte) -53;
		tryKey[13] = (byte) -39;
		tryKey[14] = (byte) 13;
		tryKey[15] = (byte) 77;
		tryKey[16] = (byte) -94;
		tryKey[17] = (byte) 101;
		tryKey[18] = (byte) -86;
		tryKey[19] = (byte) -13;
		tryKey[20] = (byte) 69;
		tryKey[21] = (byte) -118;
		tryKey[22] = (byte) 64;
		tryKey[23] = (byte) 8;
		tryKey[24] = (byte) -72;
		tryKey[25] = (byte) -34;
		tryKey[26] = (byte) 73;
		tryKey[27] = (byte) 110;
		tryKey[28] = (byte) 41;
		tryKey[29] = (byte) 106;
		tryKey[30] = (byte) 123;
		tryKey[31] = (byte) 87;
		tryKey[32] = (byte) -45;
		tryKey[33] = (byte) -90;
		tryKey[34] = (byte) -88;
		tryKey[35] = (byte) -76;
		tryKey[36] = (byte) 110;
		tryKey[37] = (byte) -97;
		tryKey[38] = (byte) 78;
		tryKey[39] = (byte) 95;
		tryKey[40] = (byte) -93;
		tryKey[41] = (byte) -70;
		tryKey[42] = (byte) -15;
		tryKey[43] = (byte) 105;
		tryKey[44] = (byte) 53;
		tryKey[45] = (byte) -85;
		tryKey[46] = (byte) 93;
		tryKey[47] = (byte) 30;
		tryKey[48] = (byte) 13;
		tryKey[49] = (byte) -75;
		tryKey[50] = (byte) 3;
		tryKey[51] = (byte) -89;
		tryKey[52] = (byte) 41;
		tryKey[53] = (byte) 87;
		tryKey[54] = (byte) 78;
		tryKey[55] = (byte) -6;
		tryKey[56] = (byte) -83;
		tryKey[57] = (byte) -30;
		tryKey[58] = (byte) 80;
		tryKey[59] = (byte) -105;
		tryKey[60] = (byte) -66;
		tryKey[61] = (byte) -36;
		tryKey[62] = (byte) -57;
		tryKey[63] = (byte) -12;
		tryKey[64] = (byte) -2;
		tryKey[65] = (byte) -118;
		tryKey[66] = (byte) -10;
		tryKey[67] = (byte) -52;
		tryKey[68] = (byte) 68;
		tryKey[69] = (byte) -98;
		tryKey[70] = (byte) 73;
		tryKey[71] = (byte) -67;
		tryKey[72] = (byte) -88;
		tryKey[73] = (byte) 86;
		tryKey[74] = (byte) 17;
		tryKey[75] = (byte) -111;
		tryKey[76] = (byte) 120;
		tryKey[77] = (byte) -16;
		tryKey[78] = (byte) -64;
		tryKey[79] = (byte) -1;
		tryKey[80] = (byte) -27;
		tryKey[81] = (byte) 86;
		tryKey[82] = (byte) 118;
		tryKey[83] = (byte) 74;
		tryKey[84] = (byte) -26;
		tryKey[85] = (byte) 103;
		tryKey[86] = (byte) 78;
		tryKey[87] = (byte) -36;
		tryKey[88] = (byte) -100;
		tryKey[89] = (byte) 84;
		tryKey[90] = (byte) -47;
		tryKey[91] = (byte) -35;
		tryKey[92] = (byte) -48;
		tryKey[93] = (byte) 80;
		tryKey[94] = (byte) 62;
		tryKey[95] = (byte) -4;
		tryKey[96] = (byte) -11;
		tryKey[97] = (byte) 9;
		tryKey[98] = (byte) -66;
		tryKey[99] = (byte) -19;
		tryKey[100] = (byte) 36;
		tryKey[101] = (byte) -35;
		tryKey[102] = (byte) 69;
		tryKey[103] = (byte) 62;
		tryKey[104] = (byte) -90;
		tryKey[105] = (byte) -42;
		tryKey[106] = (byte) 108;
		tryKey[107] = (byte) 33;
		tryKey[108] = (byte) -25;
		tryKey[109] = (byte) -43;
		tryKey[110] = (byte) -96;
		tryKey[111] = (byte) -12;
		tryKey[112] = (byte) 59;
		tryKey[113] = (byte) 17;
		tryKey[114] = (byte) -108;
		tryKey[115] = (byte) 97;
		tryKey[116] = (byte) 43;
		tryKey[117] = (byte) -51;
		tryKey[118] = (byte) 64;
		tryKey[119] = (byte) -91;
		tryKey[120] = (byte) -109;
		tryKey[121] = (byte) -74;
		tryKey[122] = (byte) -39;
		tryKey[123] = (byte) -16;
		tryKey[124] = (byte) -26;
		tryKey[125] = (byte) -90;
		tryKey[126] = (byte) 49;
		tryKey[127] = (byte) -102;
		tryKey[128] = (byte) 34;
		tryKey[129] = (byte) 20;
		tryKey[130] = (byte) -55;
		tryKey[131] = (byte) 10;
		tryKey[132] = (byte) -106;
		tryKey[133] = (byte) -102;
		tryKey[134] = (byte) 71;
		tryKey[135] = (byte) -50;
		tryKey[136] = (byte) -91;
		tryKey[137] = (byte) 20;
		tryKey[138] = (byte) 35;
		System.out.println(
				"Result byte from checking against a particular message: " + checkKeyAgainstMessage(9, 138, 'e'));
		System.out.println("Current state of the key: " + Convert.bytesToHex(tryKey));
		System.out.println();
		System.out.println(TARGET_CIPHER.length);

		// printMessages(tryKey);
		printMessages(Convert.hexToBytes(
				"a849d4339c40418a8d3a382dcbd90d4da265aaf3458a4008b8de496e296a7b57d3a6a8b46e9f4e5fa3baf16935ab5d1e0db503a729574efaade25097bedcc7f4fe8af6cc449e49bda856119178f0c0ffe556764ae6674edc9c54d1ddd0503efcf509beed24dd453ea6d66c21e7d5a0f43b1194612bcd40a593b6d9f0e6a6319a2214c90a969a47cea51423"));
	}

	/**
	 * Encrypts an array of message bytes by XORing them with key bytes.
	 *
	 * @param m
	 *            array of plaintext message bytes to be encrypted with
	 *            One-Time-Pad.
	 * @param k
	 *            array of key bytes.
	 * @return array of ciphertext bytes.
	 */
	public static byte[] otpEncrypt(byte[] m, byte[] k) {
		if (m.length > k.length) {
			return null;
		}
		byte[] ciphertext = new byte[m.length];
		for (int i = 0; i < m.length; i++) {
			ciphertext[i] = (byte) (m[i] ^ k[i]);
		}
		return ciphertext;
	}

	/*
	 * Prints out the entire state of ALL potential plaintext messages given the
	 * current state of the key, regardless of message lengths or the current
	 * key length.
	 * 
	 * @param k key array of bytes.
	 */
	public static void printMessages(byte[] k) {
		System.out.print("MESSAGE 01: ");
		int min = (k.length > CIPHER_1.length) ? CIPHER_1.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_1[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 02: ");
		min = (k.length > CIPHER_2.length) ? CIPHER_2.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_2[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 03: ");
		min = (k.length > CIPHER_3.length) ? CIPHER_3.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_3[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 04: ");
		min = (k.length > CIPHER_4.length) ? CIPHER_4.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_4[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 05: ");
		min = (k.length > CIPHER_5.length) ? CIPHER_5.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_5[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 06: ");
		min = (k.length > CIPHER_6.length) ? CIPHER_6.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_6[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 07: ");
		min = (k.length > CIPHER_7.length) ? CIPHER_7.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_7[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 08: ");
		min = (k.length > CIPHER_8.length) ? CIPHER_8.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_8[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 09: ");
		min = (k.length > CIPHER_9.length) ? CIPHER_9.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_9[i])));
		}
		System.out.println();
		System.out.print("MESSAGE 10: ");
		min = (k.length > CIPHER_10.length) ? CIPHER_10.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ CIPHER_10[i])));
		}
		System.out.println();
		System.out.print("TARGET MESSAGE: ");
		min = (k.length > TARGET_CIPHER.length) ? TARGET_CIPHER.length : k.length;
		for (int i = 0; i < min; i++) {
			System.out.print(Character.toString((char) (k[i] ^ TARGET_CIPHER[i])));
		}
		System.out.println();
	}

	/**
	 * Checks whether a given key byte at a certain position is within required
	 * parameters for ALL messages.
	 *
	 * @param pos
	 *            byte position, starting at 0.
	 * @param k
	 *            potential key byte to check for validity.
	 * @param min
	 *            the minimum value for the plain message byte after XOR with
	 *            the potential key byte.
	 * @param max
	 *            the maximum value for the plain message byte after XOR with
	 *            the potential key byte.
	 * @return true if the potential key byte is within parameters; false
	 *         otherwise.
	 */
	public static boolean isPossibleKeyByte(int pos, byte k, int min, int max) {
		if (pos < CIPHER_1.length) {
			byte check = (byte) (CIPHER_1[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_2.length) {
			byte check = (byte) (CIPHER_2[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_3.length) {
			byte check = (byte) (CIPHER_3[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_4.length) {
			byte check = (byte) (CIPHER_4[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_5.length) {
			byte check = (byte) (CIPHER_5[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_6.length) {
			byte check = (byte) (CIPHER_6[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_7.length) {
			byte check = (byte) (CIPHER_7[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_8.length) {
			byte check = (byte) (CIPHER_8[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_9.length) {
			byte check = (byte) (CIPHER_9[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < CIPHER_10.length) {
			byte check = (byte) (CIPHER_10[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		if (pos < TARGET_CIPHER.length) {
			byte check = (byte) (TARGET_CIPHER[pos] ^ k);
			if (check < min || check > max) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given a guess of the cryptanalyst on what the next character of a
	 * decrypted plaintext message should be, attempts to fit a potential key
	 * byte so that the character is resolved.
	 *
	 * @param m
	 *            message/ciphertext identifier to check against.
	 * @param pos
	 *            byte position, starting at 0.
	 * @param c
	 *            character/byte to fit the potential key byte to according to
	 *            the cryptanalyst's guess.
	 * @return fitting potential key byte if successful; the NUL byte otherwise.
	 */
	public static byte checkKeyAgainstMessage(int m, int pos, char c) {
		try {
			byte[] cipher;
			switch (m) {
			case 1:
				cipher = CIPHER_1;
				break;
			case 2:
				cipher = CIPHER_2;
				break;
			case 3:
				cipher = CIPHER_3;
				break;
			case 4:
				cipher = CIPHER_4;
				break;
			case 5:
				cipher = CIPHER_5;
				break;
			case 6:
				cipher = CIPHER_6;
				break;
			case 7:
				cipher = CIPHER_7;
				break;
			case 8:
				cipher = CIPHER_8;
				break;
			case 9:
				cipher = CIPHER_9;
				break;
			case 10:
				cipher = CIPHER_10;
				break;
			case 11:
				cipher = TARGET_CIPHER;
				break;
			default:
				return 0;
			}
			return (byte) (cipher[pos] ^ (byte) c);
		} catch (Exception ex) {
			return 0;
		}
	}
}
