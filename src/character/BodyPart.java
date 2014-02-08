package character;

public enum BodyPart
{
//	PART	(NAME,	WALK,	GRAB),
	ARM		("arm",	false,	true);
	
	public final String NAME;
	public final boolean
		REQ_TO_WALK,
		REQ_TO_GRAB;
	@SuppressWarnings("unused")
	private Health health = Health.HEALTHY; //TODO add health levels to body parts
	BodyPart(String name, boolean reqWalk, boolean reqGrab)
	{
		NAME = name;
		REQ_TO_WALK = reqWalk;
		REQ_TO_GRAB = reqGrab;
	}
	
}
