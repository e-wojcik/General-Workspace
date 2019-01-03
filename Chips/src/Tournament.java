import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

/**
 * Program to perform a Chips tournament. This program creates a database to
 * record the match and player data after performing permutations on the players
 * for each match.
 * 
 * @author Eric Wojcik
 * @version 08 April 2017
 */
public class Tournament {
	private static int firstPlayer;
	private static int secondPlayer;
	private static String game;
	private static String winner;

	/**
	 * Creates the database, determines the current game, and records the
	 * results into the database
	 * 
	 * @param roster
	 *            the array of Players
	 * @param intArray
	 *            the array of game pile sizes
	 */
	public static void runTourney(Player[] roster, int[] intArray) {
		try {
			File file = new File("tourney.mdb");
			Database db = new DatabaseBuilder(file)
					.setFileFormat(Database.FileFormat.V2010)
					.create();
			Table table = new TableBuilder("Tournament Results")
					.addColumn(new ColumnBuilder("Match", DataType.TEXT))
					.addColumn(new ColumnBuilder("First Player Name", DataType.TEXT))
					.addColumn(new ColumnBuilder("First Player Score", DataType.INT))
					.addColumn(new ColumnBuilder("Second Player Name", DataType.TEXT))
					.addColumn(new ColumnBuilder("Second Player Score", DataType.INT))
					.addColumn(new ColumnBuilder("Winner of the Match", DataType.TEXT))
					.toTable(db);

			for (int i = 0; i < roster.length; i++) {
				for (int j = i + 1; j < roster.length; j++) {
					playMatch(roster, i, j, intArray);

					table.addRow(game, roster[i].getName(), firstPlayer,
							roster[j].getName(), secondPlayer, winner);
					firstPlayer = 0;
					secondPlayer = 0;
				}
			}
			db.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Performs each of the 8 matches for the current game
	 * 
	 * @param roster
	 *            the array of Players
	 * @param i
	 *            the index of the first Player of the two
	 * @param j
	 *            the index of the second Player of the two
	 * @param intArray
	 *            the array of game pile sizes
	 */
	private static void playMatch(Player[] roster, int i, int j, int[] intArray) {
		game = roster[i].getName() + " plays " + roster[j].getName();
		System.out.println(game);

		// Initialize the Ref
		Referee ref = new Referee();
		ref.setVerbose(false);

		// Create two sub-rosters (one for each order of two)
		Player[] subRosterOne = { roster[i], roster[j] };
		Player[] subRosterTwo = { roster[j], roster[i] };

		// Perform the matches
		for (int k = 0; k < intArray.length; k++) {
			String rotateOne = ref.playGame(subRosterOne, intArray[k]);
			String rotateTwo = ref.playGame(subRosterTwo, intArray[k]);

			System.out.println(
					"	" + roster[i].getName() + " plays " 
			+ roster[j].getName() + " with " + intArray[k] + " chips.");

			System.out.println(
					"	" + roster[j].getName() + " plays " 
			+ roster[i].getName() + " with " + intArray[k] + " chips.");

			// String win01 = ref.playGame(subRosterOne, intArray[k]);
			// String win02 = ref.playGame(subRosterTwo, intArray[k]);
			//
			// System.out.println("The winner is: " + win01);
			// System.out.println("The winner is: " + win02);

			// Record the number of wins for each Player of the two
			if (rotateOne.equals(roster[i].getName())) {
				firstPlayer++;
			}

			if (rotateOne.equals(roster[j].getName())) {
				secondPlayer++;
			}

			if (rotateTwo.equals(roster[i].getName())) {
				firstPlayer++;
			}
			if (rotateTwo.equals(roster[j].getName())) {
				secondPlayer++;
			}
		}

		if (firstPlayer > secondPlayer) {
			winner = roster[i].getName();
		} else if (secondPlayer > firstPlayer) {
			winner = roster[j].getName();
		} else if (firstPlayer == secondPlayer) {
			winner = "Tie";
		}

		System.out.println(
				"	" + roster[i].getName() + " " + firstPlayer + " " 
		+ roster[j].getName() + " " + secondPlayer);
	}

	/**
	 * Main method to initialize the arrays of Players and pile sizes, and then
	 * start the tournament
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Player[] roster = { new OnesPlayer("Onesy"), new MaxPlayer("Greedy"), new MaxPlayer("Selfish"),
				new RandomPlayer("Lucky"), new RandomPlayer(), new EricPlayer() };
		int[] intArray = { 10, 21, 55, 117 };
		runTourney(roster, intArray);
	}
}