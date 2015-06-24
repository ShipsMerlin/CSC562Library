package model;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

import view.CheckoutBookGUI;
import view.ComponentMap;
import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * @author em1419
 *
 */
public class CommandFindMemberTest
{

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException
	{	
		QualifiedObserver mockedObserver = EasyMock.createMock(QualifiedObserver.class);
		QualifiedObservableConnector connector = QualifiedObservableConnector.getSingleton();
		
		connector.registerObserver(mockedObserver, FindMemberResponseReport.class);
		
		FindMemberResponseReport mockReport = new FindMemberResponseReport(MembersForTest.MERLIN.getMemberID(), MembersForTest.MERLIN.getMemberName());
		
		mockedObserver.receiveReport(mockReport);
		EasyMock.replay(mockedObserver);
		
//		connector.sendReport(new FindMemberResponseReport(2, "Merlin"));

		CommandFindMember cmd = new CommandFindMember(MembersForTest.MERLIN.getMemberID());
		cmd.execute();
//		
//		try {
//			Thread.sleep(250);
//		} catch (InterruptedException e){
//			System.out.println(e.getStackTrace());
//		}
		
		EasyMock.verify(mockedObserver);
	}

}
