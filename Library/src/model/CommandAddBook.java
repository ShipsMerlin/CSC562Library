package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;

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
	 * 
	 */
	int bookquantity;
	
	/**
	 * @param isbn
	 * @param title
	 * @param author
	 * @param memberID
	 * @param quantity
	 */
	public CommandAddBook(String isbn, String title, String author, int memberID, int quantity) {
		bookIsbn = isbn;
		Booktitle = title;
		bookauthor = author;
		bookmemberID = memberID;
		bookquantity = quantity;
	}
	
	@Override
	protected boolean execute() throws DatabaseException
	{		
		// use find constructor to get member information
		BookRowDataGatewayMock gateway = new BookRowDataGatewayMock(bookIsbn, Booktitle, bookauthor,bookmemberID, bookquantity);
		Book book = new Book(gateway.getISBN());
		
		// create response report
		BookResponseReport report = new BookResponseReport(book);
		
		// send response report
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
