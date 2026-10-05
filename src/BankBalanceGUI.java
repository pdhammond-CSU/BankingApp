import javax.swing.*;
import java.awt.*;

public class BankBalanceGUI {

    public static void main(String[] args) {
    	JFrame frame = new JFrame("Bank Balance Application");
    	
    	JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

    	JLabel amountLabel = new JLabel("Enter an amount:");
    	JTextField amountField = new JTextField();

    	JLabel balanceText = new JLabel("Current Balance:");
    	JLabel balanceLabel = new JLabel("$0.00");

    	JButton showBalanceButton = new JButton("Show Balance");
    	JButton depositButton = new JButton("Deposit");
    	JButton withdrawButton = new JButton("Withdraw");
    	JButton exitButton = new JButton("Exit");

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
}