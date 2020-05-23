package acciones;

import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import main.Juego;

public class Dar extends Accion {
	// TODO:
	/*
	 * Debera: -recibir un item y un npc -verificar que el item este en el
	 * inventario -accionar el evenro -ver si es debilidad del npc -sacar el item
	 * del inventario -mostrar el mensaje adecuado al jugador -si el npc fue
	 * derrotado, habiliatr las conexiones obstaculisadas por el y eliminarlo de la
	 * lista de NPCs
	 */
	Inventario inventario;
	Ubicacion actual;

	public Dar(Juego juego) {
		inventario = juego.getInventario();
		actual = juego.getUbicacion();
		nombre = "dar";
	}

	public void accionar(String objeto, String sujeto) {
		Item item = inventario.getItem(objeto);
		if (item != null) {
			int vencido = actual.darANpc(item, sujeto);
			if (vencido == 1) {
				actual.removeNpc(sujeto);
			} else if (vencido == 0)
				System.out.println(". Intenta con otra cosa");
			else
				System.out.println("El personaje con el que quieres interactuar no existe.");
		}else {
			System.out.println("No posees ese objeto");
		}
	}

}
