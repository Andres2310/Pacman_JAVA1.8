package PacMan3;

import java.awt.Graphics;
import java.util.Random;

public abstract class Personaje extends Figura {
	private int vidas;
	private boolean vivo;
	private int dir;  // 0:izquierda, 1:sube, 2:derecha, 3:baja
	private static final Random nAl = new Random();
	
	public Personaje(int x, int y, char c, int vidas, boolean vivo, int dir) {
		super(x, y, c);
		this.vidas = vidas;
		this.vivo = vivo;
		this.dir = dir;
	}
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		return "Personaje [vidas=" + vidas + ", vivo=" + vivo + ", dir=" + dir + ", toString()=" + super.toString()
				+ "]";
	}
	
	public boolean mover (int x, int y, Mapa mapa) {
		if ( mapa.getCharXY (x, y) != '#' ) {
			this.setX(x);
			this.setY(y);
			return true;
		}
		else {
			//System.out.printf("Posición %d %d es una pared\n", x,y);
			return false;
		}
	}
	
	public boolean comer (int x, int y, Mapa mapa, char tipo){
	if(tipo=='@'){	
	if(mapa.getCharXY(x, y)=='.'){
		mapa.setCharXY(x, y, ' ');
		return true;
		}
	}else if(tipo=='!'){
		
		if(mapa.getCharXY(x, y)=='@'){
			mapa.setCharXY(x, y, ' ');
			return true;
			}
			}
	return false;
	}
	
	
	
	
	public int contarMovimientos ( Mapa mapa) {
		int c=0;
		if ( mapa.getCharXY ( this.getX(), this.getY() -1 ) != '#' ) c++;
		if ( mapa.getCharXY ( this.getX() +1, this.getY() ) != '#' ) c++;
		if ( mapa.getCharXY ( this.getX(), this.getY() +1 ) != '#' ) c++;
		if ( mapa.getCharXY ( this.getX() -1, this.getY() ) != '#' ) c++;
		return c;
	}
	
	public void movimiento (Mapa mapa, int intento) {
		if (intento < 10 )  {
			if (this.contarMovimientos(mapa) > 2 )
				this.setDir(nAl.nextInt(4));
		
			switch ( this.getDir() ) {
			case 0: // izquierda
				if ( mover (this.getX()-1, this.getY() , mapa) == false  ) {
					this.setDir( nAl.nextInt(4) );
					this.movimiento(mapa, intento +1);
					mapa.setCharXY(this.getX(), this.getY(), ' ');
				}
				
				break;
			case 1:// sube
				if ( mover (this.getX(), this.getY()-1 , mapa) == false   ) {
					this.setDir( nAl.nextInt(4) );
					this.movimiento(mapa, intento +1);
					mapa.setCharXY(this.getX(), this.getY(), ' ');
				}
				
				break;
			case 2: // derecha
				if ( mover (this.getX()+1, this.getY() , mapa) == false  ) {
					this.setDir( nAl.nextInt(4) );
					this.movimiento(mapa, intento +1);
					mapa.setCharXY(this.getX(), this.getY(), ' ');
				}
				break;
			case 3: // baja
				if ( mover (this.getX(), this.getY()+1 , mapa) == false ) {
					this.setDir( nAl.nextInt(4) );
					this.movimiento(mapa, intento +1);

				}
				break;
			}
		}
		else {
			//System.out.println("No existen más movimientos posibles");
		}

	} // fin movimiento()

		
}
