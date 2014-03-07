package raid;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Map
{
	private static final String
		EXTENSION = ".map"; //The file extension of a map ex:"example.txt"
	private final String
		FILE_NAME;
	private int
		playerX,
		playerY,
		cameraX,
		cameraY;
	public final MapTile[][] TILES;
	
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
			int
				currX = 0,
				currY = 0;
			while (reader.hasNext())
			{
				String token = reader.next();
				//TODO Read map from file and store
				if (token.equals(""))
				{
					arrayResult.add(currY++, arrayX);
					arrayX = new ArrayList<MapTile>();
				}
				else
				{
					arrayX.add(MapTile.valueOf(token));
				}
			}
			arrayResult.add(currY++, arrayX);
			reader.close();
			result = new MapTile[arrayResult.size()][arrayResult.get(0).size()];
			for (int x=0; x<arrayResult.size(); x++)
				for (int y=0; y<arrayResult.get(x).size(); y++)
					result[x][y] = arrayResult.get(x).get(y);
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
		//TODO fix the fuck out of this
		try
		{
			return TILES[x][y].PASSABLE;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
	}
}