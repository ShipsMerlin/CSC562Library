package datasource;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

import datasource.DatabaseException;

/**
 * Defines set up and tear down methods that set up the DB for testing and roll
 * back changes when the test is over
 * 
 * @author Merlin
 * 
 */
public abstract class DatabaseTest
{

	/**
	 * set up the database and other singletons for a test
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 * 
	 */
	@Before
	public void setUp() throws DatabaseException
	{
		// DatabaseManager.reset();
		// DatabaseManager.getSingleton().setTesting();
	}

	/**
	 * @throws DatabaseException
	 *             shouldn't
	 * @throws SQLException
	 *             shouldn't
	 * 
	 */
	@After
	public void tearDown() throws DatabaseException, SQLException
	{
		// DatabaseManager.getSingleton().rollBack();
	}
}
