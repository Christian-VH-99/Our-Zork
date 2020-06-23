package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import Ubicacion.*;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
//import acciones.Moverse;
import items.Inventario;
import items.Item;
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;

public class Juego {

	private Interprete interprete;
	private EndGame fin;
	private File file;
	private List<Ubicacion> ubicaciones;
	private Jugador jugador;
//	Scanner scann = new Scanner(System.in);
	private String entradaJugador;

	/**
	 * NOTA: este constructor inicializa la aventura en base a un archivo de
	 * aventura
	 */
//	public Juego(String filname) {
//		if(!cargarAventura(filname))
//			return;
//		ubicacionActual = ubicaciones.get(0);
//		System.out.println("Ingresa tu nombre: ");
//		nombreJugador = scann.nextLine();
//		System.out.println(nombreJugador + ubicacionActual.describir());
//		while(true) {
//			entradaJugador = scann.nextLine();
//			/* le mando al interprete lo qu eingreso el jugador para que me identifique que acciones realizar*/
//			interprete.set(entradaJugador);
//			
//			/* realizo la accion */
//			//accion(interprete.getVerbo(),interprete.getSustantivo());
//			
//			if(fin.comprobar(interprete.getVerbo(), interprete.getSustantivo())){
//				System.out.println(fin.getDescripcion());
//				return;
//			}
//			
//			/* limpio la entrada del jugador */
//			entradaJugador = "";
//		}
//	}

//	public boolean cargarAventura(String filename) {
//		file = new File(filename);
//		if(!file.canRead()) {
//			System.out.println("Error al abrir el archivo para cargar la aventura...");
//			return false;
//		}
//		/* ahora trato de leer y cargar todos los elementos (ubicaciones, items, npcs,etc)*/
//		try {
//			//// Completar una vez decidido como va a ser nuestro archivo de entrada ////
//			return true;
//		}catch (Exception e) {
//			System.out.println(e);
//			return false;
//		}
//	}
//	
//// constructor y  metodo generador para hacer los test para la primera entrega ////
	public Juego(Jugador jugador) {
		this.jugador = jugador;
	}

	public void generarEntorno() {

		// Ubicaciones
		Ubicacion taberna = new Ubicacion("taberna", 'F');
		Ubicacion muelle = new Ubicacion("muelle", 'M');
		Ubicacion hotel = new Ubicacion("hotel", 'M');

		// Places
		Place mesa = new Place("Mesa", 'F', 'S');
		Place rincon = new Place("Rincon", 'M', 'S');
		Place cama = new Place("Cama", 'F', 'S');

		// inventario
		Inventario inventario = new Inventario();
		Item it1 = new Item("cerveza", 'F', 'S');
//		Item it2 = new Item("espejo", 'M', 'S'); //agregado
		inventario.agregarItem(it1);
//		inventario.agregarItem(it2);

		// set hotel
		hotel.agregarPlace(cama);

		// set taberna
		mesa.agregarItem(new Item("cuchillo", 'M', 'S'));
		mesa.agregarItem(new Item("cerveza", 'F', 'S'));

		taberna.agregarPlace(mesa);

		// set muelle
		muelle.agregarConexion(new Conexion(taberna, "norte", "fantasma"));
		muelle.agregarConexion(new Conexion(hotel, "oeste"));
		rincon.agregarItem(new Item("espejo", 'M', 'S'));
		muelle.agregarPlace(rincon);

		Debilidad d1 = new Debilidad(it1, "- Me encanta la cerveza, te dejare pasar por esta vez", "cantar"); // TODO:
																												// sacar
		muelle.agregarNpc(new Npc("fantasma", 'M', "- '¡No puedes pasar!' El pirata fantasma no te dejará pasar",
				"¡No hay nada que me digas que me haga cambiar de opinión!", d1, 'S'));

		// trato al jugador
//		ubicacionActual = muelle;
		jugador.setUbicacionActual(muelle);
		jugador.setInventario(inventario);
	}
	public static void main(String[] args) {

		AccionBase accionBase;
		Jugador jugador;
		Juego juego;
		Agarrar accion;
		Informacion informacion;
		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();// incial
		accion.setSiguiente(mirar);

		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);

		Dar dar = new Dar();
		informacion.setSiguiente(dar);

		/*********************************************/
		juego.generarEntorno();
		/*********************************************/

		String entradaTeclado = null;
		Scanner entradaEscaner = null;
		Interprete interprete = null;
		Peticion peticion = null;

		while (!jugador.esFinDeJuego()) {

			entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();

			interprete = new Interprete(entradaTeclado);
			peticion = interprete.generarPeticion();
			accion.ejecutar(peticion, jugador);
			
			//Si se dan las condiciones de Ubicacion o item para terminar el juego
//			if(condicionDeFinDeJuego) {				
//				jugador.marcarFinDeJuego();
//			}
		}
		System.out.println("Fin del juego, felicidades!");
	}

}
