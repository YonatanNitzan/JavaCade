package pong;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Pong_Frame extends JFrame {
	
	/* Variable declaration */
	private final static int WIDTH = 1100, HEIGHT = 700;	//Finals for the frame's size
    private Pong_Panel panel;								//Panel variable
	
	public Pong_Frame(Main_Frame menu) {
		menu.setVisibility();								//Turns off the main menu's visibility 
		
		/* Frame setup */
		setTitle("Two player Pong!");						//Sets the frame's title
		setResizable(false);								//Makes the frame unresizable
		setMinimumSize(new Dimension(WIDTH, HEIGHT));		//Sets the size of the frame
		setVisible(true);									//Makes the frame visible
		
		/* when the frame is closed */
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        menu.setVisibility();						//Makes the main frame visible
		    }
		});
		
		/* Adds panel */
		panel = new Pong_Panel(this);
		add(panel);
		
		validate();
		pack();
	}
	
	/* Gives the panel */
	public Pong_Panel getPanel()
	{
		return panel;
	}
}