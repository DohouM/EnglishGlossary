
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Panel extends JPanel { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g){

    System.out.println("Je suis exécutée !");
    Word hello = new Word("hello", "bonjour");
    g.drawString(hello.toString(), 10, 20);
    

  }               
}

class ComposantOnglet extends JPanel implements ActionListener {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane pane;
	 
	  public ComposantOnglet(String titre, JTabbedPane pane) {
	    this.pane = pane;
	    setOpaque(false);
	    JLabel label = new JLabel(titre);
	    add(label);
	    JButton button = new JButton("Fermer");
	    button.setPreferredSize(new Dimension(50,30));
	    button.addActionListener(this);
	    add(button);
	  }
	 
	  public void actionPerformed(ActionEvent e) {
	    int i = pane.indexOfTabComponent(this);
	    if (i != -1)
	      pane.remove(i);
	  }
	}
	 
	public class ExempleComposantOnglet {
	  public static void main(String[] args) {
	    JTabbedPane pane = new JTabbedPane();
	    String titre = "Onglet";
	    pane.add(titre, new JLabel(titre));
	    pane.setTabComponentAt(0, new ComposantOnglet(titre, pane));
	 
	    JFrame frame = new JFrame("Exemple des onglets en java");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(pane);
	    frame.setSize(500, 200);
	    frame.setVisible(true);
	  }
	}
