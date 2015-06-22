package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Portions of the system that are outside of the model need to be notified when
 * the game state changes. In other words, they need to be observers of a
 * variety of places within the Model. However, we don't want things that are
 * outside of the model to have knowledge of where in the model those place are.
 * Therefore, we have created the QualifiedObservableConnector (which is a
 * singleton) on the edge of the Model. Entities outside of (or inside) the
 * model can use this to become an observer of all of the places within the
 * model that report messages of a given type on state change.
 * <p>
 * Changes it game state are called game state reports and we want to make sure
 * that each observer only gets the reports in which it is interested.
 * Therefore, QualifiedObservableConnector allows the observer to specify
 * exactly which type of report they want to receive. For example, registering
 * to receive a report that the current player moved is done like this:
 * 
 * <p>
 * 
 * <pre>
 * QualifiedObservableConnector.getSingleton().registerObserver(this,
 * 		ThisPlayerMovedReport.class);
 * </pre>
 * 
 * @author Merlin
 * 
 */
public class QualifiedObservableConnector
{

	private static QualifiedObservableConnector singleton;

	private HashMap<Class<? extends QualifiedObservableReport>, ArrayList<QualifiedObserver>> observers;

	private QualifiedObservableConnector()
	{
		observers = new HashMap<Class<? extends QualifiedObservableReport>, ArrayList<QualifiedObserver>>();
	}

	/**
	 * @return the only one of these in the system
	 */
	public synchronized static QualifiedObservableConnector getSingleton()
	{
		if (singleton == null)
		{
			singleton = new QualifiedObservableConnector();
		}
		return singleton;
	}

	/**
	 * 
	 */
	public static void resetSingleton()
	{
		singleton = null;
	}

	/**
	 * Distributes a given report to everyone who is interested in reports of
	 * that type
	 * 
	 * @param report
	 *            the report
	 */
	public void sendReport(QualifiedObservableReport report)
	{
		ArrayList<QualifiedObserver> relevantObservers = observers.get(report
				.getClass());
		if (relevantObservers != null)
		{
			for (QualifiedObserver a : relevantObservers)
			{
				a.receiveReport(report);
			}
		}
	}

	/**
	 * Used when an observer wants to receive reports of a given type
	 * 
	 * @param observer
	 *            the observer who is interested
	 * @param reportType
	 *            the report type the observer wants to receive
	 */
	public void registerObserver(QualifiedObserver observer,
			Class<? extends QualifiedObservableReport> reportType)
	{
		rememberObserver(observer, reportType);
	}

	/**
	 * @param observer
	 *            the observer we should remember
	 * @param reportType
	 *            the report type this observer is interested in
	 * @return true if this is a new observer for this report type and false if
	 *         it was a duplicate request
	 */
	private boolean rememberObserver(QualifiedObserver observer,
			Class<? extends QualifiedObservableReport> reportType)
	{
		ArrayList<QualifiedObserver> relevantObservers = observers
				.get(reportType);
		if (relevantObservers == null)
		{
			relevantObservers = new ArrayList<QualifiedObserver>();
			observers.put(reportType, relevantObservers);
		}
		if (!relevantObservers.contains(observer))
		{
			relevantObservers.add(observer);
			return true;
		}
		return false;
	}

	/**
	 * This is called when an observer no longer wants to receive reports of a
	 * given type
	 * 
	 * @param observer
	 *            the observer who is no longer interested
	 * @param reportType
	 *            the report types they no longer want to receive
	 */
	public void unregisterObserver(QualifiedObserver observer,
			Class<? extends QualifiedObservableReport> reportType)
	{

		ArrayList<QualifiedObserver> observerList = observers.get(reportType);
		if (observerList != null)
		{
			observerList.remove(observer);
		}
	}

	/**
	 * Allows an observer to see if it is currently listening to a given report
	 * type
	 * 
	 * @param obs
	 *            the observer
	 * @param reportType
	 *            the report type
	 * @return true if the observer is hooked up for that report type
	 */
	public boolean doIObserve(QualifiedObserver obs,
			Class<? extends QualifiedObservableReport> reportType)
	{

		ArrayList<QualifiedObserver> relavantObservers = observers
				.get(reportType);
		if (relavantObservers == null)
		{
			return false;
		}
		return relavantObservers.contains(obs);
	}
}
