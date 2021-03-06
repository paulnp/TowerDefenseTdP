package Controlables;

import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Soldado extends Controlable {
	
	/*
	Nombre = "Soldado"
	JLabel = Soldado.gif
	Posicion = pos
	Vida = 160
	Alcance = 2
	Ataque = 70
	Defensa = 100
	Precio = 200
	VelocidadAt = 4
	*/
	
	public Soldado (Posicion pos) {
		super ("Soldado", pos, 160, 2, 70, 100, 200, 4);
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\SoldadoStatic.gif",pos);
	}
}