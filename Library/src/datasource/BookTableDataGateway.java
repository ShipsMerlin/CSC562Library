package datasource;

import java.util.ArrayList;

import datasource.DatabaseException;

/**
 * Defines the operations required by a gateway into the states of adventures
 * for each member
 * 
 * @author Merlin
 *
 */
public interface BookTableDataGateway
{

	/**
	 * Get ISBNs all of the books checked out by a given member
	 * 
	 * @param memberID
	 *            the member
	 * @return all of the adventure states
	 * @throws DatabaseException
	 *             if we can't get the info from the data source
	 */
	ArrayList<String> getBooksForMember(int memberID) throws DatabaseException;

	/**
	 * reset the data back to the data in BooksForTest
	 */
	void resetData();

	/**
	 * changes who owns a book
	 * 
	 * @param isbn
	 *            the book's ISBN number
	 * @param memberID
	 *            the member who will now have the book checked out
	 */
	void setMemberID(String isbn, int memberID);

}
