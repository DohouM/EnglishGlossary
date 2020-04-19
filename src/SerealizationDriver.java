import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerealizationDriver {
	
	public static void serealizeGlossary(Glossary glossary) {
		try {
		FileOutputStream fos = new FileOutputStream("glossary.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(glossary);
		oos.close();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static Glossary deSerealizeGlossary() {
		
		try {
			FileInputStream fis = new FileInputStream("glossary.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);

			Glossary glossary =(Glossary) ois.readObject();
			ois.close();
			return glossary;
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
