package core;

public class Password_Check {
	
	 private static final String finalPassWord = "938227684C1200009DF4A4E2067D934E";
	
    /**
     * A method to compare the hashed password to the hard coded
     * <code>finalPassword</code> hash.
     * 
     * @param testPassWord The password to compare
     * @param finalPassWord The password that testPassword must be equal to.
     * @return <code>true</code> if the hashes are equals, <code>false</code>
     *         otherwise.
     */
    public static boolean comparable(String testPassWord) {
	String testPassWordV2 = StringUtils.toHexa(testPassWord);

	String finalTestPassWord = StringUtils.toMD5Hash(testPassWordV2);

	if (finalTestPassWord.compareTo(finalPassWord) == 0)
	    return true;
	else
	    return false;
    }

}
