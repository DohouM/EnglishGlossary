package gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * A save file prompt to ask the location where to save a file.
 */
public class SaveFileDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * The file to save.
	 */
	private File fileToSave;

	/**
	 * A constructor for this class.
	 */
	public SaveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			this.fileToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + this.fileToSave.getAbsolutePath());
		}
	}

	/**
	 * Get the file to save.
	 * 
	 * @return See {@link #fileToSave}.
	 */
	public File getFile() {

		return this.fileToSave;

	}
}