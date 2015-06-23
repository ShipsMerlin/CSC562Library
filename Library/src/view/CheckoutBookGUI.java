package view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckoutBookGUI {

	private static JFrame jFrame;

	/**
	 * Creates the components for the Checkout Book GUI
	 */
	public void createAndShowGUI()
	{
		jFrame = new JFrame("CheckoutSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.setName("myPanel");
		final JTextField x = new JTextField(20);
		x.setName("txtMemberSearch");
		
		content.add(x);
		
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

	
}