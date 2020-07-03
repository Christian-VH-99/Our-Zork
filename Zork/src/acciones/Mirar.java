package acciones;

import java.util.List;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Mirar extends AccionBase {

	public Mirar() {
		nombre = "mirar";
	}

	/* Patron */
	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();

			if (peticion.getNombrePlace() != null) {

				switch (peticion.getNombrePlace()) {
				case "alrededor":
					System.out.println(ubicacionActual.describir());
					break;
				case "inventario":
					System.out.println(jugador.getInventario().listarItems());
					break;
				default:
					String nombrePlace = peticion.getNombrePlace();
					List<Place> sitios = ubicacionActual.getPlace();
					Place.mostrarItems(nombrePlace, sitios);
					break;
				}
			}

		} else {

			this.accionSiguiente.ejecutar(peticion, jugador);
		}
	}

}
