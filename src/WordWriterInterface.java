import java.io.IOException;
import java.util.List;

public interface WordWriterInterface
{
	public void writeWord(Word word) throws IOException;
	public void writeWords(List<Word> words) throws IOException;
}
