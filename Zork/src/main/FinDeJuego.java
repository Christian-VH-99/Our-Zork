package main;

import acciones.Peticion;

public class FinDeJuego {
	private Peticion peticion;
	private String mensajeFin;
	private String condicion;

	public FinDeJuego(Peticion peticion, String mensajeFin, String condicion) {

		this.peticion = peticion;
		this.mensajeFin = mensajeFin;
		this.condicion = condicion;
	}

	public Peticion getPeticion() {
		return peticion;
	}

	public String getMensajeFin() {
		return mensajeFin;
	}

	public String getCondicion() {
		return condicion;
	}

}
