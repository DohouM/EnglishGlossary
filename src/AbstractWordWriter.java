import java.io.IOException;
import java.util.List;

/**
 * An object that'll write <code>Word</code> objects to ObjectOutputStream
 * <code>in</code>.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public abstract class AbstractWordWriter implements WordWriterInterface {
   
    /**
     * A method to read all Word objects from <code>in</code>.
     * @return The List of Word objects read by the <code>in</code> attribute.
     * @throws IOException The stream is closed/doesn't read a Word object.
     */
    public void writeWords(List<Word> theWords) throws IOException {
    	for (Word theWord: theWords)
    		this.writeWord(theWord);
    }
}
