package words;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest
{
	@Test
	public void testShortened()
	{
		Name name = new Name("ANameWithUppercaseAndLowercase");
		assertTrue("Shortened names don't work", "ANmWthUpprcsAndLwrcs".equals(name.shortened()));
	}
	@Test
	public void testAbbrev()
	{
		Name name = new Name("A Multi-Word Name");
		assertTrue("Abbreviations don't work","A M. Name".equals(name.withAbbrev()));
	}
}
