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
import raid.Tile;

@SuppressWarnings("serial")
public class MapDisplay extends JPanel implements KeyListener
{
	public static final Font FONT = new Font("Courier new", Font.PLAIN, 10 /*Change this to change font size*/);
	public static final String playerText = "SQUAD"; //The text to display at the squad's location
	public static final int
		TILES_WIDE = 25,
		TILES_HIGH = 15,
		CHAR_WIDTH = new Canvas().getFontMetrics(FONT).charWidth('a'),
		CHAR_HEIGHT = new Canvas().getFontMetrics(FONT).getAscent(),
		TILE_WIDTH = MapTile.CHARS_WIDE*CHAR_WIDTH,
		TILE_HEIGHT = MapTile.CHARS_HIGH*CHAR_HEIGHT,
		WIDTH = TILES_WIDE*TILE_WIDTH,
		HEIGHT = TILES_HIGH*TILE_HEIGHT;
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
		//Clears and sets the background
		page.setColor(Color.BLACK);
		page.fillRect(0, 0, MapDisplay.WIDTH, MapDisplay.HEIGHT);
		
		page.setFont(FONT);
		
		for (int tileX=0; tileX<map.TILES.length; tileX++)
			for (int tileY=0; tileY<map.TILES[tileX].length; tileY++)
				drawTile(page, tileX, tileY);
		int
			textX = map.playerX*TILE_WIDTH,
			textY = ((map.playerY+1)*MapTile.CHARS_HIGH-MapTile.SQUAD_TEXT_DROP)*CHAR_HEIGHT;
		page.setColor(Color.BLACK);
		page.fillRect(textX, textY-MapTile.SQUAD_TEXT_DROP*CHAR_HEIGHT, TILE_WIDTH, CHAR_HEIGHT);
		page.setColor(Color.YELLOW);
		page.drawString(playerText, textX, textY);
	}
	private void drawTile(Graphics page, int tileX, int tileY)
	{
		Tile tile = map.TILES[tileX][tileY];
		page.setColor(tile.TILE.COLOR);
		for (int x=0; x<MapTile.CHARS_WIDE; x++)
			for (int y=0; y<MapTile.CHARS_HIGH; y++)
			{
				char cell = tile.TILE.PIECE;
				if (tile.ENTITY != null)
				{
					String entityLine = tile.ENTITY.draw()[y];
					
					for (int i=0; i<MapTile.CHARS_WIDE; i++)
						if (entityLine.charAt(x) != ' ')
							cell = entityLine.charAt(x);
				}
				page.drawString(String.valueOf(cell), CHAR_WIDTH*(tileX*MapTile.CHARS_WIDE+x), CHAR_HEIGHT*(tileY*MapTile.CHARS_HIGH+y+1));
			}
	}
	@Override
	public void keyPressed(KeyEvent k)
	{
		switch(k.getKeyCode())
		{
			//TODO Remove the magic numbers from the key-codes
			case 37: //Left arrow
				map.tryMove(-1, 0);
				break;
			case 38: //Down arrow
				map.tryMove(0, -1);
				break;
			case 39: //Right arrow
				map.tryMove(1, 0);
				break;
			case 40: //Up arrow
				map.tryMove(0, 1);
				break;
			case 69: //Interact key
				map.TILES[map.playerX][map.playerY].ENTITY.interact();
				break;
		}
		repaint();
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