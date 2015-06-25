package model;

import java.util.ArrayList;

import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;

/**
 * @author Evania Mans
 *
 */
public class CommandDeleteMember extends Command
{

	/**
	 * The Member's ID
	 */
	int memberId;
	
	/**
	 * @param id - the ID of the member you want to delete
	 */
	public CommandDeleteMember(int id)
	{
		memberId = id;
	}

	@Override
	protected boolean execute() throws DatabaseException
	{
		MemberRowDataGatewayMock gateway = null;
		
		gateway = new MemberRowDataGatewayMock(memberId);
		
		String memberName = gateway.getMemberName();
		
		MemberResponseReport report = new MemberResponseReport(memberId, memberName, new ArrayList<String>());
		
		gateway.deleteMember();
		
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
