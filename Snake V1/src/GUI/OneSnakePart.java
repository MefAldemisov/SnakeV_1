package GUI;

public class OneSnakePart {
	private int x;
	private int y;
	private short v;
	//v= vector

	public short getV() {
		return v;
	}

	public void setV(short v) {
		this.v = v;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}



	public void setY(int y) {
		this.y = y;
	}

	public OneSnakePart(int x, int y, short v) {
		this.x = x;
		this.y = y;
		this.v= v;
	}

	public int getY() {
		return y;
	}

}
