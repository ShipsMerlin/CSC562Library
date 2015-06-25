package model;

import datasource.DatabaseException;

/**
 * Required of everyone who is interested in receiving reports from the model
 * 
 * @author Merlin
 *
 */
public interface QualifiedObserver
{

	/**
	 * Receive a report from the model
	 * 
	 * @param report
	 *            the report
	 * @throws DatabaseException 
	 */
	public void receiveReport(QualifiedObservableReport report) throws DatabaseException;
}
