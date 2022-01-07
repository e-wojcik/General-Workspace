/**
 * Referee class for the ChipsMain program; makes sure that the rules are
 * followed correctly and contains a user-set verbosity
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 */
public class Referee {
	private boolean verbosity;

	/**
	 * sets the default verbosity
	 */
	public Referee() {
		verbosity = true;
	}

	/**
	 * sets the user-defined verbosity
	 * 
	 * @param b
	 *            user preference
	 * @return the user's chosen verbosity
	 */
	public boolean setVerbose(boolean b) {
		return verbosity = b;
	}

	/**
	 * plays the game following the game rules and displays each move and the
	 * final winner
	 * 
	 * @param roster
	 *            the array of Player(s)
	 * @param limit
	 *            the initial pile size of the game
	 * @return the final winner of the game
	 */
	public String playGame(Player[] roster, int limit) {
		Game game = new Game(limit);
		String winner = "";

		while (game.getPile() > 0) {
			for (int i = 0; i < roster.length; i++) {
				int currentMove = roster[i].getMove(game);
				if(verbosity){
				System.out.println(roster[i].getName() + " removing " 
				+ currentMove + " chips from a pile of size "
						+ game.getPile() + ".");
				}
				game.removeChips(currentMove);
				winner = roster[i].getName();

				if (game.getPile() == 0) {
					return winner;
				}
			}
		}
		return winner;
	}
}
