package character;

enum BodyPart
{
//	PART	(NAME,		WALK,	GRAB,	SURV),
	ARM		("arm",		false,	true,	true),
	LEG		("leg",		true,	false,	true),
	HEAD	("head",	false,	false,	false);
	
	public final String NAME;
	final boolean
		REQ_TO_WALK, //Whether the part is required to walk
		REQ_TO_GRAB, //Whether the part is required to grab objects
		SURVIVE; //Whether the creature can survive without the part
	BodyPart(String name, boolean reqWalk, boolean reqGrab, boolean survive)
	{
		NAME = name;
		REQ_TO_WALK = reqWalk;
		REQ_TO_GRAB = reqGrab;
		SURVIVE = survive;
	}
	public String toString()
	{
		return NAME;
	}
}
