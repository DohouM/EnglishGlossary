import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		    // Pan
			JTabbedPane pane = new JTabbedPane();
		    String titre = "Glossary";
		    pane.add(titre, new Panel("glossary"));
		    pane.setTabComponentAt(0, new Tabs(titre, pane));
			// Pan
		    
		    String titre2 = "Quiz";
		    pane.add(titre2, new Panel("quiz"));

			// Pan
		    
		    String titre3 = "proposal";
		    pane.add(titre3, new Panel("proposal"));
		    
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
			conectpan.add(conect, BorderLayout.SOUTH);
			this.setContentPane(conectpan);
		}

	}
}

