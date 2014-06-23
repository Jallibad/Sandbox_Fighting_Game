package raid;

/**
 * An abstract representing any map feature that is not a MapTile.  Should be extended to represent more things.
 * @author Jallibad
 *
 */
public abstract class Entity
{
	protected boolean
		passable = false,
		canInteract = true,
		chooseableInteraction = true;
	/**
	 * Gives a String[] that graphically represents the given Entity.
	 * @return a String[] with '\\' denoting an empty cell
	 */
	protected abstract String[] privateDraw();
	
	/**
	 * Causes the Entity to do its function (if it has one).
	 */
	public abstract void interact();
	
	/**
	 * a description of the Entity.
	 * @return
	 */
	public abstract String description();
	
	Entity()
	{
		
	}
	
	public String[] draw()
	{
		String[] result = privateDraw();
		String[] empty = new String[MapTile.CHARS_HIGH];
		
		if (result.length != MapTile.CHARS_HIGH)
			return empty;
		else
			for (int i=0; i<result.length; i++)
				if (result[i].length() != MapTile.CHARS_WIDE)
					return empty;
		return result;
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName();
	}
}