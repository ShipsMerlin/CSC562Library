package datasource;

import datasource.DatabaseException;

/**
 * 
 * @author Merlin
 *
 */
public interface BookRowDataGateway
{

	/**
	 * For testing purposes
	 */
	public void resetData();

	/**
	 * Store this information into the data source
	 * 
	 * @throws DatabaseException
	 *             if we can't persist the data to the data source
	 */
	void persist() throws DatabaseException;

	/**
	 * @return the book's unique db id
	 */
	int getBookID();

	/**
	 * @return the book's title
	 */
	String getTitle();

	/**
	 * @return the book's ISBN
	 */
	String getISBN();

	/**
	 * @return the book's author
	 */
	String getAuthor();

}
