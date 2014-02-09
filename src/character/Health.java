package character;
public enum Health
{
//	HEALTH		(RATE,	FUNC,	RECOV),
	HEALTHY		(0,		true,	null),
	LOW_DAMAGE	(1,		true,	HEALTHY),
	HIGH_DAMAGE	(5,		false,	LOW_DAMAGE),
	CLEAN_SEVER	(2,		false,	null),
	ROUGH_SEVER	(10,	false,	CLEAN_SEVER);
	
	public final int
		RATING;
	public final boolean
		FUNCTIONAL;
	public final Health
		RECOVER_TO;
	Health(int rating, boolean functional, Health recoverTo)
	{
		RATING = rating;
		FUNCTIONAL = functional;
		RECOVER_TO = recoverTo;
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