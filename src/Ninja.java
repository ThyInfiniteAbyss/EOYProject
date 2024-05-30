import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Ninja extends Build{	
	
	private int xSpeed = 0;
    private int ySpeed = 0;

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

	public void move(int gravity) {
        setY(getY() + gravity);
    }

	public void jump() {
        ySpeed = -5;
    }

	public void moveUp() {
		System.out.println("Moving up");
		ySpeed = -5;
	}
	
	public void moveDown() {
		System.out.println("Moving down");
		ySpeed = 5;
	}
	
	public void moveLeft() {
		System.out.println("Moving left");
		xSpeed = -5;
	}
	
	public void moveRight() {
		System.out.println("Moving right");
		xSpeed = 5;
	}

	public void stop() {
        xSpeed = 0;
        ySpeed = 0;
    }

	public void stopX() {
        xSpeed = 0;
    }

    public void stopY() {
        ySpeed = 0;
    }

	public void update(int gravity) {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        ySpeed += gravity;
    }
}
