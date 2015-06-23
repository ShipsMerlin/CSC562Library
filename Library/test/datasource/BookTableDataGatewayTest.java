package datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.DatabaseTest;

/**
 * An abstract class that tests the table data gateways into the Book table
 * 
 * @author merlin
 *
 */
public abstract class BookTableDataGatewayTest extends DatabaseTest
{

	private BookTableDataGateway gateway;

	/**
	 * Makes sure to reset gateway
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Before
	public void setup() throws DatabaseException
	{
		super.setUp();
		this.getGateway().resetData();
	}

	/**
	 * Make sure any static information is cleaned up between tests
	 * 
	 * @throws SQLException
	 *             shouldn't
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@After
	public void cleanup() throws DatabaseException, SQLException
	{
		super.tearDown();
		if (gateway != null)
		{
			gateway.resetData();
		}
	}

	/**
	 * @return the gateway we should test
	 */
	public abstract BookTableDataGateway getGateway();

	/**
	 * 
	 */
	@Test
	public void isASingleton()
	{
		BookTableDataGateway x = getGateway();
		BookTableDataGateway y = getGateway();
		assertSame(x, y);
		assertNotNull(x);
	}

	/**
	 * Make sure we can retrieve all the books that are currently checked out
	 * for a given member
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void retrieveAllBooksCheckedOutByAMember() throws DatabaseException
	{
		gateway = getGateway();
		ArrayList<String> isbn = gateway
				.getBooksForMember(MembersForTest.MERLIN.getMemberID());
		assertEquals(2, isbn.size());
		// the records could be in either order
		BooksForTest first = BooksForTest.CATCHER_IN_THE_RYE;
		BooksForTest second = BooksForTest.WELLINGTON;
		for (String record : isbn)
		{
			if (!record.equals(first.getISBN()) && !record.equals(second.getISBN()))
			{
				fail("returned a book we shouldn't have");
			}
		}
	}

	/**
	 * Make sure that nothing goes wrong if we try to retrieve books that are
	 * checked out and there aren't any
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void retrieveBooksForMemberWithNone()
			throws DatabaseException
	{
		gateway = getGateway();
		ArrayList<String> isbns = gateway.getBooksForMember(3);
		assertEquals(0, isbns.size());
	}
}
