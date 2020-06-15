package misc;

import exceptions.PassWordInvalide;
import junit.framework.TestCase;
import core.StringUtils;
/**
 * A set of test to try out the password checking function.
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.0
 *
 */
public class PassWordTest extends TestCase {
	/**
	 * The method of test for the password checking method.
	 * @throws PassWordInvalide If the password is invalide.
	 */
	public void testMDP() throws PassWordInvalide {
		String Test1 = "admin";
		Test1 = StringUtils.toHexa(Test1);
		assertEquals(StringUtils.toMD5Hash(Test1), "938227684C1200009DF4A4E2067D934E");
		String Test2 = "Admin";
		Test2 = StringUtils.toHexa(Test2);
		assertNotSame(StringUtils.toMD5Hash(Test2), "938227684C1200009DF4A4E2067D934E");
		String Test3 = "dfqhudjk";
		Test3 = StringUtils.toHexa(Test3);
		assertNotSame(StringUtils.toMD5Hash(Test3), "938227684C1200009DF4A4E2067D934E");
		
		
	}

}

