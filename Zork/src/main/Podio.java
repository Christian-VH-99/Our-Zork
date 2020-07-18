package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jugadores.Jugador;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class Podio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Podio(Jugador jugador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/corona.png"));
		setTitle("GAME OVER");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel imgCondicion = new JLabel("");
		imgCondicion.setBounds(10, 43, 164, 164);
		contentPane.add(imgCondicion);

		JLabel condicion = new JLabel("");
		condicion.setForeground(Color.ORANGE);
		condicion.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		condicion.setBounds(198, 43, 226, 61);
		contentPane.add(condicion);

		JLabel ranking = new JLabel("");
		ranking.setForeground(Color.ORANGE);
		ranking.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		ranking.setBounds(200, 140, 224, 67);
		contentPane.add(ranking);

		condicion.setText(jugador.getCondicion() + " " + jugador.getNombre());
		imgCondicion.setIcon(new ImageIcon("img/" + jugador.getCondicion() + ".png"));
		int puntajeTotal = jugador.getInventario().contarPuntaje();
		if (jugador.getCondicion().equals("GANASTE")) {

			if (puntajeTotal > 240) {
				ranking.setText("Rango: ORO");
			} else if (puntajeTotal > 150) {
				ranking.setText("Rango: PLATA");
			} else {
				ranking.setText("Rango: BRONCE");
			}
		} else {
			if (puntajeTotal > 240) {
				ranking.setText("Rango: MADERA");
			} else if (puntajeTotal > 99) {
				ranking.setText("Rango: PLASTICO");
			} else if (puntajeTotal > -101) {
				ranking.setText("Rango: CARTON");
			} else {
				ranking.setText("Rango: BORBOTON");
			}
		}

	}
}