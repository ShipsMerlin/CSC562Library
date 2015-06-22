package datasource;

import java.util.ArrayList;

import datasource.DatabaseException;

/**
 * Defines the operations required by a gateway into the states of adventures for each member
 * @author Merlin
 *
 */
public interface BookTableDataGateway
{

	/**
	 * Get info of all of the books checked out by a given member
	 * @param memberID the member
	 * @return all of the adventure states
	 * @throws DatabaseException  if we can't get the info from the data source
	 */
	ArrayList<BookRecord> getBooksForMember(int memberID) throws DatabaseException;
	
	/**
	 * reset the data back to the data in BooksForTest
	 */
	void resetData();

}
