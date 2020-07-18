package acciones;

import java.util.Iterator;

import javax.swing.JLabel;

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
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {
		if (peticion.getNombreAccion() == this.nombre) {

			item = peticion.getItem();

			Iterator<Place> it = jugador.getUbicacionActual().getPlace().iterator();
			while (it.hasNext()) {
				Place sitio = it.next();
				item = sitio.getItem(peticion.getNombreItem());
				Place.mostrarItems(sitio.getName(), jugador.getUbicacionActual().getPlace(), imagen);
				if (item != null)
					break;
			}
			if (item != null) {
				peticion.setEjecuto(true);
				jugador.getInventario().agregarItem(item);
				salida = "Tienes " + item.toString() + " en tu inventario.";
			} else {
				salida = "El objeto que quiere agarrar no existe";
			}
			return salida;
		} else {

			return this.accionSiguiente.ejecutar(peticion, jugador, imagen);
		}

	}

}
