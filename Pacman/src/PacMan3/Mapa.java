package PacMan3;

import java.awt.Color;
import java.awt.Graphics;

// La clase Mapa contiene el mapa del laberinto de pacman
// Además de las paredes, por defecto inicializa todos los pasillos con pastillas, señaladas con '.'
// Cuenta con un método adicional para colocar super pastillas, señaladas con '*'

public class Mapa {
	private int m;
	private int n;
	private char [][] mapa ;
	
	Mapa (String [] mapaCad, int _m, int _n) {
		m=_m; n=_n;
		mapa = new char [m][n];
		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++) {
				mapa[i][j] = mapaCad [j].charAt(i);
				//if (mapa[i][j] == ' ') 
					//mapa[i][j] = '.'; // Llena con pastillas todos los espacios en blanco
			}
	}
	
	public void mostrar () {
		for ( int i=0; i<m; i++) {
			for (int j=0; j<n; j++) 
				System.out.printf(" %c ", mapa[i][j] );
			System.out.println();
		}
		System.out.println();
	} // fin mostrar();
	
	public void dibujar (Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		for ( int i=0; i<m; i++) 
			for (int j=0; j<n; j++)
				if ( mapa [i][j] == '#' )
					g.fillRect(i*20, j*20, 20, 20);
				else
					if ( mapa [i][j] == '.' )
						g.fillOval(i*20+8, j*20+8, 4, 4);
					else
						if ( mapa [i][j] == '*' )
							g.fillOval(i*20+7, j*20+7, 10, 10);
	}
	
	public void setCharXY (int x, int y, char c) {
		mapa [x] [y] = c;
	}
	
	public char getCharXY (int x, int y) {
		return mapa [x] [y];
	}
	
	public void borrarXY (int x, int y) {
		setCharXY (x,y, ' ');
	}

	public void setSuperPastillaXY (int x, int y) {
		setCharXY (x,y, '*');
	}
}

/*
	
*/