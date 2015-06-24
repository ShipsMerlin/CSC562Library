package model;

import org.easymock.EasyMock;
import org.junit.Test;

import datasource.BooksForTest;
import datasource.DatabaseException;

/**
 * @author ma7488
 *
 */
public class CommandDeleteBookTest {

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException 
	
	{		
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, BookResponseReport.class);
		
		BookResponseReport expectedReport = new BookResponseReport(BooksForTest.WELLINGTON.getBookID(), BooksForTest.WELLINGTON.getISBN(), BooksForTest.WELLINGTON.getTitle(), BooksForTest.WELLINGTON.getAuthor());
		
		mockedObserver.receiveReport(expectedReport);
		EasyMock.replay(mockedObserver);
		
		CommandDeleteBook cmd = new CommandDeleteBook( BooksForTest.WELLINGTON.getISBN());
		cmd.execute();
		
		EasyMock.verify(mockedObserver);
	}

}
