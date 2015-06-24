package model;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.DatabaseException;

/**
 * @author Manal Ibrahim create Mock test Object 
 *
 */
public class MemberListTest{

	/**
	 * Testing adding member to MemberList
	 * @throws DatabaseException 
	 */
	@Test
	public void test() throws DatabaseException 
	{
		// creating the Mock Object
		MemberList mock = new MemberList();
		// Test Action
		int memberID = mock.addMember("Ali");
		assertEquals("Ali",mock.getMemberName(memberID));
	
		// release the mock Object
		//EasyMock.verify(mock);
	
	}
}
