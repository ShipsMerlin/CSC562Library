package model;

import datasource.MemberRowDataGatewayMock;
import datasource.DatabaseException;

public class MemberList {




	public String addBook (String isbn, String title, String author) {
		String memberName=null;
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock ( memberName);
		return memberRowDataGatewayMock.addMemberName();
	}
	public String getBook (String isbn) throws DatabaseException {
		String memberName=null;
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock( memberName);
		return memberRowDataGatewayMock.addMemberName();

	}
}