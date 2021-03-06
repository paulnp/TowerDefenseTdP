package Enemigos;

import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaEnemigo;

public class ConArco extends Enemigo {
	
	/*
	Nombre = "ConArco"
	JLabel = ConArco.gif
	Posicion = pos
	Vida = 200
	Alcance = 5
	Ataque = 50
	Defensa = 125
	VelocidadMov = 2
	PowerUp = False
	Puntaje = 2500
	*/
	
	public ConArco (Posicion pos) {
		super ("ConArco", pos, 200, 5, 50, 125, 2, false, 250, 2500);
		grafico = new EntidadGraficaEnemigo ("src\\Enemigos\\Sprites Enemigos\\ConArco.gif",pos,this);
	}
}