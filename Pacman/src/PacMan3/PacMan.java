package PacMan3;

import java.awt.Color;
import java.awt.Graphics;

public class PacMan extends Personaje {
	int puntaje;
		
	public PacMan(int x, int y, char c, int vidas, boolean vivo, int dir) {
		super(x, y, c, vidas, vivo, dir);
		puntaje = 0;
	}

	public void dibujar (Graphics g) {
		int x=this.getX()*20;
		int y=this.getY()*20;
		g.setColor (Color.yellow);
		g.fillArc(x, y, 20, 20, 15, 330);
		g.setColor (Color.WHITE);
		g.fillOval(x+12, y+3, 3, 6);
		g.setColor (Color.BLACK);
		g.fillOval(x+18, y+5, 2, 3);
	}


}
