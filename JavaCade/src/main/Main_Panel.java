package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pacman.Pacman_Frame;
import pong.Pong_Frame;

@SuppressWarnings("serial")
public class Main_Panel extends JPanel{
	
	public Main_Panel(Main_Frame frame) {
		setBackground(Color.WHITE);  		 				//Sets the background to white
		setLayout(new GridLayout(2,1));						//Adds a grid layout
		
		JPanel head_panel = new JPanel();					//Creates a new panel
		JPanel middle_panel = new JPanel();					//Creates a new panel
		
		JLabel l = new JLabel("Choose a game", JLabel.CENTER);	//Creates a centered label
		l.setFont(new Font("Vijaya", Font.PLAIN, 40));			//Sets the label's font
		
		String[] game_list = {"Pacman", "Pong", "What", "Twat"};//Creates an array of games
		JComboBox<String> game_combo = new JComboBox<String>(game_list);//Creates a combo box and adds the game array
		game_combo.setSelectedIndex(-1);					//Sets the selected item to nothing
		
		JButton play_button = new JButton("Play");			//Creates a new button
		play_button.setFont(new Font("Vijaya", Font.PLAIN, 25));//Sets the button's font
		
		/*Adding an action to the button*/
		play_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = "";
				if(game_combo.getSelectedIndex() != -1)
					choice = game_combo.getItemAt(game_combo.getSelectedIndex());
				
				switch(choice){
				case "Pacman":
					new Pacman_Frame(frame);
					break;
				case "Pong":
					new Pong_Frame(frame);
					break;
				}
			}
		});
		
		/*Adding all the created components*/
		head_panel.add(l);
		middle_panel.add(game_combo);
		middle_panel.add(play_button);
		add(head_panel);
		add(middle_panel);
	}
	
	// TODO: make a Game_Panel class containing of the necessary functions that every game will have 

}
