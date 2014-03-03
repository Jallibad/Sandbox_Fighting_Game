package display;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class FightingGame extends JFrame
{
	private static JFrame frame = new JFrame("FrameDemo");
	private static FightDisplay display;
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
		
		displayFight();
		
		frame.pack();
		frame.setVisible(true);
	}
	public FightingGame()
	{
		super();
	}
	public static void displayFight()
	{
		display = new FightDisplay();
		pane.add(display);
		display.setFocusable(true);
		display.requestFocusInWindow();
		display.setVisible(true);
	}
	public static void removeFight()
	{
		if (display != null)
		{
			pane.remove(display);
			display = null;
		}
	}
	public static void pause()
	{
		
	}
}