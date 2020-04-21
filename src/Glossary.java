import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jcl
 *
 */
public class Glossary {

	private ArrayList<Word> glossary = new ArrayList<Word>();

	/**
	 * @param glossary
	 */
	public Glossary() {
	}

	public void sort() { // sort words alphabetically
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
		glossary.add(word);
	}

	public Word search(String keyWord) {

		for (Word w : this.glossary) {
			if (w.getEnglishWord().contains("keyWord")) {
				return w;
			}
		}
		for (Word w : this.glossary) {
			if (w.getFrenchWord().contains("keyWord")) {
				return w;
			}
		}
		return null;
	}

	public void modify() {

	}
}
