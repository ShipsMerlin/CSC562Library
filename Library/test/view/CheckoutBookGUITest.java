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
public class CheckoutBookGUITest {

	/**
	 * Tests the UI of the CheckoutBookGUI
	 */
	@Test
	public void test() {
		CheckoutBookGUI gui = new CheckoutBookGUI();
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(CheckoutBookGUI.getContainer());
		
		/**
		 * Tests that components pertaining to member searching are on the screen
		 */
		JLabel label1 = (JLabel) componentMap.getComponentByName("lblMember");
		assertEquals("lblMember", label1.getName());
		
		JTextField textField1 = (JTextField) componentMap.getComponentByName("txtMemberSearch");
		assertEquals("txtMemberSearch", textField1.getName());
		
		JButton button1 = (JButton) componentMap.getComponentByName("btnSearchMember");
		assertEquals("btnSearchMember", button1.getName());
		
		/**
		 * Tests that components pertaining to member searching are on the screen
		 */
		JLabel label2 = (JLabel) componentMap.getComponentByName("lblBook");
		assertEquals("lblBook", label2.getName());
		
		JTextField textField2 = (JTextField) componentMap.getComponentByName("txtBookSearch");
		assertEquals("txtBookSearch", textField2.getName());
		
		JButton button2 = (JButton) componentMap.getComponentByName("btnSearchBook");
		assertEquals("btnSearchBook", button2.getName());
		
		/**
		 * Tests that the Checkout button is on the screen
		 */
		JButton button3 = (JButton) componentMap.getComponentByName("btnCheckout");
		assertEquals("btnCheckout", button3.getName());
		
	}

}
