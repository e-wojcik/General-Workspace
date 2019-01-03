/**
 * Player for the chips game that removes a random number within the limit
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 *
 */
public class RandomPlayer implements Player {
	String name;

	/**
	 * constructor that sets the default name to "Randy"
	 */
	public RandomPlayer() {
		name = "Randy";
	}

	/**
	 * constructor that sets the player name
	 * 
	 * @param n
	 *            the name of the player
	 */
	public RandomPlayer(String n) {
		name = n;
	}

	/**
	 * returns a number between 1 and the limit
	 */
	@Override
	public int getMove(Game g) {
		return (int) Math.ceil(Math.random() * g.getLimit());
	}

	/**
	 * returns the player's name
	 */
	@Override
	public String getName() {
		return name;
	}

}
