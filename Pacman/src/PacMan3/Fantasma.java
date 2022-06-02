package PacMan3;

import java.awt.Color;
import java.awt.Graphics;

public class Fantasma extends Personaje {
	
	Color color;
	
	public Fantasma(int x, int y, char c, int vidas, boolean vivo, int dir, Color color) {
		super(x, y, c, vidas, vivo, dir);
		this.color = color;
	}

	public void dibujar (Graphics g) {
		int x=this.getX()*20;
		int y=this.getY()*20;
		g.setColor (color);
		//g.fillOval(this.getX()*30, this.getY()*30, 30, 30);
		g.fillArc(x, y, 20, 20, 0, 180);
		g.fillRect(x, y+10, 20, 10);
		g.setColor (Color.WHITE);
		g.fillOval(x+4, y+3, 5, 5);
		g.fillOval(x+12, y+3, 5, 5);
		g.setColor (Color.BLACK);
		g.fillOval(x+7, y+5, 1, 2);
		g.fillOval(x+14, y+5, 1, 2);
	}


}
