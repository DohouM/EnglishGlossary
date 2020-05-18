import java.io.IOException;
import java.util.List;

public interface WordReaderInterface
{
	public Word readWord() throws IOException;
	
	public List<Word> readWords() throws IOException;
}
