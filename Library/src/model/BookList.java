package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;

public class BookList {

	public String addBook (String isbn, String title, String author) {
		BookRowDataGatewayMock bookRowDataGatewayMock = new BookRowDataGatewayMock( isbn,  title,  author);
		return bookRowDataGatewayMock.getISBN();
	}
	public String getBook (String isbn) throws DatabaseException {
		BookRowDataGatewayMock bookRowDataGatewayMock = new BookRowDataGatewayMock( isbn);
		return bookRowDataGatewayMock.getISBN();

	}
}
