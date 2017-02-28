package main;

import java.awt.Color;

import javax.swing.JPanel;

import pacman.Pacman_Frame;

@SuppressWarnings("serial")
public class Main_Panel extends JPanel {

	public Main_Panel(Main_Frame menu_frame)
	{
		setBackground(Color.WHITE);
		new Pacman_Frame(menu_frame);
	}
	
	// TODO: make a Game_Panel class containing of the necessary functions that every game will have 

}
