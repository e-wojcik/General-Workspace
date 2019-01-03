/**
 * Main method to test the Model class
 * 
 * @author Eric Wojcik
 * @version 19 February 2017
 */
public class ModelTest {
	public static void main(String[] args) {
		Model model = new Model(4);
		// Basic testing of the getters and setters for one object
		System.out.println(model.getData());
		model.setData(9);
		System.out.println(model.getData());
		model.bumpData(3);
		System.out.println(model.getData());

		// Creation of another object
		Model m = new Model();
		System.out.println(m.getData());

		model.setData(0);
		model.bumpData(4);

		m.setData(0);
		m.bumpData(6);

		// Making sure that getData() in this case returns the expected integer
		System.out.println(m.getData());
	}
}
