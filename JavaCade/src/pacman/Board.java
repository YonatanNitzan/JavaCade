package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements KeyListener, ActionListener {

	/* Variable declaration */
	private Pacman_Player p;				//Player variable
	private Timer gameTimer;				//Timer that runs the game
	
	public Board(Pacman_Frame frame) {
		setBackground(Color.BLACK);			//Sets background
		
		gameTimer = new Timer(10, this);	//Sets the timer with a delay of 10 milliseconds
		gameTimer.start(); 					//Starts the timer
		
		addKeyListener(this); 				//Adds key listener to the this panel
		frame.addKeyListener(this);			//Adds key listener to the game's frame
		
		p = new Pacman_Player(100, 100); 	//Sets the start position of the player
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		/* Calls the paint function in all objects */
		p.paint(g);
	}

	/* When the timer runs */
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	/* When a key is pressed */
	@Override
	public void keyPressed(KeyEvent e) {
		p.pressed(e.getKeyCode());			//Sends the code of the pressed key to the player object			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//unused
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//unused
	}
}