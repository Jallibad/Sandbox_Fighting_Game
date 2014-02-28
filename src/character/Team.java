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
		return team.get((int)(Math.random()*team.size()));
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
}