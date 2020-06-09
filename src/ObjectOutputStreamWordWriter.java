import java.io.IOException;
import java.io.ObjectOutputStream;

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
     * The ObjectInputStream to write <code>Word</code> objects into.
     */
    private final ObjectOutputStream out;

    /**
     * The constructor of the class.
     * 
     * @param theOut the ObjectInputStream to write <code>Word</code> objects into.
     */
    public ObjectOutputStreamWordWriter(ObjectOutputStream theOut) {
	this.out = theOut;
    }

    /**
     * A method to write one Word object from <code>in</code>.
     * @throws IOException The stream is closed/doesn't read a Word object.
     */
    public void writeWord(Word theWord) throws IOException {
    	this.out.writeObject(theWord);
    }
}
