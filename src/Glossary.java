import java.util.ArrayList;


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
	
	public void sort(){ //sort words alphabetically
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
	
	public void modifier() {
		
	}
}
