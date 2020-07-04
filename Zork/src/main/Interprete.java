package main;

import java.util.ArrayList;
import java.util.HashMap;

import acciones.Peticion;

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
	ArrayList<String> opcionesList;
	
	


	public Interprete(String comando) {
		/** Ir a la taberna */
		/* Dar cerveza al fantasma */
		/** Estructura */
		/* verbo (_ _ _ _) sustantivo (_ _ _) objetoIndirecto **/
		/* verbo (_ _ _ _) sustantivo **/
		//generarDiccionario(null);
		separarComando(comando);
	}
	
	public void recargarInterprete() {
		verbo = null;
		sustantivo = null;
		objetoIndirecto = null;
	}

	public void separarComando(String comando) {

		String[] splited = comando.split(" ");

		verbo = splited[0]; // siempre sera asi.

		int i = 0;
		if (splited.length > 1) {
			i = 1;
			while (splited[i].length() < 3 && i + 1 < splited.length) {
				i++;
			}
			sustantivo = splited[i];

			int j = i;
			if (j + 1 < splited.length) {
				j = j + 1;
			}
			while (splited[j].length() < 3 && j + 1 < splited.length) {
				j++;
			}

			if (splited[j] != splited[i]) {
				objetoIndirecto = splited[j];
			}
		}
	}

	/*
	 * devuelve la peticion en base a un comando o null si no es valido el
	 * comando(quien lo use deberia mostrar un error si devuelve null).
	 */
	public Peticion generarPeticion() {

		if (accionesSinomimosMap.get(verbo) == null)
			return null;

		String nombreAccion = accionesSinomimosMap.get(verbo);

		if (nombreAccion == "moverse") {
			// tengo que buscar una ubicacion
			if (ubicacionesList.contains(sustantivo)) {
				// paso el sustantivo en el casillero de la ubicacion.
				return new Peticion(nombreAccion, sustantivo, null, null, null);
			}
		}

		// tengo que validar que haya un item y un npc
		if (nombreAccion == "dar" && itemsList.contains(sustantivo) && npcsList.contains(objetoIndirecto)) {
			return new Peticion(nombreAccion, null, sustantivo, objetoIndirecto, null);
		}

		// tengo que validar que haya un sustantivo valido
		if (nombreAccion == "agarrar" && itemsList.contains(sustantivo)) {

			return new Peticion(nombreAccion, null, sustantivo, null, null);
		}

		if (nombreAccion == "ayuda" || nombreAccion == "informacion") {

			return new Peticion(nombreAccion, null, null, null, null);
		}

		if (nombreAccion == "usar" && itemsList.contains(sustantivo)) {
			return new Peticion(nombreAccion, null, sustantivo, null, null);
		}
		
		// aca no deberia ser objeto indirecto?
		if (nombreAccion == "hablar" && npcsList.contains(sustantivo)) {
			return new Peticion(nombreAccion, null, null, sustantivo, null);
		}
		
		if (nombreAccion == "hablar" && npcsList.contains(objetoIndirecto)) {
			return new Peticion(nombreAccion, null, null, objetoIndirecto, null);
		}

		if (sustantivo == null) {
			sustantivo = "alrededor";
		}
		
		if (nombreAccion == "mirar" && placesList.contains(sustantivo)) {

			return new Peticion(nombreAccion, null, null, null, sustantivo);
		}

		// agregado
		if (nombreAccion == "decir" && opcionesList.contains(sustantivo) && npcsList.contains(objetoIndirecto)) {

			return new Peticion(nombreAccion, sustantivo, objetoIndirecto);
		}

		return null;
	}

	public Interprete(EntornoGson entorno) {
		itemsList = entorno.getItemsList();
		ubicacionesList = entorno.getUbicacionesList();
		npcsList = entorno.getNpcsList();
		placesList = entorno.getPlacesList();
		accionesSinomimosMap = new HashMap<String, String>();
		opcionesList = new ArrayList<>();
		
		/*para probar decir: descomentar*/
//		npcsList = new ArrayList<String>();
//		npcsList.add("Covit");
		/*-----------------------------------------------*/
		// se podria agregar a GSON si la cant de opciones es variable
		opcionesList.add("opcionA");
		opcionesList.add("opcionB");
		opcionesList.add("opcionC");

		/*-----------------------------------------------*/
		accionesSinomimosMap.put("ir", "moverse");
		accionesSinomimosMap.put("moverse", "moverse");
		accionesSinomimosMap.put("moverme", "moverse");
		accionesSinomimosMap.put("vamos", "moverse");
		accionesSinomimosMap.put("dirigirme", "moverse");
		accionesSinomimosMap.put("acercarme", "moverse");
		accionesSinomimosMap.put("dirigirse", "moverse");
		accionesSinomimosMap.put("desplazarse", "moverse");

		
		accionesSinomimosMap.put("dar", "dar");
		accionesSinomimosMap.put("darle", "dar");
		accionesSinomimosMap.put("entregar", "dar");
		accionesSinomimosMap.put("mostrar", "dar");
		accionesSinomimosMap.put("otorgar", "dar");
		accionesSinomimosMap.put("toma", "dar");
		accionesSinomimosMap.put("entregarle", "dar");
		accionesSinomimosMap.put("ofrecer", "dar");
		accionesSinomimosMap.put("regalar", "dar");
		accionesSinomimosMap.put("ceder", "dar");
		accionesSinomimosMap.put("obsequiar", "dar");
		
		accionesSinomimosMap.put("preguntar", "hablar");
		accionesSinomimosMap.put("hablar", "hablar");
		accionesSinomimosMap.put("charlar", "hablar");
		accionesSinomimosMap.put("consultar", "hablar");
		accionesSinomimosMap.put("platicar", "hablar");
		accionesSinomimosMap.put("dialogar", "hablar");
		accionesSinomimosMap.put("conversar", "hablar");


		accionesSinomimosMap.put("agarrar", "agarrar");
		accionesSinomimosMap.put("pillar", "agarrar");
		accionesSinomimosMap.put("tomar", "agarrar");
		accionesSinomimosMap.put("recoger", "agarrar");
		accionesSinomimosMap.put("atrapar", "agarrar");
		accionesSinomimosMap.put("obtener", "agarrar");
		
		
		accionesSinomimosMap.put("clavar", "usar");
		accionesSinomimosMap.put("usar", "usar");
		accionesSinomimosMap.put("aplicar", "usar");
		accionesSinomimosMap.put("emplear", "usar");
		accionesSinomimosMap.put("gastar", "usar");
		

		accionesSinomimosMap.put("mirar", "mirar");
		accionesSinomimosMap.put("observar", "mirar");
		accionesSinomimosMap.put("ver", "mirar");
		accionesSinomimosMap.put("buscar", "mirar");
		accionesSinomimosMap.put("ojear", "mirar");
		accionesSinomimosMap.put("contemplar", "mirar");
		accionesSinomimosMap.put("apreciar", "mirar");
		accionesSinomimosMap.put("examinar", "mirar");
		accionesSinomimosMap.put("curiosear", "mirar");
		accionesSinomimosMap.put("pispear", "mirar");
		accionesSinomimosMap.put("fijarse", "mirar");
		
		accionesSinomimosMap.put("ayuda", "ayuda");
		accionesSinomimosMap.put("ayudame", "ayuda");

		accionesSinomimosMap.put("informacion", "informacion");
		accionesSinomimosMap.put("guia", "informacion");

		//agregado 4/7
		accionesSinomimosMap.put("decir", "decir");


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
