/**
 * A simple program to play a single game of Chips. All of the "real work" is
 * done in the supporting classes.
 * 
 * @author dlevine
 * @version 16 April 2015
 *
 */
public class ChipsMain {

	public static void main(String[] args) {
		Referee ref = new Referee();
		ref.setVerbose(true);
		Player[] roster = { new HumanPlayer(), new EricPlayer("Bob"), 
				new OnesPlayer("Lisa"),
				new MaxPlayer("Mike") };
		String winner = ref.playGame(roster, 20);
		System.out.println("The winner is player: " + winner);
	}

}
