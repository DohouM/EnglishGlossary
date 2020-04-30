import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class PanelQuiz extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public PanelQuiz() {
		super();	
		String[] monthStrings = {"1","2","3"}; //get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		JSpinner spinner = new JSpinner(monthModel);
		SpinnerListModel monthModel2 = new SpinnerListModel(monthStrings);
		JSpinner spinner2 = new JSpinner(monthModel2);
		this.add(spinner);
		this.add(spinner2);
	}


}
