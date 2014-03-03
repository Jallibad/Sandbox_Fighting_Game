package display;

import java.awt.Color;

import javax.swing.JTextPane;

import character.Team;

@SuppressWarnings("serial")
public class StatsDisplay extends JTextPane
{
	public final String name;
	private final Team team;
	StatsDisplay(Team _team, String _name)
	{
		setBackground(Color.GRAY);
		setContentType("text/html");
		team = _team;
		name = _name;
		setEditable(false);
		resetText();
		repaint();
	}
	public void resetText()
	{
		String result = "<html><center><b>"+name+"</b></center><table>";
		String[][] parts =
		{
			team.getNames(),
			team.getHealth()
		};
		for (int y=0; y<parts[0].length; y++)
		{
			result += "<tr>";
			final String color;
			switch (parts[1][y])
			{
				case ("DEAD"):
					color = "#7F7F7F"; //Background-Grey
					break;
				case ("SEVERE_DAMAGE"):
					color = "#7F0000"; //Dark-Red
					break;
				case ("HIGH_DAMAGE"):
					color = "#FF0000"; //Bright-Red
					break;
				case ("LOW_DAMAGE"):
					color = "#7F3F3F"; //Purple-Grey
					break;
				case ("HEALTHY"):
				default:
					color = "#007F00";
			}
			for (int x=0; x<parts.length; x++)
				result += "<td align=\"center\" width=150 bgcolor=\""+color+"\">"+parts[x][y]+"</td>";
			result += "</tr>";
		}
		setText(result);
	}
}