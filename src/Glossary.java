import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jcl
 *
 */


public class Glossary {
	
	public static int numberOfWordPerPage=51;

	private ArrayList<Word> glossary;

	/**
	 * @param glossary
	 */
	public Glossary() {
		this.glossary = new ArrayList<Word>();
	}

	public void sortByEn() { // sort words alphabetically
		Collections.sort(glossary);
	}

	/**
	 * @return the glossary
	 */
	public ArrayList<Word> getGlossary() {
		return glossary;
	}

	/**
	 * @param glossary the glossary to set
	 */
	public void setGlossary(ArrayList<Word> glossary) {
		this.glossary = glossary;
	}

	public void addWordGlossary(Word word) {
		this.glossary.add(word);
		this.sortByEn();
	}
	
	public void addWordStringOnly(String EnglishWord,String FrenchWord) {
		Word word = new Word(EnglishWord, FrenchWord);
		glossary.add(word);
		this.sortByEn();
	}

	public String search(String keyWord) {

		for (Word w : this.glossary) {
			if (w.getEnglishWord().contains(keyWord)) {
				return w.toString();
			}
		}
		for (Word w : this.glossary) {
			if (w.getFrenchWord().contains(keyWord)) {
				return w.toString();
			}
		}
		return keyWord+" not found";
	}

	public ArrayList<Word> page(int page) {
		ArrayList<Word> list =new ArrayList<Word>();
		page=page-1;
		int startWord=numberOfWordPerPage*page;
		int endWord=startWord+numberOfWordPerPage;
		
		for (int i=startWord; i<endWord; i++) {
			list.add(this.glossary.get(i));
		}
		
		return list;
	}
	
	public ArrayList<Word> pages(int startPage,int endPage) {
		ArrayList<Word> list =new ArrayList<Word>();
		startPage=startPage-1;
		endPage=endPage-1;
		int startWord=numberOfWordPerPage*startPage;
		int endWord=numberOfWordPerPage*endPage+numberOfWordPerPage-1;
		
		for (int i=startWord; i<=endWord; i++) {
			list.add(this.glossary.get(i));
		}
		
		return list;
	}
}
