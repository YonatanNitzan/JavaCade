package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	private Pacman_Frame game;
	private Player p;
	private Timer gameTimer;
	
	public Board(Pacman_Frame game) {
		this.game = game;
		//setBackground(Color.BLACK);
		
		gameTimer = new Timer(5, this);
		gameTimer.start();
		
		p = new Player(game, 100, 100);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		p.paint(g2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		update();
	}

	private void update() {
		p.update();
	}
}