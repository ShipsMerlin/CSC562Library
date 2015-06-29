package model;

import datasource.DatabaseException;

/**
 * @author bwiens
 *
 */
public class BookResponseReport implements QualifiedObservableReport {
	
	 /**
	 * 
	 */
	Book book;
	
	/**
	 * @param book 
	 * @param id
	 * @param isbn
	 * @param title
	 * @param author
	 * @param quantity
	 */
	public BookResponseReport(Book book) {
		this.book = book;		
	}
	
	/**
	 * @return - ID associated with the book
	 * @throws DatabaseException 
	 */
	public int getBookId() throws DatabaseException {
		return book.getBookId();
	}
	
	/**
	 * @return - ISBN associated with the book
	 * @throws DatabaseException 
	 */
	public String getBookIsbn() throws DatabaseException {
		return book.getISBN();
	}
	
	/**
	 * @return - Title associated with the book
	 * @throws DatabaseException 
	 */
	public String getBookTitle() throws DatabaseException {
		return book.getTitle();
	}
	
	/**
	 * @return - Author associated with the book
	 * @throws DatabaseException 
	 */
	public String getBookAuthor() throws DatabaseException {
		return book.getAuthor();
	}
	
	/**
	 * @return quantity
	 * @throws DatabaseException 
	 */
	public int getBookQuantity() throws DatabaseException {
		// TODO Auto-generated method stub
		return book.getQuantity();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookResponseReport other = (BookResponseReport) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}

	
	
		
	
}
