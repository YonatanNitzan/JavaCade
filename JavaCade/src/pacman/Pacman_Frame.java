package pacman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Pacman_Frame extends JFrame {
	
	private final static int WIDTH = 600, HEIGHT = 600;
    private Score Spanel;
    private Board Bpanel;
	
	public Pacman_Frame(Main_Frame menu)
	{
		menu.setVisibility();
		setTitle("Pacman");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        menu.setVisibility();
		    }
		});
		
		Spanel = new Score();
		Bpanel = new Board();
		Spanel.setPreferredSize(new Dimension(menu.getWidth(), 100));
		Bpanel.setPreferredSize(new Dimension(menu.getWidth(), 500));
		
		add(Spanel, BorderLayout.NORTH);
		add(Bpanel, BorderLayout.SOUTH);
		
		validate();
	}
}
