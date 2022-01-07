/**
 * Player for the chips game that always removes only 1 chip
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 *
 */
public class OnesPlayer implements Player {
	private String name;

	/**
	 * constructor that sets the default name to "Bob"
	 */
	public OnesPlayer() {
		name = "Bob";
	}

	/**
	 * constructor that sets the name of the player
	 * 
	 * @param n
	 *            name of the player
	 */
	public OnesPlayer(String n) {
		name = n;
	}

	/**
	 * returns a move of 1
	 */
	@Override
	public int getMove(Game g) {
		return 1;
	}

	/**
	 * returns the player's name
	 */
	@Override
	public String getName() {
		return name;
	}

}
