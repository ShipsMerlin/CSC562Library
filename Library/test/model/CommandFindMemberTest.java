package model;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * @author Evania Mans
 *
 */
public class CommandFindMemberTest
{
	
	/**
	 * Reset the necessary singletons
	 */
	@Before
	public void setup()
	{
		QualifiedObservableConnector.resetSingleton();
	}

	/**
	 * Tests to make sure that when the Command is executed, a FindMemberResponseReport is generated and sent to any
	 * observers that are registered to receive that type of report are notified of changes. 
	 * 
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException
	{	
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, MemberResponseReport.class);
		
		MemberResponseReport mockReport = new MemberResponseReport(MembersForTest.MERLIN.getMemberID(), MembersForTest.MERLIN.getMemberName());
		
		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);

		CommandFindMember cmd = new CommandFindMember(MembersForTest.MERLIN.getMemberID());
		cmd.execute();
		
		EasyMock.verify(mockedObserver);
	}

}
