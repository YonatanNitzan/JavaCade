package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;

import javax.swing.Timer;

public class Player implements ActionListener {

	private final int SIZE = 30, OPEN = 300, CLOSED = 360, MID_WAY = 330;
	private int x, xd, y, yd;
	private Arc2D.Double circle;
	private int angle = 30, Cangle, fullAngle = OPEN;
	private Timer moveTimer;
	private int animationFrame;
	private char direction;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		
		moveTimer = new Timer(100, this);
		moveTimer.start();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x, y, SIZE, SIZE, Cangle, fullAngle, Arc2D.PIE);
		g2.fill(circle);
	}

	public void update() {
		
	}
	
	public void pressed(int key) {
		switch (key)
		{
		case KeyEvent.VK_UP:
			direction = 'u';
			break;
		case KeyEvent.VK_DOWN:
			direction = 'd';
			break;
		case KeyEvent.VK_RIGHT:
			direction = 'r';
			break;
		case KeyEvent.VK_LEFT:
			direction = 'l';
			break;
		}
	}

	public void released(int key) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (direction)
		{
		case 'u':
			angle = 120;
			y -= 3;
			break;
		case 'd':
			angle = 300;
			y += 3;
			break;
		case 'r':
			angle = 30;
			x += 3;
			break;
		case 'l':
			angle = 210;
			x -= 3;
			break;
		}
		
		if(animationFrame == 0)
		{
			Cangle = angle;
			fullAngle = OPEN;
			animationFrame++;
		}
		else if(animationFrame == 1)
		{
			Cangle = angle - 15;
			fullAngle = MID_WAY;
			animationFrame++;
		}
		else
		{
			fullAngle = CLOSED;
			animationFrame = 0;
		}
	}
}