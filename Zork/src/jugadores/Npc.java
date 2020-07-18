package jugadores;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import items.Item;

public class Npc {

	protected String nombre;
	protected Character genero;
	protected String descripcion;
	protected String talk;
	protected Debilidad debilidad;
	protected Character numero;

	/* Dialogos */
	private Map<String, String> sentencias;
	private Map<String, String> respuestas;

	public Npc(String nombre, Character genero, String descripcion, String talk, Debilidad debilidad, Character num) {

		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.talk = talk;
		this.numero = num;
		this.debilidad = new Debilidad(debilidad.getCosa(), debilidad.getDialogoDerrota(), debilidad.getAccion());

		sentencias = new LinkedHashMap<>();
		respuestas = new LinkedHashMap<>();
	}

	public Npc(String nombre, Character genero, String descripcion, String talk, Character num) {

		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.talk = talk;
		this.numero = num;
		this.debilidad = null;
		sentencias = new LinkedHashMap<>();
		respuestas = new LinkedHashMap<>();

	}

	public void addSentenciaYRespuesta(String IdSent, String sentencia, String respuesta) {
		sentencias.put(IdSent, sentencia);
		respuestas.put(IdSent, respuesta);
	}

	public String getSentenciasPosibles() {

		String ret = "->Para dialogar elegi una opcion.\n";
		for (Entry<String, String> entry : sentencias.entrySet()) {

			ret += entry.getKey() + " : " + entry.getValue() + "\n";

		}
		return ret;
	}

	public String getNombreNpc() {
		return nombre;
	}

	public Character getGeneroNpc() {
		return genero;
	}

	public String getDescripcionNpc() {
		return descripcion;
	}

	public String getTalkNpc() {
		return talk;
	}

	public int cantSentencias() {
		return sentencias.size();
	}

	public boolean attack(Item objeto) {
		if (debilidad.efectividadItem(objeto))
			return true;
		return false;
	}

	public Debilidad getDebilidad() {
		return debilidad;
	}

	public String buscarSentenciaElegida(String opcion) {
		return sentencias.get(opcion);
	}

	public String buscarRespuestaASentenecia(String opcion) {
		return respuestas.get(opcion);
	}
}