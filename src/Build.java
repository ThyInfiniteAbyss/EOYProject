import javax.swing.ImageIcon;

public class Build {
	private int x, y, width, height;
	private ImageIcon pic;

public Build() {
	x = 0;
	y = 0;
	pic = new ImageIcon();
	width = 100;
	height = 100;
}

public Build(int xV, int yV, ImageIcon p, int w, int h) {
	x = xV;
	y = yV;
	pic = p;
	width = w;
	height = h;
}

public int getW() {
	return width;
}

public int getH() {
	return height;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public void setX (int xV) {
	x+= xV;
}

public void setY (int yV) {
	y+= yV;
}

public void setW (int w) {
	width = w;
}

public void setH (int h) {
	height = h;
}

public ImageIcon getPic() {
	return pic;
}
}


