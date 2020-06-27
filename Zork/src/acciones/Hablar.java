package acciones;

import Ubicacion.Ubicacion;
import jugadores.Jugador;
import jugadores.Npc;

public class Hablar extends AccionBase {

	public Hablar() {
		nombre = "hablar";
	}

	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {
		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreNPC = peticion.getNombreNpc();
			for (Npc n : ubicacionActual.getNpcs()) {
				if (n.getNombreNpc().equals(nombreNPC)) {
					System.out.println(n.getTalkNpc());
				}
			}

		} else {
			this.accionSiguiente.ejecutar(peticion, jugador);
		}
	}

}
