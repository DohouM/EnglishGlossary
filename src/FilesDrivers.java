import java.io.BufferedReader;
import java.io.FileReader;

public class FilesDrivers implements InterfaceReadWrite{
	
	 /**
	 * 
	 */
	public FilesDrivers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Glossary read(String path) { //reading of csv files
		  BufferedReader reader = null;
		  Glossary glossary = new Glossary();
		  try {
		   String line = "";
		   reader = new BufferedReader(new FileReader(path));  //data.csv
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
	return glossary;
}

	@Override
	public void write(Glossary glossary,String path) {
		// TODO Auto-generated method stub
		
	}

}