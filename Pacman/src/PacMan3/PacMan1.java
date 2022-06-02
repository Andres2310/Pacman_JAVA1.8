package PacMan3;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class PacMan1 extends Personaje {
	int puntaje;
	private static final Random nAl = new Random();
	public PacMan1(int x, int y, char c, int vidas, boolean vivo, int dir) {
		super(x, y, c, vidas, vivo, dir);
		puntaje = 0;
	}

	public void dibujar (Graphics g) {
		int x=this.getX()*20;
		int y=this.getY()*20;
		ImageIcon Img = new ImageIcon(getClass().getResource("pacman1.gif")); 
		g.drawImage(Img.getImage(), x, y, 20, 20, null);
	}
	@Override
	public boolean mover (int x, int y, Mapa mapa) {
		if ( mapa.getCharXY (x, y) != '#' ) {
			if(mapa.getCharXY (x, y) == '.'){
				mapa.setCharXY(this.getX(),this.getY() , ' ');
			}
			this.setX(x);
			this.setY(y);
			return true;
		}
		else {
			//System.out.printf("Posición %d %d es una pared\n", x,y);
			return false;
		}
	}
	
@Override
public void movimiento (Mapa mapa, int intento) {
	if (intento < 10 )  {
		if (this.contarMovimientos(mapa) > 2 )
			this.setDir(this.getDir());
	
		switch ( this.getDir() ) {
		case 0: // izquierda
			if ( mover (this.getX()-1, this.getY() , mapa) == false    ) {
				
				this.movimiento(mapa, intento +1);
				mapa.setCharXY(this.getX(), this.getY(), ' ');
			}
			
			break;
		case 1:// sube
			if ( mover (this.getX(), this.getY()-1 , mapa) == false   ) {
				
				this.movimiento(mapa, intento +1);
				mapa.setCharXY(this.getX(), this.getY(), ' ');
			}
			
			break;
		case 2: // derecha
			if ( mover (this.getX()+1, this.getY() , mapa) == false ) {
				
				this.movimiento(mapa, intento +1);
				mapa.setCharXY(this.getX(), this.getY(), ' ');
			}
			break;
		case 3: // baja
			if ( mover (this.getX(), this.getY()+1 , mapa) == false  ) {
				
				this.movimiento(mapa, intento +1);
				mapa.setCharXY(this.getX(), this.getY(), ' ');
			}
			break;
		}
	}
	else {
		//System.out.println("No existen más movimientos posibles");
	}

} // fin movimiento()


}
