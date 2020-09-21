package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import core.Word;

/**
 * Sub-part of the GUI responsible of glossary pages display.
 */
public class PanelGlossary extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * The spinner model for starting page selection.
	 */
	private SpinnerModel startPageSpinnerModel;

	/**
	 * The spinner for start page selection
	 */
	private JSpinner startSpinner;

	/**
	 * The spinner model for end page selection.
	 */
	private SpinnerModel endPageSpinnerModel;

	/**
	 * The spinner created from end page selection
	 */
	private JSpinner endSpinner;

	/**
	 * The button to generate display
	 */
	private JButton displayButton;

	/**
	 * The label associated to start page spinner
	 */
	private JLabel startPageLabel;
	
	/**
	 * The label associated to end page spinner
	 */
	private JLabel endPageLabel;

	/**
	 * The scroll pane containing the table where selected pages are displayed
	 */
	private JScrollPane scrollPane;

	/**
	 * The table containing selected pages
	 */
	private JTable table;

	/**
	 * Creates a new glossary panel instance
	 */
	public PanelGlossary() {
		super();
		this.startPageLabel = new JLabel("From page");
		this.add(this.startPageLabel);
		
		this.endPageLabel = new JLabel("to");
		this.add(this.endPageLabel);
		
		this.startPageSpinnerModel = new SpinnerNumberModel(1, 1, EnglishGlossaryGUI.glossary.numberOfPages(),1);
		this.startSpinner = new JSpinner(this.startPageSpinnerModel);
		this.add(this.startSpinner);
		
		this.endPageSpinnerModel = new SpinnerNumberModel(1, 1, EnglishGlossaryGUI.glossary.numberOfPages(),1);
		this.endSpinner = new JSpinner(this.endPageSpinnerModel);
		this.add(this.endSpinner);
		
		this.displayButton = new JButton("display");
		this.displayButton.addActionListener(this);
		this.add(this.displayButton);
		
		this.scrollPane = new JScrollPane();
	}

	/**
	 * event listener responsible of updating glossary pages display
	 * 
	 * @param event source event
	 */
	public void actionPerformed(ActionEvent event) {

		this.remove(this.scrollPane);

		List<Word> words = EnglishGlossaryGUI.glossary.pages((int) this.startSpinner.getValue(),
				(int) this.endSpinner.getValue());

		Object[][] data = new Object[words.size()][2];

		int loopCounter = 0;
		while (loopCounter < words.size()) {
			data[loopCounter][0] = words.get(loopCounter).getEnglishWord();
			data[loopCounter][1] = words.get(loopCounter).getFrenchWord();
			loopCounter = loopCounter + 1;

		}

		String title[] = { "English Words", "French Words" };
		this.table = new JTable(data, title);

		this.scrollPane = new JScrollPane(this.table);

		this.add(this.scrollPane);

		this.updateUI();
	}
}
