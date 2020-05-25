package acciones;

import com.sun.istack.internal.Nullable;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Item;

/*Request*/
public class Peticion {

	private Ubicacion ubicacion;
	private Item item;
	private String nombreItem;
	private String nombreAccion;
	private Place place;

	
	public Peticion(String nombreAccion, Ubicacion ubicacion, Item item, String nombreItem) {
		this.ubicacion = ubicacion;
		this.item = item;
		this.nombreItem = nombreItem;
		this.nombreAccion = nombreAccion;
	}
	
	/**Constructor para mirar*/
	public Peticion(Place place, String nombreAccion) {
		this.place = place;
		this.nombreAccion = nombreAccion;
	}

	public Place getPlace() {
		return place;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}


	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}
}
