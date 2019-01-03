
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Class to construct the MVC controller window to direct the growth of the
 * colored bar
 * 
 * @author Eric Wojcik
 * @version 19 February 2017
 */
public class Controller {

	private JFrame frame;
	private Model model;

	/**
	 * Constructor method for the controller
	 * 
	 * @param m
	 *            Model object
	 */
	public Controller(Model m) {
		model = m;
		// bumps by 8
		frame = new JFrame("Controller");
		final JButton b1 = new JButton("Shove 8");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				model.bumpData(8);
			}
		});
		// bumps by 1
		final JButton b2 = new JButton("Shove 1");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				model.bumpData(1);
			}
		});
		// sets the height of the bar by user text input
		final JTextField tf1 = new JTextField("");
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				model.setData(Integer.parseInt(tf1.getText()));
			}
		});

		// adds buttons and exit opertaion to the frame
		frame.add(b1, BorderLayout.CENTER);
		frame.add(b2, BorderLayout.NORTH);
		frame.add(tf1, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
