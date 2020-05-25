package acciones;

import java.util.Iterator;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import jugadores.Jugador;
import main.Juego;

//public class Agarrar extends Accion {
public class Agarrar extends AccionBase {

	/*
	 * Debera: -recibir un item -verificar si existe en la location actual (clase
	 * iterprete) -accionar el evento -mostrar mensaje al jugador -activar
	 * items/conexiones -sacar el item la lista de items de la locaction actual
	 * (porque ya fue usado el item) -ponerlo en el inventario
	 */
	Ubicacion ubicacionActual;
	Inventario inventario;
	Item item;

	/* De patron */
//	public Agarrar(Jugador jugador) {
//			this.ubicacionActual = jugador.getUbicacionActual();
//			this.inventario = jugador.getInventario();
//			nombre = "agarrar";
//		}

	/* NOTA: borrar cuando se implemente patron */
	public Agarrar(Jugador jugador) {
		this.ubicacionActual = jugador.getUbicacionActual();
		this.inventario = jugador.getInventario();
		nombre = "agarrar";
	}

	public Agarrar() {
		nombre = "agarrar";

	}

	public void accionar(Ubicacion actual, String objeto) {
		Iterator<Place> it = actual.getPlace().iterator();
		while (it.hasNext()) {
			Place sitio = it.next();
			item = sitio.getItem(objeto);
			if (item != null)
				break;
		}
		if (item != null) {
			inventario.agregarItem(item);
			String salida = "Tienes " + item.toString() + "en tu inventario.";
			System.out.println(salida);
		} else
			System.out.println("El objeto que quiere agarrar no existe");

	}

	/* Patron */
	@Override
	public void ejecutar(Peticion peticion, Jugador jugador) {

		// TODO: ver si este if se puede subir a accionBase
		if (peticion.getNombreAccion() == this.nombre) {

			item = peticion.getItem();

			Iterator<Place> it = jugador.getUbicacionActual().getPlace().iterator();
			while (it.hasNext()) {
				Place sitio = it.next();
				item = sitio.getItem(peticion.getNombreItem());
				if (item != null)
					break;
			}
			if (item != null) {
				jugador.getInventario().agregarItem(item);
				String salida = "Tienes " + item.toString() + "en tu inventario.";
				System.out.println(salida);
			} else
				System.out.println("El objeto que quiere agarrar no existe");
		
		} else {
			
			this.AccionSiguiente.ejecutar(peticion, jugador);
		}

	}

}
