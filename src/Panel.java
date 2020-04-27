
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;


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
public Panel(String type){
	if(type.equals("glossary")) {
		String[] monthStrings = {"1","2","3",}; //get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		JSpinner spinner = new JSpinner(monthModel);
		SpinnerListModel monthModel2 = new SpinnerListModel(monthStrings);
		JSpinner spinner2 = new JSpinner(monthModel2);
		this.add(spinner);
		this.add(spinner2);
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