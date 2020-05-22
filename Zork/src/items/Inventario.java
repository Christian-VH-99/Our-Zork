package items;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import sun.management.counter.Variability;

public class Inventario {

	protected String nombre;
	protected HashMap<String, Item> inventory;
	protected String descripcion;
	protected String[] aceptar;

	public Inventario() {

		inventory = new HashMap<String, Item>();

	}

//// GETTERS ////	
	public HashMap<String, Item> getInventory() {

		return this.inventory;

	}

	public String listarItems() { 
		
		String cadena = "En tu inventario hay: ";
		
		Collection<Item> col = inventory.values();
	
		// TODO: recorrer con Iterator
		if(col.size() == 1) {
			cadena += col.toString(); //TODO: revisar
		}else {
			for (int indice = 0; indice < col.size()-1; indice++) {
				
				if(indice == col.size()-2) // si es el ultimo item
				{
//					cadena += "y " + col.ge//toString();

				}else {
//					cadena += item.toString() + ", ";
				}
			}
		}
		cadena += ".";
				
		return cadena;
		
	}

	public Item getItem(String objeto) { /* remueve el item del inentario */
		Item aux = null;
		for (Item item : inventory.values()) {
			if (item.getNombre().equals(objeto)) {
				aux = new Item(item.getNombre(), item.getGenero(), item.getNumero());
				inventory.remove(objeto);
				break;
			}
		}
		return aux;
	}

//// AGREGAR ELEMENTO ////	
	public void agregarItem(Item obj) {
		inventory.put(obj.getNombre(), obj);

	}

}