
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

/**
 * Program to create a frame window and all the parts of a tip calculator within
 * the frame
 *
 * @author Eric Wojcik
 * @version 23 February 2017
 *
 */
public class TipView extends JFrame {

	private static final long serialVersionUID = 1L;

	private TipModel model = new TipModel();
	private LeaveTipViewUpdate leaveTip;
	private ActualTipViewUpdate actualTip;
	private JTextField totalBillTextField;
	private JTextField tipPercTextField;
	private JTextField quantumTextField;
	private JTextField portionBillTextField;
	private JTextField actlTipTextField;
	private JTextField leaveTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TipView frame = new TipView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TipView() {
		setTitle("Tip Calculator!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 400, 360);
		setResizable(false);

		getContentPane().setLayout(new MigLayout("", "[]", "[]"));

		/*
		 * begin to create various labels and textfields, hit "ENTER" after
		 * inputting each value
		 */
		JLabel totalBillLabel = new JLabel("Total Bill: $");
		totalBillLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(totalBillLabel, "flowx,cell 0 0,alignx center," + "aligny top");

		totalBillTextField = new JTextField();
		totalBillTextField.setEnabled(false);
		getContentPane().add(totalBillTextField, "cell 0 0,alignx center");
		totalBillTextField.setColumns(10);
		totalBillTextField.setBackground(Color.CYAN);

		JLabel portionLabel = new JLabel("Portion: $");
		portionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(portionLabel, "cell 0 0,alignx center");

		portionBillTextField = new JTextField();
		portionBillTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double partBill = Double.parseDouble(portionBillTextField.getText());
				model.setBill(partBill);
				System.out.println(model.toString());
			}
		});
		portionBillTextField.setEnabled(false);
		getContentPane().add(portionBillTextField, "cell 0 0,alignx center");
		portionBillTextField.setColumns(10);
		portionBillTextField.setBackground(Color.PINK);

		JCheckBox chckbxFullTip = new JCheckBox("Tip Whole Bill");
		chckbxFullTip.setFont(new Font("Times New Roman", Font.BOLD, 12));
		JCheckBox chckbxPartialTip = new JCheckBox("Tip Partial Bill");
		chckbxPartialTip.setFont(new Font("Times New Roman", Font.BOLD, 12));

		chckbxFullTip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Total bill button clicked...");
				if (totalBillTextField.isEnabled() == false) {
					totalBillTextField.setEnabled(true);
					totalBillTextField.setBackground(Color.WHITE);
					totalBillTextField.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							double totalBill = Double.parseDouble(totalBillTextField.getText());
							model.setBill(totalBill);
							System.out.println(model.toString());
						}
					});
					chckbxPartialTip.setEnabled(false);
				} else {
					totalBillTextField.setEnabled(false);
					totalBillTextField.setBackground(Color.CYAN);
					chckbxPartialTip.setEnabled(true);
				}
			}
		});
		getContentPane().add(chckbxFullTip, "flowx,cell 0 1,alignx center");

		chckbxPartialTip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Partial bill button clicked...");
				if (portionBillTextField.isEnabled() == false) {
					portionBillTextField.setEnabled(true);
					portionBillTextField.setBackground(Color.WHITE);
					chckbxFullTip.setEnabled(false);
				} else {
					portionBillTextField.setEnabled(false);
					portionBillTextField.setBackground(Color.PINK);
					chckbxFullTip.setEnabled(true);
				}
			}
		});
		getContentPane().add(chckbxPartialTip, "cell 0 1,alignx center");

		JLabel tipPercLabel = new JLabel("Tip %:");
		tipPercLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(tipPercLabel, "flowx,cell 0 2");

		tipPercTextField = new JTextField();
		tipPercTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tipPerc = Double.parseDouble(tipPercTextField.getText());
				model.setPercentage(tipPerc);
				System.out.println(model.toString());
			}
		});
		getContentPane().add(tipPercTextField, "cell 0 2,alignx center");
		tipPercTextField.setColumns(5);

		JLabel quantumLabel = new JLabel("Quantum:");
		quantumLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(quantumLabel, "flowx,cell 0 3");

		quantumTextField = new JTextField();
		quantumTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double quantum = Double.parseDouble(quantumTextField.getText());
				model.setQuantum(quantum);
				System.out.println(model.toString());
			}
		});
		getContentPane().add(quantumTextField, "cell 0 3,alignx center");
		quantumTextField.setColumns(4);

		JButton btnCalculateTip = new JButton("Calculate Tip");
		btnCalculateTip.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnCalculateTip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualTip = new ActualTipViewUpdate();
				leaveTip = new LeaveTipViewUpdate();
				System.out.println("Calculate button clicked...");
				actlTipTextField.setText(model.roundedString(actualTip.update(model), 1));
				leaveTextField.setText(model.roundedString(leaveTip.update(model), 2));
			}
		});
		getContentPane().add(btnCalculateTip, "flowx,cell 0 4");

		JLabel iconLabel = new JLabel("");
		getContentPane().add(iconLabel, "cell 0 5,alignx center");
		iconLabel.setIcon(new ImageIcon("receipt-small-md.png"));

		JLabel actlTipLabel = new JLabel("Actual Tip %:");
		actlTipLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(actlTipLabel, "flowx,cell 0 7");

		actlTipTextField = new JTextField();
		actlTipTextField.setText("0.0");
		actlTipTextField.setEditable(false);
		getContentPane().add(actlTipTextField, "cell 0 7,alignx center");
		actlTipTextField.setColumns(5);

		JLabel leaveLabel = new JLabel("Leave This Amount: $");
		leaveLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(leaveLabel, "flowx,cell 0 8");

		leaveTextField = new JTextField();
		leaveTextField.setText("0.00");
		leaveTextField.setEditable(false);
		getContentPane().add(leaveTextField, "cell 0 8,alignx center");
		leaveTextField.setColumns(5);

		// reset the fields to enter new values
		JButton btnReset = new JButton("Reset Calculator");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Reset button clicked...");

				// reset text fields to their original state
				totalBillTextField.setText("");
				portionBillTextField.setText("");
				tipPercTextField.setText("");
				quantumTextField.setText("");
				actlTipTextField.setText("0.0");
				leaveTextField.setText("0.00");

				// reset model data to default of zero
				model.setBill(0);
				model.setPercentage(0);
				model.setQuantum(0);
			}
		});
		getContentPane().add(btnReset, "cell 0 8,alignx center,aligny center");

		JLabel thanksLabel = new JLabel("Thank You for Using This Tip Calculator! " + "Have a Nice Day!");
		thanksLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		getContentPane().add(thanksLabel, "cell 0 11,alignx center");
	}
}
