package model;

import datasource.BookRowDataGatewayMock;

/**
 * @author ma7488
 *
 */
public class CommandAddBook extends Command

	{
	/**
	 * 
	 */
	String bookIsbn;
	/**
	 * 
	 */
	String Booktitle;
	/**
	 * 
	 */
	String bookauthor;
	/**
	 * 
	 */
	int bookmemberID;
	
	/**
	 * @param isbn
	 * @param title
	 * @param author
	 * @param memberID
	 */
	public CommandAddBook(String isbn, String title, String author, int memberID) {
		bookIsbn = isbn;
		Booktitle = title;
		bookauthor = author;
		bookmemberID = memberID;
	}
	
	@Override
	protected boolean execute()
	{

		BookRowDataGatewayMock gateway = null;
		
		// use find constructor to get member information
		gateway = new BookRowDataGatewayMock( bookIsbn, Booktitle, bookauthor,bookmemberID);
		
		// get the member name
		int bookID = gateway.getBookID();
		String bookIsbn = gateway.getISBN();
		String bookAuthor = gateway.getAuthor();
		String bookTitle = gateway.getTitle();
		
		// create response report
		BookResponseReport report = new BookResponseReport(bookID, bookIsbn, bookTitle, bookAuthor);
		
		// send response report
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
