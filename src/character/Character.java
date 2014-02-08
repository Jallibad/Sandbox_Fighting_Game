package character;
public class Character
{
	public static final int
		STAT_RANGE = 20;
	private final String[] NAME;
	public int
		strength,
		intelligence,
		agility,
		age;
	public Weapon weapon = new Weapon();
	
	public Character(Age ageLevel)
	{
		NAME = "John Doe".split(" ");
		age = ageLevel.giveAge();
		strength = (int)(Math.random()*STAT_RANGE);
		intelligence = (int)(Math.random()*STAT_RANGE);
		agility = (int)(Math.random()*STAT_RANGE);
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
		return
			fullName()+"\n"
			+ "age: "+age+"\n"
			+ "strength: "+strength+"\n"
			+ "intelligence: "+intelligence+"\n"
			+ "agility: "+agility+"\n"
			+ "\nweapon:\n"+weapon;
	}
}