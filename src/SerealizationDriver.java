import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerealizationDriver {
	public static void main(String[] args) {
//		Word hello = new Word("hello", "bonjour");
//		try {
//			FileOutputStream fos = new FileOutputStream("word.ser");
//
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//			oos.writeObject(hello);
//			oos.close();

//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			FileInputStream fis = new FileInputStream("word.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);

			Word word1 =(Word) ois.readObject();
			ois.close();
			System.out.println(word1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
