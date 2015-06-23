package model;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.DatabaseException;
import datasource.MembersForTest;

/**
 * @author em1419
 *
 */
public class CommandFindMemberTest
{

	/**
	 * @throws DatabaseException
	 */
	@Test
	public void test() throws DatabaseException
	{
		// create a member using MembersForTest
		Member m = new Member(MembersForTest.ANDY.getMemberID());
		MemberList ml = new MemberList();
		ml.addMember(m.getMemberName());
		
		CommandFindMember command = new CommandFindMember();
		String memberName = command.getMember(m.getMemberID());
		
		assertEquals(m.getMemberName(), memberName);
	}

}
