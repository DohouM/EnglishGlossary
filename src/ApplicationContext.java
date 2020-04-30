
public class ApplicationContext{
	/**
	 * @param glossary
	 */
	private static Glossary glossary;
	
	public ApplicationContext(Glossary glossary) {
		super();
		ApplicationContext.glossary = glossary;
		new Windows();
	}


	/**
	 * @return the glossary
	 */
	public static Glossary getGlossary() {
		return glossary;
	}

	/**
	 * @param glossary the glossary to set
	 */
	public void setGlossary(Glossary glossary) {
		ApplicationContext.glossary = glossary;
	}
	
}