import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

/**
 * GRectDemo - A simple demonstration of the GRect class. <br>
 * Program draws a rectangle in a GCanvas and then allows the user to adjust the
 * height four times. Note that the origin is in the upper right corner, so it
 * may look "funny"
 * 
 * @author dlevine
 * @version September 27. 2006
 * 
 *
 */
public class GRectDemo {

	static final int BAR_WIDTH = 40;

	public static void main(String[] args) {

		// Start by building the rectangle

		GRect bar = new GRect(240, 0, BAR_WIDTH, 100);
		bar.setColor(Color.GREEN);
		bar.setFilled(true);

		// Then build a canvas to hold the rectangle

		GCanvas gc = new GCanvas();
		gc.setPreferredSize(new Dimension(BAR_WIDTH, 100));
		gc.add(bar);

		// Finally build a frame to hold everything (one canvas)
		JFrame frame = new JFrame("GRectDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.add(gc, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		// Now demontrate how to change the height

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.print("New height? ");
			int s = sc.nextInt();
			bar.setBounds(240, 0, BAR_WIDTH, s);
		}
	}

}
