package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckoutBookGUI {

	private static JFrame jFrame;

	/**
	 * Creates the components for the Checkout Book GUI
	 */
	public static void createAndShowGUI()
	{
		jFrame = new JFrame("CheckoutSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2, 1));
		content.setName("myPanel");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		JLabel label = new JLabel("Member");
		label.setName("Member");
		
		JLabel label3 = new JLabel("");
		label3.setName("Spacer");
		JButton button = new JButton("Search");
		button.setName("Search");
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 2));
		JLabel label2 = new JLabel("Book");
		label2.setName("Book");
		
		JLabel label4 = new JLabel("");
		label4.setName("Spacer");
		JButton button2 = new JButton("Search");
		button2.setName("Search");
		
		JButton checkoutbutton = new JButton("Checkout");
		checkoutbutton.setName("Checkout");
				
		final JTextField x = new JTextField(20);
		x.setName("txtMemberSearch");
		
		final JTextField y = new JTextField(20);
		y.setName("txtBookSearch");
		
		panel.add(label);
		panel.add(label3);
		panel.add(x);
		panel.add(button);
		content.add(panel);

		
		panel2.add(label2);
		panel2.add(label4);
		panel2.add(y);
		panel2.add(button2);
		content.add(panel2);
		
		content.add(checkoutbutton);
		
	
		
		
		jFrame.getContentPane().add(content);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	/**
	 * @return - returns the JFrame object
	 */
	public static Container getContainer()
	{
		// TODO Auto-generated method stub
		return jFrame;
	}

	
	public static void main(String[] args) {
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
	
}