package core;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {


    /**
     * A method to convert a String into hexadecimal.
     * 
     * @param source The string to convert
     * @return The converted String object.
     */
    public static String toHexa(String source) {
	return toHexaHelp(source.getBytes());
    }

    public static String toHexaHelp(byte[] source) {
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
    public static String toMD5Hash(String source) {
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
     * @param finalPassWord The password that testPassword must be equal to.
     * @return <code>true</code> if the hashes are equals, <code>false</code>
     *         otherwise.
     */
    public static boolean comparable(String testPassWord, String finalPassWord) {
	String testPassWordV2 = toHexa(testPassWord);

	String finalTestPassWord = toMD5Hash(testPassWordV2);

	if (finalTestPassWord.compareTo(finalPassWord) == 0)
	    return true;
	else
	    return false;
    }
}



