package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pong_Panel extends JPanel implements ActionListener, KeyListener {

	private Pong game;
    private Pong_Ball ball;
    private Pong_Player p1, p2;
    private int score1, score2, starterCount = 5;
    private int stringx, stringy;
	private String string, string2, string3, string4;
	private boolean gameRunning = false;
	private Font stringFont, stringFont2;
	private Timer timer, timer2;
    
	public Pong_Panel(Pong game) {
		setBackground(Color.WHITE);
		this.game = game;
		ball = new Pong_Ball(game);
		p1 = new Pong_Player(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 1, Color.BLUE, 50);
		p2 = new Pong_Player(game, KeyEvent.VK_W, KeyEvent.VK_S, 2, Color.RED, 50);
		string3 = "starting";
		string4 = "Pause";
		timer2 = new Timer(1000, new ActionListener(){
			  public void actionPerformed(ActionEvent event) {
				  	repaint();
				    starterCount--;
				    if(starterCount == 0)
				    {
				    	gameRunning = true;
				    	timer.start();
				    	timer2.stop();
				    }
				  }
				});
		timer2.start();
		timer = new Timer(5, this);
        addKeyListener(this);
        game.addKeyListener(this);
        setFocusable(true);
        
        addComponentListener(new ComponentAdapter() 
        {  
                public void componentResized(ComponentEvent evt) {
                    p1.resized();
                    p2.resized();
                    ball.resized();
                    repaint();
                }
        });
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        ball.paint(g);
        p1.paint(g);
        p2.paint(g);
        
        g.setColor(Color.BLACK);
        
        if(timer.isRunning() && !timer2.isRunning())
        {
        	starterCount = 3;
        	
        	stringFont = new Font("Serif", Font.PLAIN, 30);
        	string = game.getPanel().getScore(2) + " : " + game.getPanel().getScore(1);
        	stringx = game.getWidth() / 2 - g.getFontMetrics(stringFont).stringWidth(string) / 2;
        	stringy = 30;
        	
        	g.setFont(stringFont);
            g.drawString(string, stringx, stringy);
        }
        else if(!timer.isRunning() && !timer2.isRunning())
        {
        	stringFont = new Font("Comic Sans MS", Font.BOLD, 50);
        	stringx = game.getWidth() / 2 - g.getFontMetrics(stringFont).stringWidth(string4) / 2;
        	stringy = game.getHeight() / 2 - g.getFontMetrics(stringFont).getHeight() / 2;
        	
        	g.setFont(stringFont);
            g.drawString(string4, stringx, stringy);
        	
        	string2 = game.getPanel().getScore(2) + " : " + game.getPanel().getScore(1);
        	stringFont2 = new Font("Serif", Font.PLAIN, 30);
        	g.setFont(stringFont2);
        	g.drawString(string2, game.getWidth() / 2 - g.getFontMetrics(stringFont2).stringWidth(string2) / 2, game.getHeight() / 2 - g.getFontMetrics(stringFont2).getHeight() + 50);
        }
        else if(timer2.isRunning())
        {
        	stringFont = new Font("Jokerman", Font.BOLD, 25);
        	string = "Game " + string3 + " in... " + starterCount;
        	stringx = game.getWidth() / 2 - g.getFontMetrics(stringFont).stringWidth(string) / 2;
        	stringy = game.getHeight() / 2 - g.getFontMetrics(stringFont).getHeight() / 2 - 50;
        	
        	g.setFont(stringFont);
            g.drawString(string, stringx, stringy);
            
            if(gameRunning)
            {
				string2 = game.getPanel().getScore(2) + " : " + game.getPanel().getScore(1);
				stringFont2 = new Font("Serif", Font.PLAIN, 30);
				g.setFont(stringFont2);
				g.drawString(string2, game.getWidth() / 2 - g.getFontMetrics(stringFont2).stringWidth(string2) / 2, game.getHeight() / 2 - g.getFontMetrics(stringFont2).getHeight() + 50);
            }
        }
    }

	@Override
	public void keyPressed(KeyEvent e) {
		p1.pressed(e.getKeyCode());
		p2.pressed(e.getKeyCode());
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			StopNcontinue();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p1.released(e.getKeyCode());
		p2.released(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//Do nothing
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
        repaint();
	}

	private void update() {
		p1.update();
		p2.update();
		ball.update();
	}
	
	private void StopNcontinue() {
		if (timer.isRunning() && !timer2.isRunning())
		{
			repaint();
			timer.stop();
		}
		else if(!timer.isRunning() && !timer2.isRunning())
		{
			repaint();
			timer.start();
		}
	}
	
	public Pong_Player getPlayer(int playerNo) {
        if (playerNo == 1)
            return p1;
        else
            return p2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
        
        string3 = "resumes";
        timer.stop();
        timer2.start();
        
        reset();
    }

    private void reset() {
		p1.resized();
		p2.resized();
		ball.reset();
	}

	public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }

	public void endgame(int NoPlayer) {
		timer.stop();
		timer2.stop();
		string4 = "Ended!";
		JOptionPane.showMessageDialog(null, "Player " + NoPlayer + " wins", "Pong", JOptionPane.PLAIN_MESSAGE);
	}
}
