package Logica.Niveles;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import Audio.Sonido;
import GUI.*;
import Logica.*;
import Logica.Caminos.Camino;
import Hilos.HiloEnemigo;
import Hilos.HiloGenerarEnemigo;
import Hilos.HiloInteraccion;
import entidades.Enemigo;

public abstract class Nivel {
	
	protected AbstractFactory fabrica;
	protected MapaLogico mapaLogico;
	protected TiendaLogica tiendaLogica;
	protected GUI miGui;
	protected Camino miCamino;
	protected Posicion posInicialEnemies;
	protected Posicion posFinalEnemies;
	protected String direccionMapa;
	protected File cancion;
	protected LinkedList <Enemigo> enemigosAMandar;
	protected HiloEnemigo [] hilosMovimientos;
	protected HiloGenerarEnemigo hiloCreador;
	protected HiloInteraccion hiloAtaque;
	protected Sonido miBGM;
	
	public Nivel (GUI gui) {
		miGui = gui;
		mapaLogico = MapaLogico.InstanciaMapaLogico ();
		mapaLogico.setNivel (this);
		mapaLogico.setMapaVisual (miGui.getMapaVisual());
		tiendaLogica = TiendaLogica.InstanciaTiendaLogica ();
		fabrica = new FabricaEnemigos ();
		enemigosAMandar = new LinkedList <Enemigo> ();
		hiloAtaque = new HiloInteraccion ();
		hiloAtaque.start ();
		miBGM = new Sonido();
	}
	
	public void moverEnemigos () {
		Iterator <Enemigo> it = mapaLogico.getListaEnemigos ().iterator ();
		while (it.hasNext ()) {
			Enemigo e = it.next ();
			e.Mover ();
			try {
				Thread.sleep (100);
				//si mi teoria es correcta, esto haria que las unidades se 
				//muevan con cierta distancia entre ellas.
				//Mi teoria era 75% correcta, genera una separaci�n, pero despues se vuelven a juntar
			}
			catch (InterruptedException e1) {
				e1.printStackTrace ();
			}
		}
	}
	
	public MapaLogico getMapa () {
		return mapaLogico;
	}
	
	/**
	 * Metodo que devuelve la TiendaLogica asociada
	 * @return TiendaLogica del  nivel (seria �nica, por eso la mand� para arriba)
	 */
	public TiendaLogica getTienda () {
		return tiendaLogica;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public Posicion getPosicionInicial () {
		return posInicialEnemies;
	}
	
	public Posicion getPosicionFinal () {
		return posFinalEnemies;
	}
	
	public String getDireccionMapa () {
		return direccionMapa;
	}
	
	/**
	 * genera la lista de enemigos que van a estar en el nivel
	 */
	public abstract void generarListaEnemigos ();
	
	/**
	 * Metodo que modifica la ventana para pasar al siguiente Nivel
	 */
	public abstract void siguienteNivel ();
	
	public File getAudio(){
		return cancion;
	}
	
	public LinkedList <Enemigo> getListaEnemigos () {
		return enemigosAMandar;
	}
	
	public void mandarEnemigo () {
		if (!enemigosAMandar.isEmpty ()) {
			boolean corte = false;
			for (int I = 0; I < hilosMovimientos.length && !corte; I++) {
				if (hilosMovimientos [I].estaLibre ()) {
					enemigosAMandar.getFirst ().activar ();
					hilosMovimientos [I].setEnemigo (enemigosAMandar.removeFirst ());
					corte = true;
				}
			}
		}
	}
	
	public void murioEnemigo (Enemigo e) {
		sacarDeHilo (e);
		e.morir();
	}
	
	public void llegoEnemigoABase (Enemigo e) {
		sacarDeHilo (e);
		mapaLogico.restarVida ();
		if (mapaLogico.getJugador ().getVidas () == 0) {
			
			
			
		}
	}
	
	private void sacarDeHilo (Enemigo e) {
		boolean corte = false;
		for (int I = 0; I < hilosMovimientos.length && !corte; I++) {
			if (hilosMovimientos [I].getEnemigo () == e) {
				hilosMovimientos [I].setEnemigo (null);
				corte = true;
			}
		}
	}
}