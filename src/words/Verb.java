package words;


public enum Verb implements Word
{
	ATTACK	(),
	HIT		();
	
	private Verb()
	{
		
	}
	public String getFileName()
	{
		return name()+"_"+getClass().getSimpleName();
	}
	public String getWord()
	{
		return getRandomWord(getFileName());
	}
}