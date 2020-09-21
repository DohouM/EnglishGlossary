package core;

import java.util.Collections;
import java.util.List;

import gui.EnglishGlossaryGUI;
import gui.FileSaveDialog;

/**
 * A class that stores methods to generate and manipulate a random quiz.
 */
public class Quiz {

	/**
	 * The List of Words to pick the words from.
	 */
	private List<Word> words;

	/**
	 * The result of the Quiz.
	 */
	private Object[] quizResults;
	/**
	 * The array to display in the GUI.
	 */
	private Object[][] table;
	/**
	 * Number of points the quiz is worth.
	 */
	private int score;

	/**
	 * The initial number of words per quiz.
	 */
	private int wordsPerQuiz = 20;

	/**
	 * @param pageStart The first page to pick in the glossary.
	 * @param pageEnd   The last page to pick in the glossary.
	 * @param mandatory Boolean to know if we only pick mandatory words.
	 * 
	 */
	public Quiz(int pageStart, int pageEnd, Boolean mandatory) {
		super();
		this.score = 0;

		this.words = EnglishGlossaryGUI.glossary.pages((int) pageStart, (int) pageEnd);

		if (mandatory) {

			this.words = EnglishGlossaryGUI.glossary.pagesMandatory((int) pageStart, (int) pageEnd);
		}

		Collections.shuffle(this.words); // randomize word list

		this.table = new Object[this.wordsPerQuiz][2];
		this.quizResults = new Object[this.wordsPerQuiz];

		int loopCounter = 0;
		while (loopCounter < this.wordsPerQuiz) {
			this.table[loopCounter][0] = this.words.get(loopCounter).getFrenchWord();
			this.table[loopCounter][1] = "";
			this.quizResults[loopCounter] = this.words.get(loopCounter).getEnglishWordWithoutMark();
			loopCounter = loopCounter + 1;

		}
	}

	/**
	 * Generate a random set of words.
	 * 
	 * @param spinnerStart The first page to fetch in glossary.
	 * @param spinnerEnd   The last page to fetch in glossary.
	 * @param mandatory    A boolean to know if the list should only include
	 *                     mandatory words.
	 * @return A random List of Word objects between page at spinnerStart and page
	 *         at spinnerEnd
	 */

	public Object[][] getTable() {
		return this.table;
	}

	public Object[] getResults() {
		return this.quizResults;
	}

	public Object[] resultChecker(Object[] UserRes) {

		Object[] toDisplay = new Object[this.wordsPerQuiz];

		for (int loopCounter = 0; loopCounter < this.wordsPerQuiz; loopCounter++) {

			if (this.quizResults[loopCounter].equals(UserRes[loopCounter])) {
				toDisplay[loopCounter] = UserRes[loopCounter] + "  ✓";
				this.score++;
			} else if (UserRes[loopCounter] == "") {
				toDisplay[loopCounter] = UserRes[loopCounter] + " // " + this.quizResults[loopCounter] + "  X";
			}
		}
		return toDisplay;
	}

	public int getPoints() {
		return this.score;
	}

	public int getWordPerQuiz() {
		return this.wordsPerQuiz;
	}

	/**
	 * A method to pick random Word objects from a <code>List&lt;Word&gt;</code>.
	 * 
	 * @param listToPickFrom      The <code>List&lt;Word&gt;</code> to pick Word
	 *                            objects from.
	 * @param numberOfWordsToPick The number of Word to pick in the
	 *                            <code>listToPickFrom</code> param.
	 * @return A 2 dimensional string array representing the words picked, and their
	 *         french equivalent.
	 */
	public String[][] randomPick(List<Word> listToPickFrom, int numberOfWordsToPick) {
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
	 * 
	 * @param listOfWords   The list of words to pick the words from.
	 * @param valueOfTest   The value of test in points.
	 * @param numberOfWords The number of words into the test
	 * @param subjectId     The number of the test (Subject One, Subject 2 , etc...)
	 */

	public static void exportTest(List<Word> listOfWords, int valueOfTest, int numberOfWords, int subjectId) {
		FileSaveDialog savefile = new FileSaveDialog();

		HtmlTest testToExport = new HtmlTest(listOfWords, valueOfTest, numberOfWords, subjectId, savefile.getFile());
		testToExport.generateTestFile();

	}

	/**
	 * @return the wordList
	 */
	public List<Word> getWordList() {
		return this.words;
	}

}
