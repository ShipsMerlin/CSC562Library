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
public class BookGUITest
{
	/**
	 * 
	 */
	@Test
	public void test() {
		JPanel panel = new JPanel();
		panel.setLayout(new CardLayout());
		BookGUI gui = new BookGUI(panel);
		gui.createAndShowGUI();
		ComponentMap componentMap = new ComponentMap(gui.bookCard);
		
		// Make sure Member label is on the screen
		JLabel label = (JLabel) componentMap.getComponentByName("BookLabel");
		assertEquals("BookLabel", label.getName());
		
		// Make sure Member TextField is on the screen
		JTextField textField = (JTextField) componentMap.getComponentByName("BookTextField");
		assertEquals("BookTextField", textField.getName());
		
		// Make sure Add button is on the screen
		JButton button = (JButton) componentMap.getComponentByName("AddBookButton");
		assertEquals("AddBookButton", button.getName());
		
		// click AddMember Button
		button.doClick();
		pause();
		
		// do we get to the Add member screen?
		assertEquals(Runner.BOOK_CARD, gui.bookCard.getName());
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
