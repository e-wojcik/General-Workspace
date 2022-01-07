import java.util.Scanner;

/**
 * Program to print args (if they exist), greet the user with the first arg, and
 * if none exist ask the user what to be greeted by
 * 
 * @author Eric Wojcik
 * @version 31 January 2017
 */
public class Greet {
	public static void main(String[] args) {
		// System.out.println("Hello World!");
		Scanner scan = new Scanner(System.in);

		// for(int i = 0; i < args.length; i++)
		// {
		// System.out.println(args[i]);
		// }

		if (args.length >= 1) {
			System.out.println("Hello " + args[0] + "!");
		}

		else {
			System.out.println("What is your name?");
			String name = scan.nextLine();
			System.out.println("Hello " + name + "!");
		}
		scan.close();
	}
}
