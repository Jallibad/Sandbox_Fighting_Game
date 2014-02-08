package fight;

import character.Age;
import character.Character;

public class Fight
{
	public static void main(String[] args)
	{
		Character person = new Character(Age.PRIME);
		System.out.println(person);
		System.out.println(person.name.withAbrev());
	}
}