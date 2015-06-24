package datasource;

import datasource.DatabaseException;

/**
 * 
 * @author Merlin
 *
 */
public interface MemberRowDataGateway
{

	/**
	 * @return this member's member id
	 * @throws DatabaseException 
	 */
	int getMemberID() throws DatabaseException;

	/**
	 * @return the member's name
	 * @throws DatabaseException 
	 */
	String getMemberName() throws DatabaseException;

	/**
	 * @return the member's name
	 */
	String addMemberName();

	/**
	 * For testing purposes
	 */
	public void resetData();

	/**
	 * Store this information into the data source
	 * 
	 * @throws DatabaseException
	 *             if we can't persist the data to the data source
	 */
	void persist() throws DatabaseException;

	public void deleteMember();
}
