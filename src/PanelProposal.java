import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelProposal extends JPanel implements ActionListener {

	private JLabel fr = new JLabel("French Word");
	private JTextField frenchWord = new JTextField("",30);

	private JLabel en = new JLabel("English Word");
	private JTextField englishWord = new JTextField("",30);
	
	//Jbutton
	private JButton btCreate= new JButton("Create a proposal");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PanelProposal() {

		this.add(en);
		this.add(englishWord);
		this.add(fr);
		this.add(frenchWord);
		this.add(btCreate);
		btCreate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {// Method that will be called when clicking on the button

		if (arg0.getSource() == btCreate) {
			Word proposalWord= new Word(englishWord.getText(),frenchWord.getText());
			ProposalList proposal= new ProposalList();
			proposal.addWord(proposalWord);
			
			JOptionPane.showMessageDialog(null,"Proposal Saved");
			frenchWord.setText("");
			englishWord.setText("");
			
			this.updateUI();
		}
		
	}

}
