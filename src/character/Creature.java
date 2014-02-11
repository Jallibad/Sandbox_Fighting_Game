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
	
	final BodyPart[] bodyParts;
	final int
		NAME_RANGE_LOW,
		NAME_RANGE_HIGH;
	Creature(BodyPart[] _bodyParts, int nameLow, int nameHigh)
	{
		bodyParts = _bodyParts;
		NAME_RANGE_LOW = nameLow;
		NAME_RANGE_HIGH = nameHigh;
	}
	public String toString()
	{
		String result = name()+":";
		for (BodyPart bodyPart: bodyParts)
			result += "\n"+bodyPart;
		return result;
	}
	int nameRange()
	{
		return (int)Math.round(Math.random()*(NAME_RANGE_HIGH - NAME_RANGE_LOW)+NAME_RANGE_LOW);
	}
}