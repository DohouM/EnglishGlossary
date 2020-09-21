package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import core.Word;

//DONE javadoc
/**
 * A class to export and import words form a serialized file.
 */
public class CsvFileSerializationDriver {
	/**
	 * The path to the serialized file (relative).
	 */
	private String path;

	/**
	 * Constructor of the class.
	 * 
	 * @param thePath See {@link #path}.
	 */
	public CsvFileSerializationDriver(String thePath) {
		this.path = thePath;
	}

	/**
	 * A method to write a <code>List&lt;Word&gt;</code> into the serialized file
	 * stored at {@link #path}.
	 * 
	 * @param theWords The <code>List&lt;Word&gt;</code> to write.
	 * @throws IOException If there's an issue with the file.
	 */
	public void exportWords(List<Word> theWords) throws IOException {
		PrintStream outStream = new PrintStream(this.path, "ISO-8859-1");
		CsvWordWriter wordWriter = new CsvWordWriter(outStream);
		wordWriter.writeWords(theWords);
		outStream.close();
	}

	/**
	 * A method to get a <code>List&lt;Word&gt;</code> from the serialized file
	 * stored at {@link #path}.
	 * 
	 * @return The <code>List&lt;Word&gt;</code> read from the serialized file
	 *         stored at {@link #path}.
	 * @throws IOException If there's an issue with the file.
	 */
	public List<Word> importWords() throws IOException {
		BufferedReader inReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(this.path), "ISO-8859-1"));
		CsvWordReader worReader = new CsvWordReader(inReader);
		List<Word> theWords = worReader.readWords();
		inReader.close();
		return theWords;
	}
}
