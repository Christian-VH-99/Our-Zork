package acciones;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Item;

/*Request*/
public class Peticion {

	private Ubicacion ubicacion; // TODO: reem por los de abajo
	private Item item;// TODO: reem por los de abajo
	private String nombreItem;
	private String nombreAccion;
	private String nombreUbicacion;
	private String nombreNpc;
	private String nombrePlace;
	private Place place;

	private String opcion;//agregado

	// TODO: armar un contructor para cada accion y asi evitar nulls
	public Peticion(String nombreAccion, String nombreUbicacion, String nombreItem, String nombreNpc,
			String nombrePlace) {

		this.nombrePlace = nombrePlace;
		this.nombreUbicacion = nombreUbicacion;
		this.nombreItem = nombreItem;
		this.nombreNpc = nombreNpc;
		this.nombreAccion = nombreAccion;
	}

	// decir
	public Peticion(String nombreAccion, String opcion,String nombreNpc) {

		this.nombreNpc = nombreNpc;
		this.nombreAccion = nombreAccion;
		this.opcion = opcion;
	}
	
	/*Ver si se puede sacar*/
	public Peticion(Place place, String nombreAccion) {
		this.place = place;
		this.nombreAccion = nombreAccion;
	}

	public String getNombrePlace() {
		return nombrePlace;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public String getNombreNpc() {
		return nombreNpc;
	}

	public Place getPlace() {
		return place;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Item getItem() {
		return item;
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	public String getNombrePLace() {
		return nombrePlace;
	}

	public String getOpcion() {
		return opcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreAccion == null) ? 0 : nombreAccion.hashCode());
		result = prime * result + ((nombreItem == null) ? 0 : nombreItem.hashCode());
		result = prime * result + ((nombreNpc == null) ? 0 : nombreNpc.hashCode());
		result = prime * result + ((nombrePlace == null) ? 0 : nombrePlace.hashCode());
		result = prime * result + ((nombreUbicacion == null) ? 0 : nombreUbicacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peticion other = (Peticion) obj;
		if (nombreAccion == null) {
			if (other.nombreAccion != null)
				return false;
		} else if (!nombreAccion.equals(other.nombreAccion))
			return false;
		if (nombreItem == null) {
			if (other.nombreItem != null)
				return false;
		} else if (!nombreItem.equals(other.nombreItem))
			return false;
		if (nombreNpc == null) {
			if (other.nombreNpc != null)
				return false;
		} else if (!nombreNpc.equals(other.nombreNpc))
			return false;
		if (nombrePlace == null) {
			if (other.nombrePlace != null)
				return false;
		} else if (!nombrePlace.equals(other.nombrePlace))
			return false;
		if (nombreUbicacion == null) {
			if (other.nombreUbicacion != null)
				return false;
		} else if (!nombreUbicacion.equals(other.nombreUbicacion))
			return false;
		return true;
	}
}
