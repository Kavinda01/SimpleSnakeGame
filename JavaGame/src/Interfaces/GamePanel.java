package Interfaces;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
	
	static final int DELAY = 75;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	
	int bodyParts = 3;
	int appleEaten;
	int appleX;
	int appleY;
	int length = 3;
	
	char direction = 'R';
	boolean running = false;
	public Timer timer;
	Random random;
	


	
	
	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new myKeyAdapter());
		this.setBounds(10, 55, 600, 600);
		startGame();
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void draw(Graphics g) {
		
		if(running) {

			//apple
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			//snake
			for(int i = 0; i < bodyParts; i++) {
				if(i == 0) {
					g.setColor(new Color(34, 139, 34));
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(Color.green);
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}

			}
			

			//score
			g.setColor(Color.blue);
			g.setFont(new Font("Times New Roman", Font.BOLD, 16));
			//FontMetrics metrics = getFontMetrics(g.getFont());
			//g.drawString("SCORE: " + appleEaten,(SCREEN_WIDTH - metrics.stringWidth("SCORE: " + appleEaten))/1 , g.getFont().getSize());
			g.drawString("Score: " + appleEaten, 520, 20);
			g.drawString("Length: " + length, 520, 42);

			
		}
		else {
			gameOver(g);
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
	}
	
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void move() {
		for(int i = bodyParts; i>0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0]-UNIT_SIZE;
			break;
			
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
			
		case 'L':
			x[0] = x[0]-UNIT_SIZE;
			break;
			
		case 'R':
			x[0] = x[0]+UNIT_SIZE;
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	public class myKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			
			case KeyEvent.VK_SPACE:
				if(timer.isRunning()) {
					timer.stop();
				}
				else {
					timer.start();
				}
				break;
			
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
				
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
				
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}
	
	public void checkApple() {
		if((x[0] == appleX) && (y[0]==appleY)) {
			bodyParts++;
			appleEaten++;
			newApple();
			length++;
		}
	}
	
	public void checkCollisions() {
		//head
		for(int i = bodyParts; i>0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		
		//left border
		if(x[0] < 0) {
			running = false;
		}
		
		//right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		
		//top border
		if(y[0] < 0) {
			running = false;
		}
		
		//bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
		
	}
	
	
	public void gameOver(Graphics g) {
		//score
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("SCORE: " + appleEaten,(SCREEN_WIDTH - metrics.stringWidth("SCORE: " + appleEaten))/2 , SCREEN_HEIGHT/3);
		
		//game over
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("GAME OVER" ,(SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2 , SCREEN_HEIGHT/2);
	}
	


	
}

