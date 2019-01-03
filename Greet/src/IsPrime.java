import java.util.Scanner;

/**
 * Program to test if a passed args element is a prime number and echo it if it
 * is, ignore it if it is not
 * 
 * @author Eric Wojcik
 * @version 05 February 2017
 *
 */
public class IsPrime {
	/**
	 * method to test if a num is a prime number
	 * 
	 * @param n
	 *            num to test
	 * @return true if num is prime, false if not
	 */
	public static boolean isPrime(int n) {

		if (n < 0) {
			return false;
		}
		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			if (args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					int currentNum = Integer.parseInt(args[i]);
					if (IsPrime.isPrime(currentNum) == true) {
						System.out.print(currentNum + " ");
					}
				}
			}

			while (scan.hasNext()) {
				int num = scan.nextInt();
				if (IsPrime.isPrime(num) == true) {
					System.out.print(num + " ");
				}
			}
			scan.close();
		} catch (NumberFormatException num) {
			System.err.println("IsPrime: The argument entered is not an integer...");
		}
	}
}
