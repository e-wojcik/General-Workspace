import java.math.BigInteger;
import java.util.Scanner;

/**
 * Program to test different algorithms for determining and reporting the nth
 * (given) Fibonacci number
 * 
 * @author Eric Wojcik
 * @version 09 September 2018
 *
 */
public class nthFib {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Please input the nth Fibonacci number to calculate: ");
		int input = scan.nextInt();
		System.out.println("Input: " + input);
		long start = System.currentTimeMillis();
//		int num = fib(input);
		BigInteger num = fib(input);
		long stop = System.currentTimeMillis(); // get the current time
		long duration = stop - start;
		System.out.println("The result of the nth given Fibonacci number: " + num);
//		System.out.println("The length of the nth Fibonacci number string: " + num.toString().length());
		System.out.println("Duration of excution: " + duration + "ms");
	}

	/**
	 * Iterative method to determine the nth Fibonacci number
	 * 
	 * @param n nth place to determine
	 * @return the nth Fibonacci number
	 */
//	 public static int fib(int n) {
	public static BigInteger fib(int n) {
		// if (n <= 1)
		// return 1;
		// return fib(n - 1) + fib(n - 2);

		// if (n <= 1)
		// return BigInteger.ONE;
		// else return fib(n - 1).add(fib(n - 2));

//		 int result = 0, prevResult = 1, temp;
		BigInteger result = BigInteger.ZERO, prevResult = BigInteger.ONE, temp;
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be less than zero");
		} else if (n <= 1) {
			return BigInteger.ONE;
//			 return 1;
		}

		for (int i = 1; i <= n; i++) {
			temp = result.add(prevResult);
//			temp = result + prevResult;
			result = prevResult;
			prevResult = temp;
		}
		return prevResult;
	}
}
