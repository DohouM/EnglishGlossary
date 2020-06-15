package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import core.Main;
import core.QuizGenerator;
import core.Word;

/**
 * A class that describe the Quiz panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.5
 */
public class PanelQuiz extends JPanel implements ActionListener {
    /**
     * The initial number of words per quiz.
     */
    private int wordPerQuiz = 20;

    private static final long serialVersionUID = 1L;
    /**
     * The SpinnerModel for starting page selection.
     */
    private SpinnerModel startPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    EnglishGlossaryGUI.glossary.numberOfPages(), // maximum value
	    1); // step
    /**
     * The JSpinner created from the previously created SpinnerModel
     * <code>startPages</code>.
     */
    private JSpinner spinnerStart = new JSpinner(startPages);
    /**
     * The SpinnerModel for ending page selection.
     */
    private SpinnerModel endPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    EnglishGlossaryGUI.glossary.numberOfPages(), // maximum value
	    1); // step
    /**
     * The JSpinner created from the previously created SpinnerModel
     * <code>endPages</code>.
     */
    private JSpinner spinnerEnd = new JSpinner(endPages);

    /**
     * The button to create a new set of words to train with from the glossary,
     * between pages from values of <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    private JButton btPlay = new JButton("Play");
    private JButton btConfirm = new JButton("confirm");

    /**
     * The JLabel placed before the <code>spinnerStart</code> JSpinner object.
     */
    private JLabel fromP = new JLabel("From page");
    /**
     * The JLabel placed between the <code>spinnerStart</code> and <code>spinnerEnd</code> JSpinner objects.
     */
    private JLabel to = new JLabel("to");
    /**
     * The JLabel that'll hold the points earned by the student.
     */
    private JLabel points = new JLabel("");

    /**
     * The JScrollPane that'll hold the JTable that'll store the quiz.
     */
    private JScrollPane tab = new JScrollPane();

    /**
     * The JTable that'll hold the quiz.
     */
    private JTable tableau;

    /**
     * A JCheckBox to only have mandatory words in the generated test.
     */
    private JCheckBox checkbox = new JCheckBox("only mandatory words(*)");

    /**
     * An array that'll hold the quiz results.
     */
    private Object[] QuizResults;

    /**
     * The constructor of the PanelQuiz class.
     */
    public PanelQuiz() {
	super();
	this.add(fromP);
	this.add(spinnerStart);
	this.add(to);
	this.add(spinnerEnd);
	this.add(btPlay);
	// add to a container
	this.add(checkbox);
	// set state
	checkbox.setSelected(true);

	btPlay.addActionListener(this);

    }

    /**
     * Method that described what to do if an action is performed.
     * 
     * @param arg0 The action performed by the user
     */
    public void actionPerformed(ActionEvent arg0) {

	if (arg0.getSource() == btPlay) {

	    this.remove(tab);
	    this.remove(points);
	    
	    List <Word> WordList=QuizGenerator.generate((int)spinnerStart.getValue(),(int) spinnerEnd.getValue(), checkbox.isSelected());
	    
	    

	    Object[][] data = new Object[wordPerQuiz][2];
	    QuizResults = new Object[wordPerQuiz];

	    int loopCounter = 0;
	    while (loopCounter < wordPerQuiz) {
		data[loopCounter][0] = WordList.get(loopCounter).getFrenchWord();
		data[loopCounter][1] = "";
		QuizResults[loopCounter] = WordList.get(loopCounter).getEnglishWordWithoutMark();
		loopCounter = loopCounter + 1;

	    }

	    String title[] = { "French Words", "English Words" };
	    tableau = new JTable(data, title);

	    tab = new JScrollPane(tableau);

	    this.add(tab);

	    this.add(btConfirm);
	    btConfirm.addActionListener(this);

	    this.updateUI();

	}

	if (arg0.getSource() == btConfirm) {
	    int point = 0;
	    this.remove(points);

	    for (int loopCounter = 0; loopCounter < wordPerQuiz; loopCounter++) {
		if (QuizResults[loopCounter].equals(tableau.getValueAt(loopCounter, 1))) {
		    tableau.setValueAt(tableau.getValueAt(loopCounter, 1) + "  ✓", loopCounter, 1);
		    point++;
		} else if (tableau.getValueAt(loopCounter, 1) == "") {
		    tableau.setValueAt(tableau.getValueAt(loopCounter, 1) + " // " + QuizResults[loopCounter] + "  X", loopCounter, 1);
		}
	    }

	    points = new JLabel(Integer.toString(point) + "/" + Integer.toString(wordPerQuiz));
	    this.add(points);
	    this.updateUI();

	}
    }

}
