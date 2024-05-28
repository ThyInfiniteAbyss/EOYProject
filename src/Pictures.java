public class Pictures {

	private String pic;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private boolean movert;
	private boolean movedn;
	private int witdh;
	private int height;
	
	public Pictures() {
		pic = "";
		x = 0;
		y = 0;
		dx = 0;
		dy = 0;
		movert = false;
		movedn = false;
		witdh = 0;
		height = 0;
	}
	
	public Pictures (String s, int x1, int y1, int w1, int h1) {
		pic = s;
		x = x1;
		y= y1;
		dx = 0;
		dy = 0;
		movert = true;
		movedn = false;
		witdh = w1;
		height = h1;
	}
	
	public Pictures (String s, int x1, int y1, int dx1, int dy1, boolean rt, boolean dn, int w1, int h1) {
		pic = s;
		x = x1;
		y= y1;
		dx = dx1;
		dy = dy1;
		movert = rt;
		movedn = dn;
		witdh = w1;
		height = h1;
	}
	
	public void move() {
		x += dx;
		y += dy;
		
	}
	
	public void bounce() {
		if (movert) {
			x += dx;
		}
		else {
			x -= dx;
		}
		if (movedn) {
			y += dy;
		}
		else {
			y -= dy;
		}
		if (x < 0)
			movert = true;
		if (x + witdh > 800)
			movert = false;
		
		if (y < 0)
			movedn = true;
		if (y + height > 600)
			movedn = false;
	}
	
	public int getW() {
		return witdh;
	}
	
	public int getH() {
		return height;
	}
	
	public String getPic() {
		return pic;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDX() {
		return dx;
	}
	
	public int getDY() {
		return dx;
	}
	
	public void setDx (int c) {
		dx = c;
	}
	
	public void setDy (int a) {
		dy = a;
	}
}