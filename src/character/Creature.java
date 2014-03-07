package character;

public enum Creature
{
//	CREATURE
//	(
//		new BodyPart[]
//		{
//			BodyPart's
//		},
//		NAME_RANGE_LOW,
//		NAME_RANGE_HIGH
//	),
	HUMAN
	(
		new BodyPart[]
		{
			BodyPart.ARM,
			BodyPart.ARM,
			BodyPart.LEG,
			BodyPart.LEG
		},
		2,
		3
	),
	DOG	
	(
		new BodyPart[]
		{
			BodyPart.LEG,
			BodyPart.LEG,
			BodyPart.LEG,
			BodyPart.LEG
		},
		1,
		1
	);
	
	final BodyPart[] body;
	final int
		NAME_RANGE_LOW, //Least number of names it can have
		NAME_RANGE_HIGH; //Highest number of names it can have
	Creature(BodyPart[] _body, int nameLow, int nameHigh)
	{
		body = _body;
		NAME_RANGE_LOW = nameLow;
		NAME_RANGE_HIGH = nameHigh;
	}
	public String toString()
	{
		String result = name()+":";
		for (BodyPart bodyPart: body)
			result += "\n"+bodyPart;
		return result;
	}
	/**
	 * Gives a random number that represents the number of possible names the creature could have
	 */
	int nameRange()
	{
		return (int)Math.round(Math.random()*(NAME_RANGE_HIGH - NAME_RANGE_LOW)+NAME_RANGE_LOW);
	}
}