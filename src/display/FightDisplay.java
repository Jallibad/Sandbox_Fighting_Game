package display;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import raid.Fight;

@SuppressWarnings("serial")
public class FightDisplay extends JPanel implements ActionListener, KeyListener
{
	private Fight fight = new Fight();
	
	private StatsDisplay allyStats = new StatsDisplay(fight.allies, "Allies");
	private JScrollPane allyScroll = new JScrollPane(allyStats);
	
	private StatsDisplay enemyStats = new StatsDisplay(fight.enemies, "Enemies");
	private JScrollPane enemyScroll = new JScrollPane(enemyStats);
	
	private JTextArea text = new JTextArea(1, 5);
	
	private final char FIGHT_CHAR = 'f';
	private final String FIGHT_TEXT = "("+FIGHT_CHAR+") fight";
	private JButton fightButton = new JButton(FIGHT_TEXT);
	
	private final char CONTINUE_CHAR = 'c';
	private final String CONTINUE_TEXT = "("+CONTINUE_CHAR+") continue";
	private JButton continueButton = new JButton(CONTINUE_TEXT);
	
	FightDisplay()
	{	
		addKeyListener(this);
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		setBackground(Color.BLACK);
		
		g.gridx = 0;
		g.gridy = 0;
		g.anchor = GridBagConstraints.LINE_START;
		fightButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		fightButton.addActionListener(this);
		add(fightButton, g);
		
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0.5;
		g.anchor = GridBagConstraints.LINE_END;
		continueButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		continueButton.addActionListener(this);
		add(continueButton, g);
		
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 1;
		g.fill = GridBagConstraints.HORIZONTAL;
		g.weighty = 1.0;
		g.gridheight = 3;
		text.setText(null);
		text.setEditable(false);
		text.setLineWrap(true);
		add(text, g);
		
		g = new GridBagConstraints();
		g.gridx = 0;
		g.gridy = 6;
		allyScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(allyScroll, g);
		
		g.gridx = 0;
		g.gridy = 7;
		enemyScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(enemyScroll, g);
		
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
			case FIGHT_TEXT:
				fight();
				break;
			case CONTINUE_TEXT:
				cont();
				break;
			default:
				break;
		}
		requestFocusInWindow();
	}
	public void fight()
	{
		doRound();
		allyStats.resetText();
		enemyStats.resetText();
		validate();
		repaint();
	}
	public void cont()
	{
		text.setText(fight.combatLog.poll());
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent k)
	{
		switch (k.getKeyChar())
		{
			case FIGHT_CHAR:
				fight();
				break;
			case CONTINUE_CHAR:
				cont();
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent k)
	{
	}

	@Override
	public void keyTyped(KeyEvent k)
	{
	}
}