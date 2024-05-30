import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1350;
	private static final int HEIGHT=700;
	
	
	public Main () {
		super("Tower tappers");
		setSize(WIDTH, HEIGHT);
		//setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		Color RoyalBlue = new Color(22, 13, 193);
		setBackground(Color.GRAY);
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}
}
