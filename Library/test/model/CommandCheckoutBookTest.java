package model;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import datasource.BookRowDataGatewayMock;
import datasource.BooksForTest;
import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;
import datasource.MembersForTest;

public class CommandCheckoutBookTest {
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
		new MemberRowDataGatewayMock().resetData();
		new BookRowDataGatewayMock().resetData();
	}

	@Test
public void test() throws DatabaseException 
	
	{		
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, CheckoutBookResponseReport.class);
		
		Book book = new Book(BooksForTest.WELLINGTON.getISBN());
		CheckoutBookResponseReport expectedReport = new CheckoutBookResponseReport(book,MembersForTest.ANDY.getMemberName());
		
		mockedObserver.receiveReport(expectedReport);
		EasyMock.replay(mockedObserver);
		
		CommandCheckoutBook cmd = new CommandCheckoutBook( BooksForTest.WELLINGTON.getISBN(),MembersForTest.ANDY.getMemberID());
		cmd.execute();
		
		EasyMock.verify(mockedObserver);
	}

}
