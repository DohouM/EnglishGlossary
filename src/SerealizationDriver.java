import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerealizationDriver {
	
	public static void serealizeGlossary(ArrayList<Word> words) {
		try {
		FileOutputStream fos = new FileOutputStream("words.ser");

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
	
	public static ArrayList<Word> deSerealizeGlossary() {
		
		try {
			FileInputStream fis = new FileInputStream("words.ser");

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
