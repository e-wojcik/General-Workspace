import java.util.Scanner;

/**
 * Program that contains a main method to implement the TipUtilities class to
 * calculate a tip from a whole bill or from a portion of a bill
 * 
 * @author Eric Wojcik
 * @version 29 January 2017
 */
public class ConsoleTips {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		System.out.println("What is the base bill?");
		double bill = scan.nextDouble();
		scan.nextLine();
		System.out.println("Answer: $" + TipUtilities.toString(bill, 2));

		System.out.println("\nAre you paying tip for a portion of the bill?");
		String answer = scan.nextLine();
		System.out.println("Answer: " + answer);

		double portionBill = 0.0;
		if (answer.equals("yes")) {
			System.out.println("\nWhat amount of the total bill do you wish to" + " pay tip on?");
			portionBill = scan.nextDouble();
			System.out.println("Answer: $" + TipUtilities.toString(portionBill, 2));
		}

		System.out.println("\nWhat is the basic tip percentage you wish" + " to use?");
		double percent = scan.nextDouble();
		System.out.println("Answer: " + TipUtilities.toString(percent, 2) + "%");

		double subTip = TipUtilities.calcTip(bill, percent);
		double newSubTip = TipUtilities.calcTip(portionBill, percent);

		if (answer.equals("yes")) {
			System.out.println("\nThe subtip determined by the inputted data: $" + TipUtilities.toString(newSubTip, 2));
		}

		else
			System.out.println("\nThe subtip determined by the inputted data: $" + TipUtilities.toString(subTip, 2));

		System.out.println("\nWhat do you want to round the tip to?");
		double quantum = scan.nextDouble();
		System.out.println("The nearest " + TipUtilities.toString(quantum, 2));

		double newTip = TipUtilities.round(subTip, quantum);
		double portionTip = TipUtilities.round(newSubTip, quantum);

		if (answer.equals("yes")) {
			System.out.println("\nThe new calculated tip is: $" + TipUtilities.toString(portionTip, 2));
		}

		else
			System.out.println("\nThe new calculated tip is: $" + TipUtilities.toString(newTip, 2));

		double actual = TipUtilities.actualTip(bill, newTip);
		double portionActual = TipUtilities.actualTip(portionBill, portionTip);

		if (answer.equals("yes")) {
			System.out.println("\nThe actual tip percent is: " + TipUtilities.toString(portionActual, 1) + "%");
		}

		else
			System.out.println("\nThe actual tip percent is: " + TipUtilities.toString(actual, 1) + "%");

		if (answer.equals("yes")) {
			double newTotal = portionTip + portionBill;
			System.out.println("\nLeave $" + TipUtilities.toString(newTotal, 2) + " at your table or the register.");
		}

		else {
			double newTotal = bill + newTip;
			System.out.println("\nLeave $" + TipUtilities.toString(newTotal, 2) + " at your table or the register.");
		}

		System.out.println("\nThank you for using Tip Calculator!");
	}
}
