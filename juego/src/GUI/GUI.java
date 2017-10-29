package GUI;

import Logica.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	private static GUI Instancia;
	private JFrame ventana;
	private JButton oleada;
	private static String direccionM = "src\\GUI\\Sprites Mapas\\Mapa1.png";
	private static String direccionS = "src\\GUI\\Sprites Mapas\\FondoTienda.png";
	private MapaVisual mapa;
	private TiendaVisual shop;
	private Nivel nivel;
	private ContadorTiempo cont;
	
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater (new Runnable() {
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
	
	private GUI () {
		this.getContentPane ().setLayout (new GridLayout (2,1));
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setSize (517, 800);
		mapa = MapaVisual.InstanciaMapaVisual ();
		mapa.cargarFondo (direccionM);
		shop = TiendaVisual.InstanciaTiendaVisual ();
		shop.cargarFondo (direccionS);
		mapa.setGUI (this);
		oleada = new JButton("Empezar Oleada");
		oleada.addActionListener(new OyenteOleada(oleada, Instancia));
		
		
		
		this.getContentPane ().add (mapa);
		this.getContentPane ().add (shop);
		getContentPane().add (mapa);
		getContentPane().add (shop);
		
	
		nivel = new Nivel1 (this);
		cont = new ContadorTiempo(nivel);
		cont.start();
	}
	
	public static GUI InstanciaGUI () {
		if (Instancia == null) {
			Instancia = new GUI ();
		}
		return Instancia;
	}
	
	public MapaVisual getMapaVisual() {
		return mapa;
	}
	
	public TiendaVisual getTiendaVisual () {
		return shop;
	}
	
	public Nivel getNivel () {
		return nivel;
	}
	
	public JFrame getVentana () {
		return ventana;
	}

	/**
	 * metodo que cambia el nivel (en l�gica, m�s o menos?)
	 * @param n nivel a usar como nuevo nivel
	 */
	public void setNivel(Nivel n){
		nivel = n;
		mapa.setVisible(false);
		mapa = nivel.getMapa().getMapaVisual();
		mapa.setVisible(true);
	}

	
}