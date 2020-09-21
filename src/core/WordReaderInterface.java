package core;

import java.io.IOException;
import java.util.List;

/**
 * An interface for Word objects readers.
 */
public interface WordReaderInterface {
	/**
	 * A method to read a word.
	 * 
	 * @return the Word object read.
	 * @throws IOException An error occurred while reading/trying to read the
	 *                     object.
	 */
	public Word readWord() throws IOException;

	/**
	 * A method to read multiple words.
	 * 
	 * @return the List of read Word objects.
	 * @throws IOException An error occurred while reading/trying to read the
	 *                     objects.
	 */
	public List<Word> readWords() throws IOException;
}
