import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModifyGlossary extends JPanel implements ActionListener{

	private JLabel fr = new JLabel("French Word");
	private JTextField frenchWord = new JTextField("",30);

	private JLabel en = new JLabel("English Word");
	private JTextField englishWord = new JTextField("",30);
	
	private JLabel search = new JLabel("Type the word to delete or modify");
	private JTextField searchBar = new JTextField("",30);
	
	//Jbutton
	private JButton btAdd= new JButton("Add to Glossary");
	private JButton btDelete= new JButton("Delete this Word");
	private JButton btSearch= new JButton("Search");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelModifyGlossary() {
		super();
		
		// search for a word part
		this.add(search);
		this.add(searchBar);
		this.add(btSearch);
		btSearch.addActionListener(this);
		
		
		//adding a word part
		this.add(en);
		this.add(englishWord);
		this.add(fr);
		this.add(frenchWord);
		this.add(btAdd);
		btAdd.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
