import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * A class made to write Word objects to CSV file, with a specific format.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class CsvWordWriter extends AbstractWordWriter {


	//TODO javadoc
    private final PrintStream out;

    public CsvWordWriter(PrintStream theOut) {
	this.out = theOut;
    }

    @Override
    public void writeWord(Word theWord) throws IOException {	
	    this.out.println(theWord.toCSVString());	
    }
}
