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
    public static void main(String[] args) {
//		Glossary glossary = new Glossary();
//		FilesDrivers.readCsv(glossary);
//		SerealizationDriver.serealizeGlossary(glossary.getGlossary());

//    	InterfaceReadWrite interface= new SerealizationDriver();
    	SerealizationDriver ser = new SerealizationDriver();
		glossary= new Glossary(ser.read("words.ser"));

		//glossary.addWordStringOnly("Hello*", "bonjour");
		
		 
		for(Word w: glossary.pages(1,6))
		{
		if (w.isMandatory()) {
		  System.out.println( w.toString());
		}
		}
		System.out.println(glossary.getGlossary().size());
		System.out.println(glossary.numberOfPages());
		System.out.println(glossary.search("clé USB"));
		new ApplicationContext(glossary);

    }

}
