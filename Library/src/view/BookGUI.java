package view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		bookCard.setLayout(new FlowLayout());
		bookCard.setName("bookPanel");
		JLabel bookLabel = new JLabel("Add Book");
		bookLabel.setName("BookLabel");
		bookCard.add(bookLabel);
		bookCard.add(new JTextField(20));
		JTextField textField = new JTextField(20); 
		textField.setName("BookTextField");
		bookCard.add(textField);
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName("AddBookButton");
		buttonAddMember.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "bookPanel");
			}

		});

		bookCard.add(buttonAddMember);
		return bookCard;
	}
}
