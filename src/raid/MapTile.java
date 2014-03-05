package raid;

import java.awt.Color;
import java.awt.Graphics;

public enum MapTile
{
//	TILE_NAME	('c',	Color.COLOR),
	CEMENT		('+', 	Color.LIGHT_GRAY);
	
	private final char LINE;
	private final Color COLOR;
	public Graphics page;
	public static final int
		ROWS = 3,
		COLUMNS = 5;
	MapTile(char line, Color color)
	{
		LINE = line;
		COLOR = color;
	}
	public void drawTiles(int tileX, int tileY)
	{
		if (page == null)
			return;
		int fontWidth = page.getFontMetrics().charWidth('a'); //The 'a' is because the font is monospace
		int fontHeight = page.getFontMetrics().getHeight();
		
		int startX = tileX*30;
		int startY = tileY*100;
		
		page.setColor(COLOR);
		for (int x=startX; x<fontWidth*COLUMNS+startX; x+=fontWidth)
			for (int y=startY; y<(ROWS+1)*fontHeight+startY; y+=fontHeight)
				page.drawString(String.valueOf(LINE), x, y);
	}
	@SuppressWarnings("unused")
	private void drawLetter(char letter, int x, int y)
	{
		
	}
}