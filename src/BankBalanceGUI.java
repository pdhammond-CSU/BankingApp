import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceGUI implements ActionListener {
	
	private JFrame frame;
    private JPanel panel;

    private JTextField amountField;
    private JLabel balanceLabel;

    private JButton showBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;

    private double balance = 0.0;
    
    public BankBalanceGUI() {
    	
    	frame = new JFrame("Bank Balance Application");

    	panel = new JPanel(new GridLayout(4, 2, 10, 10));
    	
    	JLabel amountLabel = new JLabel("Enter an amount:");
    	amountField = new JTextField();

    	JLabel balanceText = new JLabel("Current Balance:");
    	balanceLabel = new JLabel("$0.00");

    	showBalanceButton = new JButton("Show Balance");
    	depositButton = new JButton("Deposit");
    	withdrawButton = new JButton("Withdraw");
    	exitButton = new JButton("Exit");

    	showBalanceButton.addActionListener(this);
    	
    	panel.add(amountLabel);
    	panel.add(amountField);

    	panel.add(showBalanceButton);
    	panel.add(depositButton);

    	panel.add(withdrawButton);
    	panel.add(exitButton);

    	panel.add(balanceText);
    	panel.add(balanceLabel);

    	frame.add(panel);
    	frame.setSize(400, 250);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == showBalanceButton) {
                balance = Double.parseDouble(amountField.getText());

                balanceLabel.setText(String.format("$%.2f", balance));

                amountField.setText("");
            }

            if (event.getSource() == depositButton) {
                double depositAmount =
                        Double.parseDouble(amountField.getText());

                if (depositAmount > 0) {
                    balance = balance + depositAmount;

                    balanceLabel.setText(String.format(
                            "$%.2f", balance));

                    amountField.setText("");

                    JOptionPane.showMessageDialog(
                            frame,
                            "Deposit completed."
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Enter a deposit amount greater than zero."
                    );
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Please enter a valid dollar amount."
            );
        }
    }
    
    public static void main(String[] args) {
    	new BankBalanceGUI();
    }
}