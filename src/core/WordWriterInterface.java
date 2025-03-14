package core;

import java.io.IOException;
import java.util.List;

/**
 * An interface for Word objects writers.
 */
public interface WordWriterInterface {
	/**
	 * A method to write a word.
	 * 
	 * @param word the Word object to write.
	 * @throws IOException An error occurred while writing/trying to write the
	 *                     object.
	 */
	public void writeWord(Word word) throws IOException;

	/**
	 * A method to write a list of words.
	 * 
	 * @param words the Word objects List to write.
	 * @throws IOException An error occurred while writing/trying to write the
	 *                     object.
	 */
	public void writeWords(List<Word> words) throws IOException;
}
