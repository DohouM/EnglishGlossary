import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveFileDialog extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	File fileToSave;

public SaveFileDialog() {
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setDialogTitle("Specify a file to save");

	int userSelection = fileChooser.showSaveDialog(this);
	if (userSelection == JFileChooser.APPROVE_OPTION) {
		fileToSave = fileChooser.getSelectedFile();
		System.out.println("Save as file: " + fileToSave.getAbsolutePath());
	}
}


public File getFile() {
	
	return fileToSave;
	
}
}