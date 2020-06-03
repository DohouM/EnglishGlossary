import java.io.IOException;

/**
 * Main class of the program, contains Main function, which is the core of the
 * app.
 * 
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.5
 */

public class Main {
    public static Glossary glossary; 

    /**
     * Main function of the program, launches every vital function of it.
     * 
     * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
     *         PIGEYRE, Medhy DOHOU
     */
    /**
     * Main function of the program, holds all the vital functionalities.
     * 
     * @param args useless here.
     */
    public static void main(String[] args) {
//		Glossary glossary = new Glossary();
//		FilesDrivers.readCsv(glossary);
//		SerealizationDriver.serealizeGlossary(glossary.getGlossary());

    	CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("words.ser");
		try
		{
			glossary= new Glossary(readWrite.importWords());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//glossary.addWordStringOnly("Hello*", "bonjour");
		
		 
		for(Word w: glossary.pages(1,6))
		{
		if (w.isMandatory()) {
		  System.out.println( w.toString());
		}
		}
		System.out.println(glossary.getGlossary().size());
		System.out.println(glossary.numberOfPages());
		System.out.println(glossary.search("cl� USB"));
		new ApplicationContext(glossary);

    }

}
