package acciones;

import javax.swing.JLabel;

import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import jugadores.Jugador;

public class Dar extends AccionBase {

	public Dar() {
		nombre = "dar";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {

		if (peticion.getNombreAccion() == this.nombre) {

			Inventario inventario = jugador.getInventario();
			Ubicacion ubicacionActual = jugador.getUbicacionActual();
			String nombreItem = peticion.getNombreItem();
			String nombreNPC = peticion.getNombreNpc();

			Item item = inventario.getItem(nombreItem);
			if (item != null) {
				salida = ubicacionActual.darANpc(item, nombreNPC, peticion);

			} else {

				salida = "No posees ese objeto";
			}
			return salida;
		} else {
			return accionSiguiente.ejecutar(peticion, jugador, imagen);
		}
	}

}
