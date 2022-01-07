import java.util.Scanner;

/**
 * Class to ask for a number from the user and return the same number into the
 * console
 * 
 * @author Eric Wojcik
 * @version 28 February 2017
 */
public class KeyboardDice implements Dice {
	private Scanner scan;
	private int num;

	/**
	 * Default constructor that initializes the Scanner and sets the num
	 * instance variable to 20 by default
	 */
	public KeyboardDice() {
		scan = new Scanner(System.in);
		num = 20;
	}

	/**
	 * Constructor that initializes the Scanner and sets the num instance
	 * variable to a specified integer passed as a parameter
	 * 
	 * @param numberOfSides
	 *            the specified number of sides expressed as an integer
	 */
	public KeyboardDice(int numberOfSides) {
		scan = new Scanner(System.in);
		num = numberOfSides;
	}

	/**
	 * roll() method to prompt for the input of a number between 0 and a
	 * previously specified integer (num) and return the exact input
	 */
	@Override
	public int roll() {
		int choice = 0;
		int current = 0;
		try {
			while (choice <= num && choice > 0) {
				System.out.print("Enter a number between 0 and " + num + ": ");
				choice = scan.nextInt();
			}
			if (choice > num || choice < 0) {
				System.err.println("Previous choice: " + current);
			}
		} catch (NumberFormatException e) {
			System.err.println("The number entered is not an integer, please try again...");
		}
		return choice;
	}

}
