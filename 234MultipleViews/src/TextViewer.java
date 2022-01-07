import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class to create a JTextField viewer that updates when a Model update message
 * is received
 * 
 * @author Eric Wojcik
 * @version 19 February 2017
 */
public class TextViewer implements ModelObserver {
	private JTextField text;

	/**
	 * Constructor that creates the frame and textfield and its orientation on
	 * the screen
	 */
	public TextViewer() {
		JFrame frame = new JFrame("Text Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel();
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(100, 100));
		frame.pack();
		frame.setVisible(true);

		text = new JTextField();
		JLabel textLabel = new JLabel("Current Model Data:");
		text.setPreferredSize(new Dimension(60, 20));
		text.setHorizontalAlignment(JTextField.CENTER);
		JPanel tPanel = new JPanel();
		tPanel.setBounds(40, 120, 100, 150);
		tPanel.add(textLabel);
		tPanel.add(text);
		frame.getContentPane().add(tPanel);
		frame.setLocation(550, 300);

	}

	/**
	 * Updates the textfield with the new data
	 */
	@Override
	public void update(Model m) {
		// TODO Auto-generated method stub
		text.setText(Integer.toString(m.getData()));
	}

}
