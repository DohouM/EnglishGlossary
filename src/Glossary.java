import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jcl
 *
 */
public class Glossary {

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

	public ArrayList<Word> page(int startPage,int endPage) {
		ArrayList<Word> list =new ArrayList<Word>();
		int startWord=51*startPage;
		int endWord=51*endPage;
		
		for (int i=startWord; i<=endWord; i++) {
			list.add(this.glossary.get(i));
		}
		
		return list;
	}
}
