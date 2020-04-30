import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PanelGlossary extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelGlossary() {
		super();
		SpinnerModel startPages = new SpinnerNumberModel(1, //initial value  
	            1, //minimum value  
	            ApplicationContext.getGlossary().numberOfPages(), //maximum value  
	            1); //step  
		JSpinner spinnerStart = new JSpinner(startPages);
		SpinnerModel endPages = new SpinnerNumberModel(1, //initial value  
	            1, //minimum value  
	            ApplicationContext.getGlossary().numberOfPages(), //maximum value  
	            1); //step  
		JSpinner spinnerEnd = new JSpinner(endPages);
		JButton runG = new JButton("run");
		JLabel fromP=new JLabel("From page");	
		JLabel to=new JLabel("to");	
		this.add(fromP);
		this.add(spinnerStart);
		this.add(to);
		this.add(spinnerEnd);
		this.add(runG);

	}
	/**
	 * 
	 */

}
