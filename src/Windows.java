import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;


 
public class Windows extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Windows(){             
    this.setTitle("interactive Glossary");
    this.setSize(400, 100);
    this.setLocationRelativeTo(null);               
 
    //New object JPanel
    JPanel pan = new JPanel();
    //background color
    pan.setBackground(Color.ORANGE);        
    //We warn our JFrame that our JPanel will be her JPanel pane
    this.setContentPane(new Panel());               
    this.setVisible(true);

  }               
}