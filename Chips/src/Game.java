/**
 * Class to create the logic of a game of Chips
 * 
 * @author Eric Wojcik
 * @version 28 March 2017
 *
 */
public class Game {
	private int removeLimit;
	private int pile;

	/**
	 * constructor that sets the initial pile size and the limit; throws an
	 * exception if the initial pile size is less than 3 chips
	 * 
	 * @throws IllegalArgumentException
	 *             if pile is initially larger than 3
	 * @param numChips
	 *            the initial pile size parameter
	 */
	public Game(int numChips) {
		pile = numChips;

		if (pile < 3) {
			throw new IllegalArgumentException();
		}

		removeLimit = pile - 1;
	}

	/**
	 * returns the current limit size
	 * 
	 * @return the current limit
	 */
	public int getLimit() {
		return removeLimit;
	}

	/**
	 * returns the current pile size
	 * 
	 * @return the current pile size
	 */
	public int getPile() {
		return pile;
	}

	/**
	 * removes a specified number of chips from the pile as long as the limit
	 * rules are followed
	 * 
	 * @throws IllegalArgumentException
	 *             if removeNum is outside limit parameters
	 * @param removeNum
	 *            the number of chips to remove
	 */
	public void removeChips(int removeNum) {
		if (!((removeNum >= 1) && (removeNum <= removeLimit))) {
			throw new IllegalArgumentException();
		}

		else {
			pile -= removeNum;
			removeLimit = removeNum * 2;

			if (removeLimit > pile) {
				removeLimit = pile;
			}
		}
	}
}