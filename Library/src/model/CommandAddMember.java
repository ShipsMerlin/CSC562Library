package model;

import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;

/**
 * @author Manal Ibrahim
 *
 */
public class CommandAddMember extends Command
{
	/**
	 * Member Name
	 */
	String memberName;
	
	/**
	 * @param name - the member's name
	 */
	public CommandAddMember(String name) {
		memberName = name;
	}
	
	/**
	 * ML is member List gonne and new Member name
	 */

	@Override
	protected boolean execute()
	{
		MemberRowDataGatewayMock gateway = null;
		
		gateway = new MemberRowDataGatewayMock(memberName);
		
		int memberId = gateway.getMemberID();
		
		MemberResponseReport report = new MemberResponseReport(memberId, memberName);
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
		
//		MemberList ML = new MemberList();
//		String memberName = null;
//		ML.addMember(memberName);
	}
	
}