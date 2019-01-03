import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Human player for the chips game with appropriate prompts
 * 
 * @author Eric Wojcik
 * @version 02 April 2017
 */
public class HumanPlayer implements Player {
	private String name;
	private Scanner scan = new Scanner(System.in);
	private int move;

	/**
	 * prompts for the human player's name and sets the name instance variable
	 */
	public HumanPlayer() {
		System.out.println("What is your name? ");
		String n = scan.nextLine();
		name = n;
	}

	/**
	 * returns a player-defined move
	 */
	@Override
	public int getMove(Game g) {
		try {
			System.out.println("Currrent Pile Size: " + g.getPile());
			System.out.println("Current Limit: " + g.getLimit());
			System.out.println("Enter your move: ");
			move = scan.nextInt();
		} catch (InputMismatchException im) {
			System.err.println("The input you entered is not an integer: " + im);
		}
		return move;
	}

	/**
	 * returns the name of the human player
	 */
	@Override
	public String getName() {
		return name;
	}

}
