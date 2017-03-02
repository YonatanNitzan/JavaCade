package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Pong_Ball {

	private static final int WIDTH = 15, HEIGHT = WIDTH;
	private Pong game;
	private double x, xd = 2, y, yd = 2;
	private double relativeHitPoint;
	private Arc2D.Double ball;
	
	public Pong_Ball(Pong game) {
		this.game = game;
		x = game.getWidth() / 2 - WIDTH / 2;
		y = game.getHeight() / 2 - HEIGHT / 2;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.LIGHT_GRAY);
		ball = new Arc2D.Double(x, y, WIDTH, HEIGHT, 0, 360, Arc2D.OPEN);
		g2.fill(ball);
	}

	public void update() {
		x += xd;
		y += yd;
		
		if(game.getPanel().getPlayer(1).getBounds().intersects(getBounds()))
		{
			colide(1);
		}
		
		else if(game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
		{
			colide(2);
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
	
	private void colide(int p) {
		xd = -xd;
		
		if (p == 1)
			relativeHitPoint = Math.abs((y + HEIGHT / 2) - (game.getPanel().p1.getCenterY()));
		else
			relativeHitPoint = Math.abs((y + HEIGHT / 2) - (game.getPanel().p2.getCenterY()));
		
		if(yd == 0)
		{
			yd = 1;
			if(relativeHitPoint == 0)
			{
				float i = (float) Math.random();
				int j = Math.round(i);
				while(j != 0)
				{
					yd = -yd;
					j--;
				}
			}
		}
		else if (yd > 0)
		{
			yd = 1;
			yd += relativeHitPoint * 0.05;
		}
		else
		{
			yd = -1;
			yd += relativeHitPoint * -0.05;
		}
	}

	public Double getBounds() {
        return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
    }
	
	public void reset()
	{
		yd = 0;
	}
}
