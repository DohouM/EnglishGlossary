package core;

import java.util.Collections;
import java.util.List;

import gui.SaveFileDialog;
/**
 * A class that stores methods to generate and manipulate a random quiz.
 * @author Medhy DOHOU
 *
 */
public class QuizGenerator {
	/**
	 * Generate a random set of words.
	 * @param spinnerStart The first page to fetch in glossary.
	 * @param spinnerEnd The last page to fetch in glossary.
	 * @param mandatory A boolean to know if the list should only include mandatory words.
	 * @return A random List of Word objects between page at spinnerStart and page at spinnerEnd
	 */
	public static List <Word> generate(int spinnerStart,int spinnerEnd, Boolean mandatory){
		List <Word> WordList = Main.glossary.pages((int) spinnerStart,
			    (int) spinnerEnd);

		    if (mandatory) {

			WordList = Main.glossary.pagesMandatory((int) spinnerStart,
				(int) spinnerEnd);
		    }

		    Collections.shuffle(WordList); // randomize word list
		    return WordList;
	}
	
	/**
	 * A method to pick random Word objects from a <code>List&lt;Word&gt;</code>.
	 * @param listToPickFrom The <code>List&lt;Word&gt;</code> to pick Word objects from.
	 * @param numberOfWordsToPick The number of Word to pick in the <code>listToPickFrom</code> param.
	 * @return A 2 dimensional string array representing the words picked, and their french equivalent.
	 */
	public static String[][] randomPick(List<Word> listToPickFrom, int numberOfWordsToPick){
	    String[][] fetchedWords = new String[numberOfWordsToPick][2];
	    int loopCounter = 0;
	    while (loopCounter < numberOfWordsToPick) {
		fetchedWords[loopCounter][0] = listToPickFrom.get(loopCounter).getFrenchWord();
		fetchedWords[loopCounter][1] = listToPickFrom.get(loopCounter).getEnglishWordWithoutMark();
		loopCounter++;

	    }
	    return fetchedWords;
	    
	}
	
	/**
	 * Export test to an html file.
	 * @param listOfWords The list of words to pick the words from.
	 * @param valueOfTest The value of test in points.
	 * @param numberOfWords	The number of words into the test
	 * @param subjectId The number of the test (Subject One, Subject 2 , etc...)
	 */

	public static void exportTest(List<Word> listOfWords, int valueOfTest, int numberOfWords, int subjectId) {
	    SaveFileDialog savefile = new SaveFileDialog();

	    HtmlTest testToExport = new HtmlTest(listOfWords, valueOfTest, numberOfWords, subjectId, savefile.getFile());
	    testToExport.generateTestFile();
	    
	}

}
