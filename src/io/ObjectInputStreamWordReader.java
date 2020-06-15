package io;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import core.Word;
import core.WordReaderInterface;

/**
 * An object that'll read <code>Word</code> objects from ObjectInputStream
 * <code>in</code>.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 *
 */
public class ObjectInputStreamWordReader implements WordReaderInterface {
    /**
     * The ObjectInputStream to read Word objects from.
     */
    private final ObjectInputStream in;

    /**
     * The constructor of the class.
     * 
     * @param theIn the ObjectInputStream to read Word objects from.
     */
    public ObjectInputStreamWordReader(ObjectInputStream theIn) {
	this.in = theIn;
    }

    /**
     * A method to read one Word object from <code>in</code>.
     * @return The word read by the <code>in</code> attribute.
     * @throws IOException The stream is closed/doesn't read a Word object.
     */
    public Word readWord() throws IOException {
	try {
	    return (Word) this.in.readObject();
	} catch (EOFException e) {
	    return null;
	} catch (Exception e) {
	    throw new IOException();
	}
    }

    /**
     * A method to read all Word objects from <code>in</code>.
     * @return The List of Word objects read by the <code>in</code> attribute.
     * @throws IOException The stream is closed/doesn't read a Word object.
     */
    public List<Word> readWords() throws IOException {
	try {
	    this.in.readObject();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	List<Word> result = new ArrayList<Word>();

	while (true) {
	    Word wordRead = this.readWord();
	    if (wordRead == null)
		return result;
	    result.add(wordRead);
	}
    }

}
