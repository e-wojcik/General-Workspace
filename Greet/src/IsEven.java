/**
 * Program to test if a number inputted is even, and echo them to the output
 * stream if they are
 * 
 * @author Eric Wojcik
 * @version 05 February 2017
 */
public class IsEven {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < args.length; i++) {
				int currentNum = Integer.parseInt(args[i]);
				if (currentNum % 2 == 0) {
					System.out.print(currentNum + " ");
				}
			}
		}

		catch (NumberFormatException num) {
			System.err.println("IsEven: The argument entered is not an integer...");
		}

	}
}
