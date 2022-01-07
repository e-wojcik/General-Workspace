/**
 * Player for the chips game that always removes the maximum number possible
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 */
public class MaxPlayer implements Player {
	private String name;

	/**
	 * constructor that sets the default name to "Lisa"
	 */
	public MaxPlayer() {
		name = "Lisa";
	}

	/**
	 * constructor that sets the name of the player
	 * 
	 * @param n
	 *            the specified name of the player
	 */
	public MaxPlayer(String n) {
		name = n;
	}

	/**
	 * returns the limit, or the biggest move allowed
	 */
	@Override
	public int getMove(Game g) {
		return g.getLimit();
	}

	/**
	 * returns the name of the player
	 */
	@Override
	public String getName() {
		return name;
	}

}
