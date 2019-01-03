
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Events is a class-written (actually during class) program designed to provide
 * an introduction to Events and Listeners in Java
 *
 * @author dlevine - with assistance and inspiration from the CS 234 class
 * @version 9 February 2016
 *
 */
public class Events implements ActionListener {

    private JFrame frame;
    private JButton first;
    private JButton second;
    private ExternalListener snoop;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Events window = new Events();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application. Set up Listeners (so far none) here.
     */
    public Events() {
        initialize();
        snoop = new ExternalListener("CIA");
        first.addActionListener(snoop);
        second.addActionListener(new ExternalListener("Nancy"));
        second.addActionListener(this);
        second.addActionListener(new ExternalListener("Sid"));
        second.addActionListener(snoop);
        second.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JButton src = (JButton) ae.getSource();
                if (src.getBackground().equals(Color.pink)) {
                    System.out.println("You clicked a pink button");
                }
            }
        });
        first.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                JButton jb = (JButton) arg0.getSource();
                System.out.println("You have entered the button " + jb.getText());
                System.out.println("...so sasy my new MouseAdapter " + this);
            }
        });

        second.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                JButton jb = (JButton) arg0.getSource();
                System.out.println("You have entered the button " + jb.getText());
                System.out.println("...so sasy my new MouseAdapter " + this);
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame("Events Demo");
        frame.setBounds(100, 50, 523, 510);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        System.out.println("Main JFrame: " + frame);

        first = new JButton("Click me!");
        first.setBounds(100, 100, 300, 100);
        first.setBackground(Color.cyan);
        first.setActionCommand("click");
        frame.getContentPane().add(first);
        first.addActionListener(new ExternalListener("NSA"));
        first.addActionListener(this);

        second = new JButton("Try me instead!");
        second.setBounds(100, 300, 300, 100);
        second.setBackground(Color.pink);
        second.setActionCommand("instead");
        frame.getContentPane().add(second);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("We have a click!");
        if (e.getActionCommand().equals("click")) {
            System.out.println("You clicked me!");
        } else if (e.getActionCommand().equals("instead")) {
            System.out.println("You chose the alternative!  Good for you!");
        }
    }

    // @Override
    // public void mouseClicked(MouseEvent arg0) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void mouseEntered(MouseEvent arg0) {
    // JButton jb = (JButton) arg0.getSource();
    // System.out.println("You have entered the button " + jb.getText());
    //
    // }
    //
    // @Override
    // public void mouseExited(MouseEvent arg0) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void mousePressed(MouseEvent arg0) {
    // // TODO Auto-generated method stub
    //
    // }
    //
    // @Override
    // public void mouseReleased(MouseEvent arg0) {
    // // TODO Auto-generated method stub
    //
    // }
}
