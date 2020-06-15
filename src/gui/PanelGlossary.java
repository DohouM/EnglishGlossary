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

import core.Main;
import core.Word;

/**
 * A class that describe the Glossary panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 * @version 1.2
 */
public class PanelGlossary extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The SpinnerModel for starting page selection.
     */
    private SpinnerModel startPages = new SpinnerNumberModel(1, // initial value
	    1, // minimum value
	    Main.glossary.numberOfPages(), // maximum value
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
	    Main.glossary.numberOfPages(), // maximum value
	    1); // step
    
    /**
     * The JSpinner created from the previously created SpinnerModel
     * <code>endPages</code>.
     */
    private JSpinner spinnerEnd = new JSpinner(endPages);

    /**
     * The JButton to get the glossary pages between select numbers in 
     * <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    private JButton btRun = new JButton("run");

    /**
     * The JLabel placed before <code>spinnerStart</code>.
     */
    private JLabel fromP = new JLabel("From page");
    /**
     * The JLabel placed after <code>spinnerStart</code>.
     */
    private JLabel to = new JLabel("to");

    /**
     * The JScrollPane that'll contain a table with all the words between
     *  selected numbers in <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    private JScrollPane tab = new JScrollPane();

    /**
     * The JTable that'll be contained in <code>tab</code>
     */
    private JTable tableau;
    /**
     * The constructor for the Glossary panel of the application.
     */
    public PanelGlossary() {
	super();
	this.add(this.fromP);
	this.add(this.spinnerStart);
	this.add(this.to);
	this.add(this.spinnerEnd);
	btRun.addActionListener(this);
	this.add(this.btRun);

    }

    /**
     * Method that described what to do if an action is performed.
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
	this.remove(tab);

	List<Word> WordList = Main.glossary.pages((int) spinnerStart.getValue(),
		(int) spinnerEnd.getValue());

	Object[][] data = new Object[WordList.size()][2];

	int loopCounter = 0;
	while (loopCounter < WordList.size()) {
	    data[loopCounter][0] = WordList.get(loopCounter).getEnglishWord();
	    data[loopCounter][1] = WordList.get(loopCounter).getFrenchWord();
	    loopCounter = loopCounter + 1;

	}

	String title[] = { "English Words", "French Words" };
	tableau = new JTable(data, title);

	tab = new JScrollPane(tableau);

	this.add(tab);

	this.updateUI();

    }

}
