import javax.swing.*;
import java.awt.*;

public class UserInterfaceApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("User Interface Application");

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");

		JMenuItem dateTimeItem = new JMenuItem("Show Date and Time");
		JMenuItem saveLogItem = new JMenuItem("Save Text to Log");
		JMenuItem colorItem = new JMenuItem("Change Background Color");
		JMenuItem exitItem = new JMenuItem("Exit");

		menu.add(dateTimeItem);
		menu.add(saveLogItem);
		menu.add(colorItem);
		menu.add(exitItem);

		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		JTextArea textBox = new JTextArea();
		textBox.setEditable(false);

		frame.add(new JScrollPane(textBox), BorderLayout.CENTER);

		frame.setSize(500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}