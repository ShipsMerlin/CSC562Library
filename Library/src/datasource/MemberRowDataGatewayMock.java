package datasource;

import java.util.HashMap;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * A mock implementation for MemberRowDataGateway
 * 
 * @author Merlin
 *
 */
public class MemberRowDataGatewayMock implements MemberRowDataGateway
{

	private class MemberInfo
	{
		private String memberName;

		public MemberInfo(String memberName)
		{
			this.memberName = memberName;
		}

	}

	/**
	 * Map member ID to member information
	 */
	private static HashMap<Integer, MemberInfo> memberInfo;
	private static int nextKey = 1;
	private int memberID;
	private MemberInfo info;

	/**
	 * Finder constructor - will initialize itself from the stored information
	 * 
	 * @param memberID
	 *            the ID of the member we are looking for
	 * @throws DatabaseException
	 *             if the memberID isn't in the data source
	 */
	public MemberRowDataGatewayMock(int memberID) throws DatabaseException
	{
		if (memberInfo == null)
		{
			resetData();
		}

		if (memberInfo.containsKey(memberID))
		{
			info = memberInfo.get(memberID);
			this.memberID = memberID;
		} else
		{
			throw new DatabaseException("Couldn't find member with ID "
					+ memberID);
		}
	}

	/**
	 * Create constructor - will add the information as a new row in the data
	 * source as the object is constructed
	 * 
	 * @param memberName
	 *            the name of the new member
	 */
	public MemberRowDataGatewayMock(String memberName)
	{
		if (memberInfo == null)
		{
			resetData();
		}
		memberID = nextKey;
		nextKey++;

		memberInfo.put(memberID, new MemberInfo(memberName));
	}

	/**
	 * Just used by tests to reset static information
	 */
	public MemberRowDataGatewayMock()
	{
	}

	/**
	 * @see datasource.MemberRowDataGateway#resetData()
	 */
	@Override
	public void resetData()
	{
		memberInfo = new HashMap<Integer, MemberInfo>();
		nextKey = 1;
		for (MembersForTest p : MembersForTest.values())
		{
			memberInfo.put(nextKey, new MemberInfo(p.getMemberName()));
			nextKey++;
		}
	}

	/**
	 * @see datasource.MemberRowDataGateway#getMemberID()
	 */
	@Override
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * @see datasource.MemberRowDataGateway#persist()
	 */
	@Override
	public void persist()
	{
		memberInfo.put(memberID, info);
	}

	/**
	 * @see datasource.MemberRowDataGateway#getMemberName()
	 */
	@Override
	public String getMemberName()
	{
		return info.memberName;
	}

	@Override
	public String addMemberName() {
		// TODO Auto-generated method stub
		return null;
	}

}
