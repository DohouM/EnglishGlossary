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
     * {@inheritDoc}
     */
    public void writeWords(List<Word> theWords) throws IOException {
    	for (Word theWord: theWords)
    		this.writeWord(theWord);
    }
}
