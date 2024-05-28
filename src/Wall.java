import javax.swing.ImageIcon;
public class Wall extends Build{
	
	
	public Wall() {
		super();
	}
	
	public Wall(int xV, int yV, int w, int h) {
		super(xV, yV, new ImageIcon("wall.png"), 50, 50);
	}
	
	public void setdx(int dx1) {
		super.setX(dx1);
	}
	public void setdy(int dy1) {
		super.setY(dy1);
	}
}
