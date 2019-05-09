import java.awt.*;
import java.io.*;
//
import javax.imageio.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel {

    private Image scaledImage;
    private Dimension panelSize;

    public PicturePanel(Dimension frameSize) {

	this.panelSize = frameSize;
	this.setSize(panelSize);
	this.setPreferredSize(panelSize);

	Image unscaledImage = getImageFromFile("images/robot.jpg");

	// scale the image to a % of it's original size
	final double scale = 3.5;

	scaledImage = getScaledImage(unscaledImage, scale, scale);
	System.out.format("Image scaled width=%d, height=%d%n", scaledImage.getWidth(null),
		scaledImage.getHeight(null));

    }

    public void paint(Graphics g) {
	super.paint(g);
	g.drawImage(scaledImage, 0, 0, null);
    }

    private static Image getImageFromFile(String imagePath) {

	// load and scale the image
	try {
	    File f = new File(imagePath);
	    if (!f.exists()) {
		String errorMessage = String.format("file %s does not exist", f.getAbsolutePath());
		System.out.println(errorMessage);
		throw new FileNotFoundException(errorMessage);
	    }
	    Image unscaledImage = ImageIO.read(f);
	    System.out.format("Image original width=%d, height=%d%n", unscaledImage.getWidth(null),
		    unscaledImage.getHeight(null));
	    return unscaledImage;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    private static Image getScaledImage(Image unscaledImage, double pctWidth, double pctHeight) {
	int width = (int) (unscaledImage.getWidth(null) * pctWidth);
	int height = (int) (unscaledImage.getHeight(null) * pctHeight);
	Image scaledImage = unscaledImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	return scaledImage;
    }

}
