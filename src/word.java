/**
 * 
 */

/**
 * @author jcl
 *
 */
public class word {
	
	private String englishWord;
	private String frenchWord;
	private int difficulty;  // ask the client for the moment difficulty is codded by 1,2 or 3, 3 is the most difficult
	
	
	
	/**
	 * @param englishWord
	 * @param frenchWord
	 * @param difficulty
	 */
	public word(String englishWord, String frenchWord, int difficulty) {
		super();
		this.englishWord = englishWord;
		this.frenchWord = frenchWord;
		this.difficulty = difficulty;
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
	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
