import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

//TODO javadoc
public class CsvFileSerializationDriver 
{
	private String path;
	
	public CsvFileSerializationDriver(String thePath)
	{
		this.path = thePath;
	}
	
	public void exportWords(List<Word> theWords) throws IOException
	{
		PrintStream outStream = new PrintStream(this.path, "ISO-8859-1");
		CsvWordWriter wordWriter = new CsvWordWriter(outStream);
		wordWriter.writeWords(theWords);
		outStream.close();
	}
	
	public List<Word> importWords() throws IOException
	{
		BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.path), "ISO-8859-1"));
		CsvWordReader worReader = new CsvWordReader(inReader);
		List<Word> theWords = worReader.readWords();
		inReader.close();
		return theWords;
	}
}
