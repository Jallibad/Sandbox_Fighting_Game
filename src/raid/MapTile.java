package raid;

import java.awt.Color;

public enum MapTile
{
//	TILE_NAME	('c',	Color.COLOR,		pass),
	CEMENT		('+', 	Color.LIGHT_GRAY,	true),
	EMPTY		(' ',	Color.BLACK,		false);
	
	@SuppressWarnings("unused")
	private final char LINE;
	public final Color COLOR;
	public final boolean
		PASSABLE;
	MapTile(char line, Color color, boolean pass)
	{
		LINE = line;
		COLOR = color;
		PASSABLE = pass;
	}
}