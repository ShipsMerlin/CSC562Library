package view;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;

import org.junit.Test;

/**
 * Test the UI with nothing real behind it
 * 
 * @author Merlin
 *
 */
public class RunnerTestMocked
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
	
	/**
	 * make sure that the book button on the main panel causes the book panel to
	 * be displayed
	 */
	
	@Test
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
	}

	@Test
	public void testCheckoutButton()
	{
		Runner r = new Runner();
		r.createAndShowGUI();
		assertEquals(Runner.MAIN_CARD, r.getVisibleCard().getName());
		ComponentMap componentMap = new ComponentMap(Runner.getFrame());
		JButton theButton = (JButton) componentMap
				.getComponentByName(Runner.CHECKOUT_BUTTON);
		theButton.doClick();

		pause();
		assertEquals(Runner.CHECKOUT_CARD, r.getVisibleCard().getName());
	}
	
	
	
}
