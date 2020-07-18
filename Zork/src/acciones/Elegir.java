package acciones;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ubicacion.Ubicacion;
import jugadores.Jugador;
import jugadores.Npc;

public class Elegir extends AccionBase {

	public Elegir() {
		nombre = "elegir";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {
		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreNPC = peticion.getNombreNpc();
			String opcion = peticion.getOpcion();

			for (Npc n : ubicacionActual.getNpcs()) {
				if (n.getNombreNpc().equals(nombreNPC)) {
					imagen.setIcon(new ImageIcon("img/" + n.getNombreNpc() + ".jpg"));
					salida = jugador.getNombre() + ": " + n.buscarSentenciaElegida(opcion) + "\n";
					salida += n.getNombreNpc() + ": " + n.buscarRespuestaASentenecia(opcion);
				}
			}
			return salida;
		} else {
			return this.accionSiguiente.ejecutar(peticion, jugador, imagen);
		}
	}
}
