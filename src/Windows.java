import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Windows extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// all buttons
	private JButton btTeacher = new JButton("I am a teacher");
	private JButton btStudent = new JButton("I am a student");
	private JButton conect = new JButton("Conect as teacher");

	private JLabel title = new JLabel("E-GLOSSARY");
	private JTextField id = new JTextField("Your User Name");
	private User user;
	private JPasswordField password = new JPasswordField("");

	private static final String passWordV1 = "admin";

	private static final String passWordV2 = toHexa(passWordV1);

	private static final String finalPassWord = toMD5Hash(passWordV2);

	public Windows() {
		this.setTitle("interactive Glossary");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);

		// New object JPanel
		JPanel pan = new JPanel();
		// background color
		pan.setBackground(Color.ORANGE);
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
			conectpan.setBackground(Color.orange);
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
			conect.addActionListener(this);
			conectpan.add(conect, BorderLayout.SOUTH);
			this.setContentPane(conectpan);
		}

		if (arg0.getSource() == conect) {
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

		String titre3 = "proposal";
		pane.add(titre3, new PanelProposal());
		return pane;
	}

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
		String titre3 = "proposal";
		pane.add(titre3, new PanelProposalTeacher());
		
		// Pan test generato
		String titre4 = "Test Generator";
		pane.add(titre4, new PanelTestGenerator());
		
		return pane;
	}

	private static String toHexa(String source) {
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

	private static String toMD5Hash(String source) {
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

	public static boolean comparable(String testPassWord) {
		String testPassWordV2 = toHexa(testPassWord);

		String finalTestPassWord = toMD5Hash(testPassWordV2);

		if (finalTestPassWord.compareTo(finalPassWord) == 0)
			return true;
		else
			return false;
	}
}
