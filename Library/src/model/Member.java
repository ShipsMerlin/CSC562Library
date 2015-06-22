package model;

import java.util.ArrayList;

public class Member
{

	private String memberName;
	private int memberID;
	public int getMemberID()
	{
		return memberID;
	}

	private ArrayList<Book> booksCheckedOut;

	public Member(int memberID, String memberName)
	{
		this.memberID = memberID;
		this.memberName = memberName;
		this.booksCheckedOut = new ArrayList<Book>();
	}

	public String getMemberName()
	{
		return memberName;
	}

	public ArrayList<Book> getBooksCheckedOut()
	{
		return booksCheckedOut;
	}

	public void addBook(Book book)
	{
		booksCheckedOut.add(book);
	}

}
