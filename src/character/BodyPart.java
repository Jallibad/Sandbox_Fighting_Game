package character;

enum BodyPart
{
//	PART	(NAME,		WALK,	GRAB,	SURV,	DAM),
	ARM		("arm",		false,	true,	true,	20),
	LEG		("leg",		true,	false,	true,	20),
	HEAD	("head",	false,	false,	false,	20);
	
	public final
		String NAME;
	final boolean
		REQ_TO_WALK, //Whether the part is required to walk
		REQ_TO_GRAB, //Whether the part is required to grab objects
		SURVIVE; //Whether the creature can survive without the part
	final int
		DAMAGE; //Damage the part can survive before it's destroyed
	BodyPart(String name, boolean reqWalk, boolean reqGrab, boolean survive, int damage)
	{
		NAME = name;
		REQ_TO_WALK = reqWalk;
		REQ_TO_GRAB = reqGrab;
		SURVIVE = survive;
		DAMAGE = damage;
	}
	public String toString()
	{
		return NAME;
	}
}
