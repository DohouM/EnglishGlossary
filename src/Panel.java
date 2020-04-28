
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class Panel extends JPanel { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g){


    //System.out.println("Je suis exécutée !");
    //Word hello = new Word("hello", "bonjour");
    //g.drawString(hello.toString(), 10, 20);
    

  }     
public Panel(String type,Glossary glossary){
	if(type.equals("glossary")) {
		SpinnerModel startPages = new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                glossary.numberOfPages(), //maximum value  
                1); //step  
		JSpinner spinnerStart = new JSpinner(startPages);
		SpinnerModel endPages = new SpinnerNumberModel(1, //initial value  
                1, //minimum value  
                glossary.numberOfPages(), //maximum value  
                1); //step  
		JSpinner spinnerEnd = new JSpinner(endPages);
		JButton runG = new JButton("run");
		JLabel fromP=new JLabel("From page");	
		JLabel to=new JLabel("to");	
		this.add(fromP);
		this.add(spinnerStart);
		this.add(to);
		this.add(spinnerEnd);
		this.add(runG);
	}
	
	if(type.equals("quiz")) {
	String[] monthStrings = {"1","2","3"}; //get month names
	SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
	JSpinner spinner = new JSpinner(monthModel);
	SpinnerListModel monthModel2 = new SpinnerListModel(monthStrings);
	JSpinner spinner2 = new JSpinner(monthModel2);
	this.add(spinner);
	this.add(spinner2);
	}
	
	if(type.equals("proposal")) {
		JLabel addAWord = new JLabel("Add a Word");	
		this.add(addAWord);
	}
	

}
}