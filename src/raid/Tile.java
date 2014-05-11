package raid;

public class Tile
{
	public final MapTile TILE;
	public final Entity ENTITY;
	
	public Tile(MapTile tile, Entity entity)
	{
		TILE = tile;
		ENTITY = entity;
	}
	public boolean canInteract()
	{
		return ENTITY != null && ENTITY.canInteract;
	}
	public boolean isPassable()
	{
		return TILE.PASSABLE && (ENTITY != null ? ENTITY.passable : true);
	}
	public String toString()
	{
		return TILE+"\n"+ENTITY;
	}
}