package PacMan3;

import java.awt.Graphics;

public abstract class  Figura {
	private int x,y;
	char c;

	public Figura(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "Figura [x=" + x + ", y=" + y + ", c=" + c + "]";
	}

	public abstract void dibujar (Graphics g) ;
}
