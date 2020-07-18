package acciones;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Mirar extends AccionBase {

	public Mirar() {
		nombre = "mirar";
	}

	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();

			if (peticion.getNombrePlace() != null) {

				switch (peticion.getNombrePlace()) {
				case "alrededor":
					salida = ubicacionActual.describir();
					imagen.setIcon(new ImageIcon("img/" + ubicacionActual.getNombre() + ".jpg"));// bien
					break;
				case "inventario":
					salida = jugador.getInventario().listarItems();
					break;
				default:
					String nombrePlace = peticion.getNombrePlace();
					List<Place> sitios = ubicacionActual.getPlace();
					salida = Place.mostrarItems(nombrePlace, sitios, imagen);
					break;
				}
			}
			return salida;
		} else {

			salida = this.accionSiguiente.ejecutar(peticion, jugador, imagen);
			return salida;
		}
	}

}
