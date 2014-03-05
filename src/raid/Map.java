package raid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import display.MapDisplay;

public class Map
{
	public static final int
		FONT_SIZE = 10;
	private final Graphics PAGE;
	private final String
		FILE_NAME;
	private final int
		START_X,
		START_Y;
	@SuppressWarnings("unused")
	private int
		x,
		y;
	
	public Map(String fileName, Graphics page)
	{
		FILE_NAME = fileName;
		START_X = 0;
		START_Y = 0;
		PAGE = page;
		reset();
	}
	private void reset()
	{
		x = START_X;
		y = START_Y;
	}
	public void draw()
	{
		System.out.println(PAGE);
		PAGE.setColor(Color.BLACK);
		PAGE.fillRect(0, 0, MapDisplay.WIDTH, MapDisplay.HEIGHT);
		System.out.println("drawing map");
		try
		{
			Scanner reader = new Scanner(new FileReader(FILE_NAME+".map"));
			
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, FONT_SIZE);
			PAGE.setFont(font);
			
			PAGE.setColor(Color.WHITE);
			reader.useDelimiter("\\s");
			int x=0;
			int y=0;
			while (reader.hasNext())
			{
				String token = reader.next();
				if (token.equals(""))
					y++;
				else
					MapTile.valueOf(token).drawTiles(x++, y);
			}
			
			reader.close();
		}
		catch (IOException e)
		{
			System.out.println(FILE_NAME+"'s map not found");
		}
	}
}