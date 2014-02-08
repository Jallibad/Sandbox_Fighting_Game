package character;
public class Weapon
{
	public final String NAME;
	public final int
		DAMAGE;
	public Weapon(String name, int damage)
	{
		NAME = name;
		DAMAGE = damage;
	}
	public Weapon()
	{
		NAME = "DefaultGun";
		DAMAGE = 10;
	}
	public String toString()
	{
		return
			"name: "+NAME+"\n"
			+ "damage: "+DAMAGE;
	}
}