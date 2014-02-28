package character;

public class Character
{
	public static final int
		STAT_RANGE = 20;
	public Name name;
	public Weapon weapon = new Weapon();
	public int
		strength,
		intelligence,
		agility,
		age;
	public Health health = Health.HEALTHY;
	private PartsList bodyParts; //TODO implement body parts and add effects 
	
	public Character(Age ageLevel, Creature creature)
	{
		//Setting up the list of body parts
		bodyParts = new PartsList(creature.bodyParts);
		
		//Setting up miscellaneous info
		name = new Name(creature.nameRange());
		age = ageLevel.giveAge();
		
		//Allocate stats
		strength = (int)(Math.random()*STAT_RANGE);
		intelligence = (int)(Math.random()*STAT_RANGE);
		agility = (int)(Math.random()*STAT_RANGE);
	}
	public void heal()
	{
		
	}
	public int calcDamage()
	{
		//TODO calculate damage with skills
		return weapon.giveDamage();
	}
	public Health calcHealth()
	{
		return bodyParts.calcHealth();
	}
	public String damage(int damage)
	{
		String log = "";
		Health value = Health.HEALTHY;
		Health[] values = Health.values();
		while (value.HEALTH > damage || value.HEALTH == 0)
			value = values[(int) (Math.random() * values.length)];
		log += bodyParts.damagePart(value);
		return log;
	}
	public String toString()
	{
		return name.toString();
	}
	public String describe()
	{
		return
			name.toString()+"\n"
			+ "age: "+age+"\n"
			+ "strength: "+strength+"\n"
			+ "intelligence: "+intelligence+"\n"
			+ "agility: "+agility+"\n"
			+ "\nweapon:\n"+weapon+"\n"
			+ "\nbodyparts:\n"+bodyParts;
	}
}