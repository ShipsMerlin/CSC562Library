package model;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import datasource.BookRowDataGatewayMock;
import datasource.BooksForTest;
import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;

/**
 * @author bwiens
 *
 */
public class CommandFindBookTest
{
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
		new MemberRowDataGatewayMock().resetData();
		new BookRowDataGatewayMock().resetData();
	}

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException
	{
		QualifiedObserver mockedObserver = EasyMock
				.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();

		connector.registerObserver(mockedObserver, BookResponseReport.class);
		Book book = new Book(BooksForTest.WELLINGTON.getISBN());
		
		BookResponseReport mockReport = new BookResponseReport(book);

		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);

		// connector.sendReport(new FindMemberResponseReport(2, "Merlin"));

		CommandFindBook cmd = new CommandFindBook(
				BooksForTest.WELLINGTON.getISBN());
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
