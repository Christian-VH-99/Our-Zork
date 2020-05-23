package main;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import Ubicacion.*;
//import acciones.Moverse;
import items.Inventario;
import items.Item;
import jugadores.Debilidad;
import jugadores.Npc;

public class Juego {

	public Ubicacion ubicacionActual;
	public Inventario inventario;
	public Interprete interprete;
	public String nombreJugador;
	public EndGame fin;
	public File file;
	public List<Ubicacion> ubicaciones;
	
	Scanner scann = new Scanner(System.in);
	public String entradaJugador;
	
	
	/**NOTA: este constructor inicializa la aventura en base a un archivo de aventura*/
	public Juego(String filname) {
		if(!cargarAventura(filname))
			return;
		ubicacionActual = ubicaciones.get(0);
		System.out.println("Ingresa tu nombre: ");
		nombreJugador = scann.nextLine();
		System.out.println(nombreJugador + ubicacionActual.describir());
		while(true) {
			entradaJugador = scann.nextLine();
			/* le mando al interprete lo qu eingreso el jugador para que me identifique que acciones realizar*/
			interprete.set(entradaJugador);
			
			/* realizo la accion */
			//accion(interprete.getVerbo(),interprete.getSustantivo());
			
			if(fin.comprobar(interprete.getVerbo(), interprete.getSustantivo())){
				System.out.println(fin.getDescripcion());
				return;
			}
			
			/* limpio la entrada del jugador */
			entradaJugador = "";
		}
	}
	
	public boolean cargarAventura(String filename) {
		file = new File(filename);
		if(!file.canRead()) {
			System.out.println("Error al abrir el archivo para cargar la aventura...");
			return false;
		}
		/* ahora trato de leer y cargar todos los elementos (ubicaciones, items, npcs,etc)*/
		try {
			//// Completar una vez decidido como va a ser nuestro archivo de entrada ////
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
//// constructor y  metodo generador para hacer los test para la primera entrega ////
	public Juego() {
	}
	
	
	public void generarEntorno() {
		
		/**Creo las locations*/
		Ubicacion taberna = new Ubicacion("taberna", 'F') ;
		Ubicacion muelle = new Ubicacion("muelle", 'M') ;
		Ubicacion hotel = new Ubicacion("hotel",'M');
		
		Place mesa = new Place("Mesa",'F','S');
		Place rincon = new Place("Rincon",'M','S');
		Place cama = new Place("Cama",'F','S');
		inventario = new Inventario();
		
		Item it1 = new Item("cerveza",'F','S');
		inventario.agregarItem(it1);
		
		//set hotel
		
		hotel.agregarPlace(cama);
		
		//set taberna
		
		mesa.agregarItem(new Item("cuchillo",'M','S'));
		mesa.agregarItem(new Item("cerveza",'F','S'));
		
		taberna.agregarPlace(mesa);

		// set muelle
		muelle.agregarConexion(new Conexion(taberna, "norte","fantasma"));
		muelle.agregarConexion(new Conexion(hotel,"oeste"));
		rincon.agregarItem(new Item("espejo",'M','S'));
		muelle.agregarPlace(rincon);
		
		Debilidad d1 = new Debilidad(it1,"- Me encanta la cerveza, te dejare pasar por esta vez","cantar"); //TODO: sacar el "cantar"
		muelle.agregarNpc(new Npc("fantasma",'M',"- '¡No puedes pasar!' El pirata fantasma no te dejará pasar","¡No hay nada que me digas que me haga cambiar de opinión!",d1,'S'));

		
		// TODO: ver como ejecutar estos 3 test desde Junit sin modificar la interface.
		// asignacion de location inicial
		ubicacionActual = muelle;
		
		//describirTest: mensaje inicial del juego
		ubicacionActual.describir();
		
		//cambiarLocationTest: mensaje inicial del juego
//		Moverse moverse = new Moverse(this);
//		moverse.accionar(taberna);
		
		//cambiarLocationTestNOK
		//moverse.accionar(muelle);
	}
	
	public Inventario getInventario() {
		return this.inventario;
	}
	public void setNombreJugador(String nombre) {
		this.nombreJugador = nombre;
	}
	
	public String getNombreJugador() {
		return this.nombreJugador;
	}

	public void setLocation(Ubicacion ubicacion) {
		this.ubicacionActual = ubicacion;
		
		/*luego de cambiar de ubicacion, describo el luegar donde ahora se encuentra el jugador*/
		ubicacion.describir();
	}

	public Ubicacion getUbicacion() {
		return ubicacionActual;
	}
	
}
