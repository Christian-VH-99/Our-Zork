package jugadores;

//import java.util.List;

import items.Item;

public class Npc {

	protected String nombre;
	protected Character genero;
	protected String descripcion;
	protected String talk;
	//protected Item objetoDebilidad;
	protected Debilidad debilidad;
	protected Character numero;
	//protected Boolean derrotado = false;
	
	

	public Npc(String nombre, Character genero, String descripcion, String talk, /*Item*/Debilidad debilidad, Character num) {
		
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.talk = talk;
		//this.objetoDebilidad = new Item(debilidad.getGenero(), debilidad.getNombre());
		this.numero = num;
		this.debilidad = new Debilidad(debilidad.getCosa(),debilidad.getDialogoDerrota(), debilidad.getAccion());
		
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
		if(debilidad.efectividadItem(objeto)) {
			System.out.println(debilidad.getDialogoDerrota());
			//setDerrotado(true);
			return true;
		}else
			System.out.print("No ha servido de nada");
		return false;
	}

//	public void setDerrotado(Boolean derrotado) {
//		this.derrotado = derrotado;
//	}
	

}