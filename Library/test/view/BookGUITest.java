package view;

import static org.junit.Assert.*;

import javax.swing.JButton;
import org.junit.Test;

/**
 * @author Evania Mans
 *
 */
public class BookGUITest
{

	/**
	 * make sure that the book button on the main panel causes the book panel to
	 * be displayed
	 */
	@Test
	public void testBookButton()
	{
		Runner r = new Runner();
		r.createAndShowGUI();
		assertEquals(Runner.MAIN_CARD, r.getVisibleCard().getName());
		ComponentMap componentMap = new ComponentMap(Runner.getFrame());
		JButton theButton = (JButton) componentMap
				.getComponentByName(Runner.BOOK_BUTTON);
		theButton.doClick();

		pause();
		assertEquals(Runner.BOOK_CARD, r.getVisibleCard().getName());
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
