package model;

import org.easymock.EasyMock;
import org.junit.Test;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * @author Evania Mans
 *
 */
public class CommandDeleteMemberTest
{

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void testDeleteMember() throws DatabaseException {		
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, MemberResponseReport.class);
		
		MemberResponseReport mockReport = new MemberResponseReport(MembersForTest.ANDY.getMemberID(), MembersForTest.ANDY.getMemberName());
		
		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);
		
		CommandDeleteMember cmd = new CommandDeleteMember(MembersForTest.ANDY.getMemberID());
		cmd.execute();
		
		EasyMock.verify(mockedObserver);
	}

}
