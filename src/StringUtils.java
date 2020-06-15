import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}
	
	  /**
     * A method to convert a String into hexadecimal.
     * 
     * @param source The string to convert
     * @return The converted String object.
     */
    public String toHexa(String source) {
	return toHexaHelp(source.getBytes());
    }

    public String toHexaHelp(byte[] source) {
	StringBuilder sb = new StringBuilder();

	for (byte b : source) {
	    String toAppend = String.format("%2X", b).replace(" ", "0");
	    sb.append(toAppend);
	}

	return sb.toString();
    }

    /**
     * A method to get the MD5 hash of a string.
     * 
     * @param source The String object to get the MD5 hash from.
     * @return The MD5 hash of the string.
     */
    public String toMD5Hash(String source) {
	String result = "";

	try {
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    byte[] md5HashBytes = md5.digest(source.getBytes());

	    result = toHexaHelp(md5HashBytes);
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}

	return result;
    }

    /**
     * A method to compare the hashed password to the hard coded
     * <code>finalPassword</code> hash.
     * 
     * @param testPassWord The password to compare
     * @return <code>true</code> if the hashes are equals, <code>false</code>
     *         otherwise.
     */
    public boolean comparable(String testPassWord, String finalPassWord) {
	String testPassWordV2 = toHexa(testPassWord);

	String finalTestPassWord = toMD5Hash(testPassWordV2);

	if (finalTestPassWord.compareTo(finalPassWord) == 0)
	    return true;
	else
	    return false;
    }
}



