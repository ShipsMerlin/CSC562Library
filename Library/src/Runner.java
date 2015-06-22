import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Runner
{
	private static JFrame frame;

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	static void createAndShowGUI()
	{
		// Create and set up the window.
		frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.setName("myPanel");
		final JTextField x = new JTextField(20);
		x.setName("myText");
		x.setText("42");
		JButton button = new JButton("click");
		button.setName("myButton");
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				x.setText("clicked");
			}

		});
		content.add(button);

		content.add(x);
		// Display the window.
		frame.getContentPane().add(content);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}

	public static JFrame getFrame()
	{
		return frame;
	}
}
