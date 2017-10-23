package Controlables.Disparos;

import entidades.Proyectil;
import Logica.Posicion;

public class Flecha extends Proyectil {

	public Flecha(Posicion P){
		direccionDibujo = "Flecha.GIF";
		velocidadMovimiento = 5;
		posActual = P;
	}

	@Override
	public void volarAPosicion(Posicion p) {
		while(posActual.getX() != p.getX() && posActual.getY() != p.getY()) {
			int x1 = posActual.getX();
			int y1 = posActual.getY();
			int x2 = p.getX();
			int y2 = p.getY();
			
			if(x1 > x2) { //la Posicion del disparador es mayor que la del disparado en X
				if(y1 > y2) { //la Posicion del disparador es mayor que la del disparado en Y
					//Hacer que la flecha viaje haciendo uso de los x e y dados (usar setBounds()?)
					dibujo.setBounds(posActual.getX() - velocidadMovimiento, posActual.getY() - velocidadMovimiento, dibujo.getWidth(), dibujo.getHeight());
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					posActual.setX(posActual.getX() - velocidadMovimiento);
					posActual.setY(posActual.getY() - velocidadMovimiento);
					//ac�, el disparado estaria en el segundo cuadrante de coordenadas
				}
				else { //la posicion del disparado es mayor que la del disparador en Y
					//ac�, el disparado estaria en el tercer cuadrante de coordenadas
				}
			}
			else { //la Posicion del disparado es mayor que la del disparador en X
				if(y1 > y2) {
					//ac�, el disparado estaria en el primer cuadrante de coordenadas
				}
				else {
					//ac�, el disparado estaria en el cuarto cuadrante de coordenadas
				}
			}
		}
		
		
	}

}