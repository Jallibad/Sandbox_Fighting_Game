package character;
public enum Age
{
//	AGE			(YOUNG,	OLD,	STREN,	INT,	AGI),
	BABY		(0,		0,		-20,	-20,	-20),
	TODDLER		(1,		3,		-10,	-10,	-5),
	CHILD		(4,		12,		-5,		-10,	+10),
	TEENAGER	(13,	18,		+5,		-5,		+5),
	YOUNG_ADULT	(19,	24,		+10,	+0,		+0),
	PRIME		(25,	39,		+15,	+5,		+0),
	AGED		(40,	59,		+10,	+10,	-5),
	OLD			(60,	80,		+0,		+15,	-10);
	
	public final int
		YOUNGEST, //The youngest something can be in its age-group
		OLDEST, //The oldest something can be in its age-group
		STRENGTH_BONUS, //bonus to strength -- TODO not implemented
		INTELLIGENCE_BONUS, //bonus to intelligence -- TODO not implemented
		AGILITY_BONUS; //bonus to agility -- TODO not implemented
	Age(int youngest, int oldest, int strengthBonus, int intelligenceBonus, int agilityBonus)
	{
		YOUNGEST = youngest;
		OLDEST = oldest;
		STRENGTH_BONUS = strengthBonus;
		INTELLIGENCE_BONUS = intelligenceBonus;
		AGILITY_BONUS = agilityBonus;
	}
	public int giveAge()
	{
		return (int)(Math.random()*(OLDEST-YOUNGEST))+YOUNGEST;
	}
}