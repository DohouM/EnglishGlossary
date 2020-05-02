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


public class PanelQuiz extends JPanel implements ActionListener {
	
	private int wordPerQuiz=20;



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
	JButton btPlay = new JButton("Play");
	JButton btConfirm = new JButton("confirm");

	// labels
	JLabel fromP = new JLabel("From page");
	JLabel to = new JLabel("to");

	// JScrollPane
	JScrollPane tab = new JScrollPane();

	// JTable
	JTable tableau;

	// JCheckBox
	JCheckBox checkbox = new JCheckBox("only mandatory words(*)");
	
	//keep results
	Object[] QuizResults;

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
		if (arg0.getSource() == btPlay) {
			
			this.remove(tab);

			ArrayList<Word> WordList = ApplicationContext.getGlossary().pages((int) spinnerStart.getValue(),
					(int) spinnerEnd.getValue());

			if (checkbox.isSelected()) {

				WordList = ApplicationContext.getGlossary().pagesMandatory((int) spinnerStart.getValue(),
						(int) spinnerEnd.getValue());
			}
			
			Collections.shuffle(WordList); //randomize word list
			
			Object[][] data = new Object[wordPerQuiz][2];
			QuizResults= new Object[wordPerQuiz];
			
			int i = 0;
			while (i < wordPerQuiz) {
				data[i][0] = WordList.get(i).getFrenchWord();
				data[i][1] = "";
				QuizResults[i]= WordList.get(i).getEnglishWordWithoutMark();
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
			
			for(int i=0; i<wordPerQuiz;i++) {
				if(QuizResults[i].equals(tableau.getValueAt(i,1))) {
					tableau.setValueAt(tableau.getValueAt(i,1)+"  ✓",i,1);					
				} else {
					tableau.setValueAt(tableau.getValueAt(i,1)+" // "+QuizResults[i]+ "  ❌",i,1);
				}
			}
			
			
			
		}
	}

}
