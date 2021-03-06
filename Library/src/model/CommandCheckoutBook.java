package model;

import datasource.BookRowDataGatewayMock;
import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;
import model.Book;

/**
 * @author ma7488
 *
 */
public class CommandCheckoutBook extends Command

{
	/**
	 * 
	 */
	//Book book;
	String ISBN;
	/**
	 * 
	 */
	int memberId;
/**
 * @param b 
 * @param id 
 */
//public  void checkOutBook(String bookISBN, int memberID) {
public CommandCheckoutBook(String ISBN, int id) {
	this.ISBN = ISBN;
	memberId = id;
}
	

//}

@Override
protected boolean execute() throws DatabaseException
{

//	BookRowDataGatewayMock gateway = null;
	Book book= new Book(ISBN);

	// use find constructor to get member information
//	gateway = new BookRowDataGatewayMock(book.getISBN());
	
	// get the member name
	Member member = new Member(memberId);
	member.checkOutBook(book);
	
	// create response report
	CheckoutBookResponseReport report = new CheckoutBookResponseReport(book, member.getMemberName());
	
	// send response report
	QualifiedObservableConnector.getSingleton().sendReport(report);
	
	return true;
}

}
