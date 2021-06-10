import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel
{

	private Image scaledImage;
	private Dimension panelSize;

	public PicturePanel(Dimension frameSize)
	{

		this.panelSize = frameSize;
		this.setSize(panelSize);
		this.setPreferredSize(panelSize);

		Image unscaledImage = ImageUtilities.getImageFromFile("images/femaleLionAndHall.jpg");

		// scale the image to a % of it's original size
		double scale = ImageUtilities.getOptimumScale(panelSize, unscaledImage);

		scaledImage = ImageUtilities.getScaledImage(unscaledImage, scale, scale);
		System.out.format("Image scaled width=%d, height=%d%n", scaledImage.getWidth(null),
				scaledImage.getHeight(null));

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(scaledImage, 0, 0, null);
	}

}
