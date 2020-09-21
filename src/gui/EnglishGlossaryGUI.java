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
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import core.Glossary;
import core.Password_Check;
import io.CsvFileSerializationDriver;

/**
 * A class that describe a Window of the application, with Swing attributes.
 */
public class EnglishGlossaryGUI extends JFrame implements ActionListener {

	private ImageIcon img = new ImageIcon(this.getClass().getResource("/icons/E-glossaryIcone.png")); // load the icon
																										// image
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Glossary glossary; // store the when the GUI is lunched

	/**
	 * A JButton object used to connect as a teacher, after entering the password.
	 */
	private JButton connect = new JButton("Connect as teacher");
	/**
	 * 
	 */
	private JButton enterGlossary = new JButton("Enter Glossary");

	/**
	 * A JLabel object used for the title of the window.
	 */
	private JLabel title = new JLabel("E-GLOSSARY");
	/**
	 * A JTextField used for the user to input it's username.
	 */
	private JTextField id = new JTextField("Your User Name");
	/**
	 * The currently logged user.
	 */
	private String user;
	/**
	 * The JPasswordField used for the input for teacher password.
	 */
	private JPasswordField password = new JPasswordField("");

	/**
	 * The MD5 hash of the current teacher password.
	 */

	/**
	 * The constructor of the EnglishGlossaryGUI class. Create a JFrame and set it
	 * to visible, with current object attributes.
	 * 
	 * @param glossary The glossary to word with.
	 */
	public EnglishGlossaryGUI(Glossary glossary) throws IOException {

		EnglishGlossaryGUI.glossary = glossary;

		this.setTitle("Interactive Glossary");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setIconImage(this.img.getImage()); // load the icon image
		this.enterGlossary.addActionListener(this);

		// New object JPanel
		JPanel pan = new JPanel();
		// background color
		pan.setBackground(Color.WHITE);
		// We warn our JFrame that our JPanel will be her JPanel pane

		Font police = new Font("impact", Font.ITALIC, 30);
		// It is applied to the JLabel
		this.title.setFont(police);
		// Changing the text color
		this.title.setForeground(Color.blue);
		// The text alignment is modified using static attributes
		// JLabel class
		this.title.setHorizontalAlignment(SwingConstants.CENTER);

		this.id.setHorizontalAlignment(SwingConstants.CENTER);
		pan.setLayout(new BorderLayout());
		pan.add(this.title, BorderLayout.NORTH);
		// pan.add(new Panel(), BorderLayout.CENTER);
		pan.add(this.enterGlossary, BorderLayout.SOUTH);
		pan.add(this.id, BorderLayout.CENTER);
		this.setContentPane(pan);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// checking for glossary file
		String glossaryFilePath = "data.csv";
		if (!new File(glossaryFilePath).exists()) {
			JOptionPane.showMessageDialog(this, "Fichier de glossaire introuvable",
					"Démarrage de l'application impossible", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Fichier de glossaire introuvable!");
		}

		// Save the Glossary in a file when the windows is closed by the user//

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
		if (arg0.getSource() == this.enterGlossary) {
			if (this.id.getText().equals("metgec")) {
				this.user = new String(this.id.getText());
				this.title.setText("E-GLOSSARY AS " + this.user);
				this.setSize(500, 150);
				this.setLocationRelativeTo(null);

				JPanel conectpan = new JPanel();
				conectpan.setBackground(Color.white);
				Font police = new Font("impact", Font.ITALIC, 30);
				// It is applied to the JLabel
				this.title.setFont(police);
				// Changing the text color
				this.title.setForeground(Color.red);
				// The text alignment is modified using static attributes
				// JLabel class
				this.title.setHorizontalAlignment(SwingConstants.CENTER);

				this.id.setHorizontalAlignment(SwingConstants.CENTER);
				this.password.setHorizontalAlignment(SwingConstants.CENTER);

				conectpan.setLayout(new BorderLayout());
				conectpan.add(this.title, BorderLayout.NORTH);

				conectpan.add(this.password, BorderLayout.CENTER);
				this.connect.addActionListener(this);
				conectpan.add(this.connect, BorderLayout.SOUTH);
				this.setContentPane(conectpan);
			} else {
				this.user = new String(this.id.getText());
				title.setText("E-GLOSSARY AS " + this.user);
				this.setSize(1000, 800);
				this.setLocationRelativeTo(null);
				JTabbedPane pane = loadStudentPanel();
				// frame
				this.setContentPane(pane);
			}
			System.out.println("Glossary lunched");
		}

		if (arg0.getSource() == this.connect) {
			;
			char[] pass = this.password.getPassword();
			String passString = new String(pass);
			if (Password_Check.comparable(passString)) {
				System.out.println("Good PassWord");
				this.setSize(1000, 800);
				this.setLocationRelativeTo(null);
				JTabbedPane pane = loadTeacherPanel();

				// frame
				this.setContentPane(pane);
			} else {
				JOptionPane.showMessageDialog(null, "Password is incorrect, try again.");
			}

		}
	}

	/**
	 * Load the student window.
	 * 
	 * @return The student JTabbedPane object, which contains the tabs accessible to
	 *         students.
	 */
	private JTabbedPane loadStudentPanel() {
		// Pan
		JTabbedPane pane = new JTabbedPane();
		String titre = "Glossary";
		pane.add(titre, new PanelGlossary());
		pane.setTabComponentAt(0, new Tabs(titre, pane));
		// Pan

		String titre2 = "Quiz";
		pane.add(titre2, new PanelQuiz());

		// Pan

		String titre3 = "Proposal";
		pane.add(titre3, new PanelProposal());
		return pane;
	}

	/**
	 * Load the teacher window.
	 * 
	 * @return The student JTabbedPane object, which contains the tabs accessible to
	 *         teacher.
	 */
	private JTabbedPane loadTeacherPanel() {
		// Pan
		JTabbedPane pane = new JTabbedPane();
		String titre = "Glossary";
		pane.add(titre, new PanelGlossary());
		pane.setTabComponentAt(0, new Tabs(titre, pane));
		// Pan

		String titre2 = "Quiz";
		pane.add(titre2, new PanelQuiz());

		// Pan
		String titre3 = "Proposal";
		pane.add(titre3, new PanelProposalTeacher());

		// Pan test generator
		String titre4 = "Test Generator";
		pane.add(titre4, new PanelTestGenerator());

		// Pan Modify
		String titre5 = "Modify Glossary";
		pane.add(titre5, new PanelModifyGlossary());

		return pane;
	}

}
