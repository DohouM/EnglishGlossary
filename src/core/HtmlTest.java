package core;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * A class to describe an HTML page, used for the tests.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.4
 */
public class HtmlTest {

    /**
     * The list of Word to pick words from.
     */
    private List<Word> wordsToPickFrom;

    /**
     * Number of words in test.
     */
    private int numberOfWords;
    /**
     * The title of the html page.
     */
    private String title;
    /**
     * The subject of the html page (can be either subject A or subject B)
     */
    private int subject;
    /**
     * The points value (is it worth 5 points on maybe 6, 10... etc)
     */
    private int pointsValue;

    /**
     * All the words in french that must be translated in english in the test.
     */
    private List<String> wordsInFrench;
    /**
     * All the words in english that must be translated in french in the test.
     */
    private List<String> wordsInEnglish;
    
    /**
     * The file to save.
     */
    private File fileToSave;

    /**
     * Constructor of HtmlTest.
     * 
     * @param wordList The list of Words to put in the generated test.
     * @param pv The value in points of the test.
     * @param nw The number of words in the test.
     * @param subjectNumber The subject number of the test.
     * @param fileToSave The file to save the test in.
     */
    public HtmlTest(List<Word> wordList, int pv, int nw, int subjectNumber, File fileToSave) {
	this.wordsToPickFrom = wordList;
	this.pointsValue = pv;
	this.numberOfWords = nw;
	this.subject = subjectNumber;
	this.fileToSave=fileToSave;
    }

    /**
     * Generate a random HashMap with words in french and english.
     */
    private HashMap<String, Integer> generateRandomWordsArrangement() {
	HashMap<String, Integer> wordsToPutInTest = new HashMap<String, Integer>();
	Random r = new Random();
	int currentRandom = r.nextInt(2);
	int loopTurn = 0;
	for (Word w : this.wordsToPickFrom) {
	    if (loopTurn != this.numberOfWords) {
		if (currentRandom == 1) {
		    wordsToPutInTest.put(w.getEnglishWord(), new Integer(currentRandom));
		} else {
		    wordsToPutInTest.put(w.getFrenchWord(), new Integer(currentRandom));
		}
	    } else {
		break;
	    }
	    currentRandom = r.nextInt(2);
	    loopTurn++;
	}
	return wordsToPutInTest;
    }
    /**
     * Generate an english glossary test  in html format, so that it can be printed.
     */
    public void generateTestFile() {
	HashMap<String, Integer> wordsInTest = this.generateRandomWordsArrangement();
	File fileOut = new File(this.fileToSave.getAbsoluteFile()+".html");
	String htmlOut = null;
	htmlOut = "<html style=\"text-align: center;\"><head><meta charset=\"ISO-8859-1\"></head><body><h1>Subject " + this.subject + "</h1><br/><h3>Note :   /" + this.pointsValue + "</h3><br/><table>";
	for (Entry<String, Integer> entry : wordsInTest.entrySet()) {
	    String key = entry.getKey();
	    Integer value = entry.getValue().intValue();
	    if (value == 1) {
		htmlOut += "<tr><td>" + key + "</td><td></td></tr>";
	    } else {
		htmlOut += "<tr><td></td><td>" + key + "</td></tr>";
	    }
	}
	htmlOut += "</table></body>";
	htmlOut += "<style>table, th, td {border: 1px solid black; border-collapse: collapse; margin-left: auto; margin-right: auto;}</style></html>";
	if(fileOut.exists()) {
	    fileOut.delete();
	}
	try {
	    fileOut.createNewFile();
	    FileOutputStream fos = new FileOutputStream(fileOut);
	    for(char c: htmlOut.toCharArray()) {
		fos.write(c);
	    }
	    fos.close();
	} catch (IOException e) {
	    e.printStackTrace();
	    JOptionPane.showMessageDialog(null, "Issue while generating file... Aborting operation.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
	JOptionPane.showMessageDialog(null, "file generated !");
    }
}
