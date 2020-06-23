package jugadores;

import Ubicacion.Ubicacion;
import items.Inventario;

public class Jugador {

	private Inventario inventario; 
	private String nombre; 
	private Ubicacion ubicacionActual;
	private Boolean finDeJuego;

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

	//TODO: evaluar si podria ir en Juego
	public Boolean esFinDeJuego() {
		return finDeJuego;
	}
	
	public void marcarFinDeJuego() {
		finDeJuego = true;
	}
}
