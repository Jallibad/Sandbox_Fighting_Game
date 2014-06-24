package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Name
{
	private static final String[] DEFAULT_NAME = new String[]{"PhuckYou"};
	public final String[] NAME;
	
	/**
	 * Makes a new Name from a String
	 * @param name
	 */
	public Name(String name)
	{
		NAME = name.split(" ");
	}
	public Name(int parts)
	{
		String name = "";
		try
		{
			RandomAccessFile reader = new RandomAccessFile("MaleFirstNames.txt", "r");
			for (int i=0; i<parts; i++)
			{
				//TODO Use other names (not just male ones)
				int line = (int)(Math.random()*count("MaleFirstNames.txt"));
				for (int n=0; n<line; n++)
					reader.readLine();
				name += reader.readLine()+" ";
				reader.seek(0);
			}
			reader.close();
		}
		catch (IOException e)
		{
			NAME = DEFAULT_NAME;
			return;
		}
		NAME = name.split(" ");
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
			System.out.println("error reading file, defaulting to \""+DEFAULT_NAME+"\"");
		}
		return lines;
	}
}