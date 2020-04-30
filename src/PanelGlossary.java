import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PanelGlossary extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Spinners
	SpinnerModel startPages = new SpinnerNumberModel(1, //initial value  
            1, //minimum value  
            ApplicationContext.getGlossary().numberOfPages(), //maximum value  
            1); //step  
	JSpinner spinnerStart = new JSpinner(startPages);
	SpinnerModel endPages = new SpinnerNumberModel(1, //initial value  
            1, //minimum value  
            ApplicationContext.getGlossary().numberOfPages(), //maximum value  
            1); //step  
	JSpinner spinnerEnd = new JSpinner(endPages);
	
	//buttons
	JButton runG = new JButton("run");
	
	//labels
	JLabel fromP=new JLabel("From page");	
	JLabel to=new JLabel("to");	
	
	public PanelGlossary() {
		super();
		this.add(fromP);
		this.add(spinnerStart);
		this.add(to);
		this.add(spinnerEnd);
		runG.addActionListener(this);
		this.add(runG);

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
		
  		ArrayList<Word> WordList =ApplicationContext.getGlossary().pages((int)spinnerStart.getValue(),(int) spinnerEnd.getValue());
		
		Object[][] data = new Object[WordList.size()][2];
		 
        int i = 0;
        while (i < WordList.size()){
            data[i][0] = WordList.get(i).getEnglishWord();
            data[i][1] = WordList.get(i).getFrenchWord();
            i=i+1;
 
        }
             
        String  title[] = {"English Words", "French Words"};
        JTable tableau = new JTable(data, title);
         
        this.add(new JScrollPane(tableau));
		
		this.updateUI();
		
	}

}
