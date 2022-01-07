import java.awt.Color;

/**
 * Main method to test the MVC relationship between Model, Controller,
 * BarViewer, and TextViewer
 * 
 * @author Eric Wojcik
 * @version 19 February 2017
 *
 */
public class MVCMain {

	public static void main(String args[]) {
		Model m = new Model();
		Controller c = new Controller(m);
		// BarViewer bv = new BarViewer();
		BarViewer bv = new BarViewer(Color.CYAN);
		m.addObserver(bv);
		m.updateOccurred();

		TextViewer text = new TextViewer();
		m.addObserver(text);
		m.updateOccurred();
	}
}
