package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import core.Quiz;

/**
 * A class that describe the Quiz panel of the application, with Swing
 * attributes.
 */
public class PanelQuiz extends JPanel implements ActionListener {

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
	private JSpinner spinnerStart = new JSpinner(this.startPages);
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
	private JSpinner spinnerEnd = new JSpinner(this.endPages);

	/**
	 * The button to create a new set of words to train with from the glossary,
	 * between pages from values of <code>spinnerStart</code> and
	 * <code>spinnerEnd</code>.
	 */
	private JButton btPlay = new JButton("Play");
	private JButton btConfirm = new JButton("confirm");

	/**
	 * The JLabel placed before the <code>spinnerStart</code> JSpinner object.
	 */
	private JLabel fromP = new JLabel("From page");
	/**
	 * The JLabel placed between the <code>spinnerStart</code> and
	 * <code>spinnerEnd</code> JSpinner objects.
	 */
	private JLabel to = new JLabel("to");
	/**
	 * The JLabel that'll hold the points earned by the student.
	 */
	private JLabel score = new JLabel("");

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

	private Quiz quiz;

	/**
	 * An array that'll hold the quiz results.
	 */

	/**
	 * The constructor of the PanelQuiz class.
	 */
	public PanelQuiz() {
		super();
		this.add(this.fromP);
		this.add(this.spinnerStart);
		this.add(this.to);
		this.add(this.spinnerEnd);
		this.add(this.btPlay);
		// add to a container
		this.add(this.checkbox);
		// set state
		this.checkbox.setSelected(true);

		this.btPlay.addActionListener(this);

	}

	/**
	 * Method that described what to do if an action is performed.
	 * 
	 * @param arg0 The action performed by the user
	 */
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.btPlay) {

			this.remove(this.tab);
			this.remove(this.score);

			this.quiz = new Quiz((int) this.spinnerStart.getValue(), (int) this.spinnerEnd.getValue(), this.checkbox.isSelected());

			String title[] = { "French Words", "English Words" };
			this.tableau = new JTable(this.quiz.getTable(), title);

			this.tab = new JScrollPane(this.tableau);

			this.add(this.tab);

			this.add(this.btConfirm);
			this.btConfirm.addActionListener(this);

			this.updateUI();

		}

		if (arg0.getSource() == this.btConfirm) {

			this.remove(this.score);
			Object[] tabRes = new Object[this.quiz.getWordPerQuiz()];
			for (int loopCounter = 0; loopCounter < this.quiz.getWordPerQuiz(); loopCounter++) {
				tabRes[loopCounter] = this.tableau.getValueAt(loopCounter, 1);
			}

			Object[] toDisplay = this.quiz.resultChecker(tabRes);

			for (int loopCounter = 0; loopCounter < this.quiz.getWordPerQuiz(); loopCounter++) {
				this.tableau.setValueAt(toDisplay[loopCounter], loopCounter, 1);
			}

			this.score = new JLabel(Integer.toString(this.quiz.getPoints()) + "/" + Integer.toString(this.quiz.getWordPerQuiz()));
			this.add(this.score);
			this.updateUI();

		}
	}

}
