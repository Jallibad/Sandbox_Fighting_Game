package raid;

public class Door extends Entity
{
	@Override
	public String description()
	{
		return "a door";
	}
	@Override
	public void interact()
	{
		System.out.println("interacting");
		passable = !passable;
	}
	@Override
	public String toString()
	{
		return "door";
	}
	@Override
	protected String[] privateDraw()
	{
		String[] result;
		if (passable)
			result = new String[]
			{
				"    █",
				"    █",
				"    █"
			};
		else
			result = new String[]
			{
				"█    ",
				"█    ",
				"█    "
			};
		return result;
	}
}