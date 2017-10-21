package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Catapulta extends Controlable {
	
	protected Posicion pos2;
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 3
	Ataque = 200
	Defensa = 100
	Precio = 500
	VelocidadAt = 2
	*/
	
	public Catapulta (Posicion pos) {
		super ("Caballero", pos, 200, 3, 200, 100, 500, 2);
		grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif",pos);
		pos2 = new Posicion (pos.getX () + 20, pos.getY () + 20);
	}
}