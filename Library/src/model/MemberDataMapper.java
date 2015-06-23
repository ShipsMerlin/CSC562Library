package model;

import java.util.ArrayList;

import datasource.BookRowDataGateway;
import datasource.BookRowDataGatewayMock;
import datasource.BookTableDataGatewayMock;
import datasource.DatabaseException;
import datasource.MemberRowDataGateway;
import datasource.MemberRowDataGatewayMock;

/**
 * Maps all of the information from a member into the data source layer
 * @author Merlin
 *
 */
public class MemberDataMapper
{

	private MemberRowDataGateway memberRowDataGateway;
	private ArrayList<BookRowDataGateway> bookRowDataGateways;

	/**
	 * Finder constructor 
	 * @param memberID the unique ID of the member we are interested in
	 * @throws DatabaseException if we can't find the given member
	 */
	public MemberDataMapper(int memberID) throws DatabaseException
	{
		memberRowDataGateway = new MemberRowDataGatewayMock(memberID);
		bookRowDataGateways = new ArrayList<BookRowDataGateway>();
		ArrayList<String> isbns = BookTableDataGatewayMock.getSingleton().getBooksForMember(memberID);
		for (String isbn:isbns)
		{
			addISBN(isbn);
		}
	}
	
	/**
	 * @return the member's unique ID
	 */
	public int getMemberID()
	{
		return memberRowDataGateway.getMemberID();
	}

	/**
	 * @return the member's name
	 */
	public String getMemberName()
	{
		return memberRowDataGateway.getMemberName();
	}

	/**
	 * @return a list of the ISBNs of books this member has checked out
	 */
	public ArrayList<String> getISBNs()
	{
		ArrayList<String> isbns = new ArrayList<String>();
		for (BookRowDataGateway gateway: bookRowDataGateways)
		{
			isbns.add(gateway.getISBN());
		}
		return isbns;
	}

	/**
	 * Add an ISBN to the set of ISBNs this player has checked out
	 * @param isbn the book we are adding
	 * @throws DatabaseException if the book doesn't exist or the data source fails to make the change
	 */
	public void addISBN(String isbn) throws DatabaseException
	{
		BookRowDataGatewayMock gateway = new BookRowDataGatewayMock(isbn);
		gateway.setMemberID(memberRowDataGateway.getMemberID());
		bookRowDataGateways.add(gateway);
	}

	/**
	 * Persist the information about this member through the data source layer
	 * @throws DatabaseException if the data source cannot persist the data
	 */
	public void persist() throws DatabaseException
	{
		for  (BookRowDataGateway gateway: bookRowDataGateways)
		{
			gateway.persist();
		}
	}

}
