package character;
class Weapon
{
	public final String NAME;
	private final int
		LOW_DAMAGE,
		HIGH_DAMAGE;
	Weapon(String name, int lowDamage, int highDamage)
	{
		NAME = name;
		LOW_DAMAGE = lowDamage;
		HIGH_DAMAGE = highDamage;
	}
	Weapon()
	{
		NAME = "DefaultGun";
		LOW_DAMAGE = 10;
		HIGH_DAMAGE = 20;
	}
	int giveDamage()
	{
		return (int)(Math.random()*(HIGH_DAMAGE-LOW_DAMAGE))+LOW_DAMAGE;
	}
	public String toString()
	{
		return
			"name: "+NAME+"\n"
			+ "low damage: "+LOW_DAMAGE+"\n"
			+ "high damage: "+HIGH_DAMAGE;
	}
}