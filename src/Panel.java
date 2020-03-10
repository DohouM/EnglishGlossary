
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panel extends JPanel { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g){

    System.out.println("Je suis exécutée !");
    Word hello = new Word("hello", "bonjour",1);
    g.drawString(hello.toString(), 10, 20);
  }               
}
