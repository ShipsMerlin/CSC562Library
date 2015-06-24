package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;
/**
 * @author Mohhamed
 *
 */
public class CommandDeleteBook extends Command

{
	/**
	 * 
	 */
	String BookISBN;
	/**
	 * 
	 */
	String BookTitle;
	/**
	 * 
	 */
	String BookAuther;
	/**
	 * 
	 */
	int BookID;

	
	
	
	/**
	 * @param ISBN
	 * @param A 
	 */
	public CommandDeleteBook(String ISBN)
	{
		BookISBN = ISBN;
	}

	@Override
	protected boolean execute() throws DatabaseException
	{
		BookRowDataGatewayMock gateway = null;
		
		gateway = new BookRowDataGatewayMock(BookISBN);
		
		String BookTitle = gateway.getTitle();
		String BookISBN = gateway.getISBN();
		int BookID = gateway.getBookID();
		String BookAuther = gateway.getAuthor();
		
		BookResponseReport report = new BookResponseReport(BookID, BookISBN, BookTitle, BookAuther);
	
		
		gateway.deleteBook();
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
