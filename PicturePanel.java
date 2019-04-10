import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	private BufferedImage img;
	private ImageIcon icon;
	private Dimension screenSize;

	// ImageIcon icon = createImageIcon("images/" + name + ".gif");
	public PicturePanel(Dimension frameSize) {
		
		this.screenSize = frameSize;
		icon = createImageIcon("images/" + "robot.jpg");
		//img = new BufferedImage(width)
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = PicturePanel.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
