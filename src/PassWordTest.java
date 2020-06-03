
import junit.framework.TestCase;

public class PassWordTest extends TestCase {
	
	public void testMDP() throws PassWordInvalide {
		String Test1 = "admin";
		Test1 = Windows.toHexa(Test1);
		assertEquals(Windows.toMD5Hash(Test1), "938227684C1200009DF4A4E2067D934E");
		String Test2 = "Admin";
		Test2 = Windows.toHexa(Test2);
		assertNotSame(Windows.toMD5Hash(Test2), "938227684C1200009DF4A4E2067D934E");
		String Test3 = "dfqhudjk";
		Test3 = Windows.toHexa(Test3);
		assertNotSame(Windows.toMD5Hash(Test3), "938227684C1200009DF4A4E2067D934E");
		
		
	}

}
