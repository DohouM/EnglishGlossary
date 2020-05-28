import java.util.ArrayList;

/**
 * An interface that describes the different methods for reading/writing in
 * files, be it serialized or CSV.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.0
 *
 */
public interface InterfaceReadWrite {
    /**
     * Read the glossary from file at <code>path</code> argument. 
     * @param path The path to the file to read
     * @return The glossary that was contained in the file.
     */
    public ArrayList<Word> read(String path);

    /**
     * Write the <code>list</code> ArrayList of words into the file at <code>path</code>.
     * @param list The list of Words to write in the file.
     * @param path The path to the file to write in.
     */
    public void write(ArrayList<Word> list, String path);
}
