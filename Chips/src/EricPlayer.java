/**
 * Player for the chips game that always removes a number 1 more than half the
 * limit size
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 *
 */
public class EricPlayer implements Player {
	String name;

	/**
	 * constructor that sets the default name to "Eric"
	 */
	public EricPlayer() {
		name = "Eric";
	}

	/**
	 * constructor to set the name of the player
	 * 
	 * @param n
	 *            the name of the player
	 */
	public EricPlayer(String n) {
		name = n;
	}

	/**
	 * returns a number 1 more than half the limit
	 */
	@Override
	public int getMove(Game g) {
		return (g.getLimit() / 2) + 1;
	}

	/**
	 * returns the player's name
	 */
	@Override
	public String getName() {
		return name;
	}

}
