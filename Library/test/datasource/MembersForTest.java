package datasource;

/**
 * The members that are in the test database
 * 
 * @author Merlin
 * 
 */
public enum MembersForTest
{
	/**
	 * 
	 */
	JOHN(1, "John"),
	/**
	 * 
	 */
	MERLIN(2, "Merlin"),
	/**
	 * 
	 */
	NICK(3, "Nick"),
	/**
	 * 
	 */
	JOSH(4, "Josh"),
	/**
	 * 
	 */
	MATT(5, "Matt"),
	/**
	 * 
	 */
	STEVE(6, "Steve"),
	/**
	 * 
	 */
	FRANK(7, "Frank"),
	/**
	 * 
	 */
	GA(8, "Ga"),
	/**
	 * 
	 */
	ANDY(9, "Andy"),
	/**
	 * 
	 */
	DAVE(10, "Dave"),

	/**
	 * 
	 */
	LOSER(11, "Loser"),

	/**
	 * 
	 */
	MOCK_NPC(12, "NPC1"),

	/**
	 * 
	 */
	QUIZBOT(13, "QuizBot"),

	/**
	 * 
	 */
	MOCK_NPC3(14, "NPC3"),

	/**
	 * 
	 */
	RYAN(15, "Ryan");

	private int memberID;

	private String memberName;

	MembersForTest(int id, String memberName)
	{
		this.memberID = id;
		this.memberName = memberName;
	}

	/**
	 * Get the member's unique ID
	 * 
	 * @return the id
	 */
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * Get the member's unique name
	 * 
	 * @return the name
	 */
	public String getMemberName()
	{
		return memberName;
	}

}