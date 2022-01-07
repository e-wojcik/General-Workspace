/**
 * Class to conduct the calculation of any fees on any Account
 * 
 * @author WojcikEricM
 *
 */
public class Fees {

	static final double BROKER_FEE_PERCENT = .0125;

	/**
	 * method to calculate the current fee of an account (which is an element in
	 * an array of account objects).
	 * 
	 * @param accounts
	 *            the array of Account objects
	 * @return the total current fee
	 */
	public static float calculateFee(Account accounts[]) {
		float totalFee = 0;
		Account currentAccount;
		for (int i = 0; i < accounts.length; i++) {
			currentAccount = accounts[i];
			totalFee = currentAccount.isPremium(totalFee);
		}
		return totalFee;
	}
}
