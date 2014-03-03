package character;

public enum Health
{
//	HEALTH			(RATE,	FUNC,	INFECT,	RECOV,			HEALTH),
	HEALTHY			(0,		100,	0,		null,			0),
	LOW_DAMAGE		(1,		90,		5,		HEALTHY,		10),
	HIGH_DAMAGE		(2,		10,		20,		LOW_DAMAGE,		15),
	SEVERE_DAMAGE	(3,		0,		90,		HIGH_DAMAGE,	20),
	CLEAN_SEVER		(2,		0,		0,		null,			0),
	ROUGH_SEVER		(4,		0,		90,		CLEAN_SEVER,	25),
	DEAD			(-1,	0,		0,		null,			0);
	
	public final int
		RATING, //Rating of the injury 
		FUNCTIONAL, //Percent of the functionality of the organ
		INFECTION_CHANCE, //Percent chance of the organ becoming infected
		HEALTH; //Damage necessary to cause injury
	public final Health
		RECOVER_TO; //What the injury will turn to if it heals
	private Health(int rating, int functional, int infectionChance, Health recoverTo, int health)
	{
		RATING = rating;
		FUNCTIONAL = functional;
		INFECTION_CHANCE = infectionChance;
		RECOVER_TO = recoverTo;
		HEALTH = health;
	}
	boolean healthierThan(Health health)
	{
		return RATING < health.RATING;
	}
	public String toString()
	{
		return name();
	}
}