package raid;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Map
{
	private static final String
		EXTENSION = ".map"; //The file extension of a map ex:"example.txt"
	private final String
		FILE_NAME;
	public int
		playerX,
		playerY;
	public final MapTile[][] TILES;
	
	/**
	 * Creates a map from the given fileName
	 * @param fileName - The name of the map (no extension necessary)
	 */
	public Map(String fileName)
	{
		FILE_NAME = fileName;
		playerX = 0;
		playerY = 0;
		MapTile[][] result;
		try
		{
			ArrayList<ArrayList<MapTile>> arrayResult = new ArrayList<ArrayList<MapTile>>();
			ArrayList<MapTile> arrayX = new ArrayList<MapTile>();
			Scanner reader = new Scanner(new FileReader(FILE_NAME+EXTENSION));
			
			reader.useDelimiter("\\s");
			int currY = 0;
			while (reader.hasNext())
			{
				String token = reader.next();
				if (token.equals(""))
				{
					arrayResult.add(currY++, arrayX);
					arrayX = new ArrayList<MapTile>();
				}
				else
					arrayX.add(MapTile.valueOf(token));
			}
			arrayResult.add(currY++, arrayX);
			reader.close();
			result = new MapTile[arrayResult.get(0).size()][arrayResult.size()];
			for (int x=0; x<arrayResult.size(); x++)
				for (int y=0; y<arrayResult.get(x).size(); y++)
					result[y][x] = arrayResult.get(x).get(y);
		}
		catch (IOException e)
		{
			System.out.println(FILE_NAME+EXTENSION+" not found");
			JOptionPane.showMessageDialog(null, FILE_NAME+EXTENSION+" could not be found");
			result = new MapTile[0][0];
		}
		TILES = result;
	}
	/**
	 * Moves the player the requested x/y delta
	 * @param xDelta - the x delta to move the player by
	 * @param yDelta - the y delta to move the player by
	 */
	public void move(int xDelta, int yDelta)
	{
		int
			propX = playerX+xDelta,
			propY = playerY+yDelta;
		if (passable(propX, propY))
		{
			playerX = propX;
			playerY = propY;
		}
			System.out.println(playerX+"\t"+playerY);
	}
	/**
	 * Re-centers the camera on the player
	 */
	public void recenterCamera()
	{
		//TODO Re-center camera code
	}
	/**
	 * Checks if the given tile is passable
	 * @param x - the x of the tile to search on
	 * @param y - the y of the tile to search on
	 * @return A boolean 'true' if the tile is passable to the player, a false otherwise
	 */
	private boolean passable(int x, int y)
	{
		try
		{
			return TILES[x][y].PASSABLE;
		}
		catch (ArrayIndexOutOfBoundsException | NullPointerException e)
		{
			return false;
		}
	}
}