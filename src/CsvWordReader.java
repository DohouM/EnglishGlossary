import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class made to read Words object from CSV file, with a specific format.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class CsvWordReader implements WordReaderInterface {


	//TODO javadoc
    private final BufferedReader in;

    public CsvWordReader(BufferedReader theIn) {
	this.in = theIn;
    }

    @Override
    public Word readWord() throws IOException {
	try {
	    return Word.parseFromCSV(this.in.readLine());
	} catch (Exception e) {
	    throw new IOException();
	}
    }

    @Override
    public List<Word> readWords() throws IOException {
	List<Word> result = new ArrayList<Word>();

	while (true) {
	    Word wordRead = this.readWord();
	    if (wordRead == null)
		return result;
	    result.add(wordRead);
	}
    }

}
