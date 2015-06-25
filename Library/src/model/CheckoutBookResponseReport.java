package model;

import datasource.DatabaseException;

/**
 * @author ma7488
 *
 */
public class CheckoutBookResponseReport implements QualifiedObservableReport

{
	/**
	 * 
	 */
	Book book;
	/**
	 * 
	 */
	String memberName;
	
	/**
	 * @param b 
	 * @param name 
	 */
	public CheckoutBookResponseReport(Book b, String name)
	{
		book = b;
		memberName = name;
	
	}
	
	/**
	 * @return
	 * @throws DatabaseException 
	 */
	public String getBookName() throws DatabaseException 
	{
		return book.getTitle();
	}
	
	/**
	 * @return MemberName
	 */
	public String getMemberName() 
	{
		return memberName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
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
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		return true;
	}
	

	
	
		
	
	

}
