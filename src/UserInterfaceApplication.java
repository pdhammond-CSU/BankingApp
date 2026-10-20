import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterfaceApplication implements ActionListener {

	private JTextArea textBox;
	private JMenuItem dateTimeItem;

	// Builds the application window, menu, and text box.
	public UserInterfaceApplication() {
		JFrame frame = new JFrame("User Interface Application");

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");

		// Creates the four menu options.
		dateTimeItem = new JMenuItem("Show Date and Time");
		JMenuItem saveLogItem = new JMenuItem("Save Text to Log");
		JMenuItem colorItem = new JMenuItem("Change Background Color");
		JMenuItem exitItem = new JMenuItem("Exit");

		// Connects the date and time option to this listener.
		dateTimeItem.addActionListener(this);

		menu.add(dateTimeItem);
		menu.add(saveLogItem);
		menu.add(colorItem);
		menu.add(exitItem);

		// Places the Options menu in the top menu bar.
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		// Creates a read-only text box for displaying information.
		textBox = new JTextArea();
		textBox.setEditable(false);

		frame.add(new JScrollPane(textBox), BorderLayout.CENTER);

		// Sets the window size, close behavior, and screen position.
		frame.setSize(500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Handles selections from the menu.
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == dateTimeItem) {
			showDateAndTime();
		}
	}

	// Gets the current date and time and displays it in the text box.
	private void showDateAndTime() {
		DateTimeFormatter format =
				DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

		String currentDateTime = LocalDateTime.now().format(format);

		textBox.setText("Current date and time: " + currentDateTime);
	}

	// Starts the application on Swing's event dispatch thread.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(UserInterfaceApplication::new);
	}
}