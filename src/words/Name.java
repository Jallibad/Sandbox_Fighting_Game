package words;

import java.util.ArrayList;
import java.util.List;


public class Name implements Word
{
	public final String[] NAME;
	
	/**
	 * Makes a new Name from a String.
	 * @param name
	 */
	public Name(String name)
	{
		NAME = name.split(" ");
	}
	/**
	 * Makes a new Name with the given number of parts.
	 * @param parts - Number of parts to the Name
	 */
	public Name(int parts)
	{
		List<String> name = new ArrayList<String>();
		for (int i=0; i<parts; i++)
		{
			name.add(getRandomWord("MaleFirstNames"));
		}
		NAME = name.toArray(new String[name.size()]);
	}
	
	/**
	 * Gives the name abbreviating any middle names
	 * @return
	 */
	public String withAbbrev()
	{
		String result = NAME[0];
		if (NAME.length != 1)
		{
			result += " ";
			for (int i=1; i<NAME.length-1; i++)
				result += NAME[i].charAt(0)+". ";
			result += NAME[NAME.length-1];
		}
		return result;
	}
	
	/**
	 * Shortens the name by removing the lowercase vowels
	 * @return A String with the lowercase vowels removed
	 */
	public String shortened()
	{
		String result = toString();
		for (String vowel: new String[] {"a", "e", "i", "o", "u"})
			result = result.replace(vowel, "");
		return result;
	}
	
	/**
	 * The full Name
	 */
	public String toString()
	{
		String result = "";
		for (String name : NAME)
			result += " " + name;
		return result.substring(1);
	}
}