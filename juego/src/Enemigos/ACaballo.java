package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;

public class ACaballo extends Enemigo {
	
	/*
	Nombre = "ACaballo"
	JLabel = ACaballo.gif
	Posicion = pos
	Vida = 200
	Alcance = 2
	PowerUpDelMapa = null
	Ataque = 100
	Defensa = 90
	VelocidadMov = 6
	PowerUp = False
	Puntaje = 5000
	*/
	
	public ACaballo (Posicion pos) {
		super ("ACaballo", "src\\Enemigos\\Sprites Enemigos\\ACaballo.gif", pos, 200, 2, null, 100, 90, 6, false, 5000);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}
}