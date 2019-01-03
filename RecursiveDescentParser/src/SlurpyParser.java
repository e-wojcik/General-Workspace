import java.io.*;
import java.util.Scanner;

/**
 * Class to determine if an obtained string from the user is a slurpy based off of the given 
 * grammar. Determination of the truth value of a slurpy is obtained through recursive method calls.
 * 
 * @author Eric Wojcik
 * @version 03 April 2018
 * 
 * Help was obtained by examining the 8th problem of the 1996 ACM Mid-Atlantic Programming Contest and 
 * the solutions of the top placing universities as well as test cases (open to the public 
 * via archived contest records).
 * 
 * http://www.cs.nthu.edu.tw/~progcont/ACM/ProblemSetArchive/B_US_MidAtl/1996/index.html
 * http://www.cs.sbu.edu/dlevine/PreviousCourses/Spring%202014/CS331Spring2014/Prog2.htm
 */

class SlurpyParser {

	private static String charStr; // current character string
	private static int currLocation; // current location in the string
	private static Scanner input; // user input to gain string

	/**
	 * Method that returns the current character of the current character string
	 * 
	 * @return the current character
	 */
	public static char currentChar() {
		return charStr.charAt(currLocation);
	}

	/**
	 * Method to test if the current location is at the end of the string
	 * 
	 * @return truth value of being at the end of the string
	 */
	public static boolean endOfCharStr() {
		if (currLocation == (charStr.length() - 1))
			return true;
		else
			return false;
	}

	/**
	 * Method to test if the token is beyond the end of the string
	 * 
	 * @return the truth value of being beyond the end of the string
	 */
	public static boolean afterEndOfCharStr() {
		if (currLocation == charStr.length())
			return true;
		else
			return false;
	}
	
	/**
	 * Method to "consume" the current character from the token string
	 */
	public static void consumeCharacter() {

		if (afterEndOfCharStr())
			System.out.println("Cannot consume off of the end of the string");
		else
			currLocation++;
	}

	/**
	 * Method to test if the retrieved string is a slump according to the given
	 * grammar and recursive method calls
	 * 
	 * @return whether the currently examined string is a slump
	 */
	public static boolean isSlump() {

		if (!((currentChar() == 'D') || (currentChar() == 'E'))) {
			return false;
		}

		if (endOfCharStr()) {
			return false;
		}
		consumeCharacter();

		if (!(currentChar() == 'F')) {
			return false;
		}

		if (endOfCharStr()) {
			return false;
		}
		consumeCharacter();

		while (currentChar() == 'F') {
			if (endOfCharStr()) {
				return false;
			}
			consumeCharacter();
		}

		if (currentChar() == 'G') {
			consumeCharacter();
			return true;
		} else
			return isSlump();
	}

	/**
	 * Method to test if the given string is a slimp based on the given grammar and
	 * recursive method calls
	 * 
	 * @return whether the examined string is a slimp
	 */
	public static boolean isSlimp() {

		if (!(currentChar() == 'A')) {
			return false;
		}

		if (endOfCharStr()) {
			return false;
		}
		consumeCharacter();

		if (currentChar() == 'H') {
			consumeCharacter();
			return true;
		}

		else if (currentChar() == 'B') {
			if (endOfCharStr()) {
				return false;
			}
			consumeCharacter();
			if (!isSlimp()) {
				return false;
			}
			if (afterEndOfCharStr()) {
				return false;
			}
			if (!(currentChar() == 'C')) {
				return false;
			}
			consumeCharacter();
			return true;
		}

		else {
			if (!isSlump()) {
				return false;
			}
			if (afterEndOfCharStr()) {
				return false;
			}
			if (!(currentChar() == 'C')) {
				return false;
			}
			consumeCharacter();
			return true;
		}
	}

	/**
	 * Method to test if the string is a slurpy based off of recursive method calls
	 * 
	 * @return whether the string entered is a slurpy
	 */
	public static boolean isSlurpy() {

		if (!(isSlimp())) {
			return false;
		}
		if (afterEndOfCharStr()) {
			return false;
		}
		if (!(isSlump())) {
			return false;
		}
		if (!(afterEndOfCharStr())) {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) throws IOException {

		input = new Scanner(System.in);

		System.out.println("BEGIN SLURPY INPUT");

		System.out.println("Enter the number of times that you wish to run the slurpy analyzer...");

		int n;
		n = input.nextInt();
		System.out.println();

		for (int count = 1; count <= n; count++) {

			System.out.print("Enter a string to be tested: ");
			charStr = input.next();
			currLocation = 0;

			System.out.print("Is the string a slurpy? : ");
			if ((isSlurpy())) {
				System.out.println("YES\n");
			} else
				System.out.println("NO\n");
		}

		System.out.println("END SLURPY OUTPUT");
	}
}
