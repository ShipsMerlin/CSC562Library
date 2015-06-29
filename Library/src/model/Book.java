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
	 * @param isbn
	 * @param title
	 * @param author
	 */
	public Book(String isbn, String title, String author) {
		gatewayMock = new BookRowDataGatewayMock(isbn, title, author, 0);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gatewayMock == null) ? 0 : gatewayMock.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (gatewayMock == null) {
			if (other.gatewayMock != null)
				return false;
		} else if (!gatewayMock.equals(other.gatewayMock))
			return false;
		return true;
	}



	/**
	 * @return the book's unique db id
	 * @throws DatabaseException
	 */
	public int getBookId() throws DatabaseException
	{
		return gatewayMock.getBookID();
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
