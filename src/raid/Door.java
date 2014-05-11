package raid;

public class Door extends Entity
{
	@Override
	public void interact()
	{
		System.out.println("interacting");
		passable = !passable;
	}
}