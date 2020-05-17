import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * A class to describe an HTML page, used for the tests.
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE, Gabrtiel SAPONARA
 * @version 1.0
 */
public class HtmlTest {
    
    /**
     * The glossary to pick words from.
     */
    Glossary glossary;
    
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
     * The marking scheme (is it worth 5 points on maybe 6, 10... etc
     */
    String markingScheme;
    
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
     * @param glos : the glossary to pick words from.
     */
    public HtmlTest(Glossary glos) {
	this.glossary = glos;
    }
    /**
     * Generate a random HashMap with words in french and english.
     */
    private void generateRandomWordsArrangement() {
	HashMap<String, Integer> wordsToPutInTest = new HashMap<String, Integer>();
	Random r = new Random();
	int currentRandom = r.nextInt(2);
	for(Word w: glossary.getGlossary()) {
	    if(currentRandom==1) {
		wordsToPutInTest.put(w.getEnglishWord(), new Integer(currentRandom));
	    }
	    else {
		wordsToPutInTest.put(w.getFrenchWord(), new Integer(currentRandom));
	    }
	    currentRandom = r.nextInt(2);
	}
    }
    
}
