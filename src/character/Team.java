package character;

import java.util.ArrayList;
import java.util.List;

public class Team
{
	public List<Character> team = new ArrayList<Character>();
	
	public Team()
	{
		
	}
	public void addMember(Character character)
	{
		team.add(character);
	}
	public Character getRandom()
	{
		List<Character> liveCharacters = new ArrayList<Character>(team);
		for (int i=0; i<liveCharacters.size(); i++)
			if (!liveCharacters.get(i).isAlive())
				liveCharacters.remove(liveCharacters.get(i));
		if (liveCharacters.size() == 0)
			return null;
		else
			return liveCharacters.get((int)(Math.random()*liveCharacters.size()));
	}
	public String[] getHealth()
	{
		String[] results = new String[team.size()];
		for (int i=0; i<team.size(); i++)
			results[i] = team.get(i).calcHealth().toString();
		return results;
	}
	public String[] getNames()
	{
		String[] results = new String[team.size()];
		for (int i=0; i<team.size(); i++)
			results[i] = team.get(i).name.toString();
		return results;
	}
	public boolean isAlive()
	{
		for (Character character: team)
			if (character.calcHealth() != Health.DEAD)
				return true;
		return false;
	}
}