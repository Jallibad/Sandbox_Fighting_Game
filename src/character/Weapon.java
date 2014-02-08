package character;
public class Weapon
{
	public Name name;
	private final int
		LOW_DAMAGE,
		HIGH_DAMAGE;
	Weapon(String _name, int lowDamage, int highDamage)
	{
		name = new Name(_name);
		LOW_DAMAGE = lowDamage;
		HIGH_DAMAGE = highDamage;
	}
	Weapon()
	{
		name = new Name("Default Gun");
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
			name.fullName()+"\n"
			+ "low damage: "+LOW_DAMAGE+"\n"
			+ "high damage: "+HIGH_DAMAGE;
	}
}