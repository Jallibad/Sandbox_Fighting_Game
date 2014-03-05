package raid;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Map
{
	private static final String
		EXTENSION = ".map";
	public static final int
		TILES_WIDE = 5,
		TILES_HIGH = 3;
	private final String
		FILE_NAME;
	private int
		x,
		y;
	public final MapTile[][] TILES;
	
	public Map(String fileName)
	{
		FILE_NAME = fileName;
		x = 0;
		y = 0;
		MapTile[][] result;
		try
		{
			ArrayList<ArrayList<MapTile>> arrayResult = new ArrayList<ArrayList<MapTile>>();
			Scanner reader = new Scanner(new FileReader(FILE_NAME+EXTENSION));
			
			reader.useDelimiter("\\s");
			@SuppressWarnings("unused")
			int currX;
			@SuppressWarnings("unused")
			int currY;
			while (reader.hasNext())
			{
				@SuppressWarnings("unused")
				String token = reader.next();
				//TODO Read map from file and store
			}
			reader.close();
			//arrayResult.get(0).size() put this in the slot with 0 once something has been added
			result = new MapTile[arrayResult.size()][0];
		}
		catch (IOException e)
		{
			System.out.println(FILE_NAME+EXTENSION+" not found");
			JOptionPane.showMessageDialog(null, FILE_NAME+EXTENSION+" could not be found");
			result = new MapTile[0][0];
		}
		TILES = result;
	}
	public void move(int xDelta, int yDelta)
	{
		if (passable(x+xDelta, y+yDelta))
		{
			x += xDelta;
			y += yDelta;
		}
		System.out.println(x+"\t"+y);
	}
	private boolean passable(int x, int y)
	{
		//TODO Collision checking
		return true;
	}
}