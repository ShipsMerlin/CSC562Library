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
	CATCHER_IN_THE_RYE(1, "1514355000", "Catcher In The Rye", "J. D. Salinger"),
	/**
	 * 
	 */
	WELLINGTON(2, "0007137508", "Wellington The Iron Duke", "Richard Holmes");

	private int bookID;

	private String isbn;

	private String title;
	private String author;

	private BooksForTest(int bookID, String isbn, String title, String author)
	{
		this.bookID = bookID;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
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
	 * @return the title of the book
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @return the author of the book
	 */
	public String getAuthor()
	{
		return author;
	}

}