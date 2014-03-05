package display;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FightingGame extends JFrame
{
	private static JFrame frame = new JFrame("FrameDemo");
	private static FightDisplay fightDisplay;
	private static MapDisplay mapDisplay;
	public static Container pane;
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			System.out.println("shit's going down now");
			System.exit(1);
		}
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		frame.pack();
		frame.setVisible(true);
		displayRaid();
	}
	public FightingGame()
	{
		super();
	}
	public static void displayFight()
	{
		fightDisplay = new FightDisplay();
		pane.add(fightDisplay);
		fightDisplay.setFocusable(true);
		fightDisplay.requestFocusInWindow();
		fightDisplay.setVisible(true);
	}
	public static void displayRaid()
	{
		mapDisplay = new MapDisplay(frame.getGraphics());
		pane.add(mapDisplay);
		mapDisplay.setFocusable(true);
		mapDisplay.requestFocusInWindow();
		frame.pack();
	}
	public static void removeFight()
	{
		if (fightDisplay != null)
		{
			pane.remove(fightDisplay);
			fightDisplay = null;
		}
	}
}