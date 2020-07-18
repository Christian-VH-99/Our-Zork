package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Elegir;
import acciones.Hablar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
import acciones.Usar;
import jugadores.Jugador;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class Juego extends JFrame {

	private static final long serialVersionUID = 1L;
	private Jugador jugador;

	private JPanel panelJuego = new JPanel();
	private JTextArea consola;
	private JTextField entrada;
	private JButton btnEntrada;
	private JLabel imagen;
	private String salida;
	private Peticion peticion = null;
	private String historial;
	private String entradaTeclado;
	private AccionBase accion;
	private Interprete interprete;
	private JButton btnGuardar;
	@SuppressWarnings("unused")
	private Podio podio;
	private ArrayList<FinDeJuego> finales;

	/**
	 */
	public Juego(String nombre, String path) {
		setBackground(Color.BLACK);
		setForeground(Color.BLACK);
		Jugador jugador = new Jugador(nombre);
		this.jugador = jugador;
		/* interfaz */
		cargarPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/" + path + ".png"));
		historial = "esta es la historia de " + jugador.getNombre() + "\n";
		accion = cargarChainAcciones();
		EntornoGson entorno = new EntornoGson();
		entorno.deserializar(path);
		jugador.setUbicacionActual(entorno.getUbicacion());
		cargarImagenInicio(entorno.getUbicacion().getNombre());
		finales = entorno.getFinales();
		interprete = new Interprete(entorno);
		consola.append(entorno.getBienvenida() + "\n");

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirEnArchivo(historial);
			}
		});

		btnEntrada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				procesarComando(jugador);
			}
		});
		entrada.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					procesarComando(jugador);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

	}

	public void procesarComando(Jugador jugador) {
		String entradaTeclado = entrada.getText();
		consola.append(">>" + entradaTeclado + "\n");
		entrada.setText("");
		interprete.separarComando(entradaTeclado);
		peticion = interprete.generarPeticion();
		if (peticion == null) {
			consola.append("Intenta con otro comando\n");
		} else {
			salida = accion.ejecutar(peticion, jugador, imagen);
			consola.append(salida + "\n");
			historial += entradaTeclado + "\t" + salida + "\n";
			salida = null;
		}
		interprete.recargarInterprete();
		if (esFinDeJuego(peticion, jugador)) {
			entrada.setEnabled(false);
			entrada.setEditable(false);
			setPodio(new Podio(jugador));
		}
	}

	private void cargarImagenInicio(String imagen) {
		this.imagen.setIcon(new ImageIcon("img/" + imagen + ".jpg"));
	}

	private void cargarPanel() {

		setBounds(0, 0, 845, 618);
		setResizable(false);
		panelJuego.setBackground(Color.BLACK);
		getContentPane().add(panelJuego);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		panelJuego.setBounds(0, 0, 510, 720);
		panelJuego.setVisible(true);
		panelJuego.setLayout(null);

		setTitle("Zork: historia de " + jugador.getNombre());

		consola = new JTextArea(1, 50);
		consola.setForeground(Color.WHITE);
		consola.setBackground(Color.DARK_GRAY);
		consola.setFont(new Font("Verdana", Font.PLAIN, 16));
		consola.setLineWrap(true);
		consola.setWrapStyleWord(true);
		consola.setEditable(false);
		JScrollPane scrollBar = new JScrollPane(consola, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(10, 352, 819, 193);
		panelJuego.add(scrollBar);

		entrada = new JTextField();
		entrada.setFont(new Font("Verdana", Font.PLAIN, 14));
		entrada.setForeground(Color.WHITE);
		entrada.setBackground(Color.DARK_GRAY);
		entrada.setBounds(10, 556, 550, 22);
		panelJuego.add(entrada);
		entrada.setColumns(10);

		btnEntrada = new JButton("confirmar");
		btnEntrada.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnEntrada.setBounds(570, 556, 101, 23);
		panelJuego.add(btnEntrada);

		imagen = new JLabel("");
		imagen.setBounds(10, 11, 819, 331);
		panelJuego.add(imagen);

		btnGuardar = new JButton("Guardar acciones");
		btnGuardar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		btnGuardar.setBounds(681, 556, 148, 22);
		panelJuego.add(btnGuardar);

	}

	private void escribirEnArchivo(String historial) {
		File nombre = null;
		JFileChooser fileChooser = new JFileChooser("historial/");
		fileChooser.addChoosableFileFilter(new FiltroTxt());
		fileChooser.setAcceptAllFileFilterUsed(false);
		int seleccion = fileChooser.showSaveDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			nombre = fileChooser.getSelectedFile();
		}
		File fichero = new File(nombre.getPath() + ".txt");
		FileWriter escribArch;
		try {
			escribArch = new FileWriter(fichero);
			BufferedWriter bufEscribir = new BufferedWriter(escribArch);
			bufEscribir.write(historial);
			bufEscribir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private AccionBase cargarChainAcciones() {

		Agarrar accion = new Agarrar();

		Mirar mirar = new Mirar();
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		Informacion informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Dar dar = new Dar();
		informacion.setSiguiente(dar);

		Usar usar = new Usar();
		dar.setSiguiente(usar);

		Moverse moverse = new Moverse();
		usar.setSiguiente(moverse);

		Hablar hablar = new Hablar();
		moverse.setSiguiente(hablar);

		Elegir elegir = new Elegir();
		hablar.setSiguiente(elegir);

		return accion;
	}

	private boolean esFinDeJuego(Peticion peticion, Jugador jugador) {

		if (peticion == null || peticion.getEjecuto().equals(false))
			return false;

		for (FinDeJuego peticionFinal : finales) {

			if (peticionFinal.getPeticion().equals(peticion)) {
				jugador.setCondicion(peticionFinal.getCondicion());
				consola.append(peticionFinal.getMensajeFin());
				historial += "\n" + peticionFinal.getMensajeFin() + "\n" + peticionFinal.getCondicion();
				return true;
			}
		}
		return false;
	}

	public boolean getEsFinDeJuego(Peticion peticion, Jugador jugador) {
		return esFinDeJuego(peticion, jugador);
	}

	public void setFinales(ArrayList<FinDeJuego> finales) {
		this.finales = finales;
	}

	public String getEntradaTeclado() {
		return entradaTeclado;
	}

	public void setEntradaTeclado(String entradaTeclado) {
		this.entradaTeclado = entradaTeclado;
	}

	public Juego(Jugador jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setPeticion(Peticion peticion) {
		this.peticion = peticion;
	}

	private void setPodio(Podio podio) {
		this.podio = podio;
	}

}
