package datasource;

/**
 * The members that are in the test database
 * 
 * @author Merlin
 * 
 */
public enum BooksForTest
{
	/**
	 * 
	 */
	CATCHER_IN_THE_RYE(1, "1514355000", "Catcher In The Rye", "J. D. Salinger",
			MembersForTest.MERLIN.getMemberID()),
	/**
	 * 
	 */
	WELLINGTON(2, "0007137508", "Wellington The Iron Duke", "Richard Holmes",
			MembersForTest.MERLIN.getMemberID()),
	/**
	 * 
	 */
	FINDERS_KEEPERS(3, "12121212", "Finders Keepers", "Stephen King", 0);

	private int bookID;

	private String isbn;

	private String title;

	private String author;
	
	private int memberID;

	private BooksForTest(int bookID, String isbn, String title, String author,
			int memberID)
	{
		this.bookID = bookID;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.memberID = memberID;
	}

	/**
	 * @return the author of the book
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @return the books unique db ID
	 */
	public int getBookID()
	{
		return bookID;
	}

	/**
	 * @return the book's 10 digit ISBN
	 */
	public String getISBN()
	{
		return isbn;
	}

	/**
	 * @return the unique database ID of the member that has this book checked
	 *         out (zero if it is in the library)
	 */
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * @return the title of the book
	 */
	public String getTitle()
	{
		return title;
	}

}