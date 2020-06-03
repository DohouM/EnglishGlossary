import java.io.Serializable;


/**
 * An class that describes a word in the glossary.
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */
public class Word implements Serializable, Comparable<Word>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The english translation of the word.
	 */
	private String englishWord;
	/**
	 * The french translation of the word.
	 */
	private String frenchWord;
	
	
	
	/**
	 * The constructor of the Word class.
	 * @param englishWord The english translation of the word.
	 * @param frenchWord The french translation of the word.
	 */
	public Word(String englishWord, String frenchWord) {
		super();
		this.englishWord = englishWord;
		this.frenchWord = frenchWord;
	}
	
	/**
	 * A getter for the <code>englishWord</code> attribute of the current object.
	 * @return the <code>englishWord</code> attribute of the current object.
	 */
	public String getEnglishWord() {
		return englishWord;
	}
	/**
	 * A getter for the <code>englishWord</code> attribute of the current object, but without the mandatory asterisk.
	 * @return the <code>englishWord</code> attribute of the current object without the mandatory asterisk.
	 */
	public String getEnglishWordWithoutMark() {
		if (this.isMandatory()) {
			return englishWord.replaceAll("\\*","");
		}
		return englishWord;
	}
	/**
	 * A setter for the <code>englishWord</code> attribute.
	 * @param englishWord the englishWord to set
	 */
	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}
	/**
	 * A getter for the <code>frenchWord</code> attribute of the current object.
	 * @return the frenchWord
	 */
	public String getFrenchWord() {
		return frenchWord;
	}
	/**
	 * * A setter for the <code>frenchWord</code> attribute.
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
		String str1 =this.englishWord;
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
	
	public boolean isMandatory(){
		if (englishWord.contains("*")) {
		    return true;
		} 
		return false;
	}
	/**
	 * A method to parse a word object from a String object <code>readLine</code>, which is a line of a CSV file.
	 * @param readLine The line read from the CSV.
	 * @return The Word object created from parsed line <code>readLine</code>.
	 */
	public static Word parseFromCSV(String readLine) {
	    Word wordRead = null;
	    String[] parsedData = readLine.split(";");
	    wordRead = new Word(parsedData[0], parsedData[1]);
	    return wordRead;
	}

	public String toCSVString()
	{
		return this.englishWord+";"+this.frenchWord;
	}
	
}

