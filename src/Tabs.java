
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * A class that describes a tab of the application.
 * 
 * @author Medhy DOHOU, Jean-Camille LAPIERRE, Dorian MOUNIER, Cyril PIGEYRE,
 *         Gabriel SAPONARA
 *
 */

class Tabs extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    /**
     * The JTabbedPane wrapped by the object.
     */
    private JTabbedPane pane;

    /**
     * Constructor for the Tabs class.
     * 
     * @param titre The title of the tab.
     * @param pane  The JTabbedPane object to wrap.
     */
    public Tabs(String titre, JTabbedPane pane) {
	this.pane = pane;
	setOpaque(false);
	JLabel label = new JLabel(titre);
	add(label);
    }

    /**
     * Method that describes what to do if an action is performed.
     * 
     * @param arg0 The action performed by the user
     */
    public void actionPerformed(ActionEvent e) {
	int i = this.pane.indexOfTabComponent(this);
	if (i != -1)
	    this.pane.remove(i);
    }
}
