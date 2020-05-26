package acciones;

import jugadores.Jugador;

public abstract class AccionBase {

	protected String nombre; 
	protected AccionBase accionSiguiente;

	/*handle*/
	public abstract void ejecutar(Peticion peticion, Jugador jugador);

	public AccionBase getAccionSiguiente() {
		return accionSiguiente;
	}

	public void setSiguiente(AccionBase siguiente) {
		this.accionSiguiente = siguiente;
	}

}
