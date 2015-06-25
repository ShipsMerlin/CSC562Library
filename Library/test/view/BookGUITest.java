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

import datasource.BooksForTest;

/**
 * @author Benjamin Wiens
 *
 */
public class BookGUITest
{
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
	}
	
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
		JLabel label = (JLabel) componentMap.getComponentByName("AddBookLabel");
		assertEquals("AddBookLabel", label.getName());
		
		// Make sure Member TextField is on the screen
		JTextField textField = (JTextField) componentMap.getComponentByName("authorBox");
		assertEquals("authorBox", textField.getName());
		
		// Make sure Add button is on the screen
		JButton button = (JButton) componentMap.getComponentByName("AddBookButton");
		assertEquals("AddBookButton", button.getName());
		
		// click AddBook Button
		button.doClick();
		pause();
		
		// do we get to the Add book screen?
		assertEquals(Runner.BOOK_CARD, gui.bookCard.getName());
	
		// Try adding 'New Books' to the list of Books
		gui.titleBox.setText("New Member");
		gui.authorBox.setText("New Author");
		gui.isbnBox.setText("111");
		gui.buttonAddBook.doClick();	// click AddBook Button

		pause();
		
		//Does the Display Member Name textbox show 'New Book'?
		assertEquals("New Author", gui.bottomAuthorTextField.getText());
		
		// Try searching for a book that already exists
		gui.BookISBNBox.setText((BooksForTest.WELLINGTON.getISBN()));
		JButton searchBookButton = (JButton) componentMap.getComponentByName("SearchBookButton");
		searchBookButton.doClick();
		pause();
		
		// Does the Display Member Name textbox show 'New Member'?
		assertEquals(BooksForTest.WELLINGTON.getTitle(), gui.bottomTitleTextField.getText());
		
		// Try deleting a Member from the list of Members
		//deleteMemberButton.doClick();
		//pause();

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
