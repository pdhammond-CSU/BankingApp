import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserInterfaceApplication implements ActionListener {

	private JTextArea textBox;
	private JMenuItem dateTimeItem;
	private JMenuItem saveLogItem;
	private JMenuItem colorItem;
	private JMenuItem exitItem;

	private final Random random = new Random();

	// Builds the application using separate setup methods.
	public UserInterfaceApplication() {
		JFrame frame = new JFrame("User Interface Application");

		frame.setJMenuBar(createMenuBar());
		configureTextBox(frame);
		configureWindow(frame);
	}
	
	// Creates the menu bar and connects the menu options.
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");

		// Creates the four menu options.
		dateTimeItem = new JMenuItem("Show Date and Time");
		saveLogItem = new JMenuItem("Save Text to Log");
		colorItem = new JMenuItem("Change Background Color");
		exitItem = new JMenuItem("Exit");

		// Connects each menu option to this listener.
		dateTimeItem.addActionListener(this);
		saveLogItem.addActionListener(this);
		colorItem.addActionListener(this);
		exitItem.addActionListener(this);

		menu.add(dateTimeItem);
		menu.add(saveLogItem);
		menu.add(colorItem);
		menu.add(exitItem);

		menuBar.add(menu);

		return menuBar;
	}

	// Creates the text box and adds it to the window.
	private void configureTextBox(JFrame frame) {
		textBox = new JTextArea();
		textBox.setEditable(false);

		frame.add(new JScrollPane(textBox), BorderLayout.CENTER);
	}

	// Sets the window size, close behavior, and screen position.
	private void configureWindow(JFrame frame) {
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
		} else if (event.getSource() == saveLogItem) {
			saveTextToFile();
		} else if (event.getSource() == colorItem) {
			changeBackgroundColor();
		} else if (event.getSource() == exitItem) {
			System.exit(0);
		}
	}

	// Gets the current date and time and displays it in the text box.
	private void showDateAndTime() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

		String currentDateTime = LocalDateTime.now().format(format);

		textBox.setText("Current date and time: " + currentDateTime);
	}

	// Writes the text box contents to log.txt and reports the result.
	private void saveTextToFile() {
		File logFile = new File("log.txt");

		// Closes the writer automatically after saving.
		try (FileWriter writer = new FileWriter(logFile)) {
			writer.write(textBox.getText());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(textBox,"Unable to save log.txt: " + e.getMessage());
			return;
		}

		// Shows the saved file's location without changing the text box.
		JOptionPane.showMessageDialog(textBox,"Text saved to:\n" + logFile.getAbsolutePath());
	}

	// Changes the text box background to a random shade of green.
	private void changeBackgroundColor() {
		float hue = 1.0f / 3.0f;
		float saturation = 0.2f + random.nextFloat() * 0.6f;
		float brightness = 0.85f + random.nextFloat() * 0.15f;

		Color greenShade = Color.getHSBColor(hue, saturation, brightness);

		textBox.setBackground(greenShade);
	}

	// Starts the application on Swing's event dispatch thread.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(UserInterfaceApplication::new);
	}
}