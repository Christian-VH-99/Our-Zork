package interfaz;

import javax.swing.JPanel;
import java.awt.TextArea;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	public TextArea consola;
	public JTextField entrada;
	private JButton btnEntrada;

	/**
	 * Create the panel.
	 */
	public PanelJuego() {
		setVisible(true);
		setLayout(null);

		consola = new TextArea();
		consola.setBounds(10, 310, 699, 160);
		add(consola);

		Panel panelFondo = new Panel();
		panelFondo.setBounds(10, 10, 699, 294);
		add(panelFondo);

		entrada = new JTextField();
		entrada.setBounds(10, 478, 588, 20);
		add(entrada);
		entrada.setColumns(10);

		btnEntrada = new JButton("confirmar");
		btnEntrada.setBounds(608, 476, 101, 23);
		add(btnEntrada);

	}
}
