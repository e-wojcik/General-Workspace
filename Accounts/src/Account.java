/**
 * Class to define account types, principle values, interest rates, active days
 * of the account, and provides getters and setters for each.
 * 
 * @author WojcikEricM
 * @version 19 April 2017
 */
public class Account {
	private float principal;
	private float rate;
	private int daysActive;
	private int accountType;

	public static final int STANDARD = 0;
	public static final int BUDGET = 1;
	public static final int PREMIUM = 2;
	public static final int PREMIUM_PLUS = 3;

	/**
	 * method to calculate and the amount of interest on an Account minus the
	 * principal amount
	 * 
	 * @return the interest earned
	 */
	public double interestEarned() {
		double interest = Math.exp(this.getRate() 
				* (this.getDaysActive() / 365.25));

		return this.getPrincipal() * interest - this.getPrincipal();
	}

	/**
	 * method that tests if an Account is a premium type, and then modifies the
	 * total fee owed
	 * 
	 * @param totalFee
	 *            the total fee owed
	 * @return the modified total fee
	 */
	public float isPremium(float totalFee) {
		if (this.getAccountType() == PREMIUM ||
				this.getAccountType() == PREMIUM_PLUS) {
			totalFee += Fees.BROKER_FEE_PERCENT 
					* this.interestEarned();
		}
		return totalFee;
	}

	/**
	 * returns the current principle of an Account
	 * 
	 * @return the principle amount
	 */
	public float getPrincipal() {
		return principal;
	}

	/**
	 * sets the current principle amount of an Account
	 * 
	 * @param principal
	 *            amount to set the principle to
	 */
	public void setPrincipal(float principal) {
		this.principal = principal;
	}

	/**
	 * returns the current interest rate
	 * 
	 * @return the current interest rate
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * sets the current interest rate
	 * 
	 * @param rate
	 *            rate to be set
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}

	/**
	 * returns the number of days active of an Account
	 * 
	 * @return the current number of days active
	 */
	public int getDaysActive() {
		return daysActive;
	}

	/**
	 * number of days active of an Account to be set to
	 * 
	 * @param daysActive
	 *            the new number of days active
	 */
	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}

	/**
	 * returns the type of an Account
	 * 
	 * @return the Account type
	 */
	public int getAccountType() {
		return accountType;
	}

	/**
	 * sets the type of an Account
	 * 
	 * @param accountType
	 *            type of Account to be set
	 */
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

}
