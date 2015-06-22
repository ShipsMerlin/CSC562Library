package model;

import java.util.ArrayList;

import datasource.BookTableDataGatewayMock;
import datasource.DatabaseException;
import datasource.MemberRowDataGateway;
import datasource.MemberRowDataGatewayMock;

public class MemberDataMapper
{

	private MemberRowDataGateway memberRowDataGateway;

	public MemberDataMapper(int memberID) throws DatabaseException
	{
		memberRowDataGateway = new MemberRowDataGatewayMock(memberID);
	}

	public Member getMember() throws DatabaseException
	{
		Member m = new Member(memberRowDataGateway.getMemberID(), memberRowDataGateway.getMemberName());
		ArrayList<String> isbns = BookTableDataGatewayMock.getSingleton().getBooksForMember(memberRowDataGateway.getMemberID());
		for (String isbn:isbns)
		{
			m.addBook(new Book(isbn));
		}
		return m;
	}

}
