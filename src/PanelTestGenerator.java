import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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

public class PanelTestGenerator extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    // Spinners
    SpinnerModel startPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    ApplicationContext.getGlossary().numberOfPages(), // maximum value
	    1); // step
    JSpinner spinnerStart = new JSpinner(startPages);
    SpinnerModel endPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    ApplicationContext.getGlossary().numberOfPages(), // maximum value
	    1); // step
    JSpinner spinnerEnd = new JSpinner(endPages);

    // buttons
    JButton btGen = new JButton("Generate");
    JButton btExport = new JButton("Export");

    // labels
    JLabel fromP = new JLabel("From page");
    JLabel to = new JLabel("to");
    JLabel points = new JLabel("");

    // JScrollPane
    JScrollPane tab = new JScrollPane();

    // JTable
    JTable tableau;

    // JCheckBox
    JCheckBox checkbox = new JCheckBox("only mandatory words(*)");

    // keep results
    Object[] QuizResults;
    // Jlabel
    JLabel numOfWordsL = new JLabel("Number of words:");
    // JSpinner
    SpinnerModel numOfWordsSpinner = new SpinnerNumberModel(10, // initial value
	    1, // minimum value
	    (ApplicationContext.getGlossary().numberOfPages()) * 51, // maximum value
	    1); // step;
    JSpinner wordsNumber = new JSpinner(numOfWordsSpinner);

    // Jlabel
    JLabel pointsValueL = new JLabel("Value of test (points) :");
    // JSpinner
    SpinnerModel pointValueSpinner = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    20, // maximum value
	    1); // step;
    JSpinner pointValue = new JSpinner(pointValueSpinner);
    // Jlabel
    JLabel testSubject = new JLabel("Subject number:");
    // JSpinner
    SpinnerModel subject = new SpinnerNumberModel();
    JSpinner subjectNum = new JSpinner(subject);

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
     * 
     */

    @Override
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
	ArrayList<Word> wordList = ApplicationContext.getGlossary().pages((int) spinnerStart.getValue(),
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
	    HtmlTest testToExport = new HtmlTest(wordList, (int) pointValue.getValue(), (int) wordsNumber.getValue(),
		    (int) subjectNum.getValue());
	    testToExport.generateTestFile();
	    this.updateUI();
	}
    }

}
