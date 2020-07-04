package jugadores;

import java.util.HashMap;
import java.util.Map.Entry;

//import java.util.List;

import items.Item;

public class Npc {

	protected String nombre;
	protected Character genero;
	protected String descripcion;
	protected String talk;
	protected Debilidad debilidad;
	protected Character numero;
	// protected Item objetoDebilidad;
	// protected Boolean derrotado = false;

	/* Dialogos */
	private HashMap<String, String> sentencias;
	private HashMap<String, String> respuestas = new HashMap<>();

	public Npc(String nombre, Character genero, String descripcion, String talk, /* Item */Debilidad debilidad,
			Character num) {

		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.talk = talk;
		// this.objetoDebilidad = new Item(debilidad.getGenero(),
		// debilidad.getNombre());
		this.numero = num;
		this.debilidad = new Debilidad(debilidad.getCosa(), debilidad.getDialogoDerrota(), debilidad.getAccion());

		sentencias = new HashMap<>();
		respuestas = new HashMap<>();
	}

	public Npc(String nombre, Character genero, String descripcion, String talk, Character num) {

		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.talk = talk;
		this.numero = num;
		this.debilidad = null;

	}

	//agregado
	public void addSentenciaYRespuesta(String IdSent, String sentencia, String respuesta) {
		sentencias.put(IdSent, sentencia);
		respuestas.put(IdSent, respuesta);
	}

	public String getSentenciasPosibles() {

		String ret = "Ingresar: decir + opcion+letraDeSentencia + nombreNPC \n";
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

//	public Item getObjetoDebilidad() {
//		return objetoDebilidad;
//	}

	public boolean attack(Item objeto) {
		if (debilidad.efectividadItem(objeto)) {
			System.out.println(debilidad.getDialogoDerrota());

			// setDerrotado(true);
			return true;
		} else
			System.out.print("No ha servido de nada");
		return false;
	}

	public String buscarSentenciaElegida(String opcion) {
		return sentencias.get(opcion);
	}

	public String buscarRespuestaASentenecia(String opcion) {
		return respuestas.get(opcion);
	}

}