package acciones;

import java.util.Iterator;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import jugadores.Jugador;

public class Agarrar extends AccionBase {

	Ubicacion ubicacionActual;
	Inventario inventario;
	Item item;

	public Agarrar() {
		nombre = "agarrar";
	}

	/* Patron */
	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {
		if (peticion.getNombreAccion() == this.nombre) {

			item = peticion.getItem();

			Iterator<Place> it = jugador.getUbicacionActual().getPlace().iterator();
			while (it.hasNext()) {
				Place sitio = it.next();
				item = sitio.getItem(peticion.getNombreItem());
				if (item != null)
					break;
			}
			if (item != null) {
				jugador.getInventario().agregarItem(item);
				String salida = "Tienes " + item.toString() + " en tu inventario.";
				System.out.println(salida);
			} else
				System.out.println("El objeto que quiere agarrar no existe");

		} else {

			this.accionSiguiente.ejecutar(peticion, jugador);
		}

	}

}
