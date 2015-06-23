package model;

import datasource.DatabaseException;

/**
 * @author em1419
 *
 */
public class CommandFindMember
{

	/**
	 * Finds a member based on memberID
	 * @param memberID
	 * @return - the name of the member
	 * @throws DatabaseException
	 */
	public String getMember(int memberID) throws DatabaseException
	{
		MemberList ml = new MemberList();
		return ml.getMemberName(memberID);
	}

}
