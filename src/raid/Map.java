package raid;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Map
{
	private static final String
		EXTENSION = ".map"; //The file extension of a map example:"example.txt"
	private final String
		FILE_NAME;
	public int
		playerX,
		playerY;
	public boolean readyToClose = false;
	public final Tile[][] TILES;
	
	/**
	 * Creates a map from the given fileName
	 * @param fileName - The name of the map (no extension necessary)
	 */
	public Map(String fileName)
	{
		FILE_NAME = fileName;
		playerX = 0;
		playerY = 0;
		Tile[][] tileResult;
		try (Scanner reader = new Scanner(new FileReader(FILE_NAME+EXTENSION)))
		{
			ArrayList<ArrayList<Tile>> arrayResult = new ArrayList<ArrayList<Tile>>();
			ArrayList<Tile> arrayX = new ArrayList<Tile>();
			
			reader.useDelimiter("[\\t\\n\\r]"); //Reads until it encounters a tab or carriage return
			int currY = 0;
			while (reader.hasNext())
			{
				String token = reader.next();
				
				if (token.isEmpty()) //If the scanner reached the end of the row
				{
					arrayResult.add(currY++, arrayX);
					arrayX = new ArrayList<Tile>();
					continue;
				}
				
				Entity entity = null;
				
				if (token.charAt(0)=='[') //If the current token contains a MapTile and Entity
				{
					String[] split = token.substring(1, token.length()-1).split(" "); //Split the token minus the brackets
					try
					{
						String packageName = Entity.class.getPackage().getName();
						Object temp = Class.forName(packageName+"."+split[1]).getConstructor().newInstance();
						if (!(temp instanceof Entity))
							throw new ClassNotFoundException(temp+" is a class, but not a subclass of Entity");
						entity = (Entity) temp;
					}
					catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e)
					{
						String errorMessage =
								"Entity wrong: "+split[1]+
								"\n"+
								e.getClass()+
								"\nIgnoring this entity";
						
						System.out.println(errorMessage);
						JOptionPane.showMessageDialog(null, errorMessage);
					}
					token = split[0];
				}
				arrayX.add(new Tile(MapTile.valueOf(token), entity));
			}
			arrayResult.add(currY++, arrayX);
			
			//Gets the width of the map
			int arrayWidth = 0;
			for (int i=0; i<arrayResult.size(); i++)
				if (arrayResult.get(i).size()>arrayWidth)
					arrayWidth = arrayResult.get(i).size();
			
			tileResult = new Tile[arrayWidth][arrayResult.size()];
			for (int x=0; x<tileResult.length; x++)
				for (int y=0; y<tileResult[x].length; y++)
					tileResult[x][y] = new Tile(MapTile.EMPTY, null);
			for (int y=0; y<arrayResult.size(); y++)
				for (int x=0; x<arrayResult.get(y).size(); x++)
					tileResult[x][y] = arrayResult.get(y).get(x);
		}
		catch (IOException | IllegalArgumentException e)
		{
			String errorMessage = e.getMessage();
			if (e instanceof IOException)
				errorMessage = FILE_NAME+EXTENSION+" not found";
			else if (e instanceof IllegalArgumentException)
				errorMessage = FILE_NAME+" has an invalid tile in it\n"+e.getMessage();
			System.out.println(errorMessage);
			JOptionPane.showMessageDialog(null, errorMessage);
			tileResult = new Tile[0][0];
			System.exit(1); //TODO Exit the map without exiting the program
		}
		TILES = tileResult;
	}
	
	/**
	 * Tries to move the player the requested x/y delta and allows interactions with Entity's
	 * @param xDelta - the x delta to move the player by
	 * @param yDelta - the y delta to move the player by
	 */
	public void tryMove(int xDelta, int yDelta)
	{
		int
			propX = playerX+xDelta,
			propY = playerY+yDelta;
		
		if (!isACoordinate(propX, propY))
			return;
		
		Tile tile = TILES[propX][propY];
		
		if (tile.canInteract() && !tile.ENTITY.passable)
			tile.ENTITY.interact();
		else if (tile.isPassable())
		{
			playerX = propX;
			playerY = propY;
		}
	}
	
	/**
	 * Checks whether the given coordinate contains a valid MapTile
	 * @param x - the x coordinate
	 * @param y - the y coordinate
	 * @return true if valid, false otherwise.
	 */
	private boolean isACoordinate(int x, int y)
	{
		return
			x >= 0 &&
			y >= 0 &&
			x <= TILES.length-1 &&
			y <= TILES[x].length-1;
	}
}