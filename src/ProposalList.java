import java.util.ArrayList;


/**
 * A class that describe the list of proposed words.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 */
public class ProposalList {

    	/**
    	 * The proposalList wrapped by the class.
    	 */
	private ArrayList<Word> proposalList;
  
	/**
	 * Constructor for the ProposalList class.
	 */
	public ProposalList() {
		InterfaceReadWrite InterfaceRW =new FilesDrivers();
		this.proposalList = InterfaceRW.read("proposal.csv");
	}
	

	/**
	 * A method to get the wrapped list of propositions.
	 * @return the proposalList
	 */
	public ArrayList<Word> getProposalList() {
		return proposalList;
	}

	/**
	 * A method to set the proposal list wrapped into this object.
	 * @param proposalList the proposalList to set
	 */
	public void setProposalList(ArrayList<Word> proposalList) {
		this.proposalList = proposalList;
	}
	/**
	 * Add the <code>word</code> parameter to the list of words to add.
	 * @param word The word to add to the proposal list
	 */
    public void addWord(Word word) {
	this.proposalList.add(word);
	this.saveInCSV(); 
	
    }
    
    /**
     * Add the <code>proposalList</code> into the csv of proposal.
     */
    public void saveInCSV(){
    	InterfaceReadWrite InterfaceRW =new FilesDrivers();
		InterfaceRW.write(this.proposalList,"proposal.csv");
    }
    
    /**
	 * A method to get the dump list of propositions.
	 */
    
    public void fileDump() {
    	ArrayList<Word> empty= new ArrayList<Word>(); 
    	this.proposalList=empty;
    	InterfaceReadWrite InterfaceRW =new FilesDrivers();
		InterfaceRW.write(this.proposalList,"proposal.csv");
    }
}
