public class Character
{
	public static final int
		STAT_RANGE = 20;
	public static Character newPerson(Age age)
	{
		//TODO flesh this part out
		Character newCharacter = new Character("John Doe");
		
		newCharacter.age = (int)(Math.random()*(age.OLDEST-age.YOUNGEST))+age.YOUNGEST;
		newCharacter.strength = (int)(Math.random()*STAT_RANGE);
		newCharacter.intelligence = (int)(Math.random()*STAT_RANGE);
		newCharacter.agility = (int)(Math.random()*STAT_RANGE);
		return newCharacter;
	}
	private final String[] NAME;
	public int
		strength,
		intelligence,
		agility,
		age;
	public Weapon weapon;
	
	private Character(String name)
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
		return
			fullName()+"\n"
			+ "age: "+age+"\n"
			+ "strength: "+strength+"\n"
			+ "intelligence: "+intelligence+"\n"
			+ "agility: "+agility+"\n";
	}
}