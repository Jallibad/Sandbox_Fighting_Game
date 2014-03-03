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
	private BodyPart[] bodyParts;
	private Health[] partHealths;
	private int
		maxHealth,
		currHealth;
	private boolean alive = true;
	
	public Character(Age ageLevel, Creature creature)
	{
		//Setting up the list of body parts
		partHealths = new Health[creature.body.length];
		bodyParts = creature.body;
		for (int i=0; i<bodyParts.length; i++)
		{
			maxHealth += bodyParts[i].DAMAGE;
			partHealths[i] = Health.HEALTHY;
		}
		currHealth = maxHealth;
		
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
		int rating = (int)(((float)currHealth)/maxHealth*4);
		Health result;
		switch (rating)
		{
			case 1:
				result = Health.SEVERE_DAMAGE;
				break;
			case 2:
				result = Health.HIGH_DAMAGE;
				break;
			case 3:
				result = Health.LOW_DAMAGE;
				break;
			case 4:
				result = Health.HEALTHY;
				break;
			default:
				result = Health.DEAD;
				alive = false;
				break;
		}
		return result;
	}
	public String damage(int damage)
	{
		currHealth -= damage;
		Health[] values = Health.values();
		Health value = Health.HEALTHY;
		while (value.HEALTH > damage || value.HEALTH == 0)
			value = values[(int)(Math.random()*values.length)];
		int partIndex = (int)(Math.random()*bodyParts.length);
		partHealths[partIndex] = value;
		return bodyParts[partIndex].NAME;
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
			+ "\nweapon:\n"+weapon+"\n";
	}
	public boolean isAlive()
	{
		return alive;
	}
}