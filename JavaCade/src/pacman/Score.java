package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Score extends JPanel {

	private Pacman_Frame game;
	
	public Score(Pacman_Frame game)
	{
		this.game = game;
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		String s = "High Score";
		Font f = new Font("Kristen ITC", Font.ITALIC, 30);
		g.setFont(f);
		g.drawString(s, this.getWidth() / 2 - g.getFontMetrics(f).stringWidth(s) / 2, this.getHeight() / 2 - g.getFontMetrics(f).getHeight() / 2);
	}
}