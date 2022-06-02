package PacMan3;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String ... args) {
		JFrame frame = new JFrame( "PacMan" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		PanelJuego panel = new PanelJuego();
		
		frame.add( panel ); // add panel to frame
		frame.setSize( 600, 700 ); // set frame size
		frame.setVisible( true ); // display frame
		
		panel.jugar();

	} // fin main()
	
} // fin Laberinto
