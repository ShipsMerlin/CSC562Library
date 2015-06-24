package model;

import datasource.DatabaseException;
import model.InfoPacket;

/**
 * @author merlin
 * 
 */
public abstract class Command implements InfoPacket
{

	/**
	 * perform the action associated with this command
	 * 
	 * @return true of the operation was successful
	 * @throws DatabaseException 
	 */
	protected abstract boolean execute() throws DatabaseException;

	/**
	 * 
	 * @return true if the command should dump the queue of other commands after
	 *         it executes
	 */
	protected boolean doDump()
	{
		return false;
	}

}
