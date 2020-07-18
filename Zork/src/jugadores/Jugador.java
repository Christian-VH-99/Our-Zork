package jugadores;

import Ubicacion.Ubicacion;
import items.Inventario;

public class Jugador {

	private Inventario inventario;
	private String nombre;
	private Ubicacion ubicacionActual;
	private String condicion = "PERDISTE";

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.inventario = new Inventario();
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setUbicacionActual(Ubicacion ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
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
