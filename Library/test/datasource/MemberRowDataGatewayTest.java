package datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.DatabaseTest;
import datasource.MembersForTest;

/**
 * Tests required of all member gateways
 * 
 * @author Merlin
 *
 */
public abstract class MemberRowDataGatewayTest extends DatabaseTest
{

	private MemberRowDataGateway gateway;

	/**
	 * Find the gateway for a given member
	 * 
	 * @param memberID
	 *            the ID of the member we are testing
	 * @return the gateway
	 * @throws DatabaseException
	 *             if the memberID can't be found in the data source
	 */
	abstract MemberRowDataGateway findGateway(int memberID)
			throws DatabaseException;

	/**
	 * Make sure any static information is cleaned up between tests
	 * 
	 * @throws SQLException
	 *             shouldn't
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@After
	public void cleanup() throws DatabaseException, SQLException
	{
		super.tearDown();
		if (gateway != null)
		{
			gateway.resetData();
		}
	}

	/**
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void finder() throws DatabaseException
	{
		MembersForTest john = MembersForTest.JOHN;
		gateway = findGateway(john.getMemberID());
		assertEquals(john.getMemberID(), gateway.getMemberID());
	}

	/**
	 * Make sure we can add a new user to the system
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void creation() throws DatabaseException
	{
		gateway = createGateway("Methusulah");

		MemberRowDataGateway after = findGateway(gateway.getMemberID());

		assertEquals("Methusulah", after.getMemberName());
	}

	/**
	 * Put a new entry into the gateway
	 * 
	 * @param name
	 *            the new member's name
	 * @return a gateway for the new row
	 */
	abstract MemberRowDataGateway createGateway(String name);

	/**
	 * make sure we get the right exception if we try to find someone who
	 * doesn't exist
	 * 
	 * @throws DatabaseException
	 *             should
	 */
	@Test(expected = DatabaseException.class)
	public void findNotExisting() throws DatabaseException
	{
		gateway = findGateway(11111);
	}

}
