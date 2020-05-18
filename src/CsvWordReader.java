import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class CsvWordReader implements WordReaderInterface
{

	private final BufferedReader in;

	public CsvWordReader(BufferedReader theIn)
	{
		this.in = theIn;
	}
	
	@Override
	public Word readWord() throws IOException
	{
		try
		{
			return  Word.parseFromCSV(this.in.readLine());
		}
		catch (Exception e)
		{
			throw new IOException();
		}
	}

	@Override
	public List<Word> readWords() throws IOException
	{
		List<Word> result = new ArrayList<Word>();
		
		while (true)
		{
			Word wordRead = this.readWord();
			if (wordRead == null) return result;
			result.add(wordRead);
		}
	}

}
