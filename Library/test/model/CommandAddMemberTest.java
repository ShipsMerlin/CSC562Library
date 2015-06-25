package model;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * @author Manal, Evania
 *
 */
public class CommandAddMemberTest
{
	/**
	 * Resets the singleton
	 */
	@Before
	public void reset() {
		QualifiedObservableConnector.resetSingleton();
	}
	/**
	 * Tests the command for adding a new member
	 * 
	 * @throws DatabaseException
	 */
	@Test
	public void testAddMember() throws DatabaseException
	{
		String newMemberName = "NewMember";

		QualifiedObserver mockedObserver = EasyMock
				.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();

		connector.registerObserver(mockedObserver, MemberResponseReport.class);

		MemberResponseReport mockReport = new MemberResponseReport(
				MembersForTest.values().length + 1, newMemberName);

		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);

		CommandAddMember cmd = new CommandAddMember(newMemberName);
		cmd.execute();

		EasyMock.verify(mockedObserver);

	}

}