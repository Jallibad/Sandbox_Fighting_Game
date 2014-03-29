package raid;

import java.awt.Color;

public enum MapTile
{
//	TILE_NAME	('c',			Color.COLOR,			pass),
	CEMENT		('+',		 	Color.LIGHT_GRAY,		true),
	WALL		((char)9608,	Color.LIGHT_GRAY,		false),
	EMPTY		(' ',			Color.BLACK,			false);
	
	public final char
		LINE;
	public static final int
		CHARS_WIDE = 5, //Number of characters across in a tile
		CHARS_HIGH = 3; //Number of characters high in a tile
	public final Color
		COLOR;
	public final boolean
		PASSABLE;
	MapTile(char line, Color color, boolean pass)
	{
		LINE = line;
		COLOR = color;
		PASSABLE = pass;
	}
}