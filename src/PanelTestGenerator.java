import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * A class that describe the Test Generator panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 */

public class PanelTestGenerator extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    /**
     * The SpinnerModel for starting page selection.
     */
    SpinnerModel startPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    ApplicationContext.getGlossary().numberOfPages(), // maximum value
	    1); // step
    /**
     * The JSpinner created from the previously created SpinnerModel
     * <code>startPages</code>.
     */
    JSpinner spinnerStart = new JSpinner(startPages);
    /**
     * The SpinnerModel for ending page selection.
     */
    SpinnerModel endPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    ApplicationContext.getGlossary().numberOfPages(), // maximum value
	    1); // step
    /**
     * The JSpinner created from the previously created SpinnerModel
     * <code>endPages</code>.
     */
    JSpinner spinnerEnd = new JSpinner(endPages);

    // buttons
    JButton btGen = new JButton("Generate");
    JButton btExport = new JButton("Export");

    /**
     * The JLabel placed before the <code>spinnerStart</code> JSpinner object.
     */
    JLabel fromP = new JLabel("From page");
    /**
     * The JLabel placed between the <code>spinnerStart</code> and <code>spinnerEnd</code>
     * JSpinner objects.
     */
    JLabel to = new JLabel("to");
    /**
     * The JLabel that'll hold the points earned by the student.
     */
    JLabel points = new JLabel("");

    /**
     * The JScrollPane that'll hold the JTable that'll store the quiz.
     */
    JScrollPane tab = new JScrollPane();

    /**
     * The JTable that'll hold the quiz.
     */
    JTable tableau;

    /**
     * A JCheckBox to only have mandatory words in the generated test.
     */
    JCheckBox checkbox = new JCheckBox("Only mandatory words(*)");

    /**
     * An array that'll hold the quiz results.
     */
    Object[] QuizResults;
    
    
    /**
     * The JLabel placed before the JSpinner <code>wordNumber</code>
     */
    JLabel numOfWordsL = new JLabel("Number of words:");
    
    /**
     * The SpinnerModel object for the <code>wordsNumber</code> JSpinner.
     */
    SpinnerModel numOfWordsSpinner = new SpinnerNumberModel(10, // initial value
	    1, // minimum value
	    (ApplicationContext.getGlossary().numberOfPages()) * 51, // maximum value
	    1); // step;
    /**
     * The JSpinner objects to select the number of words in the generated test.
     */
    JSpinner wordsNumber = new JSpinner(numOfWordsSpinner);

    /**
     * The JLabel placed before the JSpinner <code>pointValue</code>.
     */
    JLabel pointsValueL = new JLabel("Value of test (points) :");
    /**
     * The SpinnerModel object for the <code>pointValue</code> JSpinner.
     */
    SpinnerModel pointValueSpinner = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    20, // maximum value
	    1); // step;
    
    /**
     * The JSpinner objects to select the points value of the test to generate.
     */
    JSpinner pointValue = new JSpinner(pointValueSpinner);
    
    /**
     * The JLabel placed before the JSpinner <code>subjectNum</code>.
     */
    JLabel testSubject = new JLabel("Subject number:");
    
    /**
     * The SpinnerModel object for the <code>subjectNum</code> JSpinner.
     */
    SpinnerModel subject = new SpinnerNumberModel();
    /**
     * The JSpinner objects that selects the number of the current test to generate.
     */
    JSpinner subjectNum = new JSpinner(subject);

    /**
     * The constructor of the PanelTestGenerator class.
     */
    public PanelTestGenerator() {
	super();
	this.add(fromP);
	this.add(spinnerStart);
	this.add(to);
	this.add(spinnerEnd);
	this.add(btGen);
	// add to a container
	this.add(checkbox);

	this.add(numOfWordsL);
	this.add(wordsNumber);
	// set state
	checkbox.setSelected(true);
	this.add(testSubject);
	this.add(subjectNum);
	this.add(pointsValueL);
	this.add(pointValue);
	btGen.addActionListener(this);

    }

    /**
     * Method that describes what to do if an action is performed.
     * 
     * @param arg0 The action performed by the user
     */
    public void actionPerformed(ActionEvent arg0) {

//		JTextArea EnWords= new JTextArea();
//		String EnWordList="";
//		for(Word w: ApplicationContext.getGlossary().pages((int)spinnerStart.getValue(),(int) spinnerEnd.getValue()))
//		{
//			EnWordList = EnWordList + w.getFrenchWord()+"\n";
//		}
//		EnWords.setText(EnWordList);
//		
//		this.add(EnWords);
	List<Word> wordList = ApplicationContext.getGlossary().pages((int) spinnerStart.getValue(),
		(int) spinnerEnd.getValue());
	if (arg0.getSource() == btGen) {

	    this.remove(tab);
	    this.remove(points);

	    if (checkbox.isSelected()) {

		wordList = ApplicationContext.getGlossary().pagesMandatory((int) spinnerStart.getValue(),
			(int) spinnerEnd.getValue());
	    }

	    Collections.shuffle(wordList); // randomize word list

	    Object[][] data = new Object[(int) wordsNumber.getValue()][2];
	    QuizResults = new Object[(int) wordsNumber.getValue()];

	    int i = 0;
	    while (i < (int) wordsNumber.getValue()) {
		data[i][0] = wordList.get(i).getFrenchWord();
		data[i][1] = "";
		QuizResults[i] = wordList.get(i).getEnglishWordWithoutMark();
		i = i + 1;

	    }

	    String title[] = { "French Words", "English Words" };
	    tableau = new JTable(data, title);

	    tab = new JScrollPane(tableau);

	    this.add(tab);

	    this.add(btExport);
	    btExport.addActionListener(this);

	    btGen = new JButton("Generate Again");

	    this.updateUI();

	}

	if (arg0.getSource() == btExport) {
	    // TODO export text to an html doc
	    HtmlTest testToExport = new HtmlTest(wordList, (int) pointValue.getValue(), (int) wordsNumber.getValue(), (int) subjectNum.getValue());
	    testToExport.generateTestFile();
	    this.updateUI();
	}
    }

}
