/**
 * Class Dice Encapsulation of methods for rolling an n-sided die, where n is
 * passed as an argument when a die is created. The default value is 6.
 * 
 * @author S Andrianoff, Eric Wojcik
 * @version 01 March 2017
 */

public class RandomDice implements Dice {
	private int sides;

	/**
	 * Constructor for a Dice object. Default of six sides.
	 *
	 */
	public RandomDice() {
		this(6);
	}

	/**
	 * Constructor for a Dice object. Number of sides given.
	 * 
	 * @param numSides
	 *            number of sides of Dice
	 */
	public RandomDice(int numSides) {
		sides = numSides;
	}

	/**
	 * roll() method taken from Dice interface to return a random number between
	 * 0 and the number of sides
	 */
	@Override
	public int roll() {
		double x;
		x = Math.random();
		return (int) Math.floor(x * sides);
	}
}
