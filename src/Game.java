import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener, ActionListener {
	private BufferedImage back;
	private int gravity = 1;
	private int key, count, cash, topwd, sidewd, level, lives;
	private ImageIcon background, cMoney, buildbg, upgradebg, clickbg, statsbg, levelbg, levelS, playB;
	private boolean start, win, moveRight;
	private char screen;
	private double time;
	private double currtime;
	JLabel mClick, buildClick, upgClick, clickClick, statClick, levelClick, lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, playClick;
	private Wall w;
	private Floor f, df;
	private Ninja player;
	
	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		setFocusable(true);
		start = true;
		win = false;
		moveRight = true;
		count = 0;
		screen = '1';
		background = new ImageIcon("background.png");
		cMoney = new ImageIcon("money.png");
		buildbg = new ImageIcon("bgBuildings.png");
		upgradebg = new ImageIcon("bgUpgrades.png");
		clickbg = new ImageIcon("bgClicker.png");
		statsbg = new ImageIcon("bgStats.png");
		levelbg = new ImageIcon("bgLevels.png");
		levelS = new ImageIcon("levelS.png");
		playB = new ImageIcon("playB.png");
		player = new Ninja(250, 570, 50, 50);
		df = new Floor(100, 100, 100, 100);
		f = new Floor(100, 100, 100, 100);
		w = new Wall(100, 100, 100, 100);
		cash = 0;
		currtime = 0;
		topwd = 3;
		sidewd = 1;
		level = 0;
		lives = 3;
		time = System.currentTimeMillis();
		mClick = new JLabel();
		mClick.addMouseListener(this);
		this.add(mClick);
		buildClick = new JLabel();
		buildClick.addMouseListener(this);
		this.add(buildClick);
		upgClick = new JLabel();
		upgClick.addMouseListener(this);
		this.add(upgClick);
		clickClick = new JLabel();
		clickClick.addMouseListener(this);
		this.add(clickClick);
		statClick = new JLabel();
		statClick.addMouseListener(this);
		this.add(statClick);
		levelClick = new JLabel();
		levelClick.addMouseListener(this);
		this.add(levelClick);
		lvl1 = new JLabel();
		lvl1.addMouseListener(this);
		this.add(lvl1);
		lvl2 = new JLabel();
		lvl2.addMouseListener(this);
		this.add(lvl2);
		lvl3 = new JLabel();
		lvl3.addMouseListener(this);
		this.add(lvl3);
		lvl4 = new JLabel();
		lvl4.addMouseListener(this);
		this.add(lvl4);
		lvl5 = new JLabel();
		lvl5.addMouseListener(this);
		this.add(lvl5);
		lvl6 = new JLabel();
		lvl6.addMouseListener(this);
		this.add(lvl6);
		playClick = new JLabel();
		playClick.addMouseListener(this);
		this.add(playClick);
	}
	
	public void gameReset() {
		count=0;
		screen = 'G';
		topwd = 3;
		sidewd = 1;
		level = 0;
		cash = 0;
		lives = 3;		
	}

	/*
	public void jump() {
        y -= 20;
        gravity = 2;
    }

	public void moveUp() {
        jump();
    }

	public void move() {
        y += gravity;
        gravity--;
    }
	*/
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
	
	public void screen(Graphics g2d) {
		switch(screen) {
		
		case 'G':
			//game screen
			buildClick.setBounds(950, 15, 375, 77);
			upgClick.setBounds(950, 100, 375, 77);
			clickClick.setBounds(543, 78, 284, 66);
			statClick.setBounds(292, 78, 242, 66);
			levelClick.setBounds(8, 78, 276, 66);
			if(sidewd == 1) {
				g2d.drawImage(buildbg.getImage(), 835, 0, 500, 770, this);
			}else if(sidewd == 2) {
				g2d.drawImage(upgradebg.getImage(), 835, 0, 500, 770, this);
			}
			if(topwd == 3) {
				g2d.drawImage(clickbg.getImage(), 0, 0, 835, 150, this);
				g2d.drawImage(cMoney.getImage(), 275, 200, 250, 250, this);
				mClick.setBounds(275, 200, 250, 250);
				lvl1.setBounds(0, 0, 0, 0);
				lvl2.setBounds(0, 0, 0, 0);
				lvl3.setBounds(0, 0, 0, 0);
				lvl4.setBounds(0, 0, 0, 0);
				lvl5.setBounds(0, 0, 0, 0);
				lvl6.setBounds(0, 0, 0, 0);
				playClick.setBounds(0, 0, 0, 0);
			}else if (topwd == 2) {
				g2d.drawImage(statsbg.getImage(), 0, 0, 835, 150, this);
				mClick.setBounds(0, 0, 0, 0);
				lvl1.setBounds(0, 0, 0, 0);
				lvl2.setBounds(0, 0, 0, 0);
				lvl3.setBounds(0, 0, 0, 0);
				lvl4.setBounds(0, 0, 0, 0);
				lvl5.setBounds(0, 0, 0, 0);
				lvl6.setBounds(0, 0, 0, 0);
				playClick.setBounds(0, 0, 0, 0);
			}else if(topwd == 1) {
				g2d.drawImage(levelbg.getImage(), 0, 0, 835, 150, this);
				g2d.drawImage(levelS.getImage(), 100, 200, 600, 400, this);
				g2d.drawImage(playB.getImage(), 350, 600, 100, 50, this);
				mClick.setBounds(0, 0, 0, 0);
				lvl1.setBounds(120, 216, 157, 164);
				lvl2.setBounds(321, 216, 158, 164);
				lvl3.setBounds(523, 216, 157, 164);
				lvl4.setBounds(120, 416, 157, 168);
				lvl5.setBounds(321, 416, 158, 168);
				lvl6.setBounds(523, 416, 157, 168);
				playClick.setBounds(350, 600, 100, 50);
			}
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Cash: $" + cash, 350, 30);
			g2d.drawString("Level: " + level, 100, 30);
			g2d.drawString(new DecimalFormat("#0.00"). format(currtime), 100, 50);
			currtime = (System.currentTimeMillis()-time)/1000;
			//g2d.fillRect(350, 600, 100, 50);
			break;
			
			
		case 'S':
			g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
			drawStartScreen(g2d);
			break;
			
		case '1':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 1", 350, 30);
			levelOne(g2d);
			g2d.setColor(Color.yellow);
			g2d.drawString("Lives: " + lives, 100, 30);
			drawPlayer(g2d);
			break;
			
		case '2':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 2", 350, 30);
			break;
			
		case '3':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 3", 350, 30);
			break;
			
		case '4':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 4", 350, 30);
			break;
			
		case '5':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 5", 350, 30);
			break;
			
		case '6':
			g2d.setColor(Color.orange);
			g2d.setFont(new Font ("Broadway", Font.BOLD, 25));
			g2d. drawString("Level 6", 350, 30);
			break;
		}
	}
	
	public void run() {
		try {
			while (true) {
				player.update();
				Thread.sleep(10);
				repaint();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void paint (Graphics g)
	{
		Graphics2D twoDgraph = (Graphics2D)g;
		if (back==null) {
			back =(BufferedImage) (createImage(getWidth(), getHeight()));
				}

		Graphics g2d = back.createGraphics();
		
		g2d.clearRect(0, 0, getSize().width, getSize().height);
		
		screen(g2d);
		
		
		
		twoDgraph.drawImage(back, 0, 0, null);
	}

	public void drawPlayer(Graphics g2d) {
		player.draw(g2d);
	}

	public void levelOne(Graphics g2d) {
		g2d.drawImage(df.getPic().getImage(), 0, 650, 1350, 15, this);
		g2d.drawImage(df.getPic().getImage(), 400, 380, 25, 25, this);
		g2d.drawImage(df.getPic().getImage(),690, 330, 25, 25, this);
		g2d.drawImage(df.getPic().getImage(),840, 330, 25, 25, this);
		g2d.drawImage(df.getPic().getImage(),775, 275, 10, 25, this);
		//g2d.drawImage(df.getPic().getImage(),450, 300, 250, 10, this);
		g2d.setColor(Color.red);
		g2d.fillRect(0, 650, 1350, 10);
		g2d.fillRect(400, 380, 25, 25);
		g2d.fillRect(650, 480, 250, 10);
		g2d.fillRect(690, 330, 25, 25);
		g2d.fillRect(775, 275, 10, 25);
		g2d.fillRect(840, 330, 25, 25);
		g2d.drawImage(w.getPic().getImage(), 0, 0, 250, 662, this);
		g2d.drawImage(w.getPic().getImage(), 1100, 0, 250, 662, this);
		g2d.drawImage(f.getPic().getImage(), 250, 600, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),450, 600, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),425, 500, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),600, 550, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),650, 625, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),800, 575, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),950, 525, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),650, 460, 300, 10, this);
		g2d.drawImage(f.getPic().getImage(),300, 350, 100, 10, this);
		g2d.drawImage(f.getPic().getImage(),550, 425, 25, 10, this);
		g2d.drawImage(f.getPic().getImage(),450, 400, 25, 10, this);
		g2d.drawImage(f.getPic().getImage(),450, 300, 250, 10, this);
		g2d.drawImage(f.getPic().getImage(),850, 300, 250, 10, this);
		g2d.drawImage(f.getPic().getImage(),725, 350, 100, 10, this);
	}
	
	public void drawStartScreen(Graphics g2d) {
		//create start screen
		g2d.setFont(new Font("Broadway", Font .BOLD, 50));
		g2d.setColor(Color.white);
		g2d.drawString("Welcome to Tower Clickers!", 200, 400); 
		g2d.drawString("Press the Button to Begin", 200, 600);
		//g2d. drawString("Use mouse to move and left click to shoot", 200, 800);
	}
	
	public void startgame() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	public void mouseMoved(MouseEvent m) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		//TODO Auto-Generated method stub
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		//TODO Auto-Generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		
		if(arg0.getComponent().equals(mClick)) {
			cash++;
		}
		if(arg0.getComponent().equals(levelClick)) {
			topwd = 1;
		}
		if(arg0.getComponent().equals(statClick)) {
			topwd = 2;
		}
		if(arg0.getComponent().equals(clickClick)) {
			topwd = 3;
		}
		if(arg0.getComponent().equals(buildClick)) {
			sidewd = 1;
		}
		if(arg0.getComponent().equals(upgClick)) {
			sidewd = 2;
		}
		if(arg0.getComponent().equals(lvl1)) {
			level = 1;
		}
		if(arg0.getComponent().equals(lvl2)) {
			level = 2;
		}
		if(arg0.getComponent().equals(lvl3)) {
			level = 3;
		}
		if(arg0.getComponent().equals(lvl4)) {
			level = 4;
		}
		if(arg0.getComponent().equals(lvl5)) {
			level = 5;
		}
		if(arg0.getComponent().equals(lvl6)) {
			level = 6;
		}
		if(arg0.getComponent().equals(playClick) && level == 1) {
			screen = '1';
		}else if(arg0.getComponent().equals(playClick) && level == 2) {
			screen = '2';
		}else if(arg0.getComponent().equals(playClick) && level == 3) {
			screen = '3';
		}else if(arg0.getComponent().equals(playClick) && level == 4) {
			screen = '4';
		}else if(arg0.getComponent().equals(playClick) && level == 5) {
			screen = '5';
		}else if(arg0.getComponent().equals(playClick) && level == 6) {
			screen = '6';
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		//TODO Auto-Generated method stub
	}
	
	//Do not delete
	@Override
	public void keyTyped(KeyEvent e) {
		//TODO Auto-Generated method stub
	}
	
	//Do not delete
	@Override
	public void keyPressed(KeyEvent e) {
		//TODO Auto-Generated method stub
		int key=e.getKeyCode();
		System.out.println(key);
		if(key==66) {
			screen = 'G';
		}
		
		//reset
		if(key==82) {
			gameReset();
			start = false;
		}
		
		//switch between the screens (for testing)
		if(key==71) {
			screen = 'G';
		}
		
		if(key==49) {
			screen = '1';
		}
		
		if(key==50) {
			screen = '2';
		}
		
		if(key==51) {
			screen = '3';
		}
		
		if(key==52) {
			screen = '4';
		}
		
		if(key==53) {
			screen = '5';
		}
		
		if(key==54) {
			screen = '6';
		}

		//space
		if (key == KeyEvent.VK_SPACE) {
			System.out.println("Space key pressed");
			player.jump();
		} else if (key == KeyEvent.VK_W) {
			System.out.println("W key pressed");
			player.moveUp();
		} else if (key == KeyEvent.VK_S) {
			System.out.println("S key pressed");
			player.moveDown();
		} else if (key == KeyEvent.VK_A) {
			System.out.println("A key pressed");
			player.moveLeft();
		} else if (key == KeyEvent.VK_D) {
			System.out.println("D key pressed");
			player.moveRight();
		}
		player.update(gravity);
	}
	
	//Do not delete
	@Override
	public void keyReleased(KeyEvent e) {
		key=e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			player.stopY();
		} else if (key == KeyEvent.VK_S) {
			player.stopY();
		} else if (key == KeyEvent.VK_A) {
			player.stopX();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		if(e.getSource() == b2) {
			cash += 10;
			System.out.println("Cash: $" + cash);
		}
		*/
	}
}