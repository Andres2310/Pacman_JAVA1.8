package PacMan3;


import java.awt.Graphics;

import javax.swing.ImageIcon;



public class Frutas1 extends Personaje{
	public static enum Tipos {Uva, Manzana, Fresa};
	int puntaje;
	Tipos tipo;

	public Frutas1(int x, int y, char c, int vidas, boolean vivo, int dir, int puntaje, Tipos tipo) {
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
		ImageIcon Img;
		switch (tipo) {
		case Uva:
			Img=new ImageIcon(getClass().getResource("uva.jpg")); 
			g.drawImage(Img.getImage(), x, y, 20, 20, null);
			break;
		case Manzana:

			Img = new ImageIcon(getClass().getResource("manzana.png")); 
			g.drawImage(Img.getImage(), x, y, 20, 20, null);

			break;
		case Fresa:

			Img = new ImageIcon(getClass().getResource("fresa.png")); 
			g.drawImage(Img.getImage(), x, y, 20, 20, null);
			
			break;		
		}
		
	}
	
}
