package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.CsvFileSerializationDriver;

/**
 * A class that describe the list of proposed words.
 */
public class ProposalList {

	/**
	 * The proposalList wrapped by the class.
	 */
	private List<Word> words;

	/**
	 * Constructor for the ProposalList class.
	 */
	public ProposalList() {
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
		try {
			this.words = readWrite.importWords();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A method to get the wrapped list of propositions.
	 * 
	 * @return the proposalList
	 */
	public List<Word> getProposalList() {
		return this.words;
	}

	/**
	 * A method to set the proposal list wrapped into this object.
	 * 
	 * @param proposalList the proposalList to set
	 */
	public void setProposalList(ArrayList<Word> proposalList) {
		this.words = proposalList;
	}

	/**
	 * Add the <code>word</code> parameter to the list of words to add.
	 * 
	 * @param word The word to add to the proposal list
	 */
	public void addWord(Word word) {
		this.words.add(word);
		this.saveInCSV();

	}

	/**
	 * Add the <code>proposalList</code> into the csv of proposal.
	 */
	public void saveInCSV() {
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
		try {
			readWrite.exportWords(this.words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A method to get the dump list of propositions.
	 */

	public void fileDump() {
		List<Word> empty = new ArrayList<Word>();
		this.words = empty;
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("proposal.csv");
		try {
			readWrite.exportWords(this.words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
