import java.text.DecimalFormat;

/**
 * Program that conatins a simple tip calculator, a tip rounder, and a classic
 * toString method.
 * 
 * @author Eric Wojcik
 * @version 22 January 2017
 */
public class TipUtilities {
	/**
	 * method to calculate simple tip
	 * 
	 * @param double
	 *            basis the base payment/bill
	 * @param double
	 *            percentage decimal tip percent
	 * @return basic tip calculated from mulitplying the parameters
	 */
	public static double calcTip(double basis, double percentage) {
		percentage = percentage / 100;
		return basis * percentage;
		// return 0.0;
	}

	/**
	 * method to take a subtip and a quantum rounding level and calculate a
	 * rounded tip (nearest quantum)
	 * 
	 * @param subTip
	 *            a tip basis/base bill
	 * @param quantum
	 *            the specification to round to
	 * @return rounded tip the new tip rounded off
	 */
	public static double round(double subTip, double quantum) {
		int amtPennies = (int) (subTip * 100);
		int qntPennies = (int) (quantum * 100);
		int amtPenniesAdj = amtPennies + (qntPennies / 2);

		int divide = amtPenniesAdj / qntPennies;

		int roundPennies = divide * qntPennies;

		double round = roundPennies / 100.0;

		return round;
		// return subTip;
	}

	/**
	 * Simple method to convert a num to a num with specified decimal places
	 * 
	 * @param num
	 *            starting number
	 * @param decimalPlaces
	 *            number of decimal places to round to
	 * @return formatted string the new number rounded off
	 * 
	 *         https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
	 */
	public static String toString(double num, int decimalPlaces) {
		String str = ".";
		int i = 0;

		while (i < decimalPlaces) {
			str += "#";
			i++;
		}

		if (decimalPlaces == 0) {
			str = "";
		}
		DecimalFormat form = new DecimalFormat("##" + str);
		return form.format(num);
	}

	/**
	 * method to calculate the actual tip percent
	 * 
	 * @param original
	 *            the original bill
	 * @param newTip
	 *            the newly weighted tip
	 * @return the actual tip percentage
	 */
	public static double actualTip(double original, double newTip) {
		return (newTip / original) * 100;
	}
}
