import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileHelper
{
	public static File choosePicture()
	{
		
		File baseDir = new File(System.getProperty("user.dir"));
//		File baseDir = FileSystemView.getFileSystemView().getHomeDirectory();
		File imagesDir = new File(baseDir, "images");
		JFileChooser j = new JFileChooser(imagesDir);
		//j.setCurrentDirectory(imagesDir);
		// resctrict the user to select files of all types
		j.setAcceptAllFileFilterUsed(false);

		// set a title for the dialog
		j.setDialogTitle("Select a picture");

		// only allow files of .txt extension
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only pictures", "jpg");
		j.addChoosableFileFilter(restrict);

		// invoke the showsOpenDialog function to show the save dialog
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
