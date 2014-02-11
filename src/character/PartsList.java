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
		Health worstHealth = Health.HEALTHY;
		for (Health partHealth: health)
			if (!partHealth.healthierThan(worstHealth))
				worstHealth = partHealth;
		return worstHealth;
	}
	public String damagePart(Health damage)
	{
		int partIndex = (int)(Math.random()*bodyParts.length);
		health[partIndex] = damage;
		return bodyParts[partIndex].NAME;
	}
}