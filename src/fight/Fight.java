package fight;

import character.Age;
import character.BodyPart;
import character.Character;

public class Fight
{
	public static void main(String[] args)
	{
		Character person = new Character(Age.PRIME, new BodyPart[]
		{
			BodyPart.ARM,
			BodyPart.ARM,
			BodyPart.LEG,
			BodyPart.LEG
		});
		System.out.println(person);
	}
}