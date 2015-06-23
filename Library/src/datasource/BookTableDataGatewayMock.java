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

	private Hashtable<Integer, ArrayList<String>> data;

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
		data = new Hashtable<Integer, ArrayList<String>>();
		for (BooksForTest a : BooksForTest.values())
		{
			int key = a.getMemberID();
			if (data.containsKey(key))
			{
				ArrayList<String> x = data.get(key);
				x.add(a.getISBN());
			} else
			{
				ArrayList<String> x = new ArrayList<String>();
				x.add(a.getISBN());
				data.put(key, x);
			}
		}
	}

	/**
	 * @see datasource.BookTableDataGateway#getBooksForMember(int)
	 */
	@Override
	public ArrayList<String> getBooksForMember(int memberID)
			throws DatabaseException
	{
		if (data.containsKey(memberID))
		{
			return data.get(memberID);
		} else
		{
			return new ArrayList<String>();
		}
	}
}
