package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import datasource.BooksForTest;
import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * Tests that we can retrieve and persist all aspects of a member
 * 
 * @author Merlin
 *
 */
public class MemberDataMapperTest
{

	/**
	 * @throws DatabaseException
	 *             shouldn't
	 * 
	 */
	@Test
	public void test() throws DatabaseException
	{
		MemberDataMapper mapper = new MemberDataMapper(
				MembersForTest.MERLIN.getMemberID());
		assertEquals(MembersForTest.MERLIN.getMemberName(),
				mapper.getMemberName());
		assertEquals(MembersForTest.MERLIN.getMemberID(), mapper.getMemberID());
		ArrayList<String> books = mapper.getISBNs();
		assertEquals(2, books.size());
	}

	/**
	 * Make sure we can build a person who owns no books
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void testNoBooks() throws DatabaseException
	{
		MemberDataMapper mapper = new MemberDataMapper(
				MembersForTest.JOSH.getMemberID());

		assertEquals(MembersForTest.JOSH.getMemberName(),
				mapper.getMemberName());
		assertEquals(MembersForTest.JOSH.getMemberID(), mapper.getMemberID());
		ArrayList<String> books = mapper.getISBNs();
		assertEquals(0, books.size());
	}

	/**
	 * Make sure that we can add a book to a member and persist the result
	 * correctly
	 * 
	 * @throws DatabaseException
	 *             shouldn't
	 */
	@Test
	public void canAddBook() throws DatabaseException
	{
		MemberDataMapper mapper = new MemberDataMapper(
				MembersForTest.JOSH.getMemberID());
		assertEquals(0, mapper.getISBNs().size());
		mapper.addISBN(BooksForTest.FINDERS_KEEPERS.getISBN());
		mapper.persist();

		MemberDataMapper after = new MemberDataMapper(
				MembersForTest.JOSH.getMemberID());
		ArrayList<String> afterBooks = after.getISBNs();
		assertEquals(1, afterBooks.size());
		assertEquals(BooksForTest.FINDERS_KEEPERS.getISBN(), afterBooks.get(0));
	}

}
