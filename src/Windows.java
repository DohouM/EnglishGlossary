import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Windows extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton button = new JButton("Connect");
	private JLabel title = new JLabel("E-GLOSSARY");
	private JTextField id = new JTextField("Your User Name");
	private JTextField password = new JTextField("Your Password");

	public Windows() {
		this.setTitle("interactive Glossary");
		this.setSize(400, 800);
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

		button.addActionListener(this);
		
		
		pan.setLayout(new BorderLayout());
		pan.add(title, BorderLayout.NORTH);
		pan.add(new Panel(), BorderLayout.CENTER);
		pan.add(id,BorderLayout.WEST);
		pan.add(password,BorderLayout.AFTER_LINE_ENDS);
		pan.add(button, BorderLayout.SOUTH);

		this.setContentPane(pan);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) { //Method that will be called when clicking on the button
		
		System.out.println("BT on");
		this.setSize(1000, 800);
		System.out.println("TEXT : id " + id.getText());

	}

}