package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author em1419
 *
 */
public class CheckoutBookGUI extends JPanel implements ActionListener {

	private static JFrame jFrame;

	/**
	 * Creates the components for the Checkout Book GUI
	 * @return 
	 */
	JPanel createAndShowGUI()
	{
		jFrame = new JFrame("CheckoutSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2, 1));
		content.setName("myPanel");
		
		/**
		 * Adding all components for Member Search
		 */
		JPanel memberPanel = new JPanel();
		memberPanel.setLayout(new GridLayout(2, 2));
		JLabel memberLabel = new JLabel("Member");
		memberLabel.setName("lblMember");
		
		JLabel label3 = new JLabel("");
		label3.setName("Spacer");
		JButton memberSearchButton = new JButton("Search");
		memberSearchButton.setName("btnSearchMember");
		
		final JTextField x = new JTextField(20);
		x.setName("txtMemberSearch");
		
		memberPanel.add(memberLabel);
		memberPanel.add(label3);
		memberPanel.add(x);
		memberPanel.add(memberSearchButton);
		content.add(memberPanel);
		
		/**
		 * Adding all components for Book Search
		 */
		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(new GridLayout(2, 2));
		JLabel bookLabel = new JLabel("Book");
		bookLabel.setName("lblBook");
		
		JLabel label4 = new JLabel("");
		label4.setName("Spacer");
		JButton bookSearchButton = new JButton("Search");
		bookSearchButton.setName("btnSearchBook");

		final JTextField y = new JTextField(20);
		y.setName("txtBookSearch");

		bookPanel.add(bookLabel);
		bookPanel.add(label4);
		bookPanel.add(y);
		bookPanel.add(bookSearchButton);
		content.add(bookPanel);
		
		/**
		 * Adding Checkout Button
		 */
		JButton checkoutbutton = new JButton("Checkout");
		checkoutbutton.setName("btnCheckout");
		checkoutbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		content.add(checkoutbutton);

		jFrame.getContentPane().add(content);
		jFrame.pack();
		jFrame.setVisible(true);
		
		return content;
	}

	/**
	 * @return - returns the JFrame object
	 */
	public static Container getContainer()
	{
		// TODO Auto-generated method stub
		return jFrame;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				CheckoutBookGUI gui = new CheckoutBookGUI();
				gui.createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}