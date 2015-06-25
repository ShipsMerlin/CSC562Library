package model;

import java.util.ArrayList;

import datasource.BookTableDataGatewayMock;
import datasource.DatabaseException;
import datasource.MemberRowDataGatewayMock;

/**
 * @author em1419
 *
 */
public class CommandFindMember extends Command
{
	/**
	 * 
	 */
	int memberId;
	
	/**
	 * @param id
	 */
	public CommandFindMember(int id) {
		memberId = id;
	}

	@Override
	protected boolean execute() throws DatabaseException
	{
		MemberRowDataGatewayMock gateway = null;
		
		try
		{
			// use find constructor to get member information
			gateway = new MemberRowDataGatewayMock(memberId);
		} catch (DatabaseException e)
		{
			e.printStackTrace();
			return false;
		}
		
		// get the member name
		String memberName = gateway.getMemberName();
		ArrayList<String> isbns = BookTableDataGatewayMock.getSingleton().getBooksForMember(memberId);
		
		// create response report
		MemberResponseReport report = new MemberResponseReport(memberId, memberName, isbns);
		
		// send response report
		QualifiedObservableConnector.getSingleton().sendReport(report);
		
		return true;
	}

}
