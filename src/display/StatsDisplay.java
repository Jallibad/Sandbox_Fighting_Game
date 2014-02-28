package display;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import character.Team;

@SuppressWarnings("serial")
public class StatsDisplay extends JPanel
{
	public static final int
		WIDTH = 350,
		HEIGHT = 100;
	public final String name;
	private static final int
		TEXT_DROP = 20;
	private final Team team;
	StatsDisplay(Team _team, String _name)
	{
		team = _team;
		name = _name;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		repaint();
	}
	public void paint(Graphics page)
	{
		Font defaultFont = page.getFont();
		page.setFont(page.getFont().deriveFont(18.0f));
		page.drawString(name, (WIDTH-page.getFontMetrics().stringWidth(name))/2, TEXT_DROP);
		page.setFont(defaultFont);
		drawLines(page, team.getNames(), WIDTH/3);
		drawLines(page, team.getHealth(), WIDTH/3*2);
	}
	private void drawLines(Graphics page, String[] lines, int x)
	{
		FontMetrics fontMetric = page.getFontMetrics();
		int y = fontMetric.stringWidth(name);
		
		for (String line: lines)
			page.drawString(line, x-fontMetric.stringWidth(line)/2, y += fontMetric.getHeight());
	}
}