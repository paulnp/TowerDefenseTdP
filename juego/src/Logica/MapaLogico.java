package Logica;

import java.util.Collection;
import java.util.LinkedList;

import GUI.MapaVisual;
import entidades.Controlable;
import entidades.Enemigo;

public class MapaLogico {
	private MapaVisual mapaVisual;
	protected Collection<Controlable> unidadesEnMapa;
	protected Collection <Enemigo> enemigos;
	private static MapaLogico Instancia;
	private Celda [][] matriz;
	private static int tama�o = 20;
	private static int width=500;
	private static int height =320;
	private Camino miCamino;
	
	/**
	 * constructor : inicializa la matriz de Celdas con un total de (el Ancho del Mapa)/20 por
	 * (alto del Mapa)/20. Usamos 20*20 por el tama�o del Sprite. Luego de inicializar la Matriz
	 * creamos cada Celda perteneciente a la matriz y le enviamos la posicion de su esquina izq.
	 */
	
	private MapaLogico (int w, int h) {
		matriz = new Celda [w/tama�o][h/tama�o];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz [0].length; j++) {
				matriz [i][j] = new Celda (i*tama�o,j*tama�o);
			}
		}
		miCamino = new Camino1 ();
		enemigos = new LinkedList<Enemigo>();
		unidadesEnMapa = new LinkedList<Controlable>();
	}
	
	public static MapaLogico InstanciaMapaLogico () {
		if (Instancia == null) {
			Instancia = new MapaLogico (500,320);
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
		if (posicionValida(X,Y))
		return matriz [X/tama�o] [Y/tama�o];
		
		else return null;
	}
	
	public int getTama�o () {
		return tama�o;
	}
	
	public Camino getCamino () {
		return miCamino;
	}
	
	public void generarCaminoA (Posicion pos) {
		miCamino.generarCaminoA (pos);
	}

	public Collection<Controlable> getListaControlables(){
		return unidadesEnMapa;
	}

	public Collection<Enemigo> getListaEnemigos(){
		return enemigos;
	}
	
	public boolean puedoAgregarControlable (Posicion pos) {
		boolean Puedo;
		if (posicionValida (pos.getX(), pos.getY()) && !miCamino.perteneceAlCamino(pos) && 
				matriz[pos.getX()/20][pos.getY()/20].getPersonaje() == null) {
			Puedo = true;
		}
		else {
			Puedo = false;
		}
		return Puedo;
	}
	
	public boolean puedoAgregarObjeto (Posicion pos) {
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
		matriz [pos.getX()/20][pos.getY()/20].addPersonaje (c);
		unidadesEnMapa.add (c);	
	}
	
	public void agregarEnemigo (Enemigo e) {
		Posicion pos= e.getPos();
		if (posicionValida(pos.getX(), pos.getY())) {
			enemigos.add(e);
			matriz[pos.getX()/20][pos.getY()/20].getEnemigos().add(e);
		}
	}

	private boolean posicionValida(int X, int Y) {
		return X>=0 && X<=width && Y>=0 && Y<= height;
	}
}