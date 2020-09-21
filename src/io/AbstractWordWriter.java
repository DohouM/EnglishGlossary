package io;

import java.io.IOException;
import java.util.List;

import core.Word;
import core.WordWriterInterface;

/**
 * An object that'll write <code>Word</code> objects to ObjectOutputStream
 * <code>in</code>.
 */
public abstract class AbstractWordWriter implements WordWriterInterface {

	/**
	 * {@inheritDoc}
	 */
	public void writeWords(List<Word> theWords) throws IOException {
		for (Word theWord : theWords)
			this.writeWord(theWord);
	}
}
