package character;

public class Character
{
	public static final int
		STAT_RANGE = 20;
	public Name name;
	public int
		strength,
		intelligence,
		agility,
		age;
	public Weapon weapon = new Weapon();
	@SuppressWarnings("unused")
	private BodyPart[] bodyParts; //TODO implement body parts and add effects 
	
	public Character(Age ageLevel)
	{
		name = new Name("John James Doe");
		age = ageLevel.giveAge();
		strength = (int)(Math.random()*STAT_RANGE);
		intelligence = (int)(Math.random()*STAT_RANGE);
		agility = (int)(Math.random()*STAT_RANGE);
	}
	public int calcDamage()
	{
		//TODO calculate damage with skill
		return weapon.giveDamage();
	}
	public String toString()
	{
		return
			name.fullName()+"\n"
			+ "age: "+age+"\n"
			+ "strength: "+strength+"\n"
			+ "intelligence: "+intelligence+"\n"
			+ "agility: "+agility+"\n"
			+ "\nweapon:\n"+weapon;
	}
}