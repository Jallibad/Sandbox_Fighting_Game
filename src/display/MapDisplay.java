package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import raid.Map;
import raid.MapTile;

@SuppressWarnings("serial")
public class MapDisplay extends JPanel implements KeyListener
{
	public static final Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, 10 /*Change this to change font size*/);
	public static final int
		TILES_WIDE = 25,
		TILES_HIGH = 15,
		CHAR_WIDTH = new Canvas().getFontMetrics(FONT).charWidth('a'),
		CHAR_HEIGHT = new Canvas().getFontMetrics(FONT).getAscent(),
		TILE_WIDTH = MapTile.CHARS_WIDE*CHAR_WIDTH,
		TILE_HEIGHT = MapTile.CHARS_HIGH*CHAR_HEIGHT,
		WIDTH = TILES_WIDE*CHAR_WIDTH*MapTile.CHARS_WIDE,
		HEIGHT = TILES_HIGH*CHAR_HEIGHT*MapTile.CHARS_HIGH;
	public Map map;
	public MapDisplay()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		map = new Map("test_map");
		repaint();
	}
	@Override
	public void paint(Graphics page)
	{
		page.setColor(Color.BLACK);
		page.fillRect(0, 0, MapDisplay.WIDTH, MapDisplay.HEIGHT);
		page.setFont(FONT);
		
		char[][] representation = map.represent(TILES_WIDE, TILES_HIGH);
		for (int x=0; x<representation.length; x++)
			for (int y=0; y<representation[y].length; y++)
			{
				page.setColor(Color.WHITE);
				page.drawString(String.valueOf(representation[x][y]), x*CHAR_WIDTH, (y+1)*CHAR_HEIGHT);
			}
	}
	@Override
	public void keyPressed(KeyEvent k)
	{
		switch(k.getKeyCode())
		{
			case 37: //Left arrow
				map.move(-1, 0);
				break;
			case 38: //Down arrow
				map.move(0, -1);
				break;
			case 39: //Right arrow
				map.move(1, 0);
				break;
			case 40: //Up arrow
				map.move(0, 1);
				break;
		}
	}
	@Override
	public void keyReleased(KeyEvent k)
	{
	}
	@Override
	public void keyTyped(KeyEvent k)
	{
	}
}