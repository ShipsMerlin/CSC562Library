package model;

import java.util.ArrayList;

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
	 * @throws DatabaseException 
	 */

	@Override
	protected boolean execute() throws DatabaseException
	{
		MemberRowDataGatewayMock gateway = null;
		
		gateway = new MemberRowDataGatewayMock(memberName);
		
		int memberId = gateway.getMemberID();
		
		MemberResponseReport report = new MemberResponseReport(memberId, memberName, new ArrayList<String>());
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
		
//		MemberList ML = new MemberList();
//		String memberName = null;
//		ML.addMember(memberName);
	}
	
}