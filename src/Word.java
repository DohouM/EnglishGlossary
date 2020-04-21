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
		String str1 =this.getEnglishWord();
		String str2 = wordToCompare.getEnglishWord();
		if(str1.substring(0, 3).equals("to ")) {        //solving problems of to ... every word how's start with to ..
			str1=str1.substring(3);
		}
		if(str2.substring(0, 3).equals("to ")) {
			str2=str2.substring(3);
		}
		
		str1=str1.toLowerCase();    //solving problems of FAQ,... every words with upper case
		str2=str2.toLowerCase();
		
        return str1.compareTo(str2);
	}

	
}

