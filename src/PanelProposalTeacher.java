import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * A class that describe the Proposal panel from teacher view of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 */

public class PanelProposalTeacher extends JPanel {

    /**
     * The JScrollPane that'll show the JTable that holds the proposals.
     */
    JScrollPane tab = new JScrollPane();

    /**
     * The JTable object containing all the proposals.
     */
    JTable tableau;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constructor for the PanelProposalTeacher class.
     */
    public PanelProposalTeacher() {
	JLabel addAWord = new JLabel("Add a Word");
	this.add(addAWord);

	ProposalList proposals = new ProposalList();
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
