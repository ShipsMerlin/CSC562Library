package view;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.QualifiedObservableConnector;

import org.junit.Before;
import org.junit.Test;

import datasource.MemberRowDataGatewayMock;
import datasource.MembersForTest;

/**
 * @author Evania Mans
 *
 */
public class CheckoutBookGUITest
{
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
		new MemberRowDataGatewayMock().resetData();
	}
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
		JLabel memberLabel = (JLabel) componentMap.getComponentByName("lblMember");
		assertNotNull(memberLabel);

		JTextField memberTextField = (JTextField) componentMap
				.getComponentByName("txtMemberSearch");
		assertNotNull(memberTextField);

		JButton memberSearchButton = (JButton) componentMap
				.getComponentByName("btnSearchMember");
		assertNotNull(memberSearchButton);

		/**
		 * Tests that components pertaining to member searching are on the
		 * screen
		 */
		JLabel bookLabel = (JLabel) componentMap.getComponentByName("lblBook");
		assertNotNull(bookLabel);

		JTextField bookTextField = (JTextField) componentMap
				.getComponentByName("txtBookSearch");
		assertNotNull(bookTextField);

		JButton bookSearchButton = (JButton) componentMap
				.getComponentByName("btnSearchBook");
		assertNotNull(bookSearchButton);

		/**
		 * Tests that the Checkout button is on the screen
		 */
		JButton button3 = (JButton) componentMap
				.getComponentByName("btnCheckout");
		assertNotNull(button3);

	}
	
	/**
	 * 
	 */
	@Test
	public void testSearchForMember() {
		CheckoutBookGUI gui = new CheckoutBookGUI();
		gui.createAndShowGUI();
		gui.memberSearchTextField.setText(Integer.toString(MembersForTest.ANDY.getMemberID()));
		gui.memberSearchButton.doClick();
		pause();
		assertEquals(MembersForTest.ANDY.getMemberName(), gui.memberSearchResult.getText());
	}
	
	private void pause()
	{
		try
		{
			Thread.sleep(250);
		} catch (InterruptedException e)
		{
		}
	}

}
