package datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;

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
		gateway = createGateway("999999999","Methusulah", "Great Writer");

		BookRowDataGateway after = findGateway(gateway.getISBN());

		assertEquals("Methusulah", after.getTitle());
		assertEquals("999999999", after.getISBN());
		assertEquals("Great Writer", after.getAuthor());
	}

	/**
	 * Put a new entry into the gateway
	 * 
	 * @param name
	 *            the new book's name
	 * @param author the book's author
	 * @param title the book's title
	 * @return a gateway for the new row
	 */
	abstract BookRowDataGateway createGateway(String name, String title, String author);

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

}
