package view;

import static org.junit.Assert.*;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.QualifiedObservableConnector;

import org.junit.Before;
import org.junit.Test;

import datasource.MembersForTest;

/**
 * @author Evania Mans,Saad,Mohammed
 *
 */
public class MemberGUITest
{
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
	}
	
	/**
	 * Tests the MemberGUI
	 * Makes sure the components are on the screen and tests the buttons.
	 */
	@Test
	public void test() {
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout());
		MemberGUI gui = new MemberGUI(panel);
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(gui.memberCard);
		
		/**
		 * Make sure the Add Member components are on the screen
		 */
		
		JLabel addMemberLabel = (JLabel) componentMap.getComponentByName("AddMemberName");
		assertNotNull(addMemberLabel);
		
		JTextField addMemberText = (JTextField) componentMap.getComponentByName("txtAddMemberName");
		assertNotNull(addMemberText);
		
		JButton addMemberButton = (JButton) componentMap.getComponentByName("btnAddMember");
		assertNotNull(addMemberButton);
		
		/**
		 * Make sure the Search Member components are on the screen
		 * 
		 */
		
		JLabel searchMemberLabel = (JLabel) componentMap.getComponentByName("lblSearchMemberId");
		assertNotNull(searchMemberLabel);
		
		JTextField searchMemberText = (JTextField) componentMap.getComponentByName("txtSearchMemberID");
		assertNotNull(searchMemberText);
		
		JButton searchMemberButton = (JButton) componentMap.getComponentByName("btnMemberSearch");
		assertNotNull(searchMemberButton);
		
		/**
		 * Make sure the Display Member components are on the screen
		 * 
		 */
		
		
		JLabel displayMemberNameLabel = (JLabel) componentMap.getComponentByName("DisplyMemberNameLabel");
		assertNotNull(displayMemberNameLabel);
		
		JTextField displayMemberNameText = (JTextField) componentMap.getComponentByName("DisplyMemberNameText");
		assertNotNull(displayMemberNameText);
		
		JButton deleteMemberButton = (JButton) componentMap.getComponentByName("btnDeleteMember");
		assertNotNull(deleteMemberButton);
		
		/**
		 * Make sure Book display components are on the screen
		 * 
		 */
		
		JLabel BookLabel = (JLabel) componentMap.getComponentByName("DisplaybookLabel");
		assertNotNull(BookLabel);
		
		JTextField BookText = (JTextField) componentMap.getComponentByName("DisplayBookText");
		assertNotNull(BookText);
				
				
				
		
		// Try adding 'New Member' to the list of members
		gui.addMemberNameTextField.setText("New Member");
		addMemberButton.doClick();	// click AddMember Button
		pause();
		
		// Does the Display Member Name textbox show 'New Member'?
		assertEquals("New Member", gui.txtDisplayMemberName.getText());
		
		// Try searching for a member that already exists
		gui.searchMemberIDText.setText(Integer.toString(MembersForTest.ANDY.getMemberID()));
		searchMemberButton.doClick();
		pause();
		
		// Does the Display Member Name textbox show 'New Member'?
		assertEquals(MembersForTest.ANDY.getMemberName(), gui.txtDisplayMemberName.getText());
		
		// Try deleting a Member from the list of Members
		//deleteMemberButton.doClick();
		//pause();

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
