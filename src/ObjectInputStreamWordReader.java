import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputStreamWordReader implements WordReaderInterface
{

	private final ObjectInputStream in;

	public ObjectInputStreamWordReader(ObjectInputStream theIn)
	{
		this.in = theIn;
	}
	
	@Override
	public Word readWord() throws IOException
	{
		try
		{
			return (Word) this.in.readObject();
		}
		catch (EOFException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw new IOException();
		}
	}

	@Override
	public List<Word> readWords() throws IOException
	{
		try
		{
			this.in.readObject();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Word> result = new ArrayList<Word>();
		
		while (true)
		{
			Word wordRead = this.readWord();
			if (wordRead == null) return result;
			result.add(wordRead);
		}
	}

}
