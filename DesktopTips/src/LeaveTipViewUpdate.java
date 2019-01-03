/**
 * Short class to implement ModelObserver to update the tip amount to leave at
 * the table or register
 * 
 * @author Eric Wojcik
 * @version 26 February 2017
 */
public class LeaveTipViewUpdate implements ModelObserver {

	// specific to leaving a tip
	@Override
	public double update(TipModel m) {
		return m.getRoundedTip() + m.getTotalBill();
	}

}
