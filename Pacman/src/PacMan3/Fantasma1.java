package PacMan3;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Fantasma1 extends Personaje{
	ImageIcon Img;
	
	public ImageIcon getImg() {
		return Img;
	}

	public void setImg(ImageIcon img) {
		Img = img;
	}

	public Fantasma1(int x, int y, char c, int vidas, boolean vivo, int dir, ImageIcon Img) {
		super(x, y, c, vidas, vivo, dir);
		this.Img = Img;
	}


public void dibujar(Graphics g){
	int x=this.getX()*20;
	int y=this.getY()*20;
	//ImageIcon Img = new ImageIcon(getClass().getResource("/Images/fantasmas.png")); 
	g.drawImage(Img.getImage(), x, y, 20, 20, null);

	
}
}
