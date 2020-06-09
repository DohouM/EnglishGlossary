import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class made to read Words object from CSV file, with a specific format. (frenchWord;englishWord)
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class CsvWordReader implements WordReaderInterface {


    /**
     * The <code>BufferedReader</code> to read lines from.
     */
    private final BufferedReader in;
    /**
     * The current read string from the {@link #in} attribute.
     */
    private String stringRead;

    /**
     * Constructor of the class.
     * @param theIn See {@link #in}.
     */
    public CsvWordReader(BufferedReader theIn) {
	this.in = theIn;
    }

    /**
     * The method to read a single word from the {@link #stringRead} attribute.
     */
    public Word readWord() throws IOException {
	try {
	    return Word.parseFromCSV(stringRead);
	} catch (Exception e) {
	    throw new IOException();
	}
    }

    /**
     * The method to read the words from the {@link #in} attribute. Read a line in the {@link #in}, store it
     * in the {@link #stringRead} attribute, and parse it with {@link #readWord()}.
     */
    public List<Word> readWords() throws IOException {
	List<Word> result = new ArrayList<Word>();

	while (true) {
	    stringRead = this.in.readLine();
	    if(stringRead==null)
		return result;
	    Word wordRead = this.readWord();
	    
	    result.add(wordRead);
	}
    }

}
