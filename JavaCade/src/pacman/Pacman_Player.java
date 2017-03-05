package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;

import javax.swing.Timer;

public class Pacman_Player implements ActionListener {

	/* Variable declaration */
	private final int SIZE = 30, OPEN = 300, CLOSED = 360, MID_WAY = 330; //Setting finals of the size and possible angles of the player
	private int x, y;									//Place-holder variables for x and y
	private Arc2D.Double circle;						//A 2D double arc
	private int angle = 30, Cangle, fullAngle = OPEN;	//Place-holder variables for the players appearance
	private Timer animationTimer;						//Timer for the mouth's animation
	private int animationFrame = 1;						//Counter for the frames in the animation
	private char direction;								//Char indicating the direction the player is facing
	
	public Pacman_Player(int x, int y) {
		this.x = x;										//Applies the starting x position
		this.y = y;										//Applies the starting y position
		
		animationTimer = new Timer(100, this);			//Sets the timer to  delay of a 10th of a second
		animationTimer.start();							//Starts the timer
	}

	/* Paints the player */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.YELLOW);
		circle = new Arc2D.Double(x, y, SIZE, SIZE, Cangle, fullAngle, Arc2D.PIE);
		g2.fill(circle);
	}
	
	/* When a key is pressed */
	public void pressed(int key) {
		
		/* Sets the direction of the player according to the pressed key */
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

	/* When the animation timer counts */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* Sets the angle and x, y values */
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
		
		/* The animation */
		if(animationFrame == 1)			//First frame
		{
			Cangle = angle;
			fullAngle = OPEN;
			animationFrame++;
		}
		else if(animationFrame == 2)	//Second frame
		{
			Cangle = angle - 15;
			fullAngle = MID_WAY;
			animationFrame++;
		}
		else if(animationFrame == 3)	//Third frame
		{
			fullAngle = CLOSED;
			animationFrame++;
		}
		else if(animationFrame == 4)	//Fourth frame
		{
			Cangle = angle - 15;
			fullAngle = MID_WAY;
			animationFrame = 1;			//Goes back to the first frame
		}
	}
}