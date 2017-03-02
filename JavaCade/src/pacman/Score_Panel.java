package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Score_Panel extends JPanel {
	
	public Score_Panel()
	{
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