package core;

import java.util.List;

import gui.SaveFileDialog;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * A class to modelize a glossary Test.
 * @author Medhy DOHOU
 *
 */

public class Test {

    /**
     * The List of words that can end in the test.
     */
    private List<Word> listOfWords;
    /**
     * The value in points of the test
     */
    private int valueOfTest;
    /**
     * The number of words in the test.
     */
    private int numberOfWords; 
    
    /**
     * The number of the subject. (Subject 1, Subject 2....).
     */
    private int subjectId;
    
    /**
     * 
     * @param listToPickFrom The words to pick from.
     * @param initialValue The value of the test.
     * @param initialNumOfWords	The number of words in the test.
     * @param initialId The initial number of subject.
     */
    public Test(List<Word> listToPickFrom, int initialValue, int initialNumOfWords, int initialId) {
	this.listOfWords = listToPickFrom;
	this.valueOfTest = initialValue;
	this.numberOfWords = initialNumOfWords;
	this.subjectId = initialId;
    }

    

    /**
     * Export test to an html file.
     * 
     * @param listOfWords   The list of words to pick the words from.
     * @param valueOfTest   The value of test in points.
     * @param numberOfWords The number of words into the test
     * @param subjectId     The number of the test (Subject One, Subject 2 , etc...)
     */

    public void exportTest() {
	SaveFileDialog savefile = new SaveFileDialog();

	HtmlTest testToExport = new HtmlTest(this.listOfWords, this.valueOfTest, this.numberOfWords, this.subjectId, savefile.getFile());
	testToExport.generateTestFile();

    }

}
