
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;;

/**
 * 
 */

/**
 * @author jcl
 *
 */
public class Glossary {
	
	public String pathToCsv = ; // path to access csv file
	
	BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
	while ((row = csvReader.readLine()) != null) {
	    String[] data = row.split(",");
	    // do something with the data
	}
	csvReader.close();

	
	
	
	
	public void sort(){
		
	}
}
