package pacman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Pacman_Frame extends JFrame {
	
	/* Variable declaration */
	private final static int WIDTH = 600, HEIGHT = WIDTH;	//Finals of the frame's size
    private Score_Panel Spanel;								//Variable for the score panel
    private Board Bpanel;									//Variable for the board
	
	public Pacman_Frame(Main_Frame menu)
	{
		menu.setVisibility();								//Turns off the main menu's visibility
		
		/* Frame setup */
		setTitle("Pacman"); 								//Sets the frame's title
		setResizable(false); 								//Makes the frame unresizable
		setSize(WIDTH, HEIGHT); 							//Sets the size
		setVisible(true);									//Makes the frame visible
		
		/* when the frame is closed */
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        menu.setVisibility();						//Makes the main frame visible
		    }
		});
		
		/* Sets the panels' sizes */
		Spanel = new Score_Panel();
		Bpanel = new Board(this);
		Spanel.setPreferredSize(new Dimension(menu.getWidth(), 100));
		Bpanel.setPreferredSize(new Dimension(menu.getWidth(), 500));
		
		/* Adds the panels */
		add(Spanel, BorderLayout.NORTH);
		add(Bpanel, BorderLayout.SOUTH);
		
		validate();
	}
}
