package view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CommandFindMember;
import model.ModelFacade;

/**
 * @author em1419
 *
 */
public class MemberGUI

{
	private static JFrame jFrame;
	/**
	 * 
	 */
	public JButton memberNameButton;
	/**
	 * 
	 */
	public JTextField memberNameTextField;
	/**
	 * 
	 */
	public JButton memberIDButton;
	/**
	 * 
	 */
	public JTextField memberIDTextField;
	/**
	 * 
	 */
	JPanel contentPane;
	/**
	 * 
	 */
	JPanel memberCard;

	/**
	 * @param panel
	 */
	MemberGUI(JPanel panel)
	{
		contentPane = panel;
		memberCard = createAndShowGUI();
	}

	/**
	 * @return
	 * 
	 */
	JPanel createAndShowGUI()
	{
		
		jFrame = new JFrame("MemberSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel content = new JPanel();
		content.setLayout(new GridLayout(5, 1));
		content.setName("MemberPanel");

		/**
		 * Adding all components for Member Search
		 */
		JPanel memberPanel = new JPanel();
		memberPanel.setLayout(new GridLayout(1, 3));
		JLabel memberLabel = new JLabel("Member Name");
		memberLabel.setName("MemberName");
		memberNameTextField = new JTextField(20);
		memberNameTextField.setName("txtMemberName");
		memberNameButton = new JButton("add");
		memberNameButton.setName("btnSearchMember");
		memberNameButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandFindMember command = new CommandFindMember(Integer.parseInt(memberNameTextField.getText()));
				ModelFacade.getSingleton().queueCommand(command);
			}
		});

		memberPanel.add(memberLabel);

		memberPanel.add(memberNameTextField);
		memberPanel.add(memberNameButton);
		content.add(memberPanel);
			
		/**
		 * 
		 */
		
		JPanel MemberPanel = new JPanel();
		MemberPanel.setLayout(new GridLayout(1, 3));
		JLabel MemberIDLabel = new JLabel("Member Id");
		JTextField MemberIDText = new JTextField("");
		MemberIDText.setName("MemberID");
		JButton memberIDButton = new JButton("Search");
		memberIDButton.setName("btnMemberID");
		MemberPanel.add(MemberIDLabel);
		MemberPanel.add(MemberIDText);
		MemberPanel.add(memberIDButton);
		content.add(MemberPanel);
		
		JPanel content1 = new JPanel();
		content1.setLayout(new GridLayout(2, 1));
		content1.setName("MemberPanel1");
		
		JPanel MemberPanel1 = new JPanel();
		MemberPanel1.setLayout(new GridLayout(1, 3));
		JLabel MemberNameLabel1 = new JLabel("Disply Member Name");
		JTextField MemberNameText1 = new JTextField("");
		MemberNameText1.setName("DisplyMemberName");
		JButton memberNameButton1 = new JButton("Delete");
		memberNameButton1.setName("btnMemberName");
		
		MemberPanel1.add(MemberNameLabel1);
		MemberPanel1.add(MemberNameText1);
		MemberPanel1.add(memberNameButton1);
		MemberPanel.add(MemberPanel1);
		
		JPanel BookPanel = new JPanel();
		BookPanel.setLayout(new GridLayout(1, 2));
		JLabel BookLabel = new JLabel("Disply Book ");
		JTextField BookText = new JTextField("");
		BookText.setName("DisplyBook");
		
		BookPanel.add(BookLabel);
		BookPanel.add(BookText);
		content1.add(MemberPanel1);
		content1.add(BookPanel);

		content.add(content1);
		return content;
	}
	

	/**{
	 
		JPanel card = new JPanel();
		card.setLayout(new FlowLayout());
		card.setName("memberPanel");
		JLabel memberLabel = new JLabel("Add Member Name");
		memberLabel.setName("MemberLabel");
		card.add(memberLabel);
		JTextField textField = new JTextField(20); 
		textField.setName("MemberTextField");
		card.add(textField);
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName("AddMemberButton");
		buttonAddMember.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "AddMemberCard");
			}

		});

		card.add(buttonAddMember);

		return card;
	} */
	
}
