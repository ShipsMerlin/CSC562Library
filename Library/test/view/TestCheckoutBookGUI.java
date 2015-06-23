package view;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

public class TestCheckoutBookGUI
{

	@Test
	public void test()
	{
		CheckoutBookGUI gui = new CheckoutBookGUI();
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(
				CheckoutBookGUI.getContainer());
		JTextField textField1 = (JTextField) componentMap
				.getComponentByName("txtMemberSearch");
		assertEquals("txtMemberSearch", textField1.getName());
	}

}
