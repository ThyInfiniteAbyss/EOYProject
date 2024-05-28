/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.SwingUtilities;

	public class Button extends JFrame implements ActionListener{

	 Game game;
	 JButton resetButton;
	 
	 Button(){
	  
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setSize(600, 500);
	  this.setLayout(null);
	  
	  resetButton = new JButton();
	  resetButton.setText("Reset");
	  resetButton.setSize(100, 50);
	  resetButton.setLocation(0, 200);
	  resetButton.addActionListener(this);
	  
	  game = new Game();
	  
	  this.add(resetButton);
	  this.add(game);
	  this.setVisible(true);
	  
	 }

	 @Override
	 public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==resetButton) {
	   this.remove(game);
	   game = new Game();
	   this.add(game);
	   SwingUtilities.updateComponentTreeUI(this);
	  }
	 }
}
	
public class Button extends JFrame implements ActionListener{
	
	JButton button;
	Button(){
		ImageIcon icon = new ImageIcon("money.png");
		button = new JButton();
		button.setBounds(200, 100, 100, 50);
		button.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			System.out.println("poo");
		}
	}
	*/
