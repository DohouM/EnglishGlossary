package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import core.Glossary;
import io.CsvFileSerializationDriver;

/**
 * English glossary main GUI
 */
public class EnglishGlossaryGUI extends JFrame implements ActionListener {																									// image

	private static final long serialVersionUID = 1L;

	public static Glossary glossary; 

	/**
	 * Button used to enter glossary
	 */
	private JButton enterGlossaryButton;

	/**
	 * Label used for the title of the window.
	 */
	private JLabel titleLabel;
	
	/**
	 * Text field used for the user to input its username.
	 */
	private JTextField userNameTextField;

	/**
	 * The currently logged user.
	 */
	private String user;

	/**
	 * The constructor of the EnglishGlossaryGUI class. Create a JFrame and set it
	 * to visible, with current object attributes.
	 * 
	 * @param glossary The glossary to word with.
	 */
	public EnglishGlossaryGUI(Glossary glossary) throws IOException {

		ImageIcon img = new ImageIcon(this.getClass().getResource("/icons/E-glossaryIcone.png")); // load the icon
		
		EnglishGlossaryGUI.glossary = glossary;	

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);			
		panel.setLayout(new BorderLayout());
		
		this.titleLabel = new JLabel("E-GLOSSARY");
		this.titleLabel.setFont(new Font("impact", Font.ITALIC, 30));
		this.titleLabel.setForeground(Color.blue);
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(this.titleLabel, BorderLayout.NORTH);
		
		this.enterGlossaryButton = new JButton("Enter Glossary");
		this.enterGlossaryButton.addActionListener(this);
		panel.add(this.enterGlossaryButton, BorderLayout.SOUTH);
		
		this.userNameTextField = new JTextField("Your User Name");
		this.userNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(this.userNameTextField, BorderLayout.CENTER);
		
		this.setTitle("Interactive Glossary");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setIconImage(img.getImage()); // load the icon image
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		

		// checking for glossary file
		String glossaryFilePath = "data.csv";
		if (!new File(glossaryFilePath).exists()) {
			JOptionPane.showMessageDialog(this, "Fichier de glossaire introuvable",
					"Démarrage de l'application impossible", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Fichier de glossaire introuvable!");
		}
		
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("data.csv");

		try {
			glossary.addWords(readWrite.importWords());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Fichier de glossaire invalide",
					"Démarrage de l'application impossible", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Fichier de glossaire invalide!");
		}
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) { // Method that will be called when clicking on the button

		this.user = this.userNameTextField.getText();
		this.titleLabel.setText("E-GLOSSARY AS " + this.user);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		JTabbedPane pane = new JTabbedPane();
		pane.add("Glossary", new GlossaryPanel());
		pane.add("Quiz", new QuizPanel());
		pane.add("Proposal", new ProposalPanel());
		this.setContentPane(pane);
	}
}
