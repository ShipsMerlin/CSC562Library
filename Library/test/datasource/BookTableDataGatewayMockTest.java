package datasource;

/**
 * Tests the mock implementation
 * @author merlin
 *
 */
public class BookTableDataGatewayMockTest extends
		BookTableDataGatewayTest
{

	
	/**
	 * @see datasource.BookTableDataGatewayTest#getGateway()
	 */
	@Override
	public BookTableDataGateway getGateway()
	{
		return BookTableDataGatewayMock.getSingleton();
	}

	
}
