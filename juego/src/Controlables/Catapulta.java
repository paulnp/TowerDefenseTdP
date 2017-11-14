package Controlables;

import entidades.Disparos.CargaCatapulta;
import Logica.Posicion;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Proyectil;
import entidades.EntidadesGraficas.EntidadGrafica;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

@SuppressWarnings("unused")
public class Catapulta extends Controlable {
	
	/*
	Nombre = "Catapulta"
	JLabel = Catapulta.gif
	Posicion = pos
	Vida = 200
	Alcance = 3
	Ataque = 50
	Defensa = 100
	Precio = 500
	VelocidadAt = 2
	*/
	
	public Catapulta (Posicion pos) {
		super ("Caballero", pos, 200, 3, 5000, 100, 500, 2);
		this.Pos2 = new Posicion (pos.getX () + 20, pos.getY ());
		this.miMapa.getCelda (this.Pos2.getX (), this.Pos2.getY ()).addPersonaje (this);;
		this.grafico = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CatapultaStatic.gif", pos);
		this.GraficoAuxiliar = new EntidadGraficaNoEnemigo ("src\\Controlables\\Sprites Controlables\\CargaCatapulta.png", this.Pos2);
	}

	public void atacar(Enemigo E) {
		//Proyectil municion = new CargaCatapulta(new Posicion (pos.getX(),pos.getY()), new Posicion (E.getPos().getX(), E.getPos().getY()));
		E.getEstado ().setVida (E.getEstado ().getVida () - calcularGolpe (E));
	}
}