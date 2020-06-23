package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Moverse;
import acciones.Peticion;
import jugadores.Jugador;

/*
 * Se encarga de validar la semantica de un comando en base al diccionario y devuelve la peticion armada para 
 * luego pasarsela a Chain of responsability.
 * No valida que la ubicacion pasada sea accesible en ese momento o 
 * que el item ingresado este disponible, de validar esto debera encargarse cada Accion*/
public class Interprete {

	private String verbo = null;
	private String sustantivo = null;
	private String objetoIndirecto = null;

	HashMap<String, String> accionesSinomimosMap;
	ArrayList<String> itemsList;
	ArrayList<String> ubicacionesList;
	ArrayList<String> npcsList;
	ArrayList<String> placesList;
	public Interprete(String comando) {

		/** Ir a la taberna */
		/* Dar cerveza al fantasma */

		/** Estructura */
		/* verbo (_ _ _ _) sustantivo (_ _ _) objetoIndirecto **/
		generarDiccionario();
		separarComando(comando);
	}

	private void separarComando(String comando) {

		String[] splited = comando.split(" ");

		/** Ir a la taberna */
		verbo = splited[0]; // siempre sera asi.

		int i = 0;
		if(splited.length > 1) {
			i = 1;
			while (splited[i].length() < 3 && i < splited.length) {
				i++;
			}
			sustantivo = splited[i];
			
			int j = i;
			if (j + 1 < splited.length) {
				j = j + 1;
			}
			while (splited[j].length() < 3 && j < splited.length) {
				j++;
			}
			
			if (splited[j] != splited[i]) {
				objetoIndirecto = splited[j];
			}
		}		
	}

	/* devuelve la peticion en base a un comando o null si no es valido el
	  comando(quien lo use deberia mostrar un error si devuelve null).*/
	public Peticion generarPeticion() {

		if (accionesSinomimosMap.get(verbo) == null)
			return null;

		String nombreAccion = accionesSinomimosMap.get(verbo);

		if (nombreAccion == "moverse") {
			// tengo que buscar una ubicacion
			if (ubicacionesList.contains(sustantivo)) {
				// paso el sustantivo en el casillero de la ubicacion.
				return new Peticion(nombreAccion, sustantivo, null, null,null);
			}
		}

		// tengo que validar que haya un item y un npc
		if (nombreAccion == "dar" && itemsList.contains(sustantivo) && npcsList.contains(objetoIndirecto)) {
			return new Peticion(nombreAccion, null, sustantivo, objetoIndirecto,null);
		}

		// tengo que validar que haya un sustantivo valido
		if (nombreAccion == "agarrar" && itemsList.contains(sustantivo)) {

			return new Peticion(nombreAccion, null, sustantivo, null,null);
		}
		
		if (nombreAccion == "ayuda" || nombreAccion == "informacion") {

			return new Peticion(nombreAccion, null, null, null,null);
		}
		
		if (nombreAccion == "mirar" && placesList.contains(sustantivo)) {

			return new Peticion(nombreAccion, null, null, null, sustantivo);
		}

		return null;
	}

	private void generarDiccionario() {
		itemsList = new ArrayList<String>();
		ubicacionesList = new ArrayList<String>();
		npcsList = new ArrayList<String>();
		placesList = new ArrayList<String>();
		accionesSinomimosMap = new HashMap<String, String>();
		
		/*-----------------------------------------------*/
		accionesSinomimosMap.put("ir", "moverse");
		accionesSinomimosMap.put("moverse", "moverse");
		accionesSinomimosMap.put("moverme", "moverse");

		accionesSinomimosMap.put("dar", "dar");
		accionesSinomimosMap.put("darle", "dar");

		accionesSinomimosMap.put("agarrar", "agarrar");
		accionesSinomimosMap.put("tomar", "agarrar");
		
		accionesSinomimosMap.put("mirar", "mirar");
		
		accionesSinomimosMap.put("ayuda", "ayuda");
		accionesSinomimosMap.put("ayudame", "ayuda");
		
		accionesSinomimosMap.put("informacion", "informacion");

		/*-----------------------------------------------*/
		itemsList.add("espejo");
		itemsList.add("cerveza");
		/*-----------------------------------------------*/
		ubicacionesList.add("taberna");
		ubicacionesList.add("hotel");
		ubicacionesList.add("muelle");
		/*-----------------------------------------------*/
		npcsList.add("fantasma");
		/*-----------------------------------------------*/
		placesList.add("mesa");
	}

	public String getVerbo() {
		return verbo;
	}

	public String getSustantivo() {
		return sustantivo;
	}

	public String getObjetoIndirecto() {
		return objetoIndirecto;
	}

	@Override
	public String toString() {
		return verbo + " " + sustantivo + " " + objetoIndirecto;
	}

//	public static void main(String[] args) {
//
//		Interprete interprete = new Interprete("Dar cerveza al fantasma");
//
//		if (interprete.generarPeticion() != null) {
//			System.out.println("No se pudo interpretar el comando");
//		} else {
//			Peticion peticion = interprete.generarPeticion();
//
//			System.out.println(peticion.getNombreAccion());
//			System.out.println(peticion.getNombreItem());
//			System.out.println(peticion.getNombreNPC());
//
//		}
//
//	}
}
