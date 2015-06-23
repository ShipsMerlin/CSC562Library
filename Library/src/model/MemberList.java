package model;

import datasource.MemberRowDataGatewayMock;
import datasource.DatabaseException;

/**
 * @author Manal
 *
 */
public class MemberList 
{




	/**
	 * @param memberName
	 * @return memberRowDataGatewayMock.addMemberName
	 */
	public String addMember(String memberName) {
		//String memberName=null;
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock ( memberName);
		return memberRowDataGatewayMock.addMemberName();
	}
	/**
	 * @param memberName
	 * @return memberRowDataGatewayMock.addMemberName
	 * @throws DatabaseException
	 */
	public String getBook (String memberName) throws DatabaseException {
		//String memberName=null;
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock( memberName);
		return memberRowDataGatewayMock.addMemberName();

	}
}