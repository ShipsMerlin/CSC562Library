package model;

import org.easymock.EasyMock;
import org.junit.Test;

import datasource.BooksForTest;
import datasource.DatabaseException;
/**
 * @author bwiens
 *
 */
public class CommandFindBookTest {

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException
	{	
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, BookResponseReport.class);
		
		BookResponseReport mockReport = new BookResponseReport(BooksForTest.WELLINGTON.getBookID(), BooksForTest.WELLINGTON.getISBN(), BooksForTest.WELLINGTON.getTitle(), BooksForTest.WELLINGTON.getAuthor());
		
		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);
		
//		connector.sendReport(new FindMemberResponseReport(2, "Merlin"));

		CommandFindBook cmd = new CommandFindBook(BooksForTest.WELLINGTON.getISBN());
		cmd.execute();
//		
//		try {
//			Thread.sleep(250);
//		} catch (InterruptedException e){
//			System.out.println(e.getStackTrace());
//		}
		
		EasyMock.verify(mockedObserver);
	}
	
}
