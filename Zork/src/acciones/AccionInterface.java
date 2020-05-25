package acciones;

import jugadores.Jugador;

/*Handler*/
public interface AccionInterface {

	public void setSiguiente(AccionInterface siguiente);

	/*handle*/
	public void ejecutar(Peticion peticion, Jugador jugador);

}
