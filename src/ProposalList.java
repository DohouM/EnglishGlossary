import java.util.ArrayList;

public class ProposalList {


	private ArrayList<Word> proposalList;
    /**
	 * @param proposalList
	 */
	public ProposalList() {
		InterfaceReadWrite InterfaceRW =new FilesDrivers();
		this.proposalList = InterfaceRW.read("proposal.csv");
	}
	

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
	
    public void addWord(Word word) {
	this.proposalList.add(word);
	this.saveInCSV(); 
	
    }
    
    public void saveInCSV(){
    	FilesDrivers FD= new FilesDrivers();
    	
    	FD.write(this.proposalList,"proposal.csv");
    }
}
