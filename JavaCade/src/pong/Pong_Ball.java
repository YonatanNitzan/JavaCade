package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong_Ball {

	private static final int WIDTH = 15, HEIGHT = WIDTH;
	private Pong game;
	private int x, xd = 2, y, yd = 2;
	
	public Pong_Ball(Pong game) {
		this.game = game;
		x = game.getWidth() / 2 - WIDTH;
		y = game.getHeight() / 2 - HEIGHT;
	}

	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillArc(x, y, WIDTH, HEIGHT, 0, 360);
	}
	
	public void resized()
	{
		x = game.getWidth() / 2 - WIDTH / 2;
		y = game.getHeight() / 2 - HEIGHT / 2;
	}

	public void update() {
		x += xd;
		y += yd;
		
		if(game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
		{
			xd = -xd;
			if(yd == 0)
			{
				yd = 1;
				float i = (float) Math.random();
				int j = Math.round(i);
				while(j != 0)
				{
					yd = -yd;
					j--;
				}
			}
		}
		
		else if(x < 0)
		{
			game.getPanel().increaseScore(1);
			x = game.getWidth() / 2 - WIDTH / 2;
			y = game.getHeight() / 2 - HEIGHT / 2;
		}
			
		else if(x > game.getWidth() - WIDTH - 7)
		{
			game.getPanel().increaseScore(2);
			x = game.getWidth() / 2 - WIDTH / 2;
			y = game.getHeight() / 2 - HEIGHT / 2;
		}
		
		else if(y > game.getHeight() - HEIGHT - 29 || y < 0)
			yd = -yd;
		
		
		if(game.getPanel().getScore(1) == 10)
			game.getPanel().endgame(1);
		else if(game.getPanel().getScore(2) == 10)
			game.getPanel().endgame(2);
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
	
	public void reset()
	{
		yd = 0;
	}
}
