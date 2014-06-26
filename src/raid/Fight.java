package raid;

import java.util.PriorityQueue;
import java.util.Queue;

import words.Verb;
import character.Age;
import character.Character;
import character.Creature;
import character.Team;

public class Fight
{
	public Queue<String> combatLog = new PriorityQueue<String>();
	public Team allies = new Team();
	public Team enemies = new Team();
	
	public Fight()
	{
		for (int i=0; i<6; i++)
			allies.addMember(new Character(Age.PRIME, Creature.HUMAN));
		for (int i=0; i<6; i++)
			enemies.addMember(new Character(Age.PRIME, Creature.HUMAN));
	}
	public void doRound()
	{
		sideFight(allies, enemies);
		sideFight(enemies, allies);
	}
	private void sideFight(Team attack, Team defend)
	{
		for (Character attacker: attack.team)
			if (attacker.isAlive())
				attack(attacker, defend.getRandom());
	}
	private void attack(Character attacker, Character defender)
	{
		combatLog.add
		(
			attacker.name.withAbbrev() + " "+Verb.ATTACK.getWord()+" " + attacker.weapon
			+ " at " + defender.name.withAbbrev() + "\n"
			+ attacker.name.withAbbrev() + " "+Verb.HIT.getWord()+" "+ defender.name.withAbbrev() + "'s "
			+ defender.damage(attacker.calcDamage())
		);
	}
}