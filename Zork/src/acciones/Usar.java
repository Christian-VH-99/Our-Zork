package acciones;

import items.Inventario;
import items.Item;
import jugadores.Jugador;

public class Usar extends AccionBase {

	public Usar() {
		nombre = "usar";
	}

	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {
		if (peticion.getNombreAccion() == this.nombre) {

			Inventario inventario = jugador.getInventario();
			// Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreItem = peticion.getNombreItem();
			// String nombreNPC = peticion.getNombreNpc();

			Item item = inventario.getItem(nombreItem);
			if (item != null) {
				System.out.println("has utilizado " + item.toString() + ".");

			} else {
				System.out.println("No posees ese objeto.");
			}

		} else {
			accionSiguiente.ejecutar(peticion, jugador);
		}

	}

}
