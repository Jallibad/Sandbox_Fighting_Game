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
	public static final int
		TILES_WIDE = 100,
		TILES_HIGH = 50,
		TILE_SIZE = 10,
		WIDTH = TILES_WIDE * TILE_SIZE,
		HEIGHT = TILES_HIGH * TILE_SIZE;
	public static final Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, TILE_SIZE);
	public static final int
		TILE_WIDTH = MapTile.CHARS_WIDE*new Canvas().getFontMetrics(FONT).charWidth('a'),
		TILE_HEIGHT = MapTile.CHARS_HIGH*new Canvas().getFontMetrics(FONT).getHeight();
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
		
		for (int x=0; x<map.TILES.length && x<WIDTH; x++)
			for (int y=0; y<map.TILES[x].length && y<HEIGHT; y++)
			{
				paintTile(page, x, y);
			}
	}
	private void paintTile(Graphics page, int x, int y)
	{
		MapTile tile = map.TILES[x][y];
		page.setColor(tile.COLOR);
		page.fillRect(x*TILE_WIDTH, y*TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
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