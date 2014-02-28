package character;

class PartsList
{
	BodyPart[] bodyParts;
	Health[] health;
	
	PartsList(BodyPart[] _bodyParts)
	{
		health = new Health[_bodyParts.length];
		bodyParts = new BodyPart[_bodyParts.length];
		for (int i=0; i<bodyParts.length; i++)
		{
			bodyParts[i] = _bodyParts[i];
			health[i] = Health.HEALTHY;
		}
	}
	public String toString()
	{
		String result = "";
		for (int i=0; i<bodyParts.length; i++)
			result += "\n"+bodyParts[i].NAME+": "+health[i].name();
		return result.substring(1);
	}
	public Health calcHealth()
	{
		int rating = 0;
		for (Health partHealth: health)
			rating += partHealth.RATING;
		rating /= health.length;
		Health result;
		switch (rating)
		{
			case 0:
				result = Health.HEALTHY;
				break;
			case 1:
				result = Health.LOW_DAMAGE;
				break;
			case 2:
				result = Health.HIGH_DAMAGE;
				break;
			case 3:
				result = Health.SEVERE_DAMAGE;
				break;
			case 4:
			default:
				result = null;
				break;
		}
		return result;
	}
	public String damagePart(Health damage)
	{
		int partIndex = (int)(Math.random()*bodyParts.length);
		health[partIndex] = damage;
		return bodyParts[partIndex].NAME;
	}
}