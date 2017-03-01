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

	private Player p;
	private Timer gameTimer;
	
	public Board(Pacman_Frame frame) {
		setBackground(Color.BLACK);
		
		gameTimer = new Timer(10, this);
		gameTimer.start();
		
		addKeyListener(this);
		frame.addKeyListener(this);
		
		p = new Player(100, 100);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		p.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		update();
	}

	private void update() {
		p.update();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		p.pressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p.released(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//unused
	}
}