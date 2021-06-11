import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel
{

	private Image scaledImage;
	private Dimension panelSize;
	private File picture;
	private JFrame parent;

	public PicturePanel(Dimension frameSize, File picture)
	{
		this.picture = picture;
		// Note: while it is tempting to use parent properties and methods here to set the size,
		// Java Swing does not tell you the correct size at run-time (always width = 0, height = 0).
		// You are forced to pass in the desired size via the constructor before setting the JPanel size.
		this.panelSize = frameSize;
		this.setSize(panelSize);
		this.setPreferredSize(panelSize);

		Image unscaledImage = ImageUtilities.getImageFromFile(picture.getAbsolutePath());

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
		if (parent != null)
		{
			parent.setTitle(picture.getPath());
		}
		// draw the scaled image
		g.drawImage(scaledImage, 0, 0, null);
	}

	public void setParent(JFrame frame)
	{
		if (frame != null)
		{
			this.parent = frame;
		}
	}

}
