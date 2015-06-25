package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BookResponseReport;
import model.CommandFindBook;
import model.CommandFindMember;
import model.MemberResponseReport;
import model.ModelFacade;
import model.QualifiedObservableConnector;
import model.QualifiedObservableReport;
import model.QualifiedObserver;

/**
 * @author em1419
 *
 */
public class CheckoutBookGUI extends JPanel implements QualifiedObserver
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFrame jFrame;
	/**
	 * 
	 */
	public JButton memberSearchButton;
	/**
	 * 
	 */
	public JTextField memberSearchTextField;
	/**
	 * 
	 */
	public JTextField memberSearchResult;
	/**
	 * 
	 */
	JTextField bookSearchResult;
	/**
	 * 
	 */
	JTextField bookSearchTextField;
	/**
	 * 
	 */
	public CheckoutBookGUI() {
		QualifiedObservableConnector.getSingleton().registerObserver(this, MemberResponseReport.class);
		QualifiedObservableConnector.getSingleton().registerObserver(this, BookResponseReport.class);
	}
	
	
	/**
	 * Creates the components for the Checkout Book GUI
	 * 
	 * @return - The newly created panel 
	 */
	public JPanel createAndShowGUI()
	{
		jFrame = new JFrame("CheckoutSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2, 1));
		content.setName("checkoutPanel");

		/**
		 * Adding all components for Member Search
		 */
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		JPanel memberSearchPanel = new JPanel();
		memberSearchPanel.setLayout(new GridLayout(2,3));
		JLabel memberLabel = new JLabel("Member");
		memberSearchTextField = new JTextField(5);
		memberSearchTextField.setName("txtMemberSearch");
		memberSearchButton = new JButton("Search");
		memberSearchButton.setName("btnSearchMember");
		memberSearchButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandFindMember command = new CommandFindMember(Integer.parseInt(memberSearchTextField.getText()));
				ModelFacade.getSingleton().queueCommand(command);
			}
		});
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setName("resultMember");
		memberSearchResult = new JTextField(5);
		memberSearchResult.setName("memberSearchResult");
		JLabel label3 = new JLabel("");
		label3.setName("Spacer");
		memberSearchPanel.add(memberLabel);
		memberSearchPanel.add(memberSearchTextField);
		memberSearchPanel.add(memberSearchButton);
		memberSearchPanel.add(resultLabel );
		memberSearchPanel.add(memberSearchResult);
		memberSearchPanel.add(label3);
		topPanel.add(memberSearchPanel);
		content.add(topPanel);
////////////////////////////////////////////////////////////////////////////////
		

		JPanel bookSearchPanel = new JPanel();
		bookSearchPanel.setLayout(new GridLayout(2,3));
		JLabel bookLabel = new JLabel("Book");
		bookSearchTextField = new JTextField(5);
		bookSearchTextField.setName("txtBookSearch");
		JButton bookSearchButton = new JButton("Search");
		bookSearchButton.setName("btnSearchBook");
		bookSearchButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				CommandFindBook command = new CommandFindBook(bookSearchTextField.getText());
				ModelFacade.getSingleton().queueCommand(command);
				// TODO Auto-generated method stub
			}
				
		});
		
		JLabel bookresultLabel = new JLabel("Result");
		bookresultLabel.setName("resultBook");
		bookSearchResult = new JTextField(5);
		bookSearchResult.setName("bookSearchResult");
		JLabel label4 = new JLabel("");
		label3.setName("Spacer");
		
		bookSearchPanel.add(bookLabel);
		bookSearchPanel.add(bookSearchTextField);
		bookSearchPanel.add(bookSearchButton);
		bookSearchPanel.add(bookresultLabel );
		bookSearchPanel.add(bookSearchResult);
		bookSearchPanel.add(label4);
		topPanel.add(bookSearchPanel);
		content.add(topPanel);
		/**
		 * Adding all components for Book Search
		 */
	
		/**
		 * Adding Checkout Button
		 */
		JButton checkoutbutton = new JButton("Checkout");
		checkoutbutton.setName("btnCheckout");
		checkoutbutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub

			}

		});

		content.add(checkoutbutton);

		jFrame.getContentPane().add(content);
		jFrame.pack();
		jFrame.setVisible(true);

		return content;
	}

	/**
	 * @return - returns the JFrame object
	 */
	public static Container getContainer()
	{
		// TODO Auto-generated method stub
		return jFrame;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				CheckoutBookGUI gui = new CheckoutBookGUI();
				gui.createAndShowGUI();
			}
		});
	}

	@Override
	public void receiveReport(QualifiedObservableReport report)
	{
		System.out.println("Received report");
		if (report.getClass().equals(MemberResponseReport.class))
		{
			MemberResponseReport fmrr = (MemberResponseReport)report;
			memberSearchResult.setText(fmrr.getMemberName());
			//System.out.println(fmrr.getMemberName());
		}
		else if (report.getClass().equals(BookResponseReport.class))
		{
			BookResponseReport fmrr = (BookResponseReport)report;
			bookSearchResult.setText(fmrr.getBookTitle());
			//System.out.println(fmrr.getMemberName());
		}
		
		
	}

}