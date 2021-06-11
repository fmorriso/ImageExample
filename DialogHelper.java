import java.awt.Font;

import java.util.*;

import javax.swing.JDialog;
import javax.swing.UIManager;

public class DialogHelper {
	/**
	 * Changes the font size used in JOptionPane.showInputDialogs to make them more
	 * ADA section 508 compliant by making the text size larger, which is very nice
	 * for older people and anyone else with vision problems.
	 */
	/**
	 * @param fontSize - size of the font in pixels
	 */
	public static void makeDialogsEasierToSee(int fontSize) {
		makeDialogsEasierToSee(Font.MONOSPACED, fontSize);
	}

	public static void makeDialogsEasierToSee(String fontName, int fontSize) {
		// This next one is very strange; but, without it,
		// any subsequent attempt to set InternalFrame.titleFont will
		// be ignored, so resist the temptation to remove it.
		JDialog.setDefaultLookAndFeelDecorated(true);

		// define normal and bold fonts that we will use to override the defaults
		Font normalFont = new Font(fontName, Font.PLAIN, fontSize);
		Font boldFont = normalFont.deriveFont(Font.BOLD);

		// get a list of objects that we can try to adjust font size and style for
		List<Map.Entry<Object, Object>> entries = new ArrayList<>(UIManager.getLookAndFeelDefaults().entrySet());
		// System.out.println(entries.size());
		// remove anything that does NOT involve font selection
		entries.removeIf(filter -> filter.getKey().toString().indexOf(".font") == -1);
		// System.out.println(entries.size());

		// Define a list of font sections of the screen that we do NOT want to
		// enlarge/bold.
		// The following is specific to jKarel so we do not obscure the display of
		// "beeper piles" on the maps.
		List<String> exempt = Arrays.asList("Panel.font");

		// remove anything on the exempt list
		entries.removeIf(filter -> exempt.contains(filter.getKey().toString()));
		// System.out.println(entries.size());

		// optional: sort the final list
		Collections.sort(entries, Comparator.comparing(e -> Objects.toString(e.getKey())));

		// apply normal font to all font objects that survived the filters
		for (Map.Entry<Object, Object> entry : entries) {
			String key = entry.getKey().toString();
			// System.out.println(key);
			UIManager.put(key, normalFont);
		}

		UIManager.put("Label.font", boldFont);
		UIManager.put("InternalFrame.titleFont", boldFont);
	}
}