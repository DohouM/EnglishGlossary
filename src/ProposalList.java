import java.util.ArrayList;

public class ProposalList {
    private ArrayList<Word> proposalList;

	/**
	 * @return the proposalList
	 */
	public ArrayList<Word> getProposalList() {
		return proposalList;
	}

	/**
	 * @param proposalList the proposalList to set
	 */
	public void setProposalList(ArrayList<Word> proposalList) {
		this.proposalList = proposalList;
	}
	
    public void addWordGlossary(Word word) {
	this.proposalList.add(word);
    }
}
