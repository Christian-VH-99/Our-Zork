package acciones;


import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Item;

/*Request*/
public class Peticion {

	private Ubicacion ubicacion; //TODO: reem por los de abajo
	private Item item;//TODO: reem por los de abajo
	private String nombreItem;
	private String nombreAccion;

	/*----------------------------*/
	private String nombreUbicacion;
	private String nombreNpc;
	private String nombrePlace;
	/*----------------------------*/


	private Place place;

//	public Peticion(String nombreAccion, @Nullable Ubicacion ubicacion, @Nullable Item item,
//			@Nullable String nombreItem, @Nullable String nombreNPC) {
//
//		//REVISAR: nombre NPC nunca se asigna aca
//		this.ubicacion = ubicacion;
//		this.item = item;
//		this.nombreItem = nombreItem;
//		this.nombreAccion = nombreAccion;
//	}

	/*
	 * NOTA: este constructor es el que deberia quedar para tener una interfaz
	 * normalizada y que el interprete solo valide que la semantica sea correcta (no
	 * buscara que la ubicacion este en la lista de ubicaciones accesibles
	 * actualmente)
	 */
	public Peticion(String nombreAccion, String nombreUbicacion, String nombreItem, String nombreNpc,String nombrePlace) {

		this.nombrePlace = nombrePlace;
		this.nombreUbicacion = nombreUbicacion;
		this.nombreItem = nombreItem;
		this.nombreNpc = nombreNpc;
		this.nombreAccion = nombreAccion;
	}


	/** Constructor para mirar TODO: normalizar contructores */
	public Peticion(Place place, String nombreAccion) {
//		this.place = place;
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

}
