package datasource;

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

}
