/**
 * A class that describe the context of the app, meaning it's core objects/parameters.
 * @author Jean-Camille LAPIERRE, Dorian MOUNIER, Gabriel SAPONARA, Cyril
 *         PIGEYRE, Medhy DOHOU
 * @version 1.2
 */
public class ApplicationContext{
	/**
	 * The glossary used by the running application.
	 */
	private static Glossary glossary;
	
	/**
	 * A constructor for the ApplicationContext.
	 * @param glossary The glossary the app will use.
	 */
	public ApplicationContext(Glossary glossary) {
		super();
		ApplicationContext.glossary = glossary;
		new Windows();
	}


	/**
	 * A getter for the glossary of the current running application.
	 * @return glossary The current glossary the app is using.
	 */
	public static Glossary getGlossary() {
		return glossary;
	}

	/**
	 * A setter for current application.
	 * @param glossary The glossary to set.
	 */
	public void setGlossary(Glossary glossary) {
		ApplicationContext.glossary = glossary;
	}
	
}