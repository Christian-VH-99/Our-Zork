package acciones;
import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Moverse extends AccionBase {

	public Moverse() {
		nombre = "moverse";
	}

	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion nuevaUbicacion = peticion.getUbicacion();
			Ubicacion ubicacionActual = jugador.getUbicacionActual();

			int permitido = ubicacionActual.sePuedeMoverAConexion(nuevaUbicacion);
			if (permitido == 1) {
				jugador.setUbicacionActual(nuevaUbicacion);
			} else if (permitido == -1) {
				System.out.println("no podes moverte ahi");
			}
		} else {
			accionSiguiente.ejecutar(peticion, jugador);
		}
	}

}
