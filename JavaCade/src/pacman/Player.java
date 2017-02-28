package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

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
		g2.fill(circle); //right fill
		g2.setColor(Color.BLACK);
		circle = new Arc2D.Double(x, y, 30, 30, 30, 300, Arc2D.PIE);
		g2.draw(circle); //right outline
		
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x, y + 100, 30, 30, 300, 300, Arc2D.PIE);
		g2.fill(circle); //down fill
		g2.setColor(Color.BLACK);
		circle = new Arc2D.Double(x, y + 100, 30, 30, 300, 300, Arc2D.PIE);
		g2.draw(circle); //down outline
		
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x + 100, y, 30, 30, 210, 300, Arc2D.PIE);
		g2.fill(circle); //left fill
		g2.setColor(Color.BLACK);
		circle = new Arc2D.Double(x + 100, y, 30, 30, 210, 300, Arc2D.PIE);
		g2.draw(circle); //left outline
		
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x + 100, y + 100, 30, 30, 120, 300, Arc2D.PIE);
		g2.fill(circle); //up fill
		g2.setColor(Color.BLACK);
		circle = new Arc2D.Double(x + 100, y + 100, 30, 30, 120, 300, Arc2D.PIE);
		g2.draw(circle); //up outline
	}

	public void update() {
		
	}
	
}