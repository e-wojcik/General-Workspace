/**
 * Class that contains a main that rolls Dice ten times and prints the results
 * in the console
 * 
 * @author Eric Wojcik
 * @version 28 February 2017
 */
public class DiceMain {
	public static void main(String[] args) {
		// Dice die = new RandomDice();
		Dice keyDie = new KeyboardDice();
		// for (int i = 0; i < 10; i++) {
		// System.out.println("Roll Number " + (i + 1) + ": " + die.roll());
		// }

		for (int i = 0; i < 5; i++) {
			System.out.println("Roll Number " + (i + 1) + ": " + keyDie.roll());
		}
	}
}
