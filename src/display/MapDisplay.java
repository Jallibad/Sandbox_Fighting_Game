package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import raid.Map;

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
	public MapDisplay(Graphics page)
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		map = new Map("test_map", page);
		repaint();
	}
	@Override
	public void paint(Graphics page)
	{
		map.draw();
	}
	@Override
	public void keyPressed(KeyEvent k)
	{
		System.out.println(k.getKeyCode());
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