import java.io.Serializable;

/**
 * 
 */

/**
 * @author jcl
 *
 */
public class Word implements Serializable, Comparable<Word>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String englishWord;
	private String frenchWord;
	
	
	
	
	/**
	 * @param englishWord
	 * @param frenchWord
	 * @param difficulty
	 */
	public Word(String englishWord, String frenchWord) {
		super();
		this.englishWord = englishWord;
		this.frenchWord = frenchWord;
	}
	
	/**
	 * @return the englishWord
	 */
	public String getEnglishWord() {
		return englishWord;
	}
	/**
	 * @param englishWord the englishWord to set
	 */
	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}
	/**
	 * @return the frenchWord
	 */
	public String getFrenchWord() {
		return frenchWord;
	}
	/**
	 * @param frenchWord the frenchWord to set
	 */
	public void setFrenchWord(String frenchWord) {
		this.frenchWord = frenchWord;
	}
	
	@Override
	public String toString() {
		return "Word [english Word=" + englishWord + ", french Word=" + frenchWord+ "]";
	}


	@Override
	public int compareTo(Word wordToCompare) {
		
		int compareFirst=(int) ((Word)wordToCompare).getEnglishWord().charAt(0);
        /* For Ascending order*/
		int firstLettre= (int) this.getEnglishWord().charAt(0);
        return firstLettre-compareFirst;
	}

	
}

