package core;

import java.util.Collections;
import java.util.List;

public class QuizGenerator {

	public QuizGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public List <Word> generate(int spinnerStart,int spinnerEnd, Boolean mandatory){
		List <Word> WordList = Main.glossary.pages((int) spinnerStart,
			    (int) spinnerEnd);

		    if (mandatory) {

			WordList = Main.glossary.pagesMandatory((int) spinnerStart,
				(int) spinnerEnd);
		    }

		    Collections.shuffle(WordList); // randomize word list
		    return WordList;
	}

}
