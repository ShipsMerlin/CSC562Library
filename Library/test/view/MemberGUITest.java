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
		JLabel label = (JLabel) componentMap.getComponentByName("MemberName");
		assertEquals("MemberName", label.getName());
		
		// Make sure Member TextField is on the screen
		JTextField textField = (JTextField) componentMap.getComponentByName("txtMemberName");
		assertEquals("txtMemberName", textField.getName());
		
		// Make sure Add button is on the screen
		JButton button = (JButton) componentMap.getComponentByName("btnSearchMember");
		assertEquals("btnSearchMember", button.getName());
		/**
		 * 
		 * 
		 */
		
		// Make sure Member label is on the screen
				JLabel MemberIDLabel = (JLabel) componentMap.getComponentByName("MemberId");
				assertEquals("MemberId", MemberIDLabel.getName());
				
				// Make sure Member TextField is on the screen
				JTextField MemberIDText = (JTextField) componentMap.getComponentByName("MemberID");
				assertEquals("MemberID", MemberIDText.getName());
				
				// Make sure Add button is on the screen
				JButton memberIDButton = (JButton) componentMap.getComponentByName("btnMemberID");
				assertEquals("btnMemberID", memberIDButton.getName());
				
				/**
				 * 
				 * 
				 */
				
				
				// Make sure Member label is on the screen
				JLabel MemberNameLabel1 = (JLabel) componentMap.getComponentByName("DisplyMemberN");
				assertEquals("DisplyMemberN", MemberNameLabel1.getName());
				
				// Make sure Member TextField is on the screen
				JTextField MemberNameText1 = (JTextField) componentMap.getComponentByName("DisplyMemberName");
				assertEquals("DisplyMemberName", MemberNameText1.getName());
				
				// Make sure Add button is on the screen
				JButton memberNameButton1 = (JButton) componentMap.getComponentByName("btnMemberName");
				assertEquals("btnMemberName", memberNameButton1.getName());
				
				/**
				 * 
				 * 
				 */
				
				// Make sure Member label is on the screen
				JLabel BookLabel = (JLabel) componentMap.getComponentByName("DisplyBook");
				assertEquals("DisplyBook", BookLabel.getName());
				
				// Make sure Member TextField is on the screen
				JTextField BookText = (JTextField) componentMap.getComponentByName("DisplyBook");
				assertEquals("DisplyBook", BookText.getName());
				
				
				
		
		// click AddMember Button
		button.doClick();
		pause();
		memberIDButton.doClick();
		pause();
		memberNameButton1.doClick();
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
