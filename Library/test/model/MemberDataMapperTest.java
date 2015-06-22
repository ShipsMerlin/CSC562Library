package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import datasource.MembersForTest;

/**
 * Tests that we can retrieve and persist all aspects of a member
 * @author Merlin
 *
 */
public class MemberDataMapperTest
{

	/**
	 * 
	 */
	@Test
	public void test()
	{
		MemberDataMapper mapper = new MemberDataMapper(MembersForTest.MERLIN.getMemberID());
		Member m = mapper.getMember();
		assertEquals(MembersForTest.MERLIN.getMemberName(), m.getMemberName());
		ArrayList<Book> books = m.getBooksCheckedOut(); 
		assertEquals(2, books.size());
	}

}
