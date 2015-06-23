package model;

/**
 * Report that provides the member ID and name when searching for a member.
 * @author em1419
 *
 */
public class FindMemberResponseReport implements QualifiedObservableReport
{
	/**
	 * Member ID
	 */
	int memberId;
	/**
	 * Member Name
	 */
	String memberName;
	
	/**
	 * @param id - the member's ID
	 * @param name - the member's name
	 */
	public FindMemberResponseReport(int id, String name) {
		memberId = id;
		memberName = name;
	}
	
	/**
	 * @return - ID associated with the member
	 */
	public int getMemberId() {
		return memberId;
	}
	
	/**
	 * @return - member's Name
	 */
	public String getMemberName() {
		return memberName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + memberId;
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FindMemberResponseReport other = (FindMemberResponseReport) obj;
		if (memberId != other.memberId)
			return false;
		if (memberName == null)
		{
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		return true;
	}

}
