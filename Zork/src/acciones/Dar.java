package acciones;

import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import jugadores.Jugador;

public class Dar extends AccionBase {

	public Dar() {
		nombre = "dar";
	}

	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		if (peticion.getNombreAccion() == this.nombre) {

			Inventario inventario = jugador.getInventario();
			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreItem = peticion.getNombreItem();
			String nombreNPC = peticion.getNombreNpc();

			Item item = inventario.getItem(nombreItem);
			if (item != null) {
				int vencido = ubicacionActual.darANpc(item, nombreNPC);
				if (vencido == 1) {
					ubicacionActual.removeNpc(nombreNPC);
				} else if (vencido == 0) {
					System.out.println(". Intenta con otra cosa");
				} else {
					System.out.println("El personaje con el que quieres interactuar no existe.");
				}
			} else {
				System.out.println("No posees ese objeto");
			}

		} else {
			accionSiguiente.ejecutar(peticion, jugador);
		}
	}

}
