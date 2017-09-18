package GUI;

import  Logica.*;
import entidades.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;



@SuppressWarnings("serial")
public class GUI extends JFrame {
	//private JFrame ventana;
	private ContadorTiempo tiempo;
	private static int width=500;
	private static int height=320;
	private static String direccion= "C:\\Users\\tomi_\\Desktop\\Sprites\\MapaRecortado.png";
	private MapaVisual mapa;
	@SuppressWarnings("unused")
	private Nivel nivel;
	//private ContadorTiempo contadorTiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI() {
		this.getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(517, 360);
		mapa = new MapaVisual(width,height,direccion);
		nivel= new Nivel(this);
		this.getContentPane().add(mapa);
		this.add(mapa);
		tiempo = new ContadorTiempo(nivel);
		tiempo.start();
		
		//ver();
	
	}

	
	public MapaVisual getMapaVisual() {
		return mapa;
	}
	
	private void ver() {
		APie E = new APie(new Posicion (80,60));
		E.getGrafico().setVisible(true);
		this.getContentPane().add(E.getGrafico());
		
	}

}