package raid;

import java.awt.Color;

public enum MapTile
{
//	TILE_NAME	('t',	Color.COLOR,			pass),
	CEMENT		('+',	Color.LIGHT_GRAY,		true),
	WALL		('█',	Color.LIGHT_GRAY,		false),
	EMPTY		(' ',	Color.BLACK,			false),
	FLOOR		('-',	Color.WHITE,			true);
	
	public static final int
		CHARS_WIDE = 5, //Number of characters across in a tile
		CHARS_HIGH = 3, //Number of characters high in a tile
		SQUAD_TEXT_DROP = 1; //Where the "SQUAD" text should be placed
	public final char
		PIECE;
	public final Color
		COLOR;
	public final boolean
		PASSABLE;
	MapTile(char piece, Color color, boolean pass)
	{
		PIECE = piece;
		COLOR = color;
		PASSABLE = pass;
	}
}