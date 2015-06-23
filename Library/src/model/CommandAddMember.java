package model;

/**
 * @author Manal Ibrahim
 *
 */
public class CommandAddMember extends Command
{
	/**
	 * ML is member List gonne and new Member name
	 */

	@Override
	protected boolean execute()
	{
		// TODO Auto-generated method stub
		MemberList ML = new MemberList();
		String memberName = "Manal";
		ML.addMember(memberName);
		return true;
	}

}
