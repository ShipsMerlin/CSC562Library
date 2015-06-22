package datasource;

public class BookRecord
{

	private int bookID;
	private String ISBN;
	private String title;
	private String author;
	private int memberID;
	
	public int getMemberID;
	public int getBookID()
	{
		return bookID;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public BookRecord(int bookID, String iSBN, String title, String author, int memberID)
	{
		super();
		this.bookID = bookID;
		ISBN = iSBN;
		this.title = title;
		this.author = author;
	}
}
