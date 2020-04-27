
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  }
 
  public void actionPerformed(ActionEvent e) {
    int i = pane.indexOfTabComponent(this);
    if (i != -1)
      pane.remove(i);
  }
}
