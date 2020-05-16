import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FilesDrivers implements InterfaceReadWrite{
	
	 /**
	 * 
	 */
	public FilesDrivers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Word> read(String path) { //reading of csv files
		  BufferedReader reader = null;
		  ArrayList<Word> list = new ArrayList<Word>();
		  try {
		   String line = "";
		   reader = new BufferedReader(new FileReader(path));  //data.csv
		   reader.readLine();
		   
		   while((line = reader.readLine()) != null) {
		    String[] fields = line.split(";");
		    
		    if(fields.length > 0) {
				// insert in tab //
				Word word= new Word(fields[0],fields[1]);
				list.add(word);	
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
	return list;
}

	@Override
	public void write(ArrayList<Word> list,String path) {
		// TODO Auto-generated method stub
		
	}

}