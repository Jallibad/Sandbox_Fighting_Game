package display;

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
		TILE_WIDTH = 100,
		TILE_HEIGHT = 50,
		TILE_SIZE = 10,
		WIDTH = TILE_WIDTH * TILE_SIZE,
		HEIGHT = TILE_HEIGHT * TILE_SIZE;
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
		
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, TILE_SIZE);
		page.setFont(font);
		
		for (MapTile[] tiles: map.TILES)
			for (MapTile tile: tiles)
			{
				System.out.println(tile);
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