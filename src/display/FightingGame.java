package display;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FightingGame extends JFrame
{
	private static final long serialVersionUID = 8414556091201531482L;
	private static JFrame frame = new JFrame("Sandbox Fighting Game");
	private static FightDisplay fightDisplay;
	private static MapDisplay mapDisplay;
	public static Container pane;
	
	public static void displayFight()
	{
		fightDisplay = new FightDisplay();
		pane.add(fightDisplay);
		fightDisplay.setFocusable(true);
		fightDisplay.requestFocusInWindow();
		fightDisplay.setVisible(true);
		frame.pack();
	}
	public static void displayRaid()
	{
		mapDisplay = new MapDisplay();
		pane.add(mapDisplay);
		mapDisplay.setFocusable(true);
		mapDisplay.requestFocusInWindow();
		frame.pack();
	}
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			String message = "Shit's going down now (the setLookAndFeel method just shat itself)";
			JOptionPane.showMessageDialog
			(
				null,
				message
			);
			System.out.println(message);
			System.exit(1);
		}
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		frame.pack();
		frame.setVisible(true);
//		displayRaid();
		displayFight();
	}
	public static void removeFight()
	{
		if (fightDisplay != null)
		{
			pane.remove(fightDisplay);
			fightDisplay = null;
		}
	}
	public FightingGame()
	{
		super();
	}
}