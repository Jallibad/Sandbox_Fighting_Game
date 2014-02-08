package character;

public class Name
{
	public final String[] NAME;
	public Name(String name)
	{
		NAME = name.split(" ");
	}
	public String withAbrev()
	{
		String result = NAME[0]+" ";
		for (int i=1; i<NAME.length-1; i++)
			result += NAME[i].charAt(0)+". ";
		return result+NAME[NAME.length-1];
	}
	public String fullName()
	{
		String result = "";
		for (String name: NAME)
			result += name + " ";
		return result;
	}
}