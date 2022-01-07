/**
 * Counts from 0 to N (N being arg[0]) or prints an error stream otherwise
 * 
 * @author Eric Wojcik
 * @version 31 January 2017
 *
 */
public class Count {
	public static void main(String[] args) {
		int firstNum = 0;

		if (args.length > 0) {
			firstNum = Integer.parseInt(args[0]);
		}

		if (firstNum >= 0) {
			for (int i = 0; i < firstNum; i++) {
				System.out.print(i + " ");
			}
		}

		else if (firstNum < 0) {
			System.err.print("Count: The argument "
					+ "parsed was not a positive integer...");
		}
	}
}
