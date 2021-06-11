import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel
{

	private Image scaledImage;
	private Dimension panelSize;

	public PicturePanel(Dimension frameSize)
	{
    // Note: while it is tempting to use parent properties and methods here to set the size,
    // Java Swing does not tell you the correct size at run-time (always width = 0, height = 0).
    // You are forced to pass in the desired size via the constructor before setting the JPanel size.
		this.panelSize = frameSize;
		this.setSize(panelSize);
		this.setPreferredSize(panelSize);

    // pull in an image from the images directory that is part of this project.
    // feel free to change it to suit your needs.
		Image unscaledImage = ImageUtilities.getImageFromFile("images/femaleLionAndHall.jpg");

		// scale the image to fit within the panel
		double scale = ImageUtilities.getOptimumScale(panelSize, unscaledImage);

		scaledImage = ImageUtilities.getScaledImage(unscaledImage, scale, scale);
		System.out.format("Image scaled width=%d, height=%d%n", scaledImage.getWidth(null),
				scaledImage.getHeight(null));

	}

  @Override
	public void paint(Graphics g)
	{
		super.paint(g);
    // draw the scaled image
		g.drawImage(scaledImage, 0, 0, null);
	}

}
