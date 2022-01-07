
/**
 * ModelObserver is a simple interface that all observers of the Model class
 * must implement
 * 
 * @author dlevine, Eric Wojcik
 *
 */

public interface ModelObserver {

	// double becasue all ModelObservers deal with results that are just doubles
	public double update(TipModel m);

}
