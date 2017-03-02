package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pong_Player {

	private static final int WIDTH = 15, HEIGHT = 64;
	private int playerNum, up, down, x, y, yd, d;
	private Color c;
	private Pong_Frame game;

	public Pong_Player(Pong_Frame game, int up, int down, int playerNum, Color c, int d) {
		this.game = game;
		this.up = up;
		this.down = down;
		this.c = c;
		this.playerNum = playerNum;
		this.d = d;
	}

	public void update() {
		if(y > game.getHeight() - (HEIGHT))
			y = -(HEIGHT / 2) + 1;
		else if(y < -(HEIGHT / 2))
			y = game.getHeight() - (HEIGHT) - 1;
		else
			y += yd;
	}
	
	public void pressed(int key) {
		if(key == up)
			yd = -1;
		else if(key == down)
			yd = 1;
	}

	public void released(int key) {
		if(key == up || key == down)
			yd = 0;
	}
	
	public void reset()
	{
		if(playerNum == 1)
			x = game.getWidth() - (d + WIDTH);
		else
			x = d;
		
		y = game.getHeight() / 2 - HEIGHT / 2;
	}

	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
	
	public int getCenterY()
	{
		return y + (HEIGHT / 2);
	}
}
