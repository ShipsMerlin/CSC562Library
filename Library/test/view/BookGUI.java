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
public class BookGUI {
	/**
	 * 
	 */
	JPanel contentPane;
	/**
	 * 
	 */
	JPanel bookCard;
	
	/**
	 * @param panel
	 */
	BookGUI(JPanel panel) {
		contentPane = panel;
		bookCard = createAndShowGUI();
	}
	
	/**
	 * @return
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
		bookCard.setName("BookCard");
		bookCard.add(new JLabel("Add Book"));
		bookCard.add(new JTextField(20));
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName("AddBookButton");
		buttonAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "BookCard");
			}

		});

		bookCard.add(buttonAddMember);
		return bookCard;
	}
}
