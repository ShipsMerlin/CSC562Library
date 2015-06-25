package model;

/**
 * @author ma7488
 *
 */
public class CheckoutBookResponseReport implements QualifiedObservableReport

{
	/**
	 * 
	 */
	String bookName;
	/**
	 * 
	 */
	String MemberName;
	
	/**
	 * @param bName
	 * @param MName
	 */
	public CheckoutBookResponseReport(String bName, String MName)
	{
		bookName = bName;
		MemberName = MName;
	
	}
	
	/**
	 * @return
	 */
	public String getBookName() 
	{
		return bookName;
	}
	
	/**
	 * @return MemberName
	 */
	public String getMemberName() 
	{
		return MemberName;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((MemberName == null) ? 0 : MemberName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckoutBookResponseReport other = (CheckoutBookResponseReport) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (MemberName == null) {
			if (other.MemberName != null)
				return false;
		} else if (!MemberName.equals(other.MemberName))
			return false;

		return true;
	}
	
		
	
	

}
