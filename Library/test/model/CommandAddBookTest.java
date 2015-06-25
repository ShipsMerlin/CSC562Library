package model;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import datasource.BooksForTest;
import datasource.DatabaseException;

/**
 * @author
 *
 */
public class CommandAddBookTest
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
	String NewBookISBN = "777";
	/**
		 * 
		 */
	String NewTitle = "Saudi Arabia";
	/**
		 * 
		 */
	String NewAuthor = "Saad";

	/**
	 * @throws DatabaseException 
	 * 
	 */
	@Test
	public void test() throws DatabaseException
	{
		QualifiedObserver mockedObserver = EasyMock
				.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();

		connector.registerObserver(mockedObserver, BookResponseReport.class);

		int newID = BooksForTest.values().length + 1;
		BookResponseReport mockReport = new BookResponseReport(newID,
				NewBookISBN, NewTitle, NewAuthor);

		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);

		// connector.sendReport(new FindMemberResponseReport(2, "Merlin"));

		CommandAddBook cmd = new CommandAddBook(NewBookISBN, NewTitle,
				NewAuthor, 38718);
		cmd.execute();
		//
		// try {
		// Thread.sleep(250);
		// } catch (InterruptedException e){
		// System.out.println(e.getStackTrace());
		// }

		EasyMock.verify(mockedObserver);
	}
}
