package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CommandAddMember;
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
public class MemberGUI implements QualifiedObserver

{
	private static JFrame jFrame;
	/**
	 * 
	 */
	public JButton memberNameButton;
	/**
	 * 
	 */
	public JTextField addMemberNameTextField;
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
	JTextField searchMemberIDText;
	/**
	 * 
	 */
	JTextField txtDisplayMemberName;
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
		QualifiedObservableConnector.getSingleton().registerObserver(this, MemberResponseReport.class);
	}

	/**
	 * @return - the newly created JPanel
	 * 
	 */
	JPanel createAndShowGUI()
	{
		
		jFrame = new JFrame("MemberSwing");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// main panel set up
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(5, 1));
		content.setName("memberPanel");

		/**
		 * Adding all components for Member Add
		 */
		JPanel addMemberPanel = new JPanel();
		addMemberPanel.setName("addMemberPanel");
		addMemberPanel.setLayout(new GridLayout(1, 3));
		JLabel addMemberLabel = new JLabel("Member Name");
		addMemberLabel.setName("AddMemberName");
		addMemberNameTextField = new JTextField(20);
		addMemberNameTextField.setName("txtAddMemberName");
		memberNameButton = new JButton("Add");
		memberNameButton.setName("btnAddMember");
		memberNameButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandAddMember command = new CommandAddMember(addMemberNameTextField.getText());
				ModelFacade.getSingleton().queueCommand(command);
			}
		});

		addMemberPanel.add(addMemberLabel);

		addMemberPanel.add(addMemberNameTextField);
		addMemberPanel.add(memberNameButton);
		content.add(addMemberPanel);
			
		/**
		 * Adding all components for the Member Search
		 */
		
		JPanel searchMemberPanel = new JPanel();
		searchMemberPanel.setName("SearchMemberPanel");
		searchMemberPanel.setLayout(new GridLayout(1, 3));
		JLabel searchMemberIDLabel = new JLabel("Member Id");
		searchMemberIDLabel.setName("lblSearchMemberId");
		searchMemberIDText = new JTextField();
		searchMemberIDText.setName("txtSearchMemberID");
		JButton memberSearchButton = new JButton("Search");
		memberSearchButton.setName("btnMemberSearch");
		memberSearchButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CommandFindMember command = new CommandFindMember(Integer.parseInt(searchMemberIDText.getText()));
				ModelFacade.getSingleton().queueCommand(command);
			}
		});
		
		searchMemberPanel.add(searchMemberIDLabel);
		searchMemberPanel.add(searchMemberIDText);
		searchMemberPanel.add(memberSearchButton);
		content.add(searchMemberPanel);
		
		
		JPanel displayMemberInfoPanel = new JPanel();
		displayMemberInfoPanel.setLayout(new GridLayout(2, 1));
		displayMemberInfoPanel.setName("DisplayMemberInfoPanel");
		
		JPanel memberNameDisplayPanel = new JPanel();
		memberNameDisplayPanel.setName("MemberNameDisplayPanel");
		memberNameDisplayPanel.setLayout(new GridLayout(1, 3));
		JLabel lblMemberName = new JLabel("Disply Member Name");
		lblMemberName.setName("DisplyMemberNameLabel");
		txtDisplayMemberName = new JTextField("");
		txtDisplayMemberName.setName("DisplyMemberNameText");
		JButton btnDeleteMember = new JButton("Delete");
		btnDeleteMember.setName("btnDeleteMember");
		memberNameDisplayPanel.add(lblMemberName);
		memberNameDisplayPanel.add(txtDisplayMemberName);
		memberNameDisplayPanel.add(btnDeleteMember);
		searchMemberPanel.add(memberNameDisplayPanel);
		
		JPanel BookPanel = new JPanel();
		BookPanel.setName("BookPanel");
		BookPanel.setLayout(new GridLayout(1, 2));
		JLabel BookLabel = new JLabel("Display Book ");
		BookLabel.setName("DisplaybookLabel");
		JTextField BookText = new JTextField("");
		BookText.setName("DisplayBookText");
		BookPanel.add(BookLabel);
		BookPanel.add(BookText);
		displayMemberInfoPanel.add(memberNameDisplayPanel);
		displayMemberInfoPanel.add(BookPanel);

		content.add(displayMemberInfoPanel);
		return content;
	}

	@Override
	public void receiveReport(QualifiedObservableReport report)
	{
		// TODO Auto-generated method stub
		System.out.println("Received report");
		if (report.getClass().equals(MemberResponseReport.class))
		{
			MemberResponseReport mrr = (MemberResponseReport)report;
			txtDisplayMemberName.setText(mrr.getMemberName());
			//System.out.println(fmrr.getMemberName());
		}
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
