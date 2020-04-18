import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerealizationDriver {
	
	public static void serealizeTabWord(Word[] words) {
		try {
		FileOutputStream fos = new FileOutputStream("words.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(words);
		oos.close();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static Word[] deSerealizeTabWord() {
		
		try {
			FileInputStream fis = new FileInputStream("words.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);

			Word[] words =(Word[]) ois.readObject();
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
