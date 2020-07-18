package acciones;

import javax.swing.JLabel;

import items.Inventario;
import items.Item;
import jugadores.Jugador;

public class Usar extends AccionBase {

	public Usar() {
		nombre = "usar";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {
		if (peticion.getNombreAccion() == this.nombre) {

			Inventario inventario = jugador.getInventario();
			String nombreItem = peticion.getNombreItem();

			Item item = inventario.getItem(nombreItem);
			if (item != null) {
				peticion.setEjecuto(true);
				salida = "has utilizado " + item.toString() + ".";

			} else {
				salida = "No posees ese objeto.";
			}
			return salida;
		} else {
			return accionSiguiente.ejecutar(peticion, jugador, imagen);
		}

	}

}
