package datasource;

import java.util.ArrayList;
import java.util.Hashtable;

import datasource.DatabaseException;

/**
 * Mock version of the gateway to the table of adventure states.
 * 
 * @author merlin
 *
 */
public class BookTableDataGatewayMock implements BookTableDataGateway
{
	private static BookTableDataGateway singleton;

	/**
	 * Retrieves the mock gateway singleton.
	 * 
	 * @return singleton
	 */
	public static synchronized BookTableDataGateway getSingleton()
	{
		if (singleton == null)
		{
			singleton = new BookTableDataGatewayMock();
		}
		return singleton;
	}

	private Hashtable<Integer, ArrayList<BookRecord>> data;

	/**
	 * build the mock data from AdventuresForTest
	 */
	private BookTableDataGatewayMock()
	{
		resetData();
	}

	
	/**
	 * @see datasource.BookTableDataGateway#resetData()
	 */
	public void resetData()
	{
		data = new Hashtable<Integer, ArrayList<BookRecord>>();
		for (BooksForTest a : BooksForTest.values())
		{
			BookRecord rec = new BookRecord(a.getBookID(),a.getISBN(),a.getTitle(), a.getAuthor(), a.getMemberID());
			int key = a.getMemberID();
			if (data.containsKey(key))
			{
				ArrayList<BookRecord> x = data.get(key);
				x.add(rec);
			} else
			{
				ArrayList<BookRecord> x = new ArrayList<BookRecord>();
				x.add(rec);
				data.put(key, x);
			}
		}
	}

	/**
	 * @see datasource.BookTableDataGateway#getBooksForMember(int)
	 */
	@Override
	public ArrayList<BookRecord> getBooksForMember(int memberID)
			throws DatabaseException
	{
		if (data.containsKey(memberID))
		{
			return data.get(memberID);
		} else
		{
			return new ArrayList<BookRecord>();
		}
	}
}
