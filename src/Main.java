

public class Main {
	public static Glossary glossary = new Glossary();
	
	public static void main(String[] args) {
//		Glossary glossary = new Glossary();
//		FilesDrivers.readCsv(glossary);
//		SerealizationDriver.serealizeGlossary(glossary.getGlossary());
		
		
		
		glossary.setGlossary(SerealizationDriver.deSerealizeGlossary());

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
		
		System.out.println(Windows.comparable("admin"));
		System.out.println(Windows.comparable("kebab"));
	}

}
