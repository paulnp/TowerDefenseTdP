package entidades.EntidadesGraficas;

import Logica.Posicion;

public class EntidadGraficaEnemigo extends EntidadGrafica {
	
	public EntidadGraficaEnemigo (String File, Posicion pos) {
		super (File, pos);
	}
	
	public void moverA (Posicion pos, int vel) {
		try {
			if(this.pos.getX()!= pos.getX()) {
				while(this.pos.getX()!=pos.getX())
					this.grafico.setBounds(this.pos.getX()-vel, this.pos.getY(), 20, 20);
				    Thread.sleep(100);
			}
			else {
				while(this.pos.getY()!=pos.getY()) {
					this.grafico.setBounds(this.pos.getX(), this.pos.getY()-vel, 20, 20);
				    Thread.sleep(100);
				}
			}		
			this.pos = pos;
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}