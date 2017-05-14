import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Rocketship play = new Rocketship();
	ObjectManager manager = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		time = new Timer(1000 / 60, this);
		manager.addObject(play);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket2.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void startGame() {
		time.start();
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		if(play.isAlive == false){
			play.isAlive = true;
			manager.addObject(play);
			manager.reset();
			currentState = END_STATE;
		
		}
	}

	void updateEndState() {
	
	}
	

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.bwidth, LeagueInvaders.bheight);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Play Game", 150, 400);
	}

	void drawGameState(Graphics g) {
		manager.checkCollision();
		play.draw(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.bwidth, LeagueInvaders.bheight);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Survive", 150, 400);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.bwidth, LeagueInvaders.bheight);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 150, 400);
		g.drawString(""+manager.getScore(), 150, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState < END_STATE) {
				currentState++;
			} else {
				currentState = MENU_STATE;
			} 
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			play.x = play.x-play.speed;

		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			play.x = play.x+play.speed;

		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			play.y = play.y-play.speed;

		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			play.y = play.y+play.speed;

		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			for (int i = 0; i < ObjectManager.numbersSpawned; i++) {
				manager.addObject(new Projectile(play.x,play.y,10,10,3));
				manager.addObject(new Projectile(play.x,play.y,10,10,2));
				manager.addObject(new Projectile(play.x+18,play.y,10,10,1));
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
}
