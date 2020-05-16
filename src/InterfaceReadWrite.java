import java.util.ArrayList;

public interface InterfaceReadWrite {
	public ArrayList<Word> read(String path);
	public void write(ArrayList<Word> list, String path);
}
