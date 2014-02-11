package display;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FightingGame extends JFrame
{
	private static JFrame frame = new JFrame("FrameDemo");
	private static FightDisplay display;
	
	public static void main(String[] args)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		displayFight();
	}
	public static void displayFight()
	{
		display = new FightDisplay();
		frame.add(display);
		frame.pack();
		display.setVisible(true);
	}
	public static void hideFight()
	{
		if (display == null)
			return;
		frame.remove(display);
		display = null;
	}
}