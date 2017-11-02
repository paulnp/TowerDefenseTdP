package Logica;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import GUI.MapaVisual;
import Objetos.ObjResistente.CampoDeDa�o;
import Objetos.ObjResistente.Roca;
import Objetos.ObjTemporal.CampoDebilitador;
import Objetos.ObjTemporal.Lago;
import entidades.Controlable;
import entidades.Enemigo;
import entidades.Objeto;

public class MapaLogico {
	
	private MapaVisual mapaVisual;
	protected Collection <Controlable> unidadesEnMapa;
	protected Collection <Enemigo> enemigosEnMapa;
	protected Collection <Objeto> objetosEnMapa;
	private static MapaLogico Instancia;
	private Celda [][] matriz;
	private static int tama�o = 20;
	private static int width = 500;
	private static int height = 320;
	private Camino miCamino;
	private Jugador P;
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tama�o del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	private MapaLogico () {
		matriz = new Celda [width / tama�o] [height / tama�o];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tama�o,j*tama�o);
			}
		}
		miCamino = new Camino1 ();
		unidadesEnMapa = new LinkedList <Controlable> ();
		enemigosEnMapa = new LinkedList <Enemigo> ();
		objetosEnMapa = new LinkedList <Objeto> ();
		P = Jugador.InstanciaJugador ();
	}
	
	public static MapaLogico InstanciaMapaLogico () {
		if (Instancia == null) {
			Instancia = new MapaLogico ();
		}
		return Instancia;
	}
	
	public void setMapaVisual (MapaVisual MV) {
		this.mapaVisual = MV;
	}
	
	public MapaVisual getMapaVisual() {
		return mapaVisual;
	}
	
	public Celda getCelda (int X, int Y) {
		Celda C;
		if (posicionValida (X,Y)) {
			C = matriz [X/tama�o] [Y/tama�o];
		}
		else  {
			C = null;
		}
		return C;
	}
	
	public int getTama�o () {
		return tama�o;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public Jugador getJugador () {
		return P;
	}
	
	public void generarCaminoA (Posicion pos) {
		miCamino.generarCamino ();
	}

	public Collection <Controlable> getListaControlables () {
		return unidadesEnMapa;
	}

	public Collection <Enemigo> getListaEnemigos () {
		return enemigosEnMapa;
	}
	
	public Collection <Objeto> getListaObjetos () {
		return objetosEnMapa;
	}
	
	public boolean puedoAgregarControlable (Posicion pos) {
		boolean Puedo;
		if (posicionValida (pos.getX (), pos.getY ()) && !miCamino.perteneceAlCamino (pos) && 
			matriz[pos.getX()/20][pos.getY()/20].getPersonaje() == null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public boolean puedoAgregarObjetoDeTienda (Posicion pos) {
		boolean Puedo;
		if (posicionValida (pos.getX(), pos.getY()) && !miCamino.perteneceAlCamino(pos) && 
			matriz[pos.getX()/20][pos.getY()/20].getPersonaje() != null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public void agregarControlable (Controlable c, Posicion pos) {
		if (posicionValida (pos.getX (), pos.getY ())) {
			matriz [pos.getX()/20][pos.getY()/20].addPersonaje (c);
			unidadesEnMapa.add (c);
		}
	}
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos = e.getPos();
		if (posicionValida (pos.getX (), pos.getY ())) {
			enemigosEnMapa.add (e);
			matriz [pos.getX()/20] [pos.getY()/20].getEnemigos ().add (e);
		}
	}
	
	public void agregarObjeto (Objeto O) {
		Posicion pos = O.getPos ();
		if (posicionValida (pos.getX (), pos.getY ())) {
			objetosEnMapa.add (O);
			matriz [pos.getX()/20] [pos.getY()/20].addObjeto (O);
		}
	}

	private boolean posicionValida(int X, int Y) {
		return X >= 0 && X <= width && Y >= 0 && Y <= height;
	}
	
	/**
	 * metodo que se encarga de, usando un Random, generar un objeto de mapa
	 * (Lago,campo da�ino, etc) y tirarlo en alguna posici�n del Camino de enemigos
	 * El MapaVisual debria tener un metodo similar que lo que haga es, 
	 * recibiendo el item especifico, lo muestre en el mapa donde debe
	 *  podemos usar el Thread "Contador Tiempo" para contar el tiempo que dura el objeto
	 *  lo que hace ese Thread es mantener un contador y le va sumando 1 por cada segundo que pasa
	 *  con un sleep de, justamente, un segundo
	 */
	public void generarElementoDeMapa() {
		Random rand = new Random();
		Objeto k;
		int r = rand.nextInt(4);
		Posicion p = miCamino.getPosAleatoria();
		switch (r) {
			case 0:
				k = new Roca(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k,p);
				break;
			case 1:
				k = new CampoDeDa�o(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
			case 2:
				k = new Lago(p); //todos los objetos temporales tendrian asociados un contador Thread para contar el tiempo que tardan en irse
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
			case 3:
				k = new CampoDebilitador(p);
				matriz[p.getX()][p.getY()].addObjeto(k);
				mapaVisual.agregarObjeto(k, p);
				break;
		}
	}
	
	public void eliminarControlable (Controlable C) {
		getCelda (C.getPos ().getX (), C.getPos ().getY ()).EliminarControlableDeCelda (C);
		unidadesEnMapa.remove (C);
	}
	
	public void eliminarEnemigo (Enemigo E) {
		getCelda (E.getPos ().getX (), E.getPos ().getY ()).EliminarEnemigoDeCelda (E);
		enemigosEnMapa.remove (E);
	}
	
	public void eliminarObjeto (Objeto O) {
		getCelda (O.getPos ().getX (), O.getPos ().getY ()).EliminarObjetoDeCelda (O);
		objetosEnMapa.remove (O);
	}
	
	public void restarVida () {
		P.restarVida ();
	}
}