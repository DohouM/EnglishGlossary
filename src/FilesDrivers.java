import java.io.BufferedReader;
import java.io.FileReader;

public class FilesDrivers {
	
	 public static void readCsv(Glossary glossary) {
		  BufferedReader reader = null;
		  
		  try {
		   String line = "";
		   reader = new BufferedReader(new FileReader("data.csv"));
		   reader.readLine();
		   
		   while((line = reader.readLine()) != null) {
		    String[] fields = line.split(";");
		    
		    if(fields.length > 0) {
				// insert in tab //
				Word word= new Word(fields[0],fields[1]);
				glossary.addWordGlossary(word);	
		    }
		   }
		   
		   
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  } finally {
		   try {
		    reader.close();
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
}
}