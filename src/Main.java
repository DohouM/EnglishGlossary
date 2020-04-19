
public class Main {
	public static void main(String[] args) {
		Glossary glossary = new Glossary();
		FilesDrivers.readCsv(glossary);
		
		for(Word w: glossary.getGlossary())
		{
		  System.out.println( w.toString());
		}
		new Windows();
	
	}
	public void modifierGlaussaire() {
		
	}
}
