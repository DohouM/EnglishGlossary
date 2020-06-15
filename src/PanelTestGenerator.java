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
 * @version 1.3
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
     * The JLabel placed between the <code>spinnerStart</code> and
     * <code>spinnerEnd</code> JSpinner objects.
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
    
    List<Word> wordList;
    
    String[][] data;
    
    List<Word> newWordList;

    /**
     * The constructor of the PanelTestGenerator class.
     */
    public PanelTestGenerator() {
	super();
	this.add(this.fromP);
	this.add(this.spinnerStart);
	this.add(this.to);
	this.add(this.spinnerEnd);
	this.add(this.btGen);
	// add to a container
	this.add(this.checkbox);

	this.add(this.numOfWordsL);
	this.add(this.wordsNumber);
	// set state
	this.checkbox.setSelected(true);
	this.add(this.testSubject);
	this.add(this.subjectNum);
	this.add(this.pointsValueL);
	this.add(this.pointValue);
	this.btGen.addActionListener(this);

    }

    /**
     * Method that describes what to do if an action is performed.
     * 
     * @param arg0 The action performed by the user
     */
    public void actionPerformed(ActionEvent arg0) {
	this.wordList = ApplicationContext.getGlossary().pages((int) this.spinnerStart.getValue(),
		(int) this.spinnerEnd.getValue());
	
	
	if (arg0.getSource() == this.btGen) {
	    this.data = new String[(int) this.wordsNumber.getValue()][2];
	    this.remove(this.tab);
	    this.remove(this.points);

	    if (this.checkbox.isSelected()) {

		this.wordList = ApplicationContext.getGlossary().pagesMandatory((int) this.spinnerStart.getValue(),
			(int) this.spinnerEnd.getValue());
	    }

	    Collections.shuffle(wordList); // randomize word list

	    

	    int i = 0;
	    while (i < (int) this.wordsNumber.getValue()) {
		this.data[i][0] = this.wordList.get(i).getFrenchWord();
		this.data[i][1] = this.wordList.get(i).getEnglishWordWithoutMark();
		i = i + 1;

	    }

	    String title[] = { "French Words", "English Words" };
	    this.tableau = new JTable(this.data, title);

	    this.tab = new JScrollPane(this.tableau);

	    this.add(this.tab);

	    this.add(this.btExport);
	    this.btExport.addActionListener(this);

	    this.btGen = new JButton("Generate Again");
	    this.newWordList = new ArrayList<Word>();
	    for(i=0; i < (int) this.wordsNumber.getValue();i++) {
		this.newWordList.add(new Word(this.data[i][0],this.data[i][1]));
	    }
	    for(Word w: this.newWordList) {
		System.out.println(w.getEnglishWord() + ";" +w.getFrenchWord());
	    }

	    this.updateUI();

	}

	if (arg0.getSource() == this.btExport) {
	    SaveFileDialog savefile = new SaveFileDialog();

	    HtmlTest testToExport = new HtmlTest(this.newWordList, (int) this.pointValue.getValue(), (int) this.wordsNumber.getValue(), (int) this.subjectNum.getValue(), savefile.getFile());
	    testToExport.generateTestFile();
	    this.updateUI();
	}
    }

}
