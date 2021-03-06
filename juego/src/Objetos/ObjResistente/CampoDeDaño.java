package Objetos.ObjResistente;

import Enemigos.Movimiento.CaminarDaņado;
import Logica.Posicion;
import entidades.Enemigo;
import entidades.EntidadesGraficas.EntidadGraficaNoEnemigo;

public class CampoDeDaņo extends ObjetoResistente {

	public CampoDeDaņo (Posicion Pos) {
		super ("CampoDeDaņo", Pos, 100);
		grafico = new EntidadGraficaNoEnemigo ("src\\Objetos\\ObjResistente\\Sprites Resistentes\\CampoDeDaņo.png",Pos);
	}
	
	public void Afectar (Enemigo E) {
		E.setEstrategia (new CaminarDaņado (E));
		E.setAfectado(true);
	}
}