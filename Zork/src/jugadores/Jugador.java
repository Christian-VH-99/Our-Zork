package jugadores;

import Ubicacion.Ubicacion;
import items.Inventario;

public class Jugador {

	private Inventario inventario; 
	private String nombre; 
	private Ubicacion ubicacionActual;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	public Inventario getInventario() {
		return inventario;
	}
	
	public void setUbicacionActual(Ubicacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
		/*Descomentar para probar en historia nueva, con historia vieja, rompera porque no esa asignado*/
		//ubicacionActual.mostrarMensajeDeIngresoAUbicacion();
		ubicacionActual.describir();
	}
	
	public Ubicacion getUbicacionActual() {
		return ubicacionActual;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
