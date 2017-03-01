package pong;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Pong extends JFrame {
	
	private final static int WIDTH = 1100, HEIGHT = 700;
    private Pong_Panel panel;
	
	public Pong(Main_Frame menu) {
		menu.setVisibility();
		
		setTitle("Two player Pong!");
		setResizable(false);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        menu.setVisibility();
		    }
		});
		
		panel = new Pong_Panel(this);
		add(panel);
		
		validate();
		pack();
	}
	
	public Pong_Panel getPanel()
	{
		return panel;
	}
}