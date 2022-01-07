import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Model for TipView and all proper getters, setters, and handlers (for
 * observers)
 * 
 * @author Eric Wojcik
 * @version 26 February 2017
 */
public class TipModel {
	private double totalBill;
	private double tipPercentage;
	private double tipQuantum;
	private ArrayList<ModelObserver> modObv = new ArrayList<ModelObserver>();

	/**
	 * Default constructor
	 */
	public TipModel() {
		totalBill = 0;
		tipPercentage = 0;
		tipQuantum = 0;
	}

	/**
	 * Constructor used to create a TipModel object
	 * 
	 * @param bill
	 *            original total Bill
	 * @param percent
	 *            tip percentage to apply to total bill
	 * @param quantum
	 *            quantum level to round the tip bill to
	 */
	public TipModel(double bill, double percent, double quantum) {
		totalBill = bill;
		tipPercentage = percent;
		tipQuantum = quantum;
	}

	/**
	 * Setter for the total bill
	 * 
	 * @param bill
	 *            amount to set the total bill to
	 */
	public void setBill(double bill) {
		totalBill = bill;
	}

	/**
	 * Setter for the tip percentage
	 * 
	 * @param percent
	 *            percent to apply to the total bill to find the tip amount
	 */
	public void setPercentage(double percent) {
		tipPercentage = percent / 100;
	}

	/**
	 * Setter for the quantum to round the tipped bill amount to
	 * 
	 * @param quantum
	 *            the rounding level
	 */
	public void setQuantum(double quantum) {
		tipQuantum = quantum;
	}

	/**
	 * Getter for the total bill
	 * 
	 * @return the total bill instance variable
	 */
	public double getTotalBill() {
		return totalBill;
	}

	/**
	 * Getter for the tip percentage
	 * 
	 * @return the value of the tip percentage instance variable
	 */
	public double getTipPercentage() {
		return tipPercentage;
	}

	/**
	 * Getter for the quantum rounding level for the final bill
	 * 
	 * @return the value of the quantum instance variable
	 */
	public double getQuantum() {
		return tipQuantum;
	}

	/**
	 * Getter for the base tip
	 * 
	 * @return the tip
	 */
	public double getTip() {
		return totalBill * tipPercentage;
	}

	/**
	 * Getter to round the tipped bill to the quantum level
	 * 
	 * @return the newly rounded bill
	 */
	public double getRoundedTip() {
		int amtPennies = (int) (getTip() * 100);
		int qntPennies = (int) (tipQuantum * 100);
		int amtPenniesAdj = amtPennies + (qntPennies / 2);

		int divide = amtPenniesAdj / qntPennies;

		int roundPennies = divide * qntPennies;

		double round = roundPennies / 100.0;

		return round;
	}

	/**
	 * Getter to compute the actual tip percentage after rounding compared to
	 * the actual bill amount
	 * 
	 * @return the actual tip percentage
	 */
	public double getActualTipPercent() {
		return ((getRoundedTip() / totalBill) * 100);
	}

	/**
	 * toString to convert any number to a string with a specified number of
	 * decimal places
	 * 
	 * @param num
	 *            number to round
	 * @param decimalPlaces
	 *            number of decimal places to round num to
	 * @return a string stating the newly rounded number
	 */
	public String roundedString(double num, double decimalPlaces) {
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
	 * Adds a model observer to a list
	 * 
	 * @param mod
	 *            ModelObserver object to add to the list
	 */
	public void addObserver(ModelObserver mod) {
		modObv.add(mod);
	}

	/**
	 * "Updates" each ModelObserver object and prints out the current data in
	 * the console for each element in the list
	 */
	public void updateOccurred() {

		for (int i = 0; i < modObv.size(); i++) {
			modObv.get(i).update(this);
		}
	}

	/**
	 * Returns a simple string of the three data elements
	 */
	public String toString() {
		return "Total Bill: " + getTotalBill() + "\nTip Percentage: " 
				+ getTipPercentage() + "\nQuantum: "
				+ getQuantum() + "\n";
	}
}
