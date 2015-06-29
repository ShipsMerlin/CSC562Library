package datasource;

import datasource.DatabaseException;

/**
 * Tests for the mock version of the gateway
 * 
 * @author Merlin
 *
 */
public class BookRowDataGatewayMockTest extends BookRowDataGatewayTest
{

	/**
	 * @see datasource.BookRowDataGatewayTest#findGateway(java.lang.String)
	 */
	@Override
	BookRowDataGateway findGateway(String isbn) throws DatabaseException
	{
		return new BookRowDataGatewayMock(isbn);
	}

	/**
	 * @see datasource.BookRowDataGatewayTest#createGateway(java.lang.String,
	 *      java.lang.String, java.lang.String, int)
	 */
	@Override
	BookRowDataGateway createGateway(String isbn, String title, String author,
			int memberID)
	{
		return new BookRowDataGatewayMock(isbn, title, author, memberID);
	}

	/**
	 * @see datasource.BookRowDataGatewayTest#findTableGateway()
	 */
	@Override
	BookTableDataGateway findTableGateway()
	{
		return BookTableDataGatewayMock.getSingleton();
	}

}
