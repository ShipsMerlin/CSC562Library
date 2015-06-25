import model.CommandAddBookTest;
import model.CommandAddMemberTest;
import model.CommandDeleteBookTest;
import model.CommandDeleteMemberTest;
import model.CommandFindBookTest;
import model.CommandFindMemberTest;
import model.MemberDataMapperTest;
import model.MemberListTest;
import model.MemberTest;
import model.QualifiedObserverConnectorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import view.BookGUITest;
import view.MemberGUITest;
import view.RunnerTestMocked;
import view.CheckoutBookGUITest;
import datasource.BookRowDataGatewayMockTest;
import datasource.BookTableDataGatewayMockTest;
import datasource.MemberRowDataGatewayMockTest;

/**
 * All of the tests for the Library code. Notice that the packages, and classes
 * within them, are in order by the way they show in the package explorer. This
 * is to make it easy to see if a class is missing from this list. Helper
 * classes that do not contain tests are included in the list, but commented out
 * 
 * @author Merlin
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{

		// datasource
		BookRowDataGatewayMockTest.class,
		// BookRowDataGatewayTest.class,
		// BooksForTest.class,
		BookTableDataGatewayMockTest.class,
		// BookTableDataGatewayTest.class,
		// DatabaseTest.class
		MemberRowDataGatewayMockTest.class,
		// MemberRowDataGatewayTest.class,
		// MembersForTest.class,

		// model
		CommandAddBookTest.class,
		CommandAddMemberTest.class,
		CommandDeleteMemberTest.class,
		CommandDeleteBookTest.class,
		CommandFindBookTest.class,
		CommandFindMemberTest.class,
		MemberDataMapperTest.class, 
		MemberListTest.class,
		MemberTest.class,
		QualifiedObserverConnectorTest.class,

		// View
		BookGUITest.class,
		CheckoutBookGUITest.class,
		// ComponentMap.class
		MemberGUITest.class,
		RunnerTestMocked.class, 
		 })
public class AllLibraryTests
{
}
