package model;

import datasource.MemberRowDataGatewayMock;
import datasource.DatabaseException;

/**
 * @author Manal Ibrahim
 *
 */
public class MemberList 
{
	/**
	 * 
	 */
	public String memberName;
	/**
	 * @param string 
	 * @param memberName
	 * @return 
	 */
	public int addMember(String memberName) {
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock ( memberName);
		return memberRowDataGatewayMock.getMemberID();
	}
	
	
	/**
	 * @return memberRowDataGatewayMock
	 * @throws DatabaseException
	 */
	public String getMemberName(int memberID) throws DatabaseException {
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock(memberID);
		return memberRowDataGatewayMock.getMemberName();

	}
}