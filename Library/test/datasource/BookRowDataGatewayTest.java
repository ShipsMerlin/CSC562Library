package datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.DatabaseTest;
import datasource.BooksForTest;

/**
 * Tests required of all book gateways
 * 
 * @author Merlin
 *
 */
public abstract class BookRowDataGatewayTest extends DatabaseTest
{

	private BookRowDataGateway gateway;

	/**
	 * Find the gateway for a given book
	 * 
	 * @param isbn
	 *            the ID of the book we are testing
	 * @return the gateway
	 * @throws DatabaseException
	 *             if the bookID can't be found in the data source
	 */
	abstract BookRowDataGateway findGateway(String isbn)
			throws DatabaseException;

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
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void finder() throws DatabaseException
	{
		BooksForTest book = BooksForTest.WELLINGTON;
		gateway = findGateway(book.getISBN());
		assertEquals(book.getBookID(), gateway.getBookID());
		assertEquals(book.getAuthor(), gateway.getAuthor());
		assertEquals(book.getISBN(), gateway.getISBN());
		assertEquals(book.getTitle(), gateway.getTitle());
	}

	/**
	 * Make sure we can add a new user to the system
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void creation() throws DatabaseException
	{
		gateway = createGateway("999999999", "Methusulah", "Great Writer", 5);

		BookRowDataGateway after = findGateway(gateway.getISBN());

		assertEquals("Methusulah", after.getTitle());
		assertEquals("999999999", after.getISBN());
		assertEquals("Great Writer", after.getAuthor());
		assertEquals(5, after.getMemberID());
	}

	/**
	 * Put a new entry into the gateway
	 * 
	 * @param name
	 *            the new book's name
	 * @param title
	 *            the book's title
	 * @param author
	 *            the book's author
	 * @param memberID
	 *            the member that has the book checked out
	 * @return a gateway for the new row
	 */
	abstract BookRowDataGateway createGateway(String name, String title,
			String author, int memberID);

	/**
	 * make sure we get the right exception if we try to find someone who
	 * doesn't exist
	 * 
	 * @throws DatabaseException
	 *             should
	 */
	@Test(expected = DatabaseException.class)
	public void findNotExisting() throws DatabaseException
	{
		gateway = findGateway("000000000");
	}

	/**
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void canChangeMemberID() throws DatabaseException
	{
		gateway = findGateway(BooksForTest.FINDERS_KEEPERS.getISBN());
		gateway.setMemberID(42);
		gateway.persist();

		BookRowDataGateway after = findGateway(BooksForTest.FINDERS_KEEPERS
				.getISBN());
		assertEquals(42, after.getMemberID());

		ArrayList<String> isbns = findTableGateway().getBooksForMember(42);
		assertEquals(1, isbns.size());
		assertEquals(BooksForTest.FINDERS_KEEPERS.getISBN(), isbns.get(0));
	}

	/**
	 * This is used to make sure that the data that is persisted by the row data
	 * gateway is also persisted to the data source used by the table data
	 * gateway
	 * 
	 * @return the table data gateway that functions like the row data gateway
	 *         we are testing.
	 */
	abstract BookTableDataGateway findTableGateway();
}
