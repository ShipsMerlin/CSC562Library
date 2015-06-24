package datasource;

import org.junit.Test;

import datasource.DatabaseException;

/**
 * Tests for the mock version of the gateway
 * 
 * @author Merlin
 *
 */
public class MemberRowDataGatewayMockTest extends MemberRowDataGatewayTest
{

	/**
	 * @see datasource.MemberRowDataGatewayTest#findGateway(int)
	 */
	@Override
	MemberRowDataGateway findGateway(int memberID) throws DatabaseException
	{
		return new MemberRowDataGatewayMock(memberID);
	}

	/**
	 * @see datasource.MemberRowDataGatewayTest#createGateway(java.lang.String)
	 */
	@Override
	MemberRowDataGateway createGateway(String memberName)
	{
		return new MemberRowDataGatewayMock(memberName);
	}
	
	/**
	 * @throws DatabaseException
	 */
	@Test(expected=DatabaseException.class)
	public void deleteMember() throws DatabaseException {
		MemberRowDataGatewayMock mock = new MemberRowDataGatewayMock(MembersForTest.ANDY.getMemberID());
		mock.deleteMember();
		mock.getMemberID();		// should throw exception because the member no longer exists
		mock.getMemberName();
	}
	
	/**
	 * @throws DatabaseException
	 */
	@Test(expected=DatabaseException.class)
	public void getMemberID() throws DatabaseException {
		MemberRowDataGatewayMock mock = new MemberRowDataGatewayMock();
		mock.getMemberID();
	}
	
	/**
	 * @throws DatabaseException
	 */
	@Test(expected=DatabaseException.class)
	public void getMemberName() throws DatabaseException {
		MemberRowDataGatewayMock mock = new MemberRowDataGatewayMock();
		mock.getMemberName();
	}

}
