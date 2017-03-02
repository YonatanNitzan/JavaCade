package main;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main_Frame extends JFrame {

	/* Variable setup */
	private final static int WIDTH = 600, HEIGHT = 600;	//Dimensions constants
    private Main_Panel panel;							//Panel variable
	
	public static void main(String[] args)
	{
		new Main_Frame();								//Starts the program
	}
	
	public Main_Frame()
	{
		/* Frame setup */
		setTitle("JavaCade Main Menu");					//Title setting
		setResizable(false);							//Makes the frame unresizable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Makes the program terminate when the frame closes
		setSize(WIDTH, HEIGHT);							//Sets the size of the frame
		setVisible(true);								//Makes the frame visible
		
		/* Panel adding */
		panel = new Main_Panel(this);
		add(panel);
		
		validate();
	}
	
	/* A function that toggles the visibility of the frame */
	public void setVisibility()
	{
		setVisible(!isVisible());
	}
	
	// TODO: make a Game_Frame class containing of the necessary functions that every game will have
	
}