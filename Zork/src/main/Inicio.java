package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;

public class Inicio extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = -5820555671833794616L;

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> boxAventura;
	private JLabel titulo;
	private JButton btnJugar;
	private Juego zork;
	private HashMap<String, String> aventuras;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setForeground(Color.BLACK);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.getContentPane().setBackground(Color.BLACK);
		aventuras = new HashMap<String, String>();
		aventuras.put("Piramide", "piramide.json");
		aventuras.put("Muelle", "muelle.json");

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/zork.png"));
		setTitle("Zork");
		setBounds(100, 100, 424, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(262, 128, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre Jugador");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 121, 115, 32);
		contentPane.add(lblNewLabel);

		JLabel lblSeleccioneAventura = new JLabel("Seleccione aventura");
		lblSeleccioneAventura.setForeground(Color.LIGHT_GRAY);
		lblSeleccioneAventura.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		lblSeleccioneAventura.setBounds(35, 164, 138, 32);
		contentPane.add(lblSeleccioneAventura);

		boxAventura = new JComboBox<String>();
		boxAventura.setForeground(Color.BLACK);
		boxAventura.setBackground(Color.WHITE);
		boxAventura.setBounds(262, 171, 124, 20);
		boxAventura.setModel(
				new DefaultComboBoxModel<>(aventuras.keySet().toArray(new String[aventuras.keySet().size()])));
		contentPane.add(boxAventura);

		titulo = new JLabel("");
		titulo.setIcon(new ImageIcon("img/zorkPPAL.jpg"));
		titulo.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 24));
		titulo.setBounds(25, 23, 360, 90);
		contentPane.add(titulo);

		btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnJugar.setBounds(162, 224, 89, 23);
		contentPane.add(btnJugar);

		btnJugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreJugador = textField.getText();
				String aventura = boxAventura.getSelectedItem().toString();
				setZork(new Juego(nombreJugador, aventuras.get(aventura)));
			}
		});
	}

	public Juego getZork() {
		return zork;
	}

	public void setZork(Juego zork) {
		this.zork = zork;
	}
}
