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
	
	private Main_Frame frame;
	
	public Main_Panel(Main_Frame main_Frame) {
		this.frame = main_Frame;
		
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,1));
		
		JPanel head_panel = new JPanel();
		JPanel middle_panel = new JPanel();
		
		JLabel l = new JLabel("Choose a game", JLabel.CENTER);
		l.setFont(new Font("Vijaya", Font.PLAIN, 40));
		
		String[] game_list = {"Pacman", "Pong", "What", "Twat"};
		JComboBox<String> game_combo = new JComboBox<String>(game_list);
		game_combo.setSelectedIndex(-1);
		
		JButton play_button = new JButton("Play");
		play_button.setFont(new Font("Vijaya", Font.PLAIN, 25));
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
		
		head_panel.add(l);
		middle_panel.add(game_combo);
		middle_panel.add(play_button);
		add(head_panel);
		add(middle_panel);
	}
	// TODO: make a Game_Panel class containing of the necessary functions that every game will have 

}
