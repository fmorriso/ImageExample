import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PictureHelper
{
	public static File choosePicture()
	{
		// assumes there is a images directory in this project
		File imagesDir = new File(FileChooser.getMediaDirectory());	
		JFileChooser j = new JFileChooser(imagesDir);
		//j.setCurrentDirectory(imagesDir);
		// resctrict the user to select files of all types
		j.setAcceptAllFileFilterUsed(false);

		// set a title for the dialog
		j.setDialogTitle("Select a picture");

		// only allow files of .txt extension
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only pictures (.jpg)", "jpg");
		j.addChoosableFileFilter(restrict);

		// invoke the showsOpenDialog function to show the open file dialog
		int r = j.showOpenDialog(null);
		
		// if the user selects a file
		if (r == JFileChooser.APPROVE_OPTION)
		{
			return j.getSelectedFile();
		}
		else
		{
			return null;
		}

	}
}
