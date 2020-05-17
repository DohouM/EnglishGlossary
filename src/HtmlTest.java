import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * A class to describe an HTML page, used for the tests.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.3
 */
public class HtmlTest {

    /**
     * The list of Word to pick words from.
     */
    ArrayList<Word> wordsToPickFrom;

    /**
     * Number of words in test.
     */
    int numberOfWords;
    /**
     * The title of the html page.
     */
    String title;
    /**
     * The subject of the html page (can be either subject A or subject B)
     */
    String subject;
    /**
     * The points value (is it worth 5 points on maybe 6, 10... etc)
     */
    int pointsValue;

    /**
     * All the words in french that must be translated in english in the test.
     */
    List<String> wordsInFrench;
    /**
     * All the words in english that must be translated in french in the test.
     */
    List<String> wordsInEnglish;

    /**
     * Constructor of HtmlTest.
     * 
     * @param glos : the glossary to pick words from.
     */
    public HtmlTest(ArrayList<Word> al, int pv) {
	this.wordsToPickFrom = al;

    }

    /**
     * Generate a random HashMap with words in french and english.
     */
    private HashMap<String, Integer> generateRandomWordsArrangement() {
	HashMap<String, Integer> wordsToPutInTest = new HashMap<String, Integer>();
	Random r = new Random();
	int currentRandom = r.nextInt(2);
	int loopTurn = 1;
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

}
