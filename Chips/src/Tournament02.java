/**
 * 
 * @author TienH
 * purpose: To start a chip tournament with given players and pile and put the stats into a access database
 * @version 4/9/2017
 *
 */
public class Tournament02 {

	private static int player1Wins;
	private static int player2Wins;
	private static String matchWinner;

	public static void main(String[] args) {

		Player[] players = { new OnesPlayer("Onesy"), new MaxPlayer("Greedy"), new MaxPlayer("Selfish"),
				new RandomPlayer("Lucky"), new OnesPlayer() };
		int[] pile = { 10, 21, 55, 117 };

		runTourney(players, pile);

	}
	/*
	 * Start the tournament with a given array of player objects, and an array of int(pile size)
	 * Get all permutation of matches
	 * Create a ChipGameDataBase object which create a access database file given a name
	 * Create a table in that database
	 * Add tournament stats to that database
	 */

	public static void runTourney(Player[] arrayPlayer, int[] integerArray) {
		ChipGameDataBase chipData = new ChipGameDataBase();
		chipData.createChipDatabase("chipTournament.mdb");
		chipData.createTable("TournamentStats");
		for (int i = 0; i < arrayPlayer.length; i++) {

			for (int j = i + 1; j < arrayPlayer.length; j++) {

				playMatch(arrayPlayer, i, j, integerArray);

				chipData.addData(arrayPlayer[i].getName() + " plays " + arrayPlayer[j].getName(),
						arrayPlayer[i].getName(), player1Wins, arrayPlayer[j].getName(), player2Wins, matchWinner);

			}

		}

	}
	/*
	 * Start each permutation/ matches given an array of player object, i,j varible in forloop, and the pilesize array
	 * Create a referee object to start playing the matches/games
	 * Acquire the number of wins for each matches between two players
	 */
	private static void playMatch(Player[] arrayPlayer, int i, int j, int[] integerArray) {

		matchWinner = "";
		Referee ref = new Referee();
		ref.setVerbose(false);
		player1Wins = 0;
		player2Wins = 0;
		Player[] matchPlayers = { arrayPlayer[i], arrayPlayer[j] };
		Player[] flipmatchPlayers = { arrayPlayer[j], arrayPlayer[i] };
		 System.out.println(arrayPlayer[i].getName() + " plays " +
		 arrayPlayer[j].getName());

		for (int k = 0; k < integerArray.length; k++) {

			String winnerRotation1 = ref.playGame(matchPlayers, integerArray[k]);
			String winnerRotation2 = ref.playGame(flipmatchPlayers, integerArray[k]);

//			 System.out.println("Winner is "+ winnerRotation1);
//			 System.out.println("Winner is "+ winnerRotation2);

			if (winnerRotation1.equals(arrayPlayer[i].getName())) {
				player1Wins++;
			}
			if (winnerRotation1.equals(arrayPlayer[j].getName())) {
				player2Wins++;
			}
			if (winnerRotation2.equals(arrayPlayer[i].getName())) {
				player2Wins++;
			}
			if (winnerRotation2.equals(arrayPlayer[j].getName())) {
				player1Wins++;
			}

			 System.out.println(" " + arrayPlayer[i].getName() + " Plays " +
			 arrayPlayer[j].getName() + " with "
			 + integerArray[k] + " chips");
			
			 System.out.println(" " + arrayPlayer[j].getName() + " Plays " +
			 arrayPlayer[i].getName() + " with "
			 + integerArray[k] + " chips");

		}
		if (player1Wins > player2Wins) {
			matchWinner = arrayPlayer[i].getName();
		} else if (player2Wins > player1Wins) {
			matchWinner = arrayPlayer[j].getName();
		} else {
			matchWinner = "Tie";
		}

		System.out.println(
				arrayPlayer[i].getName() + " " + player1Wins + " " + arrayPlayer[j].getName() + " " + player2Wins);

	}

}
