import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Controller class for the DesktopTipsMain program; also handles all necessary
 * events
 * 
 * @author Eric Wojcik
 * @version 26 March 2017
 */
public class SimpleController {

	private TipModel model = new TipModel();
	private LeaveTipViewUpdate leaveTip;
	private ActualTipViewUpdate actualTip;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField fullTip;

	@FXML
	private CheckBox fullTipBox;

	@FXML
	private TextField partialTip;

	@FXML
	private CheckBox partTipBox;

	@FXML
	private TextField tipPercent;

	@FXML
	private TextField quantum;

	@FXML
	private Button calculate;

	@FXML
	private TextField actlTip;

	@FXML
	private TextField leaveThis;

	@FXML
	private Button reset;

	@FXML
	void handleFullTipAction(ActionEvent event) {

	}

	/**
	 * Initializes all textfields and buttons with all event handlers
	 */
	@FXML
	public void initialize() {
		assert fullTip != null : "fx:id=\"fullTip\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		fullTip.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Full tip entered...");
				double fullBill = Double.parseDouble(fullTip.getText());
				model.setBill(fullBill);
				System.out.println(model.toString());
			}
		});

		assert fullTipBox != null : "fx:id=\"fullTipBox\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		fullTipBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Full tip selected...");
				double totalBill = Double.parseDouble(fullTip.getText());
				model.setBill(totalBill);
				System.out.println(model.toString());
			}

		});

		assert partialTip != null : "fx:id=\"partialTip\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		partialTip.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Partial tip entered...");
				double partialBill = Double.parseDouble(partialTip.getText());
				model.setBill(partialBill);
				System.out.println(model.toString());
			}

		});

		assert partTipBox != null : "fx:id=\"partTipBox\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		partTipBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Partial tip selected...");
				double partialBill = Double.parseDouble(partialTip.getText());
				model.setBill(partialBill);
				System.out.println(model.toString());
			}

		});

		assert tipPercent != null : "fx:id=\"tipPercent\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		tipPercent.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Tip percent entered...");
				double tipPercentage = Double.parseDouble(tipPercent.getText());
				model.setPercentage(tipPercentage);
				System.out.println(model.toString());
			}

		});

		assert quantum != null : "fx:id=\"quantum\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		quantum.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Quantum entered...");
				double quantumLvl = Double.parseDouble(quantum.getText());
				model.setQuantum(quantumLvl);
				;
				System.out.println(model.toString());
			}

		});

		assert calculate != null : "fx:id=\"calculate\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		calculate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Calculate button clicked...");
				actualTip = new ActualTipViewUpdate();
				leaveTip = new LeaveTipViewUpdate();
				actlTip.setText(model.roundedString(actualTip.update(model), 1));
				leaveThis.setText(model.roundedString(leaveTip.update(model), 2));
			}

		});

		assert actlTip != null : "fx:id=\"actlTip\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		assert leaveThis != null : "fx:id=\"leaveThis\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'JavaFxTip.fxml'.";
		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Reset button clicked...");

				fullTip.setText("");
				partialTip.setText("");
				tipPercent.setText("");
				quantum.setText("");
				actlTip.setText("");
				leaveThis.setText("");

				// reset model data to default of zero
				model.setBill(0);
				model.setPercentage(0);
				model.setQuantum(0);
			}

		});

	}
}
