import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TestSerialization
{

	public static void main(String[] args)
	{
		String path = "words.ser";
		try
		{
			FileInputStream fin = new FileInputStream(new File(path));
			ObjectInputStream oin = new ObjectInputStream(fin);
			ObjectInputStreamWordReader win = new ObjectInputStreamWordReader(oin);
			List<Word> words = win.readWords();
			System.out.println(words.size());
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
