package misc;

import core.Glossary;
import core.Word;
import exceptions.GlossaryError;
import junit.framework.TestCase;

/**
 * A set of test cases, to ensure that the vital functions of the application
 * are working.
 */
public class GlossaryTest extends TestCase {

	public void testGlossary() throws GlossaryError {
		Word RA = new Word("Hello", "Bonjour");
		Word BadResult = new Word("1", "1");
		Glossary Test1 = new Glossary();
		assertEquals(RA.equals(Test1.search("Hello")), false);
		Test1.addWordStringOnly("Hello", "Bonjour");
		assertEquals(Test1.search("Hello").toString(), RA.toString());
		assertEquals(Test1.numberOfPages(), 1);
		assertNotSame(Test1.search("Hello").toString(), BadResult.toString());
		assertNotSame(Test1.numberOfPages(), 5);
		Test1.removeWord(RA);
		assertEquals(RA.equals(Test1.search("Hello")), false);
		Test1.addWordGlossary(RA);
		assertEquals(Test1.search("Hello").toString(), RA.toString());
		assertNotSame(Test1.search("Hello").toString(), BadResult.toString());
		Test1.removeWord(RA);
		assertEquals(RA.equals(Test1.search("Hello")), false);
	}
}
