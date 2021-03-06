package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("unused")
public class MenuPrincipal {

	private JFrame frame;
	private JTextField Autores;
	private GUI siguienteNivel;
	private Clip clip;
	private AudioInputStream audio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal () {
		initialize ();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			audio = AudioSystem.getAudioInputStream (new File("src\\Audio\\Audio.Sonidos\\MenuPrincipal.WAV").getAbsoluteFile());
			clip = AudioSystem.getClip();
			if(audio != null){
				clip.open(audio);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		}
		catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		JLabel lblimagenDelTitulo = new JLabel("All your base are NOT belong to us");
		lblimagenDelTitulo.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		lblimagenDelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblimagenDelTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton jugar = new JButton("Empezar");
		jugar.setBounds(135, 56, 122, 23);
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clip.stop();
				frame.setVisible(false);
				frame.dispose();
				siguienteNivel = GUI.InstanciaGUI();
				siguienteNivel.setVisible(true);
				siguienteNivel.setBounds(300,10,516,680);
			}
		});
		panel.setLayout(null);
		panel.add(jugar);
		
		JButton EXIT = new JButton("Salir");
		EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		EXIT.setBounds(135, 164, 122, 23);
		panel.add(EXIT);
		
		Autores = new JTextField();
		Autores.setHorizontalAlignment(SwingConstants.CENTER);
		Autores.setEditable(false);
		Autores.setBounds(22, 216, 388, 20);
		Autores.setText("Sacomani Franco, Gomez Tom\u00E1s, Ceballos Vitale Pablo Guillermo");
		panel.add(Autores);
		Autores.setColumns(10);
		frame.setVisible(true);
	}
}