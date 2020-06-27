package main;

//import java.io.File;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Hablar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
import acciones.Usar;
import jugadores.Jugador;

public class Juego {

	private Jugador jugador;
	static ArrayList<Peticion> finales;

	public Juego(Jugador jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public static void main(String[] args) {

		// TODO: este es un ejemplo de como se haria, ahora debemos armar

		Jugador jugador = new Jugador("Juanito");
		Juego juego;
		AccionBase accion;
		System.out.println("Ingrese su nombre");
		Scanner entradaEscaner = new Scanner(System.in);
		String entradaTeclado = entradaEscaner.nextLine();
		;
		;
		juego = new Juego(jugador);
		accion = cargarChainAcciones();
		EntornoGson entorno = new EntornoGson();
		entorno.deserializar();
		jugador.setUbicacionActual(entorno.getUbicacion());
		finales = entorno.getFinales();
		Interprete interprete = new Interprete(entorno);

		Peticion peticion = null;

		System.out.println(entorno.getBienvenida());

		do {
			entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();

			interprete.separarComando(entradaTeclado);
			peticion = interprete.generarPeticion();
			if (peticion == null) {
				System.out.println("error");
			} else {
				accion.ejecutar(peticion, jugador);
			}

			interprete.recargarInterprete();
		} while (!juego.esFinDeJuego(peticion, jugador));
		entradaEscaner.close();
		System.out.println(jugador.getCondicion());
	}

	private static Agarrar cargarChainAcciones() {

		Agarrar accion = new Agarrar();// incial

		Mirar mirar = new Mirar();
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		Informacion informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Dar dar = new Dar();
		informacion.setSiguiente(dar);

		Usar usar = new Usar();
		dar.setSiguiente(usar);

		Moverse moverse = new Moverse();
		usar.setSiguiente(moverse);

		Hablar hablar = new Hablar();
		moverse.setSiguiente(hablar);

		return accion;
	}

	public boolean getEsFinDeJuego(Peticion peticion, Jugador jugador) {
		return esFinDeJuego(peticion, jugador);
	}

	private boolean esFinDeJuego(Peticion peticion, Jugador jugador) {

		if (peticion == null)
			return false;
		for (Peticion peticionFinal : finales) {

			if (peticionFinal.equals(peticion)) {
				if (peticionFinal.getNombreAccion().equals("dar")) {
					jugador.setCondicion("GANASTE");
				}
				return true;
			}
		}
		return false;
	}

	public void setFinales(ArrayList<Peticion> finales) {
		this.finales = finales;
	}
}
