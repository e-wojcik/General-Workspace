
import java.util.ArrayList;
import java.util.Collections;

/**
 * Program to break any Caesar Cipher
 *
 * @author Eric Wojcik
 * @version 29 January 2017
 *
 */
public class CaesarCipher {

    public static void main(String args[]) {
        String ciphertext = "lwzdvwkhzrqwriwkhlppruwdojrgvvrphwlphvwrjudqwsurvshulwbdqgorqjlpsxqlwbwrphqzkrvhfulphvwkhbzhuhplqghgwrsxqlvklqrughuwkdwdfrpsohwhuhyhuvhriiruwxqhpljkwpdnhwkhpvxiihupruhelwwhuob";

        System.out.println("Caesar's Shift broken!\n\nMessage: "
                + breakCaesarShift(ciphertext, 23));
    }

    /**
     * Breaks Caesar's Shift Cipher, given any shift parameter.
     *
     * @param ciphertext message encrypted using the cipher.
     * @param shift shift of plain alphabet (0-25) to create cipher alphabet.
     * @return plaintext English message if used with proper shift parameter;
     * empty string otherwise.
     */
    public static String breakCaesarShift(String ciphertext, int shift) {
        if (shift < 0 || shift > 25) {
            return "";
        }
        if (shift == 0) {
            return ciphertext; //Understand why?
        }
        String plaintext = "";
        char[] plainAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};
//		YOUR CODE HERE
        ciphertext.toLowerCase();
        ArrayList<Character> cipherAlph = new ArrayList<Character>();

        for (int h = 0; h < plainAlphabet.length; h++) {
            cipherAlph.add(plainAlphabet[h]);
        }

        Collections.rotate(cipherAlph, shift);

        for (int i = 0; i < ciphertext.length(); i++) {
            for (int j = 0; j < cipherAlph.size(); j++) {
                if (ciphertext.charAt(i) == cipherAlph.get(j)) {
                    plaintext = plaintext + plainAlphabet[j];
                }
            }
        }
        return plaintext;
    }

    /**
     * Counts the number of occurrences of character 'e' in a string.
     *
     * @param str string to be counted on.
     * @return the number of times 'e' occurs in the string.
     */
    public static int countEs(String str) {
        str = str.toLowerCase();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
        return count;
    }

    /**
     * Iterates over all 26 shift possibilities of Caesar's Shift Cipher to find
     * a shift that yields between 12% and 14% of 'e' occurrences in the
     * resulting plaintext decryption of ciphertext.
     *
     * @param ciphertext encrypted message to find proper shift on.
     * @return the proper shift needed to break the cipher.
     */
    public static int findCaesarShift(String ciphertext) {
        ciphertext = ciphertext.toLowerCase();
        int shift = 0;
        char[] plain = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};
        //YOUR CODE HERE
        String plainText = "";
        double numEs = 0.0;
        double percentE = 0.0;
        for (int i = 0; i < plain.length; i++) {
            plainText = CaesarCipher.breakCaesarShift(ciphertext, shift);
            numEs = CaesarCipher.countEs(plainText);
            percentE = (numEs / plainText.length()) * 100;

            if (percentE >= 12 && percentE <= 14) {
                return shift;
            }

            shift++;
        }

        return shift;
    }

}
