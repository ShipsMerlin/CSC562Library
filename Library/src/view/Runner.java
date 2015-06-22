package view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The main UI for the library app. It is a frame that contains a set of cards
 * where only one card is visible at a time
 * 
 * @author Merlin
 *
 */
public class Runner
{
	/**
	 * 
	 */
	static final String BOOK_BUTTON = "bookButton";
	static final String Member_BUTTON = "MemberButton";
	static final String AddMember_BUTTON = "AddMemberButton";
	/**
	 * 
	 */
	static final String MAIN_CARD = "mainPanel";
	/**
	 * 
	 */
	static final String BOOK_CARD = "bookPanel";
	
	static final String Member_CARD = "MemberPanel";
	static final String AddMember_CARD = "AddMemberPanel";
	private static JFrame frame;
	private static JPanel cards;

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	void createAndShowGUI()
	{
		// Create and set up the window.
		frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainCard = buildMainPanel();
		JPanel bookCard = buildBookPanel();
		JPanel MemberCard = bulidMemberPanel();
		cards = new JPanel(new CardLayout());
		cards.add(mainCard, MAIN_CARD);
		cards.add(bookCard, BOOK_CARD);
		cards.add(MemberCard, Member_CARD);
		// Display the window.
		frame.getContentPane().add(cards);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel buildBookPanel()
	{
		JPanel card = new JPanel();
		card.setLayout(new FlowLayout());
		card.setName(BOOK_CARD);
		card.add(new JLabel("BOOKS!!!"));
		return card;
	}

	private JPanel buildMainPanel()
	{
		JPanel mainCard = new JPanel();
		mainCard.setLayout(new FlowLayout());
		mainCard.setName(MAIN_CARD);

		JButton button = new JButton("Books");
		button.setName(BOOK_BUTTON);
		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, BOOK_CARD);
			}
		
		});
		
		JButton button1 = new JButton("Member");
		button1.setName(Member_BUTTON);
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, Member_CARD);
			}
			
		});
			
		mainCard.add(button);
		mainCard.add(button1);
		return mainCard;
	}
	
	
	private JPanel bulidMemberPanel()
	{
		JPanel card = new JPanel();
		card.setLayout(new FlowLayout());
		card.setName(Member_CARD);
		card.add(new JLabel("Add Member"));
		card.add(new JTextField(20));
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName(AddMember_BUTTON);
		buttonAddMember.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, AddMember_CARD);
			}
			
		});
		
		card.add(buttonAddMember);
		return card;
	}

	

	/**
	 * @param args
	 *            unused
	 */
	public static void main(String[] args)
	{
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Runner r = new Runner();
				r.createAndShowGUI();
			}
		});
	}

	/**
	 * @return the frame containing the application view
	 */
	static JFrame getFrame()
	{
		return frame;
	}

	/**
	 * @return the card that is current visible
	 */
	Component getVisibleCard()
	{
		for (int i = 0; i < cards.getComponentCount(); i++)
		{
			if (cards.getComponent(i).isVisible())
			{
				return cards.getComponent(i);
			}
		}
		return null;
	}
}
