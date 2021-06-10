import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtilities
{
	public static Image getImageFromFile(String imagePath)
	{

		// load and scale the image
		try
		{
			File f = new File(imagePath);
			if (!f.exists())
			{
				String errorMessage = String.format("file %s does not exist", f.getAbsolutePath());
				System.out.println(errorMessage);
				throw new FileNotFoundException(errorMessage);
			}
			Image unscaledImage = ImageIO.read(f);
			System.out.format("Image original width=%d, height=%d%n", unscaledImage.getWidth(null),
					unscaledImage.getHeight(null));
			return unscaledImage;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Image getScaledImage(Image unscaledImage, double pctWidth, double pctHeight)
	{
		int width = (int) (unscaledImage.getWidth(null) * pctWidth);
		int height = (int) (unscaledImage.getHeight(null) * pctHeight);
		Image scaledImage = unscaledImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return scaledImage;
	}
	
	public static double getOptimumScale(Dimension panelSize, Image img)
	{
		double scale = 1;
		
		double scaleW = 1;
		int imgW = img.getWidth(null);
		if(imgW > panelSize.width)
		{
			scaleW = (double)imgW / panelSize.width; // image too wide, so scale back the width
		}
		else if (imgW < panelSize.width)
		{
			scaleW = (double)panelSize.width / imgW; // enlarge image
		}
		
		double scaleH = 1;
		int imgH = img.getHeight(null);
		if(imgH > panelSize.height)
		{
			scaleH = (double)imgH / panelSize.height; // image too tall, so scale back the height
		}
		else if(imgH < panelSize.height)
		{
			scaleH = (double)panelSize.height / imgH; // enlarge image
		}
		
		// use the smaller of scaleH and scaleW to preserve aspect ratio of image
		scale = Math.min(scaleH, scaleW);
		return scale;
	}
}
