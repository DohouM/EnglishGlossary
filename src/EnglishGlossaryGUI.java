import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * A class that describe a Window of the application, with Swing attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */
public class EnglishGlossaryGUI extends JFrame implements ActionListener {

    private ImageIcon img = new ImageIcon("E-glossaryIcone.png"); // load the icon image
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

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
    private static final String finalPassWord = "938227684C1200009DF4A4E2067D934E";

    /**
     * The constructor of the EnglishGlossaryGUI class. Create a JFrame and set it to visible,
     * with current object attributes.
     */
    public EnglishGlossaryGUI() {
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
	this.title.setHorizontalAlignment(JLabel.CENTER);

	this.id.setHorizontalAlignment(JLabel.CENTER);
	pan.setLayout(new BorderLayout());
	pan.add(this.title, BorderLayout.NORTH);
	// pan.add(new Panel(), BorderLayout.CENTER);
	pan.add(this.enterGlossary, BorderLayout.SOUTH);
	pan.add(this.id, BorderLayout.CENTER);
	this.setContentPane(pan);
	this.setVisible(true);

	// Save the Glossary in a file when the windows is closed by the user//

	CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("data.csv");

	this.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		int userChoice = JOptionPane.showConfirmDialog(null, "Do you want to save the glossary?");
		if (userChoice == 0)

		    try { // saving glossary before closing
			readWrite.exportWords(Main.glossary.getGlossary());
			System.out.println("Glossary saved");
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }

		System.exit(0);// close the windows
	    }
	});

    }

    public void actionPerformed(ActionEvent arg0) { // Method that will be called when clicking on the button
	if (arg0.getSource() == enterGlossary) {
	    if (this.id.getText().equals("metgec")) {
		this.user = new String(this.id.getText());
		title.setText("E-GLOSSARY AS " + this.user);
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
		this.title.setHorizontalAlignment(JLabel.CENTER);

		this.id.setHorizontalAlignment(JLabel.CENTER);
		this.password.setHorizontalAlignment(JLabel.CENTER);

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
		JTabbedPane pane = LoadStudentPanel();
		// frame
		this.setContentPane(pane);
	    }
	    System.out.println("Glossary lunched");
	}

	if (arg0.getSource() == this.connect) {
	    StringUtils sUtils = new StringUtils();
	    char[] pass = this.password.getPassword();
	    String passString = new String(pass);
	    if (sUtils.comparable(passString,finalPassWord)) {
		System.out.println("Good PassWord");
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		JTabbedPane pane = LoadTeacherPanel();

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
    private JTabbedPane LoadStudentPanel() {
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
    private JTabbedPane LoadTeacherPanel() {
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
