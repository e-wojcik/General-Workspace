import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main class that launches an application that is dictated by "JavaFxTip.fxml"
 * 
 * @author Eric Wojcik
 * @version 26 March 2017
 */
public class DesktopTipsMain extends Application {

	/**
	 * Method to "launch" the JavaFX GUI
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(DesktopTipsMain.class, (java.lang.String[]) null);
	}

	/**
	 * Method to create a stage area for the JavaFX GUI
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(DesktopTipsMain.class.getResource("JavaFxTip.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("JavaFX Tip Calculator");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(DesktopTipsMain.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
