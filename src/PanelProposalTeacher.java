import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * A class that describe the Proposal panel from teacher view of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.3
 */

public class PanelProposalTeacher extends JPanel implements ActionListener {

    /**
     * The JScrollPane that'll show the JTable that holds the proposals.
     */
    JScrollPane tab = new JScrollPane();

    /**
     * The JTable object containing all the proposals.
     */
    JTable tableau;
    /**
     * A JButton object used to dump the file of proposal.
     */
    private JButton btDump = new JButton("Dump proposal List");

    /**
     * The proposal list
     */
    private ProposalList proposals;
    
    private static final long serialVersionUID = 1L;

    /**
     * The constructor for the PanelProposalTeacher class.
     */
    public PanelProposalTeacher() {
    	
    	proposals = new ProposalList();
    	int numberOfProposal = proposals.getProposalList().size();

    	Object[][] data = new Object[numberOfProposal][2];

    	int i = 0;
    	while (i < numberOfProposal) {
    	    data[i][0] = proposals.getProposalList().get(i).getFrenchWord();
    	    data[i][1] = proposals.getProposalList().get(i).getEnglishWord();
    	    i = i + 1;

    	}
    	String title[] = { "French Words", "English Words" };
    	tableau = new JTable(data, title);

    	tab = new JScrollPane(tableau);

    	this.add(tab);

	
	this.add(btDump);
	btDump.addActionListener(this);

    }
    public void actionPerformed(ActionEvent arg0) {// Method that will be called when clicking on the button
    	if (arg0.getSource() == btDump) {
    		proposals.fileDump();
    		this.loadAndDispayTab();
    		this.remove(btDump);
    		this.updateUI();
    	}
    }
    
    public void loadAndDispayTab(){
    	this.remove(tab);
    	proposals = new ProposalList();
    	int numberOfProposal = proposals.getProposalList().size();

    	Object[][] data = new Object[numberOfProposal][2];

    	int i = 0;
    	while (i < numberOfProposal) {
    	    data[i][0] = proposals.getProposalList().get(i).getFrenchWord();
    	    data[i][1] = proposals.getProposalList().get(i).getEnglishWord();
    	    i = i + 1;

    	}
    	String title[] = { "French Words", "English Words" };
    	tableau = new JTable(data, title);

    	tab = new JScrollPane(tableau);

    	this.add(tab);
    }
}
