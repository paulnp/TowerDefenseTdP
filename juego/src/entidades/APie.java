package entidades;

import Logica.Posicion;

public class APie extends enemigo {
	
	/*
	Nombre = "APie"
	JLabel = GifSoldado.gif
	Posicion = null
	Vida = 50
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 50
	Defensa = 100
	VelocidadMov = 5
	PowerUp = False
	*/
	
	public APie (Posicion pos) {
		super ("APie","C:\\Users\\tomi_\\Desktop\\Sprites\\GifSoldado.gif",pos,50,1,null,50,100,5,false);
		this.grafico.setBounds(getPos ().getX (), getPos ().getY (), 20, 20);
	}
}