package PacMan3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements KeyListener {

	String  mapaCad [] = {
			"############################",
			"#............##............#",
			"#.####.#####.##.#####.####.#",
			"#*####.#####.##.#####.####*#",
			"#.####.#####.##.#####.####.#",
			"#..........................#",
			"#.####.##.########.##.####.#",
			"#.####.##.########.##.####.#",
			"#......##....##....##......#",
			"######.#####.##.#####.######",
			"######.#####.##.#####.######",
			"######.##..........##.######",
			"######.##.###  ###.##.######",
			"######.##.###  ###.##.######",
			"#.........##    ##.........#",
			"######.##.########.##.######",
			"######.##.########.##.######",
			"######.##..........##.######",
			"######.##.########.##.######",
			"######.##.########.##.######",
			"#............##............#",
			"#.####.#####.##.#####.####.#",
			"#.####.#####.##.#####.####.#",
			"#*..##................##..*#",
			"###.##.##.########.##.##.###",
			"###.##.##.########.##.##.###",
			"#......##....##....##......#",
			"#.##########.##.##########.#",
			"#.##########.##.##########.#",
			"#..........................#",
			"############################"
	};
	
	Mapa m = new Mapa( mapaCad, 28, 31 );
	
	//Pastillas p = new Pastillas (3,2);
	Frutas1 fr1 = new Frutas1(3,2, '$', 3, true, 0, 25, Frutas1.Tipos.Uva);
	Frutas1 fr2 = new Frutas1 (3,2, '$', 3, true, 0, 25, Frutas1.Tipos.Manzana);
	Frutas1 fr3 = new Frutas1 (3,2, '$', 3, true, 0, 25, Frutas1.Tipos.Fresa);
	Fantasma1 f1 = new Fantasma1 (14,13, '!', 3, true, 0, new ImageIcon(getClass().getResource("f_amarillo.png") ));
	Fantasma1 f2 = new Fantasma1 (14,12, '!', 3, true, 0, new ImageIcon(getClass().getResource("f_azul.png")));
	Fantasma1 f3 = new Fantasma1 (14,15, '!', 3, true, 0, new ImageIcon(getClass().getResource("f_rosado.png")));
	Fantasma1 f4 = new Fantasma1 (14,14, '!', 3, true, 0, new ImageIcon(getClass().getResource("fantasma.png") ));
	PacMan1 pc = new PacMan1 (14,17, '@', 3, true, 0);

	
	PanelJuego () {
		//m.setSuperPastillaXY (3,2);

		m.mostrar();
		System.out.println("Construye el mapa y pone el personaje");
		
		addKeyListener( this );
		System.out.println("KeyListener añadido");
		setFocusable(true);
	    setFocusTraversalKeysEnabled(false);

	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent( g ); // llama al paintComponent de la superclase
		this.setBackground( Color.WHITE ); 
		m.dibujar(g);
		f1.dibujar(g);
		f2.dibujar(g);
		f3.dibujar(g);
		f4.dibujar(g);
		fr1.dibujar(g);
		fr2.dibujar(g);
		fr3.dibujar(g);
		pc.dibujar(g);

	}
	
	public void jugar () {
		for (int i = 0; i<1000; i++) {
			f1.movimiento(m, 0);
			f2.movimiento(m, 0);
			f3.movimiento(m, 0);
			f4.movimiento(m, 0);
			fr1.movimiento(m, 0);
			fr2.movimiento(m, 0);
			fr3.movimiento(m, 0);
			pc.movimiento(m, 0);
			try {
				Thread.sleep(200);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			repaint();
		}
	}

	  public void keyPressed( KeyEvent event )
	   {
	      System.out.println(event.getKeyCode());
	      switch ( event.getKeyCode() ) {
	      case 37: // izquierda
	    	  pc.setDir(0);
	    	  break;
	      case 38: // arriba
	    	  pc.setDir(1);
	    	  break;
	      case 39: // derecha
	    	  pc.setDir(2);
	    	  break;
	      case 40: // abajo
	    	  pc.setDir(3);
	    	  break;
	      }
	      System.out.println(pc.getDir());

	   }
	  
	   // handle release of any key
	   public void keyReleased( KeyEvent event )
	   {
	   } // end method keyReleased

	   // handle press of an action key
	   public void keyTyped( KeyEvent event )
	   {
	   } // end method keyTyped
	
}
