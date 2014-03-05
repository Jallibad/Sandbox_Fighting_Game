package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public enum Word
{
	ATTACK_VERB("attack_verbs", "hammer tosses"),
	HIT_VERB	("hit_verbs", "licks");
	
	private final String
		FILE_NAME,
		DEFAULT;
	private Word(String file, String normal)
	{
		FILE_NAME = file+".word";
		DEFAULT = normal;
	}
	public String getWord()
	{
		String result = "";
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
			int line = (int)(Math.random()*count(FILE_NAME));
			for (int n=0; n<line; n++)
				reader.readLine();
			result = reader.readLine();
			reader.close();
		}
		catch (IOException e)
		{
			System.out.println("No "+name()+" file found, defaulting to \""+DEFAULT+"\"");
			return DEFAULT;
		}
		return result;
	}
	public static int count(String filename)
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