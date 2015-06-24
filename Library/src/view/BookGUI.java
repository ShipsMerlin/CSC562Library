package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author em1419
 *
 */
public class BookGUI
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
	 * Constructor 
	 * @param panel - the main panel of the application
	 */
	BookGUI(JPanel panel)
	{
		contentPane = panel;
		bookCard = createAndShowGUI();
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
		JLabel addBookLabel = new JLabel("Add Book");
		addBookLabel.setName("addBookLabel");
		JLabel spaceLabel = new JLabel("");
		
		JLabel title = new JLabel("Title");
		title.setName("titelField");
		JTextField titleBox =new JTextField(20);
	    titleBox.setName("TitleBox");
	    
		JLabel author = new JLabel("Author");
		author.setName("authorField");
		JTextField authorBox =new JTextField(20);
		  authorBox.setName("authorBox");
		  
		JLabel isbn = new JLabel("ISBN");
		isbn.setName("isbnField");
		JTextField isbnBox =new JTextField(20);
		isbnBox.setName("isbnBox");
		
		AddFieldPanel.add(addBookLabel);
		AddFieldPanel.add(spaceLabel);
		AddFieldPanel.add(title);
		AddFieldPanel.add(titleBox);
		AddFieldPanel.add(author);
		AddFieldPanel.add(authorBox);
		AddFieldPanel.add(isbn);
		AddFieldPanel.add(isbnBox);
		topPanel.add(AddFieldPanel);
		JPanel AddButtonPanel = new JPanel(new GridLayout(1,1));
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName("AddBookButton");
		AddButtonPanel.add(buttonAddMember);
		topPanel.add(AddButtonPanel);
		bookCard.add(topPanel);
		
		//--------------------------------- End First part of the Book Card Adding Info -----------------
		
		JPanel searchFieldPanel = new JPanel(new GridLayout(1,3));
		JLabel BookISBNLabel = new JLabel("Member ID:");
		BookISBNLabel .setName("BookISBNField");
		JTextField BookISBNBox =new JTextField(20);
		BookISBNBox.setName("BookISBNLabel Box");
		JButton buttonsearchMember = new JButton("Search");
		buttonsearchMember.setName("SearchBookButton");
		searchFieldPanel.add(BookISBNLabel );
		searchFieldPanel.add(BookISBNBox);
		searchFieldPanel.add(buttonsearchMember);
		bookCard.add(searchFieldPanel);
		
	//--------------------------------- End First part of the Book Card Adding Info -----------------
		JPanel bottomPanel = new JPanel(new GridLayout(1,2));
		JPanel bottomInnerPanel = new JPanel(new GridLayout(2,2));
		
		JLabel bottomMemberNameLabel= new JLabel("Member Name:");
		bottomMemberNameLabel.setName("MemberName");
		JTextField bottomMemberTextField = new JTextField(20);
		JLabel bottomBooksLabel = new JLabel("Books:");
		bottomBooksLabel.setName("BooksLabel");
		JTextField bottomBooksTextField = new JTextField(20);
		bottomBooksTextField.setName("bookNameofDeletefield");
		bottomInnerPanel.add(bottomMemberNameLabel);
		bottomInnerPanel.add(bottomMemberTextField);
		bottomInnerPanel.add(bottomBooksLabel);
		bottomInnerPanel.add(bottomBooksTextField);
		bottomPanel.add(bottomInnerPanel);
		
		JPanel bottomRightPanel = new JPanel(new GridLayout(1,1));
		JButton deleteButton = new JButton("Delete");
		deleteButton.setName("DeleteBookButton");
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
}
