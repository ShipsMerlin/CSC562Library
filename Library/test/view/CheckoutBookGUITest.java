package view;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

/**
 * @author Evania Mans
 *
 */
public class CheckoutBookGUITest
{

	/**
	 * Tests the UI of the CheckoutBookGUI
	 */
	@Test
	public void test()
	{
		CheckoutBookGUI gui = new CheckoutBookGUI();
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(
				CheckoutBookGUI.getContainer());

		/**
		 * Tests that components pertaining to member searching are on the
		 * screen
		 */
		JLabel label1 = (JLabel) componentMap.getComponentByName("lblMember");
		assertNotNull(label1);

		JTextField textField1 = (JTextField) componentMap
				.getComponentByName("txtMemberSearch");
		assertNotNull(textField1);

		JButton button1 = (JButton) componentMap
				.getComponentByName("btnSearchMember");
		assertNotNull(button1);

		/**
		 * Tests that components pertaining to member searching are on the
		 * screen
		 */
		JLabel label2 = (JLabel) componentMap.getComponentByName("lblBook");
		assertNotNull(label2);

		JTextField textField2 = (JTextField) componentMap
				.getComponentByName("txtBookSearch");
		assertNotNull(textField2);

		JButton button2 = (JButton) componentMap
				.getComponentByName("btnSearchBook");
		assertNotNull(button2);

		/**
		 * Tests that the Checkout button is on the screen
		 */
		JButton button3 = (JButton) componentMap
				.getComponentByName("btnCheckout");
		assertNotNull(button3);

	}

}
