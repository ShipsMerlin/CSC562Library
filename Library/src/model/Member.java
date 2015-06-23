package model;

import java.util.ArrayList;

import datasource.DatabaseException;

/**
 * Holds the information about one member of our library
 * 
 *
 */
public class Member
{

	private MemberDataMapper dataMapper;
	
	/**
	 * @param memberID the unique ID of the member we are modeling
	 * @throws DatabaseException if we can't find the given member in the data source
	 *  
	 */
	public Member(int memberID) throws DatabaseException
	{
		this.dataMapper = new MemberDataMapper(memberID);
	}
	
	/**
	 * Add a book to the list of books this member has checked out
	 * @param book the book
	 */
	public void checkOutBook(Book book)
	{
		dataMapper.addISBN(book.getISBN());
	}

	/**
	 * @return the list of books the member currently has checked out
	 */
	public ArrayList<String> getBooksCheckedOut()
	{
		return dataMapper.getISBNs();
	}

	/**
	 * @return the member's unique ID
	 */
	public int getMemberID()
	{
		return dataMapper.getMemberID();
	}

	/**
	 * @return the member's name
	 */
	public String getMemberName()
	{
		return dataMapper.getMemberName();
	}

}
