package Objetos.ObjResistente;

import Logica.Posicion;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class Roca extends ObjetoResistente {

	public Roca (Posicion Pos) {
		super ("Roca", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\Roca.png",Pos);
	}

	public void setVida (int i) {
		Vida = i;
	}
	
	public void Afectar () {}
}