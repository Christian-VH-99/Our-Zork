package acciones;

import Ubicacion.Ubicacion;
import jugadores.Jugador;
import jugadores.Npc;

public class Decir extends AccionBase {
	
	public Decir() {
		nombre = "decir";
	}

	// decir opcionA a borracho
	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {
		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreNPC = peticion.getNombreNpc();
			String opcion = peticion.getOpcion();
			
			// busco el npc
			for (Npc n : ubicacionActual.getNpcs()) {
				if (n.getNombreNpc().equals(nombreNPC)) {
					//mostrar sentencia del jugador
					System.out.println(n.buscarSentenciaElegida(opcion));
					//mostrar respuesta del NPC a este
					System.out.println(n.buscarRespuestaASentenecia(opcion));
				}
			}
			
		} else {
			this.accionSiguiente.ejecutar(peticion, jugador);
		}
	}
}
