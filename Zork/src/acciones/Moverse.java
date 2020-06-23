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

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreUbicacion = peticion.getNombreUbicacion();
			Ubicacion nuevaUbicacion = ubicacionActual.buscarUbicacionAMoverse(nombreUbicacion);

			if(nuevaUbicacion != null) {
				jugador.setUbicacionActual(nuevaUbicacion);				
			}else {
				System.out.println("no podes moverte ahi"); //TODO: ver como diferenciar entre que haya un obstaculo y que no exista esa ubicacion
			}

		} else {
			accionSiguiente.ejecutar(peticion, jugador);
		}
	}

}
