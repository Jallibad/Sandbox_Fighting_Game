package character;
public enum Health
{
//	HEALTH	(RATE,	FUNC),
	HEALTHY	(0,		true),
	//TODO add more health levels
	LOST	(1,		false);
	
	public final int
		RATING;
	public final boolean
		FUNCTIONAL;
	Health(int rating, boolean functional)
	{
		RATING = rating;
		FUNCTIONAL = functional;
	}
}