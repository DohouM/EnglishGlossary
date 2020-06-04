import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * A class that describe the Glossary panel of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */
public class PanelGlossary extends JPanel implements ActionListener {
    /**
     * 
     */
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
     * The JButton to get the glossary pages between select numbers in 
     * <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    JButton btRun = new JButton("run");

    /**
     * The JLabel placed before <code>spinnerStart</code>.
     */
    JLabel fromP = new JLabel("From page");
    /**
     * The JLabel placed after <code>spinnerStart</code>.
     */
    JLabel to = new JLabel("to");

    /**
     * The JScrollPane that'll contain a table with all the words between
     *  selected numbers in <code>spinnerStart</code> and <code>spinnerEnd</code>.
     */
    JScrollPane tab = new JScrollPane();

    /**
     * The JTable that'll be contained in <code>tab</code>
     */
    JTable tableau;
    /**
     * The constructor for the Glossary panel of the application.
     */
    public PanelGlossary() {
	super();
	this.add(fromP);
	this.add(spinnerStart);
	this.add(to);
	this.add(spinnerEnd);
	btRun.addActionListener(this);
	this.add(btRun);

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

	List<Word> WordList = ApplicationContext.getGlossary().pages((int) spinnerStart.getValue(),
		(int) spinnerEnd.getValue());

	Object[][] data = new Object[WordList.size()][2];

	int i = 0;
	while (i < WordList.size()) {
	    data[i][0] = WordList.get(i).getEnglishWord();
	    data[i][1] = WordList.get(i).getFrenchWord();
	    i = i + 1;

	}

	String title[] = { "English Words", "French Words" };
	tableau = new JTable(data, title);

	tab = new JScrollPane(tableau);

	this.add(tab);

	this.updateUI();

    }

}
