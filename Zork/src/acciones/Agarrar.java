package acciones;
import java.util.Iterator;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Inventario;
import items.Item;
import main.Juego;

/*
 * Debera: -recibir un item -verificar si existe en la location actual (clase
 * iterprete) -accionar el evento -mostrar mensaje al jugador -activar
 * items/conexiones -sacar el item la lista de items de la locaction actual
 * (porque ya fue usado el item) -ponerlo en el inventario
 */
public class Agarrar extends Accion {

	Ubicacion ubicacionActual;
	Inventario inventario;
	Item item;

	public Agarrar(Juego juego) {
		this.ubicacionActual = juego.getUbicacion();
		this.inventario = juego.getInventario();
		nombre = "agarrar";
	}

	public void accionar(Ubicacion actual, String objeto) {
		Iterator<Place> it = actual.getPlace().iterator();
		while (it.hasNext()) {
			Place sitio = it.next();
			item = sitio.getItem(objeto);
			break;
		}
		inventario.agregarItem(item);
		String salida = "Tienes " + item.toString() + "en tu inventario.";
		System.out.println(salida);
	}

}
