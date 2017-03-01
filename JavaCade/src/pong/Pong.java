package pong;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Pong extends JFrame {
	
	private final static int WIDTH = 300, HEIGHT = 300;
    private Pong_Panel panel;
	
	public Pong() {
		setTitle("Two player Pong!");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
		panel = new Pong_Panel(this);
		add(panel);
		
		validate();
		pack();
	}
	
	public Pong_Panel getPanel()
	{
		return panel;
	}
	
	public static void main(String[] args)
	{
		new Pong();
	}
}