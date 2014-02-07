public class Character
{
	private final String[] NAME;
	public int
		strength,
		intelligence,
		agility;
	
	public Character(String name)
	{
		NAME = name.split(" ");
	}
	public String firstName()
	{
		return NAME[0];
	}
	public String lastName()
	{
		return NAME[NAME.length-1];
	}
	public String fullName()
	{
		String result = "";
		for (String name: NAME)
			result += name + " ";
		return result;
	}
	public String toString()
	{
		return fullName();
	}
}