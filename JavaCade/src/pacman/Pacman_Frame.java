package pacman;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pacman_Frame extends JFrame {
	
	private final static int WIDTH = 600, HEIGHT = 600;
    private Pacman_Panel panel;
	
	public Pacman_Frame() {
		setTitle("Pacman");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
		panel = new Pacman_Panel(this);
		add(panel);
		
		validate();
	}
}
