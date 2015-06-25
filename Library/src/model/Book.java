package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;

/**
 * Models one book in the system
 *
 */
public class Book
{
	private BookRowDataGatewayMock gatewayMock;

	/**
	 * Get the object of an existing book with a given ISBN number
	 * 
	 * @param isbn
	 *            the isbn we are interested in
	 * @throws DatabaseException
	 *             if we can't find the given ISBN number
	 */
	public Book(String isbn) throws DatabaseException
	{
		gatewayMock = new BookRowDataGatewayMock(isbn);
	}

	/**
	 * @return the book's ISBN
	 * @throws DatabaseException 
	 */
	public String getISBN() throws DatabaseException
	{
		return gatewayMock.getISBN();
	}

	/**
	 * @return the book's title
	 * @throws DatabaseException 
	 */
	public String getTitle() throws DatabaseException
	{
		return gatewayMock.getTitle();
	}

	/**
	 * @return the book's author
	 * @throws DatabaseException 
	 */
	public String getAuthor() throws DatabaseException
	{
		return gatewayMock.getAuthor();
	}

}
