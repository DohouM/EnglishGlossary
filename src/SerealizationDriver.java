import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerealizationDriver implements InterfaceReadWrite{
	
	/**
	 * 
	 */
	public SerealizationDriver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void write(ArrayList<Word> words,String path) { //serealizeGlossary
		try {
		FileOutputStream fos = new FileOutputStream(path); //words.ser

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(words.size());
		for(Word w: words)
		{
			oos.writeObject(w);
		}
		
		oos.close();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public ArrayList<Word> read(String path) {
		
		try {
			FileInputStream fis = new FileInputStream(path); //words.ser

			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ArrayList<Word> words= new ArrayList<Word>();
			int length = (int) ois.readObject();
			for (int i=0;i<length;i++) {
				Word word =(Word) ois.readObject();
				words.add(word);
			}
			ois.close();
		
			return words;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
