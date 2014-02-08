package character;

public class Name
{
	public final String[] NAME;
	public Name(String name)
	{
		NAME = name.split(" ");
	}
	public String withAbbrev() //Gives the name abbreviating any middle names
	{
		String result = NAME[0]+" ";
		for (int i=1; i<NAME.length-1; i++)
			result += NAME[i].charAt(0)+". ";
		return result+NAME[NAME.length-1];
	}
	public String shortened() //Gives the name without any vowels
	{
		final String[] vowels = {"a", "e", "i", "o", "u"};
		String result = fullName();
		for (String vowel: vowels)
			result = result.replace(vowel, "");
		return result;
	}
	public String fullName() //Gives the full name
	{
		String result = "";
		for (String name: NAME)
			result += name + " ";
		return result.substring(0, result.length()-1);
	}
}