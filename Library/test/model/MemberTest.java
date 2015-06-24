package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import datasource.BooksForTest;
import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * Tests the member class
 * 
 * @author Merlin
 *
 */
public class MemberTest
{

	/**
	 * Make sure we can find existing members
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void findConstructor() throws DatabaseException
	{

		ArrayList<String> expectedISBNs = new ArrayList<String>();
		for (BooksForTest b : BooksForTest.values())
		{
			if (b.getMemberID() == 2)
			{
				expectedISBNs.add(b.getISBN());
			}
		}

		Member m = new Member(MembersForTest.MERLIN.getMemberID());
		assertEquals(MembersForTest.MERLIN.getMemberID(), m.getMemberID());
		assertEquals(MembersForTest.MERLIN.getMemberName(), m.getMemberName());
		assertEquals(expectedISBNs, m.getBooksCheckedOut());
	}

}