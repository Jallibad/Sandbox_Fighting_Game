package raid;

public abstract class Entity
{
	protected boolean
		passable = false,
		canInteract = true,
		chooseableInteraction = true;
	
	Entity()
	{
		
	}
	
	public abstract void interact();
	
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}