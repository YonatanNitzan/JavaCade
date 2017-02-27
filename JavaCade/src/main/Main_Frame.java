package main;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main_Frame extends JFrame{

	private final static int WIDTH = 600, HEIGHT = 600;
    private Main_Panel panel;
	
	public static void main(String[] args) {
		new Main_Frame();
	}
	
	public Main_Frame()
	{
		setTitle("JavaCade Main Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
		panel = new Main_Panel(this);
		add(panel);
		
		validate();
	}
	
	// TODO: make a Game_Frame class containing of the necessary functions that every game will have
	
}