package PacMan3;

import java.awt.Color;
import java.awt.Graphics;

public class Frutas extends Personaje {
	public static enum Tipos {Uva, Manzana, Fresa};
	int puntaje;
	Tipos tipo;

	public Frutas(int x, int y, char c, int vidas, boolean vivo, int dir, int puntaje, Tipos tipo) {
		super(x, y, c, vidas, vivo, dir);
		this.puntaje = puntaje;
		this.tipo = tipo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "Comida [puntaje=" + puntaje + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void dibujar(Graphics g) {
		int x=this.getX()*20;
		int y=this.getY()*20;
		switch (tipo) {
		case Uva:
			g.setColor (Color.BLUE);
			g.fillOval(x+10, y+10, 5, 5);
			g.fillOval(x+15, y+10, 5, 5);
			g.fillOval(x+20, y+10, 5, 5);
			g.fillOval(x+13, y+15, 5, 5);
			g.fillOval(x+18, y+15, 5, 5);
			g.fillOval(x+15, y+20, 5, 5);
			g.setColor (Color.getColor("BROWN"));
			g.fillRect(x+17, y+5, 2, 5);
			g.setColor (Color.green);
			g.fillRect(x+19, y+7, 5, 2);
			break;
		case Manzana:
			g.setColor (Color.red);
			g.fillOval(x+10, y+12, 20, 18);
			g.fillOval(x+10, y+10, 10, 8);
			g.fillOval(x+20, y+10, 10, 8);
			g.setColor (Color.getColor("BROWN"));
			g.fillRect(x+17, y+5, 2, 5);
			g.setColor (Color.green);
			g.fillRect(x+19, y+7, 5, 2);
			break;
		case Fresa:
			g.setColor (Color.pink);
			g.fillOval(x+10, y+15, 20, 12);
			g.fillOval(x+10, y+20, 20, 8);
			g.fillOval(x+10, y+10, 10, 8);
			g.fillOval(x+20, y+10, 10, 8);
			g.setColor (Color.getColor("BROWN"));
			g.fillRect(x+17, y+5, 2, 5);
			g.setColor (Color.green);
			g.fillRect(x+19, y+7, 5, 2);
			break;		
		}
		
	}
	
}
