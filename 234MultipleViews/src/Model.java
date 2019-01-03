import java.util.ArrayList;

/**
 * Program to create a integer data model (with standard getters and setters and
 * modifiers) and create a list of observers of the model
 * 
 * @author Eric Wojcik
 * @version 16 February 2017
 */
public class Model {
	private int data;
	private ArrayList<ModelObserver> modObv = new ArrayList<ModelObserver>();

	/**
	 * Default constructor
	 */
	public Model() {
		data = 0;
	}

	/**
	 * Constructor to start a Model object with a predetermined data amount
	 * 
	 * @param dataInt
	 *            the defined starting data amount
	 */
	public Model(int dataInt) {
		data = dataInt;
	}

	/**
	 * Basic getter for the data
	 * 
	 * @return the data integer
	 */
	public int getData() {
		return data;
	}

	/**
	 * Basic setter that also determines when to update a model observer
	 * 
	 * @param setNum
	 *            integer to set data to
	 */
	public void setData(int setNum) {
		if (setNum != data) {
			data = setNum;
			updateOccurred();
		} else
			data = setNum;
	}

	/**
	 * Setter that increases the data integer by a specified amount
	 * 
	 * @param constant
	 *            integer to increase data by
	 */
	public void bumpData(int constant) {
		data = data + constant;
		updateOccurred();
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
			System.out.println(getData());
		}
	}
}
