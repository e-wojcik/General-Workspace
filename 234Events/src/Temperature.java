
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Program to allow a user to convert any number from fahrenheit to celsius or
 * vice versa, and temps are highlighted
 *
 * @author DLevine, EWojcik
 * @version 12 February 2017
 */
public class Temperature implements ActionListener, KeyListener {

    private static DecimalFormat form = new DecimalFormat("##.#");
    private static JTextField fahr;
    private static JTextField cels;
    private JFrame frame;
    private JButton first;
    private JButton second;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Temperature window = new Temperature();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * creates both buttons and the window
     */
    private void initialize() {
        frame = new JFrame("Temperature Conversion");
        frame.setBounds(100, 50, 350, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        first = new JButton("...To Celsius");
        first.setBounds(120, 60, 120, 50);
        first.setBackground(Color.cyan);
        first.setActionCommand("click");
        frame.getContentPane().add(first);
        first.addActionListener(this);

        second = new JButton("...To Fahrenheit");
        second.setBounds(120, 230, 120, 50);
        second.setBackground(Color.pink);
        second.setActionCommand("instead");
        frame.getContentPane().add(second);
        second.addActionListener(this);
    }

    /**
     * creates both JTextFields and assigns listeners
     */
    public Temperature() {
        initialize();
        // Build the Fahrenheit side
        JLabel fLabel = new JLabel("Fahrenheit");
        fahr = new JTextField("32");
        fahr.setPreferredSize(new Dimension(50, 50));
        fahr.setHorizontalAlignment(JTextField.CENTER);
        JPanel fPanel = new JPanel();
        fPanel.setBounds(40, 120, 100, 100);
        fPanel.add(fLabel);
        fPanel.add(fahr);
        frame.getContentPane().add(fPanel);
        // fahr.addActionListener(this);
        fahr.addKeyListener(this);
        fahr.setActionCommand("click");

        // Build the Celsius side
        JLabel cLabel = new JLabel("Celsius");
        cels = new JTextField("0");
        cels.setPreferredSize(new Dimension(50, 50));
        cels.setHorizontalAlignment(JTextField.CENTER);
        JPanel cPanel = new JPanel();
        cPanel.setBounds(220, 120, 100, 100);
        cPanel.add(cLabel);
        cPanel.add(cels);
        frame.getContentPane().add(cPanel);
        // cels.addActionListener(this);
        cels.addKeyListener(this);
        cels.setActionCommand("instead");

        // Put it all up on the screen
        frame.setVisible(true);

    }

    /**
     * for each conversion action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        double fahren;
        try {
            fahren = Double.parseDouble((fahr.getText()).toString());
        } catch (NumberFormatException num) {
            fahren = 0;
        }
        double celsius;
        try {
            celsius = Double.parseDouble((cels.getText()).toString());
        } catch (NumberFormatException num) {
            celsius = 0;
        }

        if (e.getActionCommand().equals("click")) {
            System.out.println("Celsius button was clicked...");
            System.out.println("Fahrenheit: " + fahren);
            double celsi = ((fahren - 32.0) * 5) / 9;
            cels.setText(form.format(celsi) + "");
            if (celsi >= 34) {
                cels.setBackground(Color.RED);
            } else if (celsi < 34 && celsi >= 27) {
                cels.setBackground(Color.PINK);
            } else if (celsi < 27 && celsi >= 20) {
                cels.setBackground(Color.CYAN);
            } else if (celsi < 20) {
                cels.setBackground(Color.BLUE);
            }
        } else if (e.getActionCommand().equals("instead")) {
            System.out.println("Fahrenheit button was clicked...");
            System.out.println("Celsius: " + celsius);
            double fahrenheit = ((celsius * 9) / 5) + 32;
            fahr.setText(form.format(fahrenheit) + "");
            if (fahrenheit >= 70) {
                fahr.setBackground(Color.RED);
            } else if (fahrenheit >= 50) {
                fahr.setBackground(Color.PINK);
            } else if (fahrenheit >= 30) {
                fahr.setBackground(Color.CYAN);
            } else if (fahrenheit <= 29) {
                fahr.setBackground(Color.BLUE);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * "triggers" the conversions when ENTER key is pressed and released;
     * console prints multiple copies dependent on number of keys released while
     * entering the data in a text field
     */
    @Override
    public void keyReleased(KeyEvent arg0) {
        fahr.addActionListener(this);
        cels.addActionListener(this);

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
}
