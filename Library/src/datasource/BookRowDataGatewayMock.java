package datasource;

import java.util.HashMap;

import datasource.DatabaseException;
import datasource.BooksForTest;

/**
 * A mock implementation for BookRowDataGateway
 * 
 * @author Merlin
 *
 */
public class BookRowDataGatewayMock implements BookRowDataGateway
{

	private class BookInfo
	{
		public BookInfo(int bookId, String title, String author, int memberID)
		{
			super();
			this.bookId = bookId;
			this.title = title;
			this.author = author;
			this.memberID = memberID;
		}

		private int bookId;
		private String title;
		private String author;
		private int memberID;

	}

	/**
	 * Map book ID to book information
	 */
	private static HashMap<String, BookInfo> bookInfo;
	private static int nextKey = 1;
	private BookInfo info;
	private String isbn;

	/**
	 * Finder constructor - will initialize itself from the stored information
	 * 
	 * @param isbn
	 *            the ISBN of the book we are looking for
	 * @throws DatabaseException
	 *             if the bookID isn't in the data source
	 */
	public BookRowDataGatewayMock(String isbn) throws DatabaseException
	{
		if (bookInfo == null)
		{
			resetData();
		}

		if (bookInfo.containsKey(isbn))
		{
			info = bookInfo.get(isbn);
			this.isbn = isbn;
		} else
		{
			throw new DatabaseException("Couldn't find book with ID " + isbn);
		}
	}

	/**
	 * Create constructor - will add the information as a new row in the data
	 * source as the object is constructed
	 * 
	 * @param isbn
	 *            the book's isbn number
	 * @param title
	 *            the book's title
	 * @param author
	 *            the books author
	 * @param memberID
	 *            the ID of the member that has this book checked out
	 * 
	 */
	public BookRowDataGatewayMock(String isbn, String title, String author,
			int memberID)
	{
		if (bookInfo == null)
		{
			resetData();
		}
		int bookID = nextKey;
		nextKey++;
		this.isbn = isbn;

		bookInfo.put(isbn, new BookInfo(bookID, title, author, memberID));
	}

	/**
	 * Just used by tests to reset static information
	 */
	public BookRowDataGatewayMock()
	{
	}

	/**
	 * @see datasource.BookRowDataGateway#resetData()
	 */
	@Override
	public void resetData()
	{
		bookInfo = new HashMap<String, BookInfo>();
		nextKey = 1;
		for (BooksForTest p : BooksForTest.values())
		{
			bookInfo.put(
					p.getISBN(),
					new BookInfo(nextKey, p.getTitle(), p.getAuthor(), p
							.getMemberID()));
			nextKey++;
		}
	}

	/**
	 * @see datasource.BookRowDataGateway#getBookID()
	 */
	@Override
	public int getBookID()
	{
		return info.bookId;
	}

	/**
	 * @see datasource.BookRowDataGateway#getISBN()
	 */
	@Override
	public String getISBN()
	{
		return isbn;
	}

	/**
	 * @see datasource.BookRowDataGateway#getTitle()
	 */
	@Override
	public String getTitle()
	{
		return info.title;
	}

	/**
	 * @see datasource.BookRowDataGateway#getAuthor()
	 */
	@Override
	public String getAuthor()
	{
		return info.author;
	}

	/**
	 * @see datasource.BookRowDataGateway#persist()
	 */
	@Override
	public void persist()
	{
		bookInfo.put(isbn, info);
		BookTableDataGatewayMock.getSingleton()
				.setMemberID(isbn, info.memberID);
	}

	/**
	 * @see datasource.BookRowDataGateway#setMemberID(int)
	 */
	@Override
	public void setMemberID(int memberID)
	{
		info.memberID = memberID;

	}

	/**
	 * @see datasource.BookRowDataGateway#getMemberID()
	 */
	@Override
	public int getMemberID()
	{
		return info.memberID;
	}

}
