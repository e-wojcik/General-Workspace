/**
 * Short class to implement ModelObserver to update the actual tip percentage
 * 
 * @author Eric Wojcik
 * @version 26 February 2017
 */
public class ActualTipViewUpdate implements ModelObserver {
	// updates the actual tip percentage
	@Override
	public double update(TipModel m) {
		return m.getActualTipPercent();
	}

}
