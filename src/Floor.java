import javax.swing.ImageIcon;

public class Floor extends Build{	
	
	public Floor() {
		super();
	}
	
	public Floor(int xV, int yV, int w, int h) {
		super(xV, yV, new ImageIcon("floor.png"), w, h);
	}
	
	public void setX(int x1) {
		super.setX(x1-super.getX());
	}
		
	public void setY(int y1) {
		super.setY(y1-super.getY());
	}
}
