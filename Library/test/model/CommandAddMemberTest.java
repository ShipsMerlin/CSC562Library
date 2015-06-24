package model;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

import datasource.MembersForTest;



/**
 * @author Manal
 *
 */
public class CommandAddMemberTest {

	/**
	 * Tests the command for adding a new member
	 */
	@Test
	public void testAddMember() {
		String newMemberName = "NewMember";
		
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, MemberResponseReport.class);
		
		MemberResponseReport mockReport = new MemberResponseReport(MembersForTest.values().length+1, newMemberName);
		
		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);
		
		CommandAddMember cmd = new CommandAddMember(newMemberName);
		cmd.execute();
		
		EasyMock.verify(mockedObserver);
		
	}

}