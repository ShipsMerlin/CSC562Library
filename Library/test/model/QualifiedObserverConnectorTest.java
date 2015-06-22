package model;

import static org.junit.Assert.*;

import java.util.Observable;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Merlin
 * 
 */
public class QualifiedObserverConnectorTest
{

	/**
	 * reset the singleton before each test
	 */
	@Before
	public void setUp()
	{
		QualifiedObservableConnector.resetSingleton();
	}

	/**
	 * Test the singleton functionality. First, make sure you get the same
	 * object and then reset the singleton and make sure you get a different one
	 */
	@Test
	public void isSingleton()
	{
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();
		assertNotNull(connector);
		QualifiedObservableConnector connector2 = QualifiedObservableConnector
				.getSingleton();
		assertNotNull(connector2);
		assertSame(connector, connector2);
		QualifiedObservableConnector.resetSingleton();
		connector2 = QualifiedObservableConnector.getSingleton();
		assertNotSame(connector, connector2);
	}

	/**
	 * If we register the same observer for the same report type, we should
	 * ignore it
	 */
	@Test
	public void addingSameObserverTwiceIgnoresSecondCall()
	{
		// set up the connection
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();
		QualifiedObserver mockObserver = EasyMock
				.createMock(QualifiedObserver.class);
		connector.registerObserver(mockObserver, TestReport.class);
		connector.registerObserver(mockObserver, TestReport.class);

		// we should expect an single update on notification
		mockObserver.receiveReport(EasyMock.anyObject(TestReport.class));
		EasyMock.replay(mockObserver);

		// now cause the notification
		connector.sendReport(new TestReport());
		EasyMock.verify(mockObserver);
	}

	/**
	 * Make sure that if we unregister an observer, it no longer gets updated on
	 * notification
	 */
	@Test
	public void canUnRegisterAnObserver()
	{
		// set up the connection
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();
		Observable mockObservable = new Observable();
		QualifiedObserver mockObserver = EasyMock
				.createMock(QualifiedObserver.class);
		connector.registerObserver(mockObserver, TestReport.class);

		// no notification should be expected
		EasyMock.replay(mockObserver);

		connector.unregisterObserver(mockObserver, TestReport.class);
		mockObservable.notifyObservers(new TestReport());
		EasyMock.verify(mockObserver);
	}

	/**
	 * If we unregister an observer, adding subsequent observables for that
	 * report type should NOT connect them
	 */
	@Test
	public void unregistrationForgetsObserver()
	{
		// set up the connection
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();
		Observable mockObservable = new Observable();
		QualifiedObserver mockObserver = EasyMock
				.createMock(QualifiedObserver.class);
		connector.registerObserver(mockObserver, TestReport.class);
		connector.unregisterObserver(mockObserver, TestReport.class);

		// no notification should be expected
		EasyMock.replay(mockObserver);

		mockObservable.notifyObservers(new TestReport());
		EasyMock.verify(mockObserver);
	}

	/**
	 * We just want to be sure that, if you ask to unregister for something you
	 * aren't connected to, we just ignore you.
	 */
	@Test
	public void observerUnregistrationWhenNotRegistered()
	{
		QualifiedObservableConnector connector = QualifiedObservableConnector
				.getSingleton();
		QualifiedObserver mockObserver = EasyMock
				.createMock(QualifiedObserver.class);
		connector.unregisterObserver(mockObserver, TestReport.class);
	}

	private class TestReport implements QualifiedObservableReport
	{

	}
}
