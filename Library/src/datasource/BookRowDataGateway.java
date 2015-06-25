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
	 * @throws DatabaseException 
	 */
	int getBookID() throws DatabaseException;

	/**
	 * @return the book's title
	 * @throws DatabaseException 
	 */
	String getTitle() throws DatabaseException;

	/**
	 * @return the book's ISBN
	 * @throws DatabaseException 
	 */
	String getISBN() throws DatabaseException;

	/**
	 * @return the book's author
	 * @throws DatabaseException 
	 */
	String getAuthor() throws DatabaseException;

	/**
	 * @param memberID
	 *            the ID of the member that has this book checked out
	 */
	public void setMemberID(int memberID);

	/**
	 * @return the ID of the member that has this book checked out
	 */
	public int getMemberID();

	/**
	 * Delete the book that this object is managing
	 */
	public void deleteBook();

}
