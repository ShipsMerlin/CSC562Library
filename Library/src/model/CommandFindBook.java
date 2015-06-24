package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;

/**
 * @author bwiens
 *
 */
public class CommandFindBook extends Command{

	
	/**
	 * 
	 */
	String bookIsbn;
	/**
	 * @param isbn
	 */
	public CommandFindBook(String isbn) {
		bookIsbn = isbn;
	}

	/**
	 * 
	 */
	@Override
	protected boolean execute()
	{
		BookRowDataGatewayMock gateway = null;
		
		try
		{
			// use find constructor to get member information
			gateway = new BookRowDataGatewayMock(bookIsbn);
		} catch (DatabaseException e)
		{
			e.printStackTrace();
			return false;
		}
		
		// get the member name
		int bookID = gateway.getBookID();
		String bookIsbn = gateway.getISBN();
		String bookAuthor = gateway.getAuthor();
		String bookTitle = gateway.getTitle();
		
		// create response report
		FindBookResponseReport report = new FindBookResponseReport(bookID, bookIsbn, bookTitle, bookAuthor);
		
		// send response report
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
