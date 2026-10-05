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
    
    // Builds the bank balance window and adds its components.
    public BankBalanceGUI() {
    	
    	frame = new JFrame("Bank Balance Application");

    	panel = new JPanel(new GridLayout(4, 2, 10, 10));
    	
    	JLabel amountLabel = new JLabel("Enter an amount:");
    	amountField = new JTextField();

    	JLabel balanceText = new JLabel("Current Balance:");
    	balanceLabel = new JLabel("");

    	showBalanceButton = new JButton("Show Balance");
    	depositButton = new JButton("Deposit");
    	withdrawButton = new JButton("Withdraw");
    	exitButton = new JButton("Exit");

    	// Connects the buttons to the listener.
    	showBalanceButton.addActionListener(this);
    	depositButton.addActionListener(this);
    	withdrawButton.addActionListener(this);
    	exitButton.addActionListener(this);
    	
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
    
    // Responds when the user clicks a button.
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
        	// Sets and displays the starting balance.
            if (event.getSource() == showBalanceButton) {
            	if(balance>=0) {
            		balanceLabel.setText(String.format("$%.2f", balance));

                    amountField.setText("");
            	}
            }
            // Adds a valid deposit amount to the current balance.
            if (event.getSource() == depositButton) {
                double depositAmount =
                        Double.parseDouble(amountField.getText());

                if (depositAmount > 0) {
                    balance = balance + depositAmount;

                    balanceLabel.setText("");
                    amountField.setText("");

                    JOptionPane.showMessageDialog(frame, "Deposit completed.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Enter a deposit amount greater than zero.");
                }
            }
            // Subtracts a valid withdrawal that does not exceed the balance. 
            if (event.getSource() == withdrawButton) {
                double withdrawalAmount = Double.parseDouble(amountField.getText());

                if (withdrawalAmount <= 0) {
                	JOptionPane.showMessageDialog(frame, "Enter a withdrawal amount greater than zero.");
                } else if (withdrawalAmount > balance) {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds for this withdrawal.");
                } else {
                	balance = balance - withdrawalAmount;
                	
                    balanceLabel.setText(String.format("$%.2f", balance));
                    balanceLabel.setText("");
                    amountField.setText("");
                    
                    JOptionPane.showMessageDialog(frame, "Withdrawal completed.");
                }
            }
            // Shows the final balance before ending the program.
            if (event.getSource() == exitButton) {
            	JOptionPane.showMessageDialog(frame, String.format("Your remaining balance is $%.2f, GOODBYE!", balance));
                System.exit(0);
            }
        } catch (NumberFormatException e) {
        	// Displays an error if the user enters text instead of a number.
            JOptionPane.showMessageDialog(frame,"Please enter a valid dollar amount.");
        }
    }
    // Starts the Bank Balance GUI application. Calls on constructor
    public static void main(String[] args) {
    	new BankBalanceGUI();
    }
}