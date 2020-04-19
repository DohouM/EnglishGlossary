
public class Main {
	public static void main(String[] args) {
//		Glossary glossary = new Glossary();
//		FilesDrivers.readCsv(glossary);
//		SerealizationDriver.serealizeGlossary(glossary.getGlossary());
		Glossary glossary = new Glossary();
		glossary.setGlossary(SerealizationDriver.deSerealizeGlossary());
		
		for(Word w: glossary.getGlossary())
		{
		  System.out.println( w.toString());
		}
		System.out.println(glossary.getGlossary().size());
		new Windows();
	
	}
	public void modifierGlaussaire() {
		
	}
}
