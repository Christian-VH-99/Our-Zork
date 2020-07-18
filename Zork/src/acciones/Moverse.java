package acciones;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ubicacion.Ubicacion;
import jugadores.Jugador;
import jugadores.Npc;

public class Moverse extends AccionBase {

	public Moverse() {
		nombre = "moverse";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreUbicacion = peticion.getNombreUbicacion();
			Ubicacion nuevaUbicacion = ubicacionActual.buscarUbicacionAMoverse(nombreUbicacion, "");

			if (nombreUbicacion.equals(ubicacionActual.getNombre())) {
				salida = "Ya estas ahí.";
			} else {

				if (nuevaUbicacion != null) {
					peticion.setEjecuto(true);
					jugador.setUbicacionActual(nuevaUbicacion);
					salida = nuevaUbicacion.describir();
					imagen.setIcon(new ImageIcon("img/" + nuevaUbicacion.getNombre() + ".jpg"));
				} else {
					List<Npc> npcs = ubicacionActual.getNpcs();

					if (npcs.size() != 0) {
						salida = "Oh no ,";
						for (Npc n : npcs) {
							salida += n.getNombreNpc();
						}
						salida += " bloquea tu camino.\n";
						return salida;
					} else
						return "no podes moverte ahi, la ubicacion a la que quieres ir no existe.";
				}
			}
			return salida;
		} else {
			return accionSiguiente.ejecutar(peticion, jugador, imagen);

		}
	}

}
