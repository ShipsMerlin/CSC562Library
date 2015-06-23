package view;

import static org.junit.Assert.*;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Test;

/**
 * @author Evania Mans
 *
 */
public class MemberGUITest
{

	/**
	 * 
	 */
	@Test
	public void test() {
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout());
		MemberGUI gui = new MemberGUI(panel);
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(gui.memberCard);
		
		// Make sure Member label is on the screen
		JLabel label = (JLabel) componentMap.getComponentByName("MemberLabel");
		assertEquals("MemberLabel", label.getName());
		
		// Make sure Member TextField is on the screen
		JTextField textField = (JTextField) componentMap.getComponentByName("MemberTextField");
		assertEquals("MemberTextField", textField.getName());
		
		// Make sure Add button is on the screen
		JButton button = (JButton) componentMap.getComponentByName("AddMemberButton");
		assertEquals("AddMemberButton", button.getName());
		
		// click AddMember Button
		button.doClick();
		pause();
		
		// do we get to the Add member screen?
		assertEquals(Runner.MEMBER_CARD, gui.memberCard.getName());
	}
	
	
	/**
	 * make sure that the book button on the main panel causes the book panel to
	 * be displayed
	 */

	/*@Test
	public void testMembersButton()
	{
		Runner r = new Runner();
		r.createAndShowGUI();
		assertEquals(Runner.MAIN_CARD, r.getVisibleCard().getName());
		ComponentMap componentMap = new ComponentMap(Runner.getFrame());
		JButton theButton = (JButton) componentMap
				.getComponentByName(Runner.MEMBER_BUTTON);
		theButton.doClick();

		pause();
		assertEquals(Runner.MEMBER_CARD, r.getVisibleCard().getName());
	}*/

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
