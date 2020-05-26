package main;

import java.util.HashMap;

import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Moverse;
import acciones.Peticion;
import jugadores.Jugador;

public class Interprete {
	
	private String verbo = null;
	private String sustantivo = null;
	private String objetoIndirecto = null;
	
	
	HashMap<String, String> accionesSinomimosMap;
	
	public Interprete(String comando) {
		
		/**Ir a la taberna*/
		/* Dar cerveza al fantasma */
		
		/**Estructura*/
		/*verbo (_ _ _ _) sustantivo (_ _ _) objetoIndirecto**/
		separarComando(comando);
	}
	private void separarComando(String comando) {
		
		String[] splited = comando.split(" ");
		
		/**Ir a la taberna*/
		this.verbo = splited[0]; // siempre sera asi.
		
		int i = 1;
		while(splited[i].length() < 3 && i < splited.length) {
			i++;
		}
		this.sustantivo = splited[i];
		
		int j = i;
		if(j+1 < splited.length) {
			j=j+1;
		}
		while(splited[j].length() < 3 &&  j < splited.length) {
			j++;
		}
		
		if(splited[j] != splited[i]) {
			objetoIndirecto = splited[j];	
		}
	}
	
	public Peticion generarPeticion() {
		
		String nombreAccion = buscarAccionEnBaseASinonimo(verbo);
		

		// TODO: ver como diferenciar entre una ubicacion y un item.
		// Tendria que buscarla en una lista de ubicaciones y si pertenece, creo la peticion con ubicacion
		// Caso contrario, verifico si esta en la lista de items y si esta, creo la peticion con item.
		//El NPC siempre seta objeto indirecto.
		
		// caso "dar cerveza al fantasma"
		return new Peticion(nombreAccion,null, null, sustantivo,objetoIndirecto);

		
	}
	private String buscarAccionEnBaseASinonimo(String verbo) {

		
		
		// esto a otro metodo.
		accionesSinomimosMap = new HashMap<>();
		
		accionesSinomimosMap.put("ir", "ir");
		accionesSinomimosMap.put("moverse", "ir");
		accionesSinomimosMap.put("tomar", "agarrar");
		
		// TODO: si no encontro el objeto, devolver excepcion.
		return accionesSinomimosMap.get(verbo);
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
	public void setObjetoIndirecto(String objetoIndirecto) {
		this.objetoIndirecto = objetoIndirecto;
	}

	@Override
	public String toString() {
		return verbo + " " + sustantivo + " " + objetoIndirecto ;
	}
}
