package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Word;

/**
 * A class that describe the Modify panel of the application, with Swing
 * attributes.
 */
public class PanelModifyGlossary extends JPanel implements ActionListener {
	/**
	 * A JLabel placed before the JTextField used to ask for the french word to add.
	 */
	private JLabel fr = new JLabel("French Word");
	/**
	 * The JTextField used for french word to add to Glossary.
	 */
	private JTextField frenchWord = new JTextField("", 30);

	/**
	 * A JLabel placed before the JTextField used to ask for the english word to
	 * add.
	 */
	private JLabel en = new JLabel("English Word");
	/**
	 * The JTextField used for english words to add to Glossary.
	 */
	private JTextField englishWord = new JTextField("", 30);

	/**
	 * A JLabel placed before the JTextField used to ask for the word to search into
	 * the glossary.
	 */
	private JLabel search = new JLabel("Type the word to delete or modify");
	/**
	 * The JTextField used for word search.
	 */
	private JTextField searchBar = new JTextField("", 30);

	/**
	 * The JLabel that'll contain the result of the search.
	 */

	private JLabel result = new JLabel();

	/**
	 * The JButton object to add the Word into glossary, from JTextField
	 * <code>fr</code> and <code>en</code>.
	 */
	private JButton btAdd = new JButton("Add to glossary");
	/**
	 * The JButton object to delete the result of the search.
	 */
	private JButton btDelete = new JButton("Delete this word");
	/**
	 * The JButton object to search the word in glossary, from JTextField
	 * <code>searchBar</code>.
	 */
	private JButton btSearch = new JButton("Search");

	/**
	 * The Word object found during search.
	 */
	private Word wordFound;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the PanelModifyGlossary class.
	 */
	public PanelModifyGlossary() {
		super();

		// search for a word part
		this.add(this.search);
		this.add(this.searchBar);
		this.add(this.btSearch);
		this.btSearch.addActionListener(this);

		// adding a word part
		this.add(this.en);
		this.add(this.englishWord);
		this.add(this.fr);
		this.add(this.frenchWord);
		this.add(this.btAdd);
		this.btAdd.addActionListener(this);

	}

	/**
	 * Method that described what to do if an action is performed.
	 * 
	 * @param arg0 The action performed by the user
	 */
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == this.btSearch) {

			this.remove(this.result);

			this.wordFound = EnglishGlossaryGUI.glossary.search(this.searchBar.getText());

			this.result = new JLabel(this.wordFound.toString());
			this.add(this.result);
			this.add(this.btDelete);
			this.btDelete.addActionListener(this);

			this.updateUI();
		}

		if (arg0.getSource() == this.btAdd) {

			EnglishGlossaryGUI.glossary.addWordStringOnly(this.englishWord.getText(), this.frenchWord.getText());

			JOptionPane.showMessageDialog(null, "Word Saved");

			this.frenchWord.setText("");
			this.englishWord.setText("");

			this.updateUI();
		}

		if (arg0.getSource() == this.btDelete) {

			EnglishGlossaryGUI.glossary.removeWord(this.wordFound);

			JOptionPane.showMessageDialog(null, "Word Deleted");

			this.remove(this.result);
			this.remove(this.btDelete);

			this.updateUI();
		}

	}
}
