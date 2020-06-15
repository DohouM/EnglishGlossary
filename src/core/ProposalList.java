package core;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.CsvFileSerializationDriver;


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
	private List<Word> proposalList;
  
	/**
	 * Constructor for the ProposalList class.
	 */
	public ProposalList() {
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
		try {
			this.proposalList=readWrite.importWords();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	

	/**
	 * A method to get the wrapped list of propositions.
	 * @return the proposalList
	 */
	public List<Word> getProposalList() {
		return this.proposalList;
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
    	CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
		try {
			readWrite.exportWords(this.proposalList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
	 * A method to get the dump list of propositions.
	 */
    
    public void fileDump() {
    	List<Word> empty= new ArrayList<Word>(); 
    	this.proposalList=empty;
    	CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
    	try {
			readWrite.exportWords(this.proposalList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
