package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;

public class Book 
{
	BookRowDataGatewayMock gatewayMock;
	
	public Book() 
	{
	}
	
	public Book(String isbn) throws DatabaseException 
	{
		gatewayMock = new BookRowDataGatewayMock(isbn);
	}

	public String getIsbn() 
	{
		return gatewayMock.getISBN();
	}
	
	public String getTitle() 
	{
		return gatewayMock.getTitle();
	}
	
	public String getAuthor() 
	{
		return gatewayMock.getAuthor();
	}
	
	
}
