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
	 * @param string 
	 * @param memberName
	 * @return MemberID
	 */
	public int addMember(String memberName) {
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock ( memberName);
		return memberRowDataGatewayMock.getMemberID();
	}
	
	
	/**
	 * @param int
	 * @return memberName
	 * @throws DatabaseException
	 */
	@SuppressWarnings("javadoc")
	public String getMemberName(int memberID) throws DatabaseException {
		MemberRowDataGatewayMock memberRowDataGatewayMock = new MemberRowDataGatewayMock(memberID);
		return memberRowDataGatewayMock.getMemberName();


	}

}
