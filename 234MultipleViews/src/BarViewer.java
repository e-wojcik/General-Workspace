import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

/**
 * Program to create a colored bar that grows in size based on the current state
 * of Model data determined by the Controller
 * 
 * @author Eric Wojcik
 * @version 18 February 2017
 */
public class BarViewer implements ModelObserver {

	private static final int BAR_WIDTH = 40;
	private JFrame frame;
	private GCanvas gc;
	private GRect bar;

	/**
	 * Default constructor that creates the bar and its containing frame
	 */
	public BarViewer() {
		frame = new JFrame("Your bar");
		int height = 30;
		bar = new GRect(BAR_WIDTH, height);
		bar.setColor(Color.GREEN);
		bar.setFilled(true);
		gc = new GCanvas();
		gc.setPreferredSize(new Dimension(300, 300));
		gc.add(bar);
		frame.add(gc, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(200, 200);

	}

	/**
	 * Constructor that acts the same as the default but allows for a color to
	 * be sent as a parameter to determine the bar color
	 * 
	 * @param c
	 *            the color the user passes as a parameter
	 */
	public BarViewer(Color c) {
		frame = new JFrame("Your Bar");
		int height = 30;
		bar = new GRect(BAR_WIDTH, height);
		bar.setColor(c);
		bar.setFilled(true);
		gc = new GCanvas();
		gc.setPreferredSize(new Dimension(300, 300));
		gc.add(bar);
		frame.add(gc, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(200, 200);
	}

	/**
	 * Updates the bar dimensions based on the reception of an update message
	 * from Model
	 */
	public void update(Model m) {
		bar.setBounds(130, 300 - m.getData(), BAR_WIDTH, m.getData());
	}

}
