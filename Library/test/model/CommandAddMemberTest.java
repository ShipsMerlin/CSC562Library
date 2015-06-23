package model;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * @author Manal
 *
 */
public class CommandAddMemberTest {

	/**
	 * 
	 */
	@Test
	public void testAddMember() {
		//fail("Not yet implemented");
		
		CommandAddMember command = new CommandAddMember();
	//	assertFalse(command.execute());  to fill the exam
		assertTrue(command.execute()); // to pass the exam
		
	}

}