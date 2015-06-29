package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datasource.DatabaseException;
import model.BookResponseReport;
import model.CommandAddBook;
import model.CommandDeleteBook;
import model.CommandFindBook;
import model.ModelFacade;
import model.QualifiedObservableConnector;
import model.QualifiedObservableReport;
import model.QualifiedObserver;

/**
 * @author em1419
 *
 */
public class BookGUI implements QualifiedObserver
{
	/**
	 * 
	 */
	JPanel contentPane;
	/**
	 * 
	 */
	JPanel bookCard;
	
	/**
	 * 
	 */
	JTextField BookISBNBox;
	/**
	 * 
	 */
	JTextField titleBox;
	
	/**
	 * 
	 */
	JTextField BookQuantityBox;
	/**
	 * 
	 */
	JTextField bottomAuthorTextField;
	/**
	 * 
	 */
	JButton buttonAddBook;
	/**
	 * 
	 */
	JTextField authorBox;
	/**
	 * 
	 */
	JTextField isbnBox;
	/**
	 * 
	 */
	JTextField bottomTitleTextField;

	/**
	 * Constructor 
	 * @param panel - the main panel of the application
	 */
	BookGUI(JPanel panel)
	{
		contentPane = panel;
		bookCard = createAndShowGUI();
		QualifiedObservableConnector.getSingleton().registerObserver(this, BookResponseReport.class);
	}

	/**
	 * @return - return the book panel
	 */
	JPanel createAndShowGUI()
	{
		/**
		 * JPanel card = new JPanel(); card.setLayout(new FlowLayout());
		 * card.setName(BOOK_CARD); card.add(new JLabel("BOOKS!!!")); return
		 * card; }
		 */
		JPanel bookCard = new JPanel();
		bookCard.setLayout(new GridLayout(3,1));
		bookCard.setName("bookPanel");
		JPanel topPanel = new JPanel(new GridLayout(1,2));
		JPanel AddFieldPanel = new JPanel(new GridLayout(4,2));
		JLabel addBookLabel = new JLabel("Add Books");
		addBookLabel.setName("AddBookLabel");
		JLabel spaceLabel = new JLabel("");
		
		JLabel title = new JLabel("Title");
		title.setName("titelField");
		titleBox =new JTextField(20);
	    titleBox.setName("TitleBox");
	    
		JLabel authorlabel = new JLabel("Author");
		authorlabel.setName("Author");
		authorBox =new JTextField(20);
		 authorBox.setName("authorBox");
		  
		JLabel isbn = new JLabel("ISBN");
		isbn.setName("isbnField");
		isbnBox =new JTextField(20);
		isbnBox.setName("isbnBox");
		
		AddFieldPanel.add(addBookLabel);
		AddFieldPanel.add(spaceLabel);
		AddFieldPanel.add(title);
		AddFieldPanel.add(titleBox);
		AddFieldPanel.add(authorlabel);
		AddFieldPanel.add(authorBox);
		AddFieldPanel.add(isbn);
		AddFieldPanel.add(isbnBox);
		topPanel.add(AddFieldPanel);
		JPanel AddButtonPanel = new JPanel(new GridLayout(1,1));
		buttonAddBook = new JButton("Add");
		buttonAddBook.setName("AddBookButton");
		
		buttonAddBook.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandAddBook command = new CommandAddBook(isbnBox.getText(), titleBox.getText(), authorBox.getText(), 0, 0);
				ModelFacade.getSingleton().queueCommand(command);
			}
		});

		
		AddButtonPanel.add(buttonAddBook);
		topPanel.add(AddButtonPanel);
		bookCard.add(topPanel);
		
		//--------------------------------- End First part of the Book Card Adding Info -----------------
		
		JPanel searchFieldPanel = new JPanel(new GridLayout(1,3));
		JLabel BookISBNLabel = new JLabel("Book ISBN:");
		BookISBNLabel .setName("BookISBN");
		BookISBNBox = new JTextField();
		BookISBNBox.setName("BookISBNTextFieldBox");
		JButton buttonSearchBooks = new JButton("Search");
		buttonSearchBooks.setName("SearchBookButton");
		buttonSearchBooks.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandFindBook command = new CommandFindBook(BookISBNBox.getText());
				ModelFacade.getSingleton().queueCommand(command);
			}
		});
		
		JLabel bookQuantity = new JLabel("Book Quantity:");
		bookQuantity .setName("BookQuantity");
		BookQuantityBox = new JTextField();
		BookQuantityBox.setName("BookQuantityTextFieldBox");
		
		searchFieldPanel.add(bookQuantity);
		searchFieldPanel.add(BookQuantityBox);	
		searchFieldPanel.add(BookISBNLabel);
		searchFieldPanel.add(BookISBNBox);
		searchFieldPanel.add(buttonSearchBooks);
		bookCard.add(searchFieldPanel);
		
	//--------------------------------- End First part of the Book Card Adding Info -----------------
		JPanel bottomPanel = new JPanel(new GridLayout(1,2));
		JPanel bottomInnerPanel = new JPanel(new GridLayout(2,2));
		
		JLabel bottomTitleLabel= new JLabel("Title:");
		bottomTitleLabel.setName("TitleName");
		bottomTitleTextField = new JTextField(20);
		JLabel bottomAuthorLabel = new JLabel("Author:");
		bottomAuthorLabel.setName("AuthorLabel");
		bottomAuthorTextField = new JTextField(20);
		bottomAuthorTextField.setName("bookNameofDeletefield");
		bottomInnerPanel.add(bottomTitleLabel);
		bottomInnerPanel.add(bottomTitleTextField);
		bottomInnerPanel.add(bottomAuthorLabel);
		bottomInnerPanel.add(bottomAuthorTextField);
		bottomPanel.add(bottomInnerPanel);
		
		JPanel bottomRightPanel = new JPanel(new GridLayout(1,1));
		JButton deleteButton = new JButton("Delete");
		deleteButton.setName("DeleteBookButton");
		
		deleteButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandDeleteBook command = new CommandDeleteBook(BookISBNBox.getText());
				ModelFacade.getSingleton().queueCommand(command);
			}
		});
		bottomRightPanel.add(deleteButton);
		bottomPanel.add(bottomRightPanel);
		bookCard.add(bottomPanel);
		
		/** Do we need an ActionListener here?
		buttonAddMember.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			CardLayout cl = (CardLayout) (contentPane.getLayout());
			cl.show(contentPane, "bookPanel");
    	}

		});
		AddFieldPanel.add(buttonAddMember);
		topPanel.add(AddButtonPanel);
		**/
		
		return bookCard;
	}

	@Override
	public void receiveReport(QualifiedObservableReport report) throws DatabaseException
	{
		// TODO Auto-generated method stub
		System.out.println("Received report");
		if (report.getClass().equals(BookResponseReport.class))
		{
			BookResponseReport mrr = (BookResponseReport)report;
			bottomTitleTextField.setText(mrr.getBookTitle());
			bottomAuthorTextField.setText(mrr.getBookAuthor());
			BookQuantityBox.setText(String.valueOf(mrr.getBookQuantity()));
			
			//System.out.println(fmrr.getMemberName());
		}
	}
}
