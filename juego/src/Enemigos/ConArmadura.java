package Enemigos;

import Logica.Posicion;
import Logica.Visitor;
import entidades.Controlable;
import entidades.Enemigo;

public class ConArmadura extends Enemigo {
	
	/*
	Nombre = "ConArmadura"
	JLabel = ConArmadura.gif
	Posicion = pos
	Vida = 450
	Alcance = 1
	PowerUpDelMapa = null
	Ataque = 200
	Defensa = 75
	VelocidadMov = 3
	PowerUp = False
	Puntaje = 4500
	*/
	
	public ConArmadura (Posicion pos) {
		super ("ConArmadura", "src\\Enemigos\\Sprites Enemigos\\ConArmadura.gif", pos, 450, 1, null, 200, 75, 3, false, 4500);
		this.grafico.setBounds (getPos ().getX (), getPos ().getY (), 20, 20);
	}

	@Override
	public void accept(Visitor V, Controlable P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor V, Enemigo E) {
		// TODO Auto-generated method stub
		
	}
}