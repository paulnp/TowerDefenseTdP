package GUI;

import Logica.Jugador;
import Audio.Sonido;
import Creadores.CreadoresVisuales.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TiendaVisual extends JPanel implements ActionListener {
	private JLabel fondo;
	private int height;
	private int width;
	private FactoryVisual [] botones = new FactoryVisual [8];
	private Sonido efectos;
	private Jugador P; //En esta clase se encarga de tomar los numeros y modificar el display
	private JLabel displayMonedas;
	private JLabel displayPuntos;
	
	public TiendaVisual (int width, int height, String direccion) {
		this.setLayout (null);
		this.setSize (width, height);
		this.height = height;
		this.width = width;
		this.efectos = new Sonido ();
		ImageIcon imagen = new ImageIcon (direccion);
		cargarFondo (imagen);
		setBotones ();
		//setNumeros (); //Agrega el puntaje y las monedas pero tira error cuando se ejecuta
	}
	
	public JLabel getFondo () {
		return fondo;
	}
	
	public int getHeight () {
		return height;
	}
	
	public int getWidth () {
		return width;
	}
	
	public FactoryVisual [] getBotones () {
		return botones;
	}
	
	public Jugador getP () {
		return P;
	}
	
	public JLabel getPanelMonedas () {
		return displayMonedas;
	}
	
	public JLabel getPanelPuntos () {
		return displayPuntos;
	}
	
	private void cargarFondo(ImageIcon im) {
		fondo = new JLabel(im);
		fondo.setBounds(0, 0, width, height);
		this.add(fondo);
	}
	
	private void setBotones () {
        botones [0] = new CreadorSoldadoBoton ();
        botones [1] = new CreadorArqueroBoton ();
        botones [2] = new CreadorCaballeroBoton ();
        botones [3] = new CreadorCatapultaBoton ();
        botones [4] = new CreadorEliteBoton ();
        botones [5] = new CreadorExplosivoBoton ();
        botones [6] = new CreadorKitMedicoBoton ();
        botones [7] = new CreadorArmaduraBoton ();
        for (int i = 0; i < 8; i++) {
    		botones [i].addActionListener(this);
    		add (botones [i]);
    	}
	}
	
	public void setNumeros () {
		displayMonedas = new JLabel ("" + P.getMonedas ());
		displayPuntos = new JLabel ("" + P.getPuntos ());
		add (displayMonedas);
		add (displayPuntos);
	}
	
	public void modificarMonedas () {
		
	}
	
	public void modificarPuntaje () {
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		efectos.ReproducirSonido ("src\\Audio\\Sonidos\\TestSound.wav");
	}
}