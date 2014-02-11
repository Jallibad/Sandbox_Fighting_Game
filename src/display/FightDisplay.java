package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import fight.Fight;

@SuppressWarnings("serial")
public class FightDisplay extends JPanel
{
	private Fight fight = new Fight();
	@SuppressWarnings("unused")
	private JButton advanceButton = new JButton();
	StatsDisplay statsDisplay = new StatsDisplay();
	private String lastLog = "";
	public static final int
		WIDTH = 350,
		HEIGHT = 100,
		TEXT_X = 25,
		TEXT_Y = 10;
	FightDisplay()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(statsDisplay);
		validate();
		doRound();
	}
	public void doRound()
	{
		fight.doRound();
		lastLog = fight.combatLog.poll();
	}
	public void paint(Graphics page)
	{
		page.setColor(Color.BLACK);
		page.fillRect(0, 0, WIDTH, HEIGHT);
		
		page.setColor(Color.GREEN);
		drawLines(page, lastLog, TEXT_X, TEXT_Y);
	}
	private void drawLines(Graphics page, String lines, int x, int y)
	{
		for (String line: lines.split("\n"))
			page.drawString(line, x, y+=page.getFontMetrics().getHeight());
	}
}