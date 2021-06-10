import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		
		// capture size of screen we're using
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Define the size of the JFrame as a rectangle that is a percentage of the
		// available screen area and a multiple of 100.
		final int frameHeight = (int) (screenSize.height * 85.00 / 100) / 100 * 100;
		final int frameWidth = (int) (screenSize.width * 85.00 / 100) / 100 * 100;

		Dimension frameSize = new Dimension(frameWidth, frameHeight);
		System.out.format("frameSize=%s%n", frameSize);

		JFrame frame = new JFrame("Image Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// note the use of setPreferredSize instead of setSize, coupled with
		// frame.pack() below:
		frame.setPreferredSize(frameSize);

		PicturePanel pnl = new PicturePanel(frameSize);
		frame.getContentPane().add(pnl, BorderLayout.CENTER);

		frame.pack();

		// put the JFrame in the middle of the physical screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
