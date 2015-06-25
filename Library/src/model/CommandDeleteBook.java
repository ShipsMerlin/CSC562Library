package model;

import datasource.BookRowDataGateway;
import datasource.BookRowDataGatewayMock;
import datasource.BookRowDataGatewaySQL;
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
	String bookISBN;
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
		bookISBN = ISBN;
	}

	@Override
	protected boolean execute() throws DatabaseException
	{
		BookRowDataGateway gateway = new BookRowDataGatewaySQL(bookISBN);
		Book book = new Book(bookISBN);

		BookResponseReport report = new BookResponseReport(book);

		gateway.deleteBook();
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
