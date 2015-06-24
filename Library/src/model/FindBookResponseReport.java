package model;

/**
 * @author bwiens
 *
 */
public class FindBookResponseReport implements QualifiedObservableReport {
	
	 /**
	 * Book ID
	 */
	int bookId;

	 /**
	 * Book ISBN
	 */
	String bookIsbn;

	 /**
	 * Book Title
	 */
	String bookTitle;

	 /**
	 * Book Author
	 */
	String bookAuthor;
	 
	 /**
	 * 
	 */
	int memberID;
	
	/**
	 * @param id
	 * @param isbn
	 * @param title
	 * @param author
	 */
	public FindBookResponseReport(int id, String isbn, String title, String author) {
		bookId = id;
		bookIsbn = isbn;
		bookTitle = title;
		bookAuthor = author;		
	}
	
	/**
	 * @return - ID associated with the book
	 */
	public int getBookId() {
		return bookId;
	}
	
	/**
	 * @return - ISBN associated with the book
	 */
	public String getBookIsbn() {
		return bookIsbn;
	}
	
	/**
	 * @return - Title associated with the book
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	
	/**
	 * @return - Author associated with the book
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookIsbn == null) ? 0 : bookIsbn.hashCode());
		result = prime * result
				+ ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + memberID;
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
		FindBookResponseReport other = (FindBookResponseReport) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookIsbn == null) {
			if (other.bookIsbn != null)
				return false;
		} else if (!bookIsbn.equals(other.bookIsbn))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (memberID != other.memberID)
			return false;
		return true;
	}
	
		
	
}
