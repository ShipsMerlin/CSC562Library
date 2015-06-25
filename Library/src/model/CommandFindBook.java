package model;

import datasource.DatabaseException;

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
	 * @throws DatabaseException 
	 * 
	 */
	@Override
	protected boolean execute() throws DatabaseException
	{		
		Book book = new Book(bookIsbn);
		
		// create response report
		BookResponseReport report = new BookResponseReport(book);
		//BookResponseReport report = new BookResponseReport(bookID, bookIsbn, bookTitle, bookAuthor);
		
		// send response report
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
