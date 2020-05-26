package Ubicacion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import items.Item;
//import items.Item;
import jugadores.Npc;

public class Ubicacion {

	private String nombre;
	private Character genero;
	private List<Place> sitios;
	private List<Conexion> conexiones;
	private List<Npc>npcs;

	public Ubicacion(String nombre, Character genero) {
		this.genero = genero;
		this.nombre = nombre;

		conexiones = new LinkedList<>();
		sitios = new LinkedList<>();
		npcs = new LinkedList<>();
	}

//// AGREGAR ELEMENOTS A LAS LISTAS ////
	public void agregarConexion(Conexion conexion) {
		conexiones.add(conexion);
	}
	
	public void agregarPlace(Place sitio) {
		sitios.add(sitio);
	}
	
	public void agregarNpc(Npc personaje) {
		npcs.add(personaje);
	}
	
//// ELIMINAR ELEMENTOS DE LAS LISTAS ////
	public boolean removeNpc(String personaje) {

		for (Conexion conexion : conexiones) {

			if (conexion.tieneObstaculo(personaje)) {
				conexion.habilitar();
				break;
			}
		}

		Iterator<Npc> it2 = npcs.iterator();
		while (it2.hasNext()) {
			Npc npc = it2.next();
			if (npc.getNombreNpc().equals(personaje)) {
				it2.remove();
				return true;
			}
		}
		return false;
	}


//// GETTERS ////
	public String listarPlaces() {
		String listaPlace = "";
		for (Place sitio : sitios) {
			listaPlace+=sitio.toString();
			listaPlace+=", ";
		}
		return listaPlace;	
	}
	
	public List<Place> getPlace(){
		return sitios;
	}
	
	public void getConexiones() {
		for(Conexion conexion : conexiones) {
			System.out.println(conexion.getLocation().getNombre());
		}
	}

	public String getNpcs() {
		String personajes = "";
		for(Npc npc : npcs) {
			personajes += npc.getNombreNpc() + " ";
		}
		return personajes;
	}

	public String getNombre() {
		return nombre;
	}
	
	private Character getGenero() {
		return genero;
	}
	
	public String getNombreGenero() {
		
		return (genero == 'F'?"la":"el")+" " + nombre;
	}

//// DESCRIPCION DE LA UBICACION ////
	public String describir() {

		/*
		 * Articulos determinados: el, la Articulos indererminados: una, uno
		 */

		String articuloDeterminado = genero == 'F' ? "la" : "el";

		String cad = "Estas en " + articuloDeterminado + " " + getNombre() + ".";

		if(!sitios.isEmpty())
			cad += cadenaSitios();
		if (!conexiones.isEmpty())
			cad += cadenaConexiones();

		return cad;
	}

	public String cadenaSitios() {
		String cadenaSitios = " Hay ";
		Place sitio;
		for (int indice = 0; indice < sitios.size(); indice++) {
			sitio = sitios.get(indice);
			if(sitios.size()==1)
				cadenaSitios += sitio.toString() +".";
			else if(indice + 1 == sitios.size()) 
				cadenaSitios += "y " + sitio.toString() + "";
			else
				cadenaSitios += sitio.toString() + " ";
		}
		return cadenaSitios;
	}

	public String cadenaConexiones() {

		String cadenaConexiones = " Se ve a lo lejos ";

		String articuloIndeterminado = null;
		Conexion conexion;
		Ubicacion location;

		for (int indice = 0; indice < conexiones.size(); indice++) {

			conexion = conexiones.get(indice);
			location = conexion.getLocation();

			articuloIndeterminado = location.getGenero() == 'F' ? "una" : "un";
			if(conexiones.size()==1) {
				cadenaConexiones += articuloIndeterminado + " " +location.getNombre() + ".";
			}
			// si es el ultimo de la lista
			else if (indice + 1 == conexiones.size()) {
				cadenaConexiones += "y " + articuloIndeterminado + " " + location.getNombre() + ".";
			} else {
				cadenaConexiones += articuloIndeterminado + " " + location.getNombre() + ", ";
			}
		}

		return cadenaConexiones;
	}

	
	// TODO: cambiar valores de retorno por constantes (Enum)
//// metodos que facilitan realizar las acciones ////
	public int sePuedeMoverAConexion(Ubicacion nuevaLocation) {

		Ubicacion location = null;

		for (Conexion conexion : conexiones) {

			location = conexion.getLocation();

			if (location.getNombre() == nuevaLocation.getNombre()) {

				if (conexion.habilitado == true) {
					return 1;
				} else {
					System.out.println("No podes pasar, hay un " + conexion.getObstaculo()); // TODO: revisar
					return 0;
				}
			}
		}
		return -1;
	}
	
	// TODO: revisar este metodo, no es claro que devuelva valores, podria devolver una constante.
	public int darANpc(Item item, String sujeto) { 
		for (Npc npc : npcs) {
			if(npc.getNombreNpc().equals(sujeto)) {
				if(npc.attack(item))
					return 1;
				else
					return 0;
			}
		}
		return -1;
	}
}
