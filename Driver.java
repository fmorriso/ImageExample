import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {

		// capture size of screen we're using
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Define the size of the JFrame as a rectangle that is a percentage of the
		// available device screen area, rounded to a multiple of 100, because it
    // might make it easier to do calculations that position other objects within
    // the frame.
		final double pct = 90; // a value that I recommend be between 50 and 100
		final int frameHeight = (int) (screenSize.height * pct / 100) / 100 * 100;
		final int frameWidth = (int) (screenSize.width * pct / 100) / 100 * 100;

		Dimension frameSize = new Dimension(frameWidth, frameHeight);
		System.out.format("frameSize=%s%n", frameSize);

		JFrame frame = new JFrame("Image Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Notice the use of setPreferredSize instead of setSize, coupled with
		// frame.pack() below:
		frame.setPreferredSize(frameSize);

    // Create the JPanel that sits inside the JFrame.
    // Notice how we have to tell it the size of the "parent" JFrame
    // in order to size it correctly.
		PicturePanel pnl = new PicturePanel(frameSize);
		frame.getContentPane().add(pnl, BorderLayout.CENTER);

		// This is key to making the JFrame and JPanel contents look correct,
    // at least initially.
    frame.pack();

		// put the JFrame in the middle of the physical screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
