package core;

import java.io.IOException;

import gui.EnglishGlossaryGUI;

/**
 * Main class of the program, contains Main function, which is the core of the
 * app.
 */

public class Main {
	public static Glossary glossary;

	/**
	 * Main function of the program, holds all the vital functionalities.
	 * 
	 * @param args useless here.
	 */
	public static void main(String[] args) {

		try {
			new EnglishGlossaryGUI(glossary);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

	}

}
