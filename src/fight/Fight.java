package fight;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import character.Age;
import character.Character;
import character.Creature;

public class Fight
{
	public List<Character> allies = new ArrayList<Character>();
	public List<Character> enemies = new ArrayList<Character>();
	public Queue<String> combatLog = new PriorityQueue<String>();
	
	public Fight()
	{
		allies.add(new Character(Age.PRIME, Creature.HUMAN));
		enemies.add(new Character(Age.PRIME, Creature.HUMAN));
	}
	public void doRound()
	{
		for (int i=0; i<allies.size(); i++)
			attack(allies.get(i), enemies.get((int)(Math.random()*enemies.size())));
	}
	private void attack(Character attacker, Character defender)
	{
		combatLog.add
		(
			attacker.name.withAbbrev() + " swings " + attacker.weapon
			+ " at " + defender.name.withAbbrev() + "\n"
			+ attacker.name.withAbbrev() + " hits " + defender.name.withAbbrev() + "'s "
			+ defender.damage(attacker.calcDamage())
		);
	}
}