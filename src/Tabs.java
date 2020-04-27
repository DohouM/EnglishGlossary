
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
class Tabs extends JPanel implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JTabbedPane pane;
 


public Tabs(String titre, JTabbedPane pane) {
    this.pane = pane;
    setOpaque(false);
    JLabel label = new JLabel(titre);
    add(label);
    JButton button = new JButton("❌");
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
