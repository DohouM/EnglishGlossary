import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelProposalTeacher extends JPanel {

	// JScrollPane
	JScrollPane tab = new JScrollPane();

	// JTable
	JTable tableau;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public PanelProposalTeacher() {
		JLabel addAWord = new JLabel("Add a Word");	
		this.add(addAWord);
		
		ProposalList proposals= new ProposalList();
		int numberOfProposal=proposals.getProposalList().size();
		
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
