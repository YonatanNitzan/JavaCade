package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Player {

	private Pacman_Frame game;
	private int x, y;
	private Arc2D.Double circle;
	
	public Player(Pacman_Frame game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x, y, 30, 30, 30, 300, Arc2D.PIE);
		g2.fill(circle); //right
		circle = new Arc2D.Double(x, y + 100, 30, 30, 300, 300, Arc2D.PIE);
		g2.fill(circle); //down
		circle = new Arc2D.Double(x + 100, y, 30, 30, 210, 300, Arc2D.PIE);
		g2.fill(circle); //left
		circle = new Arc2D.Double(x + 100, y + 100, 30, 30, 0, 0, Arc2D.PIE);
		g2.fill(circle); //up
	}

	public void update() {
		
	}
	
}