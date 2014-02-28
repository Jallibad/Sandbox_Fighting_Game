package display;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fight.Fight;

@SuppressWarnings("serial")
public class FightDisplay extends JPanel implements ActionListener
{
	private Fight fight = new Fight();
	private StatsDisplay allyStats = new StatsDisplay(fight.allies, "Allies");
	private StatsDisplay enemyStats = new StatsDisplay(fight.enemies, "Enemies");
	private JTextArea text = new JTextArea();
	
	private JButton fightButton = new JButton("fight");
	private JButton continueButton = new JButton("continue");
	
	public static final int
		WIDTH = 350,
		HEIGHT = 300;
	
	FightDisplay()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);;
		fightButton.addActionListener(this);
		continueButton.addActionListener(this);
		add(text);
		text.setText("test");
		text.setEditable(false);
		text.setLineWrap(true);
		add(allyStats);
		add(enemyStats);
		add(fightButton, 0);
		validate();
	}
	
	public void doRound()
	{
		fight.doRound();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent a)
	{
		switch (a.getActionCommand())
		{
			case "fight":
				doRound();
				remove(fightButton);
				add(continueButton, 0);
				validate();
				repaint();
				break;
			case "continue":
				if (fight.combatLog.isEmpty())
				{
					remove(continueButton);
					add(fightButton, 0);
					validate();
				}
				else
					System.out.println(fight.combatLog.poll());
				repaint();
				break;
			default:
				break;
		}	
	}
}