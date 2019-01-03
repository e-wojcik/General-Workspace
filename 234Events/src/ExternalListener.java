import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A small Listener to show how "external" classes can listen for events
 * 
 * @author dlevine
 * @version 9 February 2016
 *
 */
public class ExternalListener implements ActionListener {

    String name;
    
    public ExternalListener(String s) {
        name = s;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click detected from outside by " + name);

    }

}
