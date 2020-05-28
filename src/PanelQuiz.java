import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * A class that describe the Quiz panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
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

    /**
     * The button to create a new set of words to train with from the glossary,
     * between pages from values of <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    JButton btPlay = new JButton("Play");
    JButton btConfirm = new JButton("confirm");

    /**
     * The JLabel placed before the <code>spinnerStart</code> JSpinner object.
     */
    JLabel fromP = new JLabel("From page");
    /**
     * The JLabel placed between the <code>spinnerStart</code> and <code>spinnerEnd</code> JSpinner objects.
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
    JCheckBox checkbox = new JCheckBox("only mandatory words(*)");

    /**
     * An array that'll hold the quiz results.
     */
    Object[] QuizResults;

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

//		JTextArea EnWords= new JTextArea();
//		String EnWordList="";
//		for(Word w: ApplicationContext.getGlossary().pages((int)spinnerStart.getValue(),(int) spinnerEnd.getValue()))
//		{
//			EnWordList = EnWordList + w.getFrenchWord()+"\n";
//		}
//		EnWords.setText(EnWordList);
//		
//		this.add(EnWords);
	if (arg0.getSource() == btPlay) {

	    this.remove(tab);
	    this.remove(points);

	    ArrayList<Word> WordList = ApplicationContext.getGlossary().pages((int) spinnerStart.getValue(),
		    (int) spinnerEnd.getValue());

	    if (checkbox.isSelected()) {

		WordList = ApplicationContext.getGlossary().pagesMandatory((int) spinnerStart.getValue(),
			(int) spinnerEnd.getValue());
	    }

	    Collections.shuffle(WordList); // randomize word list

	    Object[][] data = new Object[wordPerQuiz][2];
	    QuizResults = new Object[wordPerQuiz];

	    int i = 0;
	    while (i < wordPerQuiz) {
		data[i][0] = WordList.get(i).getFrenchWord();
		data[i][1] = "";
		QuizResults[i] = WordList.get(i).getEnglishWordWithoutMark();
		i = i + 1;

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

	    for (int i = 0; i < wordPerQuiz; i++) {
		if (QuizResults[i].equals(tableau.getValueAt(i, 1))) {
		    tableau.setValueAt(tableau.getValueAt(i, 1) + "  ✓", i, 1);
		    point++;
		} else if (tableau.getValueAt(i, 1) == "") {
		    tableau.setValueAt(tableau.getValueAt(i, 1) + " // " + QuizResults[i] + "  X", i, 1);
		}
	    }

	    points = new JLabel(Integer.toString(point) + "/" + Integer.toString(wordPerQuiz));
	    this.add(points);
	    this.updateUI();

	}
    }

}
