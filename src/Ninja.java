import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Ninja extends Build{	
	
	private int gravity = 1;

	public Ninja() {
		super();
	}
	
	public Ninja(int xV, int yV, int w, int h) {
		super(xV, yV, new ImageIcon("ninja.png"), w, h);
	}
	
	public void setX(int x1) {
		super.setX(x1-super.getX());
	}
		
	public void setY(int y1) {
		super.setY(y1-super.getY());
	}

	public void draw(Graphics g2d) {
		g2d.drawImage(super.getPic().getImage(), super.getX(), super.getY(), super.getW(), super.getH(), null);
	}

	public void move() {
        setY(getY() + gravity);
        gravity++;
    }

	public void jump() {
        gravity = -5;
    }
}
