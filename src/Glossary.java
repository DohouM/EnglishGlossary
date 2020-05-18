import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Glossary is a class meant to contain an English-French technical glossary.
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.4
 * 
 * 
 */

public class Glossary {
    /**
     * The number of word per pages into this glossary.
     */
    private final int numberOfWordPerPage = 51;
    
    /**
     * The glossary stored into the object.
     */
    private ArrayList<Word> glossary;

    /**
     * Create a new Glossary object, with the <tt>glossary</tt>
     * @param glossary : The glossary to contain.
     */
    public Glossary(ArrayList<Word> glossary) {
	this.glossary = glossary;
    }
    
    public Glossary() {
    }
    
    /**
     * Sort glossary by lexical order using english words.
     */
    public void sortByEn() {
	Collections.sort(glossary);
    }

    /**
     * Glossary getter.
     * @return An array list with all the words of the glossary.
     */
    public ArrayList<Word> getGlossary() {
	return glossary;
    }

    /**
     * @deprecated
     * Take a glossary as a parameter.
     * @param glossary : The glossary to contain.
     */
    public void setGlossary(ArrayList<Word> glossary) {
	this.glossary = glossary;
    }
    
    /** 
     * Add a word to the glossary, and sort it again using the method <tt>sortByEn</tt>
     * @param word : The word to add into the glossary.
     */

    public void addWordGlossary(Word word) {
	this.glossary.add(word);
	this.sortByEn();
    }

    /**
     * Same method as <tt>addWordGlossary</tt>, except it takes strings as an input rather than a <tt>Word</tt> object.
     * @param EnglishWord :  The English word to add (must be a <tt>String</tt>).
     * @param FrenchWord :  The french translation of the word (must be a <tt>String</tt>).
     */
    public void addWordStringOnly(String englishWord, String frenchWord) {
	Word word = new Word(englishWord, frenchWord);
	glossary.add(word);
	this.sortByEn();
    }

    /**
     * Search through the glossary for the string passed as a parameter, and return all the results.
     * @param keyWord : The word to search (can be either french or english).
     * @return The word that matches, else returns <tt>keyWord not found</tt>.
     */
    public Word search(String keyWord) {
//ArrayList � faire pour le return ->ajouter les mots ->plusieurs mots m�me traduction
	for (Word w : this.glossary) {
	    if (w.getEnglishWord().contains(keyWord)) {
		return w;
	    }
	}
	for (Word w : this.glossary) {
	    if (w.getFrenchWord().contains(keyWord)) {
		return w;
	    }
	}
	return null;
    }

//	public ArrayList<Word> page(int page) {
//		ArrayList<Word> list = new ArrayList<Word>();
//		page = page - 1;
//		int startWord = numberOfWordPerPage * page;
//		int endWord = startWord + numberOfWordPerPage;
//
//		for (int i = startWord; i < endWord; i++) {
//			list.add(this.glossary.get(i));
//		}
//
//		return list;
//	}

    /**
     * Returns all the words of the glossary between <tt>startPage</tt> (included) and <tt>endPage</tt> (included) parameters.
     * @param startPage : First page to return.
     * @param endPage : Last page to return.
     * @return Content of pages between startPage (included) and endPage (included).
     */
    public ArrayList<Word> pages(int startPage, int endPage) {
	ArrayList<Word> list = new ArrayList<Word>();
	startPage = startPage - 1;
	endPage = endPage - 1;
	int startWord = numberOfWordPerPage * startPage;
	int endWord;
	if (endPage + 1 == this.numberOfPages()) {
	    endWord = this.glossary.size() - 1;
	} else {
	    endWord = numberOfWordPerPage * endPage + numberOfWordPerPage - 1;
	}

	for (int i = startWord; i <= endWord; i++) {
	    list.add(this.glossary.get(i));
	}

	return list;
    }

    /**
     * Returns only the mandatory words of the glossary between <tt>startPage</tt> (included) and <tt>endPage</tt> (included) parameters.
     * @param startPage : First page to return.
     * @param endPage : Last page to return.
     * @return Content of pages between startPage (included) and endPage (included).
     */
    public ArrayList<Word> pagesMandatory(int startPage, int endPage) {
	ArrayList<Word> list = new ArrayList<Word>();
	startPage = startPage - 1;
	endPage = endPage - 1;
	int startWord = numberOfWordPerPage * startPage;
	int endWord;
	if (endPage + 1 == this.numberOfPages()) {
	    endWord = this.glossary.size() - 1;
	} else {
	    endWord = numberOfWordPerPage * endPage + numberOfWordPerPage - 1;
	}

	for (int i = startWord; i <= endWord; i++) {
	    if (this.glossary.get(i).isMandatory()) {
		list.add(this.glossary.get(i));
	    }
	}
	return list;
    }
    
    /**
     * Returns the number of pages of the glossary.
     * @return The number of pages of the glossary.
     */
    public int numberOfPages() {
	return (int) Math.ceil(glossary.size() / (double) numberOfWordPerPage);
    }
}
