package character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Name
{
	public final String[] NAME;
	private static final int
		LINES_IN_FILE = count("MaleFirstNames.txt");
	public Name(String name)
	{
		NAME = name.split(" ");
	}
	public Name(int parts)
	{
		String name = "";
		try
		{
			for (int i=0; i<parts; i++)
			{
				BufferedReader reader = new BufferedReader(new FileReader("MaleFirstNames.txt"));
				int line = (int)(Math.random()*LINES_IN_FILE);
				for (int n=0; n<line; n++)
					reader.readLine();
				name += reader.readLine()+" ";
				reader.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("no file");
			NAME = new String[]{"PhuckYou"};
			return;
		}
		System.out.println(name);
		NAME = name.split(" ");
	}
	public String withAbbrev() //Gives the name abbreviating any middle names
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
	public String shortened() //Gives the name without any vowels
	{
		String result = toString();
		for (String vowel: new String[] {"a", "e", "i", "o", "u"})
			result = result.replace(vowel, "");
		return result;
	}
	
	public String toString() // Gives the full name
	{
		String result = "";
		for (String name : NAME)
			result += " " + name;
		return result.substring(1);
	}
	
	private static int count(String filename)
	{
		int lines = 0;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while (reader.readLine() != null) lines++;
			reader.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("error reading file, defaulting to PhuckYou");
		}
		return lines;
	}
}