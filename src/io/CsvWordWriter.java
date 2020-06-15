package io;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import core.Word;

/**
 * A class made to write Word objects to CSV file, with a specific format.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class CsvWordWriter extends AbstractWordWriter {


    /**
     * The stream to store the CSV formatted word(s).
     */
    private final PrintStream out;
    
    /**
     * Constructor of the class.
     * @param theOut The <code>PrintStream</code> to store the CSV formatted word(s).
     */
    public CsvWordWriter(PrintStream theOut) {
	this.out = theOut;
    }

    /**
     * {@inheritDoc}
     * In this case, write a <code>Word</code> object into the <code>out</code> attribute, in CSV format. (frenchWord;englishWord)
     */
    public void writeWord(Word theWord) throws IOException {	
	    this.out.println(theWord.toCSVString());	
    }
}
