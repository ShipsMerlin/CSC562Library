package datasource;

public class BookRowDataGatewaySQL implements BookRowDataGateway
{

	public BookRowDataGatewaySQL(String bookISBN)
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resetData()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void persist() throws DatabaseException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int getBookID() throws DatabaseException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTitle() throws DatabaseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getISBN() throws DatabaseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() throws DatabaseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemberID(int memberID)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int getMemberID()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBook()
	{
		// TODO Auto-generated method stub

	}

}
