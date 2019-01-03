import java.util.Scanner;

/**
 * Program to add a specified int to an orinigal int (args[0]) predefined by a
 * call of the program
 * 
 * @author Eric Wojcik
 * @version 31 January 2017
 */
public class Add {
	public static void main(String[] args) {
		try {
			int firstNum = 0;

			if (args.length > 0) {
				firstNum = Integer.parseInt(args[0]);
			}

			Scanner scan = new Scanner(System.in);

			while (scan.hasNext()) {
				int addNum = scan.nextInt();
				System.out.print((firstNum + addNum) + " ");
			}
			scan.close();
		}

		catch (NumberFormatException num) {
			System.err.println("Add: The argument entered is not an integer...");
		}

	}
}
