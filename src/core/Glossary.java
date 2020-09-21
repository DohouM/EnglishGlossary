package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Glossary is a class meant to contain an English-French technical glossary.
 */
public class Glossary {
	
	/**
	 * Number of words per glossary page
	 */
	private final static int WORDS_PER_PAGE = 51;

	/**
	 * Words stored in the glossary.
	 */
	private final List<Word> words;

	/**
	 * Create a new Glossary object, with the <code>glossary</code>
	 * 
	 * @param words : The words to add
	 */
	public Glossary(List<Word> words) {
		this.words = new ArrayList<Word>();
		this.addWords(words);
	}

	/**
	 * A constructor for the Glossary class, which initializes an empty
	 * <code>List&lt;Word&gt;</code>
	 */
	public Glossary() {
		this.words = new ArrayList<Word>();
	}

	/**
	 * Sort glossary by lexical order using english words.
	 */
	public void sortByEn() {
		Collections.sort(this.words);
	}

	/**
	 * Glossary getter.
	 * 
	 * @return An array list with all the words of the glossary.
	 */
	public List<Word> getWords() {
		return Collections.unmodifiableList(this.words);
	}

	/**
	 * Add a word to the glossary, and sort it again using the method
	 * <code>sortByEn</code>
	 * 
	 * @param word : The word to add into the glossary.
	 */
	public void addWord(Word word) {
		this.words.add(word);
		this.sortByEn();
	}

	/**
	 * Add a list of word to the glossary, and sort it again using the method
	 * <code>sortByEn</code>
	 * 
	 * @param words : The words to add into the glossary.
	 */
	public void addWords(List<Word> words) {
		this.words.addAll(words);
		this.sortByEn();
	}
	
	/**
	 * Same method as <code>addWord</code>, except it takes strings as an
	 * input rather than a <code>Word</code> object.
	 * 
	 * @param englishWord : The English word to add (must be a <code>String</code>).
	 * @param frenchWord  : The french translation of the word (must be a
	 *                    <code>String</code>).
	 */
	public void addWord(String englishWord, String frenchWord) {
		this.addWord(new Word(englishWord, frenchWord));
	}

	/**
	 * Search through the glossary for the string passed as a parameter, and return
	 * all the results.
	 * 
	 * @param keyWord : The word to search (can be either french or english).
	 * @return The word that matches, else returns <code>keyWord not found</code>.
	 */
	public Word search(String keyWord) {
		for (Word word : this.words) {
			if (word.getEnglishWord().contains(keyWord)) {
				return word;
			}
		}
		
		for (Word word : this.words) {
			if (word.getFrenchWord().contains(keyWord)) {
				return word;
			}
		}
		return null;
	}

	/**
	 * Returns all the words of the glossary between <code>startPage</code>
	 * (included) and <code>endPage</code> (included) parameters.
	 * 
	 * @param startPage : First page to return.
	 * @param endPage   : Last page to return.
	 * @return Content of pages between startPage (included) and endPage (included).
	 */
	public List<Word> pages(int startPage, int endPage) {
		List<Word> list = new ArrayList<Word>();
		startPage = startPage - 1;
		endPage = endPage - 1;
		int startWord = WORDS_PER_PAGE * startPage;
		int endWord;
		if (endPage + 1 == this.numberOfPages()) {
			endWord = this.words.size() - 1;
		} else {
			endWord = WORDS_PER_PAGE * endPage + WORDS_PER_PAGE - 1;
		}

		for (int loopCounter = startWord; loopCounter <= endWord; loopCounter++) {
			list.add(this.words.get(loopCounter));
		}

		return list;
	}

	/**
	 * Returns only the mandatory words of the glossary between
	 * <code>startPage</code> (included) and <code>endPage</code> (included)
	 * parameters.
	 * 
	 * @param startPage : First page to return.
	 * @param endPage   : Last page to return.
	 * @return Content of pages between startPage (included) and endPage (included).
	 */
	public List<Word> pagesMandatory(int startPage, int endPage) {
		List<Word> list = new ArrayList<Word>();
		startPage = startPage - 1;
		endPage = endPage - 1;
		int startWord = WORDS_PER_PAGE * startPage;
		int endWord;
		if (endPage + 1 == this.numberOfPages()) {
			endWord = this.words.size() - 1;
		} else {
			endWord = WORDS_PER_PAGE * endPage + WORDS_PER_PAGE - 1;
		}

		for (int loopCounter = startWord; loopCounter <= endWord; loopCounter++) {
			if (this.words.get(loopCounter).isMandatory()) {
				list.add(this.words.get(loopCounter));
			}
		}
		return list;
	}

	/**
	 * Returns the number of pages of the glossary.
	 * 
	 * @return The number of pages of the glossary.
	 */
	public int numberOfPages() {
		return (int) Math.ceil(this.words.size() / (double) WORDS_PER_PAGE);
	}

	/**
	 * Remove the word in the glossary.
	 * 
	 * @param word The Word to remove from the glossary.
	 */
	public void removeWord(Word word) {
		this.words.remove(word);

	}
}
