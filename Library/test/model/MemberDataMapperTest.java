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
		Member m = mapper.getMember();
		assertEquals(MembersForTest.MERLIN.getMemberName(), m.getMemberName());
		assertEquals(MembersForTest.MERLIN.getMemberID(), m.getMemberID());
		ArrayList<Book> books = m.getBooksCheckedOut(); 
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
		Member m = mapper.getMember();
		assertEquals(MembersForTest.JOSH.getMemberName(), m.getMemberName());
		assertEquals(MembersForTest.JOSH.getMemberID(), m.getMemberID());
		ArrayList<Book> books = m.getBooksCheckedOut(); 
		assertEquals(0, books.size());
	}

}
