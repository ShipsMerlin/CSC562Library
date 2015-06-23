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
	 */
	public String getISBN()
	{
		return gatewayMock.getISBN();
	}

	/**
	 * @return the book's title
	 */
	public String getTitle()
	{
		return gatewayMock.getTitle();
	}

	/**
	 * @return the book's author
	 */
	public String getAuthor()
	{
		return gatewayMock.getAuthor();
	}

}
