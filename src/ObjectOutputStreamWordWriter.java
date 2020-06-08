import java.io.IOException;
import java.io.ObjectOutputStream;



//TODO javadoc (rewrite, copy/pasted from OISWW)
/**
 * An object that'll write <code>Word</code> objects to ObjectOutputStream
 * <code>in</code>.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class ObjectOutputStreamWordWriter extends AbstractWordWriter {
    /**
     * The ObjectInputStream to read Word objects from.
     */
    private final ObjectOutputStream out;

    /**
     * The constructor of the class.
     * 
     * @param theIn the ObjectInputStream to read Word objects from.
     */
    public ObjectOutputStreamWordWriter(ObjectOutputStream theOut) {
	this.out = theOut;
    }

    /**
     * A method to read one Word object from <code>in</code>.
     * @return The word read by the <code>in</code> attribute.
     * @throws IOException The stream is closed/doesn't read a Word object.
     */
    public void writeWord(Word theWord) throws IOException {
    	this.out.writeObject(theWord);
    }
}
