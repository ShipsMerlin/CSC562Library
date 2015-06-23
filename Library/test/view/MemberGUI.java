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
public class MemberGUI {
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
	MemberGUI(JPanel panel) {
		contentPane = panel;
		memberCard = createAndShowGUI();
	}
	
	/**
	 * @return 
	 * 
	 */
	JPanel createAndShowGUI()
	{
		JPanel card = new JPanel();
		card.setLayout(new FlowLayout());
		card.setName("MemberCard");
		card.add(new JLabel("Add Member"));
		card.add(new JTextField(20));
		JButton buttonAddMember = new JButton("Add");
		buttonAddMember.setName("AddMemberButton");
		buttonAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (contentPane.getLayout());
				cl.show(contentPane, "AddMemberCard");
			}

		});

		card.add(buttonAddMember);
		
		return card;
	}
}
