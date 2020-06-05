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
 * A class that describe a Window of the application, with Swing
 * attributes.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */
public class Windows extends JFrame implements ActionListener {
	
    private ImageIcon img = new ImageIcon("E-glossaryIcone.png");  //load the icon image
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A JButton object used to enter the app as a teacher.
	 */
	private JButton btTeacher = new JButton("I am a teacher");
	/**
	 * A JButton object used to enter the app as a student.
	 */
	private JButton btStudent = new JButton("I am a student");
	/**
	 * A JButton object used to connect as a teacher, after entering the password.
	 */
	private JButton connect = new JButton("Connect as teacher");

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
	private User user;
	/**
	 * The JPasswordField used for the input for teacher password.
	 */
	private JPasswordField password = new JPasswordField("");
	/**
	 * The MD5 hash of the current teacher password.
	 */
	private static final String finalPassWord = "938227684C1200009DF4A4E2067D934E";

	/**
	 * The constructor of the Windows class. Create a JFrame and set it to visible, with current object attributes.
	 */
	public Windows() {
		this.setTitle("Interactive Glossary");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setIconImage(img.getImage());  //load the icon image

		// New object JPanel
		JPanel pan = new JPanel();
		// background color
		pan.setBackground(Color.WHITE);
		// We warn our JFrame that our JPanel will be her JPanel pane

		Font police = new Font("impact", Font.ITALIC, 30);
		// It is applied to the JLabel
		title.setFont(police);
		// Changing the text color
		title.setForeground(Color.blue);
		// The text alignment is modified using static attributes
		// JLabel class
		title.setHorizontalAlignment(JLabel.CENTER);

		btStudent.addActionListener(this);
		btTeacher.addActionListener(this);

		id.setHorizontalAlignment(JLabel.CENTER);
		pan.setLayout(new BorderLayout());
		pan.add(title, BorderLayout.NORTH);
		// pan.add(new Panel(), BorderLayout.CENTER);
		pan.add(id, BorderLayout.CENTER);
		pan.add(btTeacher, BorderLayout.WEST);
		pan.add(btStudent, BorderLayout.EAST);

		this.setContentPane(pan);
		this.setVisible(true);
		
		
		
								//Save the Glossary in a file when the windows is closed by the user//
		
		CsvFileSerializationDriver readWrite = new CsvFileSerializationDriver("data.csv");
		
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                int i=JOptionPane.showConfirmDialog(null, "Do you want to save the glossary?");
                if(i==0)
                	
                	
            		try {													                     //saving glossary before closing
            			readWrite.exportWords( ApplicationContext.getGlossary().getGlossary());
            			System.out.println("Glossary saved");
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                	
                    System.exit(0);//close the windows
            }
        });

	}

	public void actionPerformed(ActionEvent arg0) { // Method that will be called when clicking on the button

		if (arg0.getSource() == btStudent) {
			user = new User(id.getText());
			title.setText("E-GLOSSARY AS " + this.user.getUserName());
			this.setSize(1000, 800);
			this.setLocationRelativeTo(null);
			JTabbedPane pane = LoadStudentPanel();

			// frame
			this.setContentPane(pane);
		}

		if (arg0.getSource() == btTeacher) {
			user = new User(id.getText());
			title.setText("E-GLOSSARY AS " + this.user.getUserName());
			this.setSize(500, 150);
			this.setLocationRelativeTo(null);

			JPanel conectpan = new JPanel();
			conectpan.setBackground(Color.white);
			Font police = new Font("impact", Font.ITALIC, 30);
			// It is applied to the JLabel
			title.setFont(police);
			// Changing the text color
			title.setForeground(Color.red);
			// The text alignment is modified using static attributes
			// JLabel class
			title.setHorizontalAlignment(JLabel.CENTER);

			id.setHorizontalAlignment(JLabel.CENTER);
			password.setHorizontalAlignment(JLabel.CENTER);

			conectpan.setLayout(new BorderLayout());
			conectpan.add(title, BorderLayout.NORTH);
			// pan.add(new Panel(), BorderLayout.CENTER);

			conectpan.add(password, BorderLayout.CENTER);
			connect.addActionListener(this);
			conectpan.add(connect, BorderLayout.SOUTH);
			this.setContentPane(conectpan);
		}

		if (arg0.getSource() == connect) {
			char[] pass = password.getPassword();
			String passString = new String(pass);
			if (comparable(passString)) {
				System.out.println("Good PassWord");
				this.setSize(1000, 800);
				this.setLocationRelativeTo(null);
				JTabbedPane pane = LoadTeacherPanel();

				// frame
				this.setContentPane(pane);
			} else {
				System.out.println("Try again");
			}

		}
	}
	/**
	 * Load the student window.
	 * @return The student JTabbedPane object, which contains the tabs accessible to students.
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
	 * @return The student JTabbedPane object, which contains the tabs accessible to teacher.
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
	/**
	 * A method to convert a String into hexadecimal.
	 * @param source The string to convert
	 * @return The converted String object.
	 */
	static String toHexa(String source) {
		return toHexaHelp(source.getBytes());
	}

	private static String toHexaHelp(byte[] source) {
		StringBuilder sb = new StringBuilder();

		for (byte b : source) {
			String toAppend = String.format("%2X", b).replace(" ", "0");
			sb.append(toAppend);
		}

		return sb.toString();
	}

	/**
	 * A method to get the MD5 hash of a string.
	 * @param source The String object to get the MD5 hash from.
	 * @return The MD5 hash of the string.
	 */
	static String toMD5Hash(String source) {
		String result = "";

		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] md5HashBytes = md5.digest(source.getBytes());

			result = toHexaHelp(md5HashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
	/**
	 * A method to compare the hashed password to the hard coded <code>finalPassword</code> hash.
	 * @param testPassWord The password to compare
	 * @return <code>true</code> if the hashes are equals, <code>false</code> otherwise.
	 */
	public static boolean comparable(String testPassWord) {
		String testPassWordV2 = toHexa(testPassWord);

		String finalTestPassWord = toMD5Hash(testPassWordV2);

		if (finalTestPassWord.compareTo(finalPassWord) == 0)
			return true;
		else
			return false;
	}
}
