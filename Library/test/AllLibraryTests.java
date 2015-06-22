import model.QualifiedObserverConnectorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import view.RunnerTestMocked;
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
// DatabaseTest.class
		MemberRowDataGatewayMockTest.class,
		// MemberRowDataGatewayTest.class,
		// MembersForTest.class,

		// model
		QualifiedObserverConnectorTest.class,

		// View
		// ComponentMap.class
		RunnerTestMocked.class, })
public class AllLibraryTests
{
}
