package datasource;

/**
 * A data transfer record that contains the information about a given book
 * @author Merlin
 *
 */
public class BookRecord
{

	private int bookID;
	private String ISBN;
	private String title;
	private String author;
	private int memberID;

	/**
	 * @param bookID
	 *            the book's unique ID
	 * @param ISBN
	 *            the book's ISBN
	 * @param title
	 *            the book's title
	 * @param author
	 *            the book's author
	 * @param memberID
	 *            the ID of the member that has the book checked out (zero if it
	 *            is in the library)
	 */
	public BookRecord(int bookID, String ISBN, String title, String author,
			int memberID)
	{
		super();
		this.bookID = bookID;
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}

	/**
	 * @return the book's author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @return the book's unique DB id
	 */
	public int getBookID()
	{
		return bookID;
	}

	/**
	 * @return the book's ISBN
	 */
	public String getISBN()
	{
		return ISBN;
	}

	/**
	 * 
	 * @return the unique DB id of the member that has this book checked out
	 *         (zero if it is in the library)
	 */
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * @return the book's title
	 */
	public String getTitle()
	{
		return title;
	}
}
