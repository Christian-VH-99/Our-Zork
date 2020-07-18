package acciones;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ubicacion.Ubicacion;
import jugadores.Jugador;
import jugadores.Npc;

public class Hablar extends AccionBase {

	public Hablar() {
		nombre = "hablar";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {
		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreNPC = peticion.getNombreNpc();
			for (Npc n : ubicacionActual.getNpcs()) {
				if (n.getNombreNpc().equals(nombreNPC)) {
					imagen.setIcon(new ImageIcon("img/" + n.getNombreNpc() + ".jpg"));

					salida = n.getNombreNpc() + ": " + jugador.getNombre() + ", " + n.getTalkNpc();
					if (n.cantSentencias() != 0) {
						salida += "\n" + n.getSentenciasPosibles();
					}
				}
			}
			return salida;
		} else {
			return this.accionSiguiente.ejecutar(peticion, jugador, imagen);
		}
	}

}
