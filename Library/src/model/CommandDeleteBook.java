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
		BookRowDataGatewayMock gateway = new BookRowDataGatewayMock(BookISBN);
		Book book = new Book(BookISBN);

		BookResponseReport report = new BookResponseReport(book);

		gateway.deleteBook();
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
