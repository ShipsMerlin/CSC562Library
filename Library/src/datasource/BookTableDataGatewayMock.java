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

	private class BookInfo
	{
		public BookInfo(int bookID, String iSBN, String title, String author)
		{
			super();
			this.bookID = bookID;
			ISBN = iSBN;
			this.title = title;
			this.author = author;
		}
		private int bookID;
		private String ISBN;
		private String title;
		private String author;
		
	}
	private Hashtable<Integer, ArrayList<BookInfo>> data;

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
		data = new Hashtable<Integer, ArrayList<BookInfo>>();
		for (BooksForTest a : BooksForTest.values())
		{
			BookInfo rec = new BookInfo(a.getBookID(),a.getISBN(),a.getTitle(), a.getAuthor());
			int key = a.getMemberID();
			if (data.containsKey(key))
			{
				ArrayList<BookInfo> x = data.get(key);
				x.add(rec);
			} else
			{
				ArrayList<BookInfo> x = new ArrayList<BookInfo>();
				x.add(rec);
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
			ArrayList<String> isbns = new ArrayList<String>();
			for (BookInfo info:data.get(memberID))
			{
				isbns.add(info.ISBN);
			}
			return isbns;
		} else
		{
			return new ArrayList<String>();
		}
	}
}
