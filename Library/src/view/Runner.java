package view;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
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
/**
*
*/
static final String MAIN_CARD = "mainPanel";
/**
*
*/
static final String BOOK_CARD = "bookPanel"; 
/**
*
*/
static final String MEMBER_BUTTON = "memberButton";
/**
*
*/
static final String CHECKOUT_CARD = "checkoutPanel";
/**
*
*/
static final String CHECKOUT_BUTTON = "checkoutButton";
/**
*AddBook_BUTTON
*/
static final String MEMBER_CARD = "memberPanel";
/**
 * 
 */
static final String ADDMEMBER_CARD = "AddMemberPanel";
/**
 * 
 */
static final String ADDMEMBER_BUTTON = "AddMemberButton";
private static final String ADDBOOK_BUTTON = "AddBookButton";
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
JPanel memberCard = buildMemberPanel();
JPanel checkoutCard = buildCheckoutPanel();
cards = new JPanel(new CardLayout());
cards.add(mainCard, MAIN_CARD);
cards.add(bookCard, BOOK_CARD);
cards.add(memberCard, MEMBER_CARD);
cards.add(checkoutCard, CHECKOUT_CARD);
// Display the window.
frame.getContentPane().add(cards);
frame.pack();
frame.setVisible(true);
}

private JPanel buildMemberPanel() {
	// TODO Auto-generated method stub
	
	JPanel card = new JPanel();
	card.setLayout(new FlowLayout());
	card.setName(MEMBER_CARD);
	card.add(new JLabel("Add Member"));
	card.add(new JTextField(20));
	JButton buttonAddMember = new JButton("Add");
	buttonAddMember.setName(ADDMEMBER_BUTTON);
	buttonAddMember.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, ADDMEMBER_CARD);
		}
		
	});
	
	card.add(buttonAddMember);
	return card;
}
private JPanel buildBookPanel()
{
/**JPanel card = new JPanel();
card.setLayout(new FlowLayout());
card.setName(BOOK_CARD);
card.add(new JLabel("BOOKS!!!"));
return card;
}*/
	JPanel bookCard = new JPanel();
	bookCard.setLayout(new FlowLayout());
	bookCard.setName(BOOK_CARD);
	bookCard.add(new JLabel("Add Book"));
	bookCard.add(new JTextField(20));
	JButton buttonAddMember = new JButton("Add");
	buttonAddMember.setName(ADDBOOK_BUTTON);
	buttonAddMember.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, BOOK_CARD);
		}
		
	});
	
	bookCard.add(buttonAddMember);
	return bookCard;
}
private JPanel buildCheckoutPanel()
{
JPanel card = new JPanel();
card.setLayout(new FlowLayout());
card.setName(CHECKOUT_CARD);
card.add(new JLabel("CHECKOUT!!!"));
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
mainCard.add(button);
JButton memberButton = new JButton("Members");
memberButton.setName(MEMBER_BUTTON);
memberButton.addActionListener(new ActionListener()
{
@Override
public void actionPerformed(ActionEvent e)
{
CardLayout cl = (CardLayout) (cards.getLayout());
cl.show(cards, MEMBER_CARD);
}
});
mainCard.add(memberButton);
JButton checkoutButton = new JButton("Checkout");
checkoutButton.setName(CHECKOUT_BUTTON);
checkoutButton.addActionListener(new ActionListener()
{
@Override
public void actionPerformed(ActionEvent e)
{
CardLayout cl = (CardLayout) (cards.getLayout());
cl.show(cards, CHECKOUT_CARD);
}
});
mainCard.add(checkoutButton);
return mainCard;
}
/**
* @param args
* unused
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