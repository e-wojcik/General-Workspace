import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to create ArrayLists of "fortunes" from a text file (specified by
 * number of lines or by lines that contain a specific string of characters),
 * and contains a method to get a random "fortune" based on any args passed to
 * the main method (either none or ONE WORD for which to search).
 * 
 * @author Eric Wojcik
 * @version 07 March 2017
 */
public class FortuneTeller {
	private ArrayList<String> keyFortunes = new ArrayList<String>();
	private ArrayList<String> fortunes = new ArrayList<String>();

	/**
	 * Constructor to add to the fortunes ArrayList each line of text in the
	 * fortunes.txt file
	 */
	public FortuneTeller() {
		File fortunesTxt = new File("fortunes.txt");
		try {
			Scanner input = new Scanner(fortunesTxt);

			while (input.hasNextLine()) {
				fortunes.add(input.nextLine());
			}

			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to create a RandomDice object and perform a "roll" based on the
	 * number of sides of the "die" (the number of lines in the text file).
	 * 
	 * @return "random" roll on the ArrayList
	 */
	public String getFortune() {
		// KeyboardDice die = new KeyboardDice(fortunes.size() - 1);
		RandomDice die = new RandomDice(fortunes.size());
		return fortunes.get(die.roll());
	}

	/**
	 * Method to add to the keyFortunes ArrayList each line of the text file
	 * that contains a specific string of characters,
	 * 
	 * @param key
	 *            the specific string of characters for which to search
	 * @return "random" roll on the ArrayList
	 */
	public String getFortune(String key) {
		keyFortunes.clear();
		try {
			for (int i = 0; i < fortunes.size(); i++) {
				String currentLine = fortunes.get(i);
				if (currentLine.contains(key)) {
					keyFortunes.add(currentLine);
				}
			}

			if (keyFortunes.size() == 0) {
				return "Nothing good comes when one thinks of " + key;
			}

			else if (keyFortunes.size() == 1) {
				return keyFortunes.get(0);
			}

		} catch (IndexOutOfBoundsException iob) {
			iob.printStackTrace();
		}
		// KeyboardDice die = new KeyboardDice(keyFortunes.size() - 1);
		RandomDice die = new RandomDice(keyFortunes.size());
		return keyFortunes.get(die.roll());
	}

	/**
	 * Main to take arguments as parameters and print a random "fortune"
	 * 
	 * @param args
	 *            either nothing or ONE WORD for which to search
	 */
	public static void main(String[] args) {
		// try {
		// FortuneTeller teller = new FortuneTeller();
		//
		// for (int i = 0; i < 5; i++) {
		// System.out.println(teller.getFortune("is"));
		// }
		// } catch (IndexOutOfBoundsException ie) {
		// System.err.println("The number entered is more than the number of
		// fortunes, please try again...");
		// }

		FortuneTeller teller = new FortuneTeller();
		Scanner scan = new Scanner(System.in);

		if (args.length == 0) {
			System.out.println(teller.getFortune());
		}

		else {
			System.out.println(teller.getFortune(args[0]));
		}

		scan.close();
	}

}
