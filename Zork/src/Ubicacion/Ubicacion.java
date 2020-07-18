package Ubicacion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import acciones.Peticion;
import items.Item;
//import items.Item;
import jugadores.Npc;

public class Ubicacion {

	private String nombre;
	private Character genero;
	private List<Place> sitios;
	private List<Conexion> conexiones;
	private List<Npc> npcs;
	private String mensajeDeIngreso;

	public Ubicacion(String nombre, Character genero) {
		this.genero = genero;
		this.nombre = nombre;
		conexiones = new LinkedList<>();
		sitios = new LinkedList<>();
		npcs = new LinkedList<>();
	}

	public void setMensajeDeingreso(String mensajeDeIngreso) {
		this.mensajeDeIngreso = mensajeDeIngreso;
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
			listaPlace += sitio.toString();
			listaPlace += ", ";
		}
		return listaPlace;
	}

	public List<Place> getPlace() {
		return sitios;
	}

	public void getConexiones() {
		for (Conexion conexion : conexiones) {
			System.out.println(conexion.getLocation().getNombre());
		}
	}

	public String listarNpcs() {
		String personajes = "";
		for (Npc npc : npcs) {
			personajes += npc.getNombreNpc() + " ";
		}
		return personajes;
	}

	public List<Npc> getNpcs() {
		return npcs;
	}

	public String getNombre() {
		return nombre;
	}

	private Character getGenero() {
		return genero;
	}

	public String getNombreGenero() {

		return (genero == 'F' ? "la" : "el") + " " + nombre;
	}

//// DESCRIPCION DE LA UBICACION ////
	public String describir() {

		String articuloDeterminado = genero == 'F' ? "la" : "el";

		String cad = "Estas en " + articuloDeterminado + " " + getNombre() + ".";

		if (!sitios.isEmpty())
			cad += cadenaSitios();
		if (!conexiones.isEmpty())
			cad += cadenaConexiones();

		for (Npc n : npcs) {
			cad += " " + n.getDescripcionNpc() + ".";
		}
		return cad;
	}

	public String cadenaSitios() {
		String cadenaSitios = " Hay ";
		Place sitio;
		for (int indice = 0; indice < sitios.size(); indice++) {
			sitio = sitios.get(indice);
			if (sitios.size() == 1)
				cadenaSitios += sitio.toString() + ".";
			else if (indice + 1 == sitios.size())
				cadenaSitios += "y " + sitio.toString() + ".";
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
			if (conexiones.size() == 1) {
				cadenaConexiones += articuloIndeterminado + " " + location.getNombre() + ".";
			} else if (indice + 1 == conexiones.size()) {
				cadenaConexiones += "y " + articuloIndeterminado + " " + location.getNombre() + ".";
			} else {
				cadenaConexiones += articuloIndeterminado + " " + location.getNombre() + ", ";
			}
		}

		return cadenaConexiones;
	}

	public Ubicacion buscarUbicacionAMoverse(String nombreLocation, String personaje) {

		Ubicacion location = null;

		for (Conexion conexion : conexiones) {

			location = conexion.getLocation();

			if (location.getNombre().equals(nombreLocation)) {
				if (conexion.habilitado == true) {
					return location;
				} else {
					personaje += "No podes pasar, hay un " + conexion.getObstaculo();
					return null;
				}
			}
		}
		return null;
	}

	public String darANpc(Item item, String sujeto, Peticion peticion) {
		
		for (Npc npc : npcs) {
			if (npc.getNombreNpc().equals(sujeto)) {
				if (npc.attack(item)) {
					removeNpc(npc.getNombreNpc());
					peticion.setEjecuto(true);
					return npc.getDebilidad().getDialogoDerrota();
				}
				else {
					return "No ha servido de nada, itenta con otra cosa." ;
				}
						
			}
		}
		
		return "El personaje con el que quieres interactuar no existe.";
	}

	public void mostrarMensajeDeIngresoAUbicacion() {
		System.out.println(mensajeDeIngreso);
	}

}
