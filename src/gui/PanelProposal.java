package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.ProposalList;
import core.Word;

/**
 * A class that describe the Proposal panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.0
 */

public class PanelProposal extends JPanel implements ActionListener {
    /**
     * A JLabel placed before the JTextField used to ask for the french word to propose.
     */
    private JLabel fr = new JLabel("French Word");
    /**
     * A JTextField used for the french word to propose.
     */
    private JTextField frenchWord = new JTextField("", 30);

    /**
     * A JLabel placed before the JTextField used to ask for the english word to propose.
     */
    private JLabel en = new JLabel("English Word");
    /**
     * A JTextField used for the english word to propose.
     */
    private JTextField englishWord = new JTextField("", 30);

    /**
     * A JButton object used to create and submit a new proposal.
     */
    private JButton btCreate = new JButton("Create a proposal");
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constructor of the PanelProposal class.
     */
    public PanelProposal() {

	this.add(this.en);
	this.add(this.englishWord);
	this.add(this.fr);
	this.add(this.frenchWord);
	this.add(this.btCreate);
	btCreate.addActionListener(this);
    }

    /**
     * Method that described what to do if an action is performed.
     * 
     * @param arg0 The action performed by the user
     */
    public void actionPerformed(ActionEvent arg0) {// Method that will be called when clicking on the button

	if (arg0.getSource() == this.btCreate) {
		
	    Word proposalWord = new Word(this.englishWord.getText(), this.frenchWord.getText());
	    ProposalList proposal = new ProposalList();
	    proposal.addWord(proposalWord);

	    JOptionPane.showMessageDialog(null, "Proposal Saved");
	    this.frenchWord.setText("");
	    this.englishWord.setText("");

	    this.updateUI(); //Refresh
	}

    }

}
