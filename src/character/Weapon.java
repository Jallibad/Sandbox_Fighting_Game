package character;
public class Weapon
{
	public Name name;
	private final int
		LOW_DAMAGE,
		HIGH_DAMAGE;
	public final boolean RANGED;
	Weapon(String _name, boolean ranged,int lowDamage, int highDamage)
	{
		name = new Name(_name);
		LOW_DAMAGE = lowDamage;
		HIGH_DAMAGE = highDamage;
		RANGED = ranged;
	}
	Weapon()
	{
		name = new Name("Default Gun");
		LOW_DAMAGE = 100;
		HIGH_DAMAGE = 200;
		RANGED = false;
	}
	int giveDamage()
	{
		return (int)(Math.random()*(HIGH_DAMAGE-LOW_DAMAGE))+LOW_DAMAGE;
	}
	public String toString()
	{
		return name.toString();
	}
	public String describe()
	{
		return
			this+"\n"
			+ "low damage: "+LOW_DAMAGE+"\n"
			+ "high damage: "+HIGH_DAMAGE;
	}
}