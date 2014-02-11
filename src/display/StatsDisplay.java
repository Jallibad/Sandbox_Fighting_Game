package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatsDisplay extends JPanel
{
	public static final int
		WIDTH = 100,
		HEIGHT = 100;
	StatsDisplay()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	public void paint(Graphics page)
	{
		page.setColor(Color.BLACK);
		page.fillRect(0, 0, WIDTH, HEIGHT);
	}
}