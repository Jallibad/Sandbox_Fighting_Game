package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

interface Word
{
	static final String
		DEFAULT_NAME = "PhuckYou",
		EXTENSION = ".word";
	/**
	 * Counts the number of lines in the specified file.
	 * @param filename - The file to count in
	 * @return The number of lines in the file
	 */
	default int count(String filename)
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
	default String getRandomWord(String filename)
	{
		String result = "";
		filename += EXTENSION;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			int line = (int)(Math.random()*count(filename));
			for (int n=0; n<line; n++)
				reader.readLine();
			result = reader.readLine();
			reader.close();
			return result;
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("No "+filename+" file found, defaulting to \""+DEFAULT_NAME+"\"");
			return DEFAULT_NAME;
		}
	}
}