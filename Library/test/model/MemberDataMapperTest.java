package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * Tests that we can retrieve and persist all aspects of a member
 * @author Merlin
 *
 */
public class MemberDataMapperTest
{

	/**
	 * @throws DatabaseException shouldn't
	 * 
	 */
	@Test
	public void test() throws DatabaseException
	{
		MemberDataMapper mapper = new MemberDataMapper(MembersForTest.MERLIN.getMemberID());
		assertEquals(MembersForTest.MERLIN.getMemberName(), mapper.getMemberName());
		assertEquals(MembersForTest.MERLIN.getMemberID(), mapper.getMemberID());
		ArrayList<String> books = mapper.getISBNs();
		assertEquals(2, books.size());
	}
	
	/**
	 * Make sure we can build a person who owns no books
	 * @throws DatabaseException shouldn't
	 */
	@Test
	public void testNoBooks() throws DatabaseException
	{
		MemberDataMapper mapper = new MemberDataMapper(MembersForTest.JOSH.getMemberID());
		
		assertEquals(MembersForTest.JOSH.getMemberName(), mapper.getMemberName());
		assertEquals(MembersForTest.JOSH.getMemberID(), mapper.getMemberID());
		ArrayList<String> books = mapper.getISBNs(); 
		assertEquals(0, books.size());
	}

}
