package model;

import java.util.ArrayList;

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

	/**
	 * Finder constructor 
	 * @param memberID the unique ID of the member we are interested in
	 * @throws DatabaseException if we can't find the given member
	 */
	public MemberDataMapper(int memberID) throws DatabaseException
	{
		memberRowDataGateway = new MemberRowDataGatewayMock(memberID);
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
		try
		{
			return BookTableDataGatewayMock.getSingleton().getBooksForMember(memberRowDataGateway.getMemberID());
		} catch (DatabaseException e)
		{
			return null;
		}
	}

	/**
	 * Add an ISBN to the set of ISBNs this player has checked out
	 * @param isbn the book we are adding
	 */
	public void addISBN(String isbn)
	{
		// TODO Auto-generated method stub
		
	}

}
