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
	/**
	 * Checks whether the Entity can interact at the moment
	 * @return false if the Entity is null or if the Entity can't interact
	 */
	public boolean canInteract()
	{
		return ENTITY != null && ENTITY.canInteract;
	}
	public boolean isPassable()
	{
		return TILE.PASSABLE && (ENTITY != null ? ENTITY.passable : true);
	}
	@Override
	public String toString()
	{
		return TILE+"\n"+ENTITY;
	}
}