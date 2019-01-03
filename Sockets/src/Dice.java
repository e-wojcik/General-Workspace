/**
 * Interface to include only the roll() method header
 * 
 * @author Eric Wojcik
 * @version 07 March 2017
 */
public interface Dice {

	/**
	 * Roll the Dice and return result of roll. Returns a random integer between
	 * 1 and the number of sides.
	 * 
	 * @return result of roll
	 */
	int roll();
}