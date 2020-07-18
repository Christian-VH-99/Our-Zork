package acciones;

import javax.swing.JLabel;

import jugadores.Jugador;

public abstract class AccionBase {

	protected String nombre;
	protected AccionBase accionSiguiente;
	protected String salida;

	/* handle */
	public abstract String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen);

	public AccionBase getAccionSiguiente() {
		return accionSiguiente;
	}

	public void setSiguiente(AccionBase siguiente) {
		this.accionSiguiente = siguiente;
	}

}
