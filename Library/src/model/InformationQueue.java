package model;

import java.util.Vector;

/**
 * A queue to pass information between two threads
 * 
 * @author Merlin
 * 
 */
public class InformationQueue
{

	private Vector<InfoPacket> infoPackets = new Vector<InfoPacket>();

	/**
	 * Put a message in the queue to the view.
	 * 
	 * @param infoPacket
	 *            the view command to be added to the buffer
	 */
	public synchronized void queueInfoPacket(InfoPacket infoPacket)
	{
		infoPackets.addElement(infoPacket);
		notify();
	}

	/**
	 * @return the next message that should be processed by the GUI
	 * @throws InterruptedException
	 *             if this synchronized section is interrupted
	 */
	public synchronized InfoPacket getInfoPacket() throws InterruptedException
	{
		notify();
		while (infoPackets.size() == 0)
			wait();
		InfoPacket infoPacket = infoPackets.firstElement();
		infoPackets.removeElement(infoPacket);
		return infoPacket;
	}

	/**
	 * @return the number of commands that are waiting to be processed by the
	 *         view
	 */
	public int getQueueSize()
	{
		return infoPackets.size();
	}

}
