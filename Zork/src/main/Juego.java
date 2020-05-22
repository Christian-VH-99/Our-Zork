package main;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import Ubicacion.*;
import acciones.Moverse;
import items.Inventario;
import items.Item;

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
	// TODO: agregar un objeto que guarde los pasos 
	
	
	/**NOTA: este contructor inicializa la aventura en base a un archivo de aventura */
	public Juego(String filename) {
		if(!cargarAventura(filename))
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
	
	public Juego() {
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
	
	
	public void generarEntorno() {
		
		/**Creo las locations*/
		Ubicacion taberna = new Ubicacion("taberna", 'F') ;
		Ubicacion muelle = new Ubicacion("muelle", 'M') ;
		Place mesa = new Place("Suelo",'F','S');
		Place rincon = new Place("Rincon",'M','S');
		inventario = new Inventario();
		//set taberna
		
		mesa.agregarItem(new Item("cuchillo",'M','S'));
		mesa.agregarItem(new Item("cerveza",'F','S'));
		
		taberna.agregarPlace(mesa);

		// set muelle
		muelle.agregarConexion(new Conexion(taberna, "norte"));
		rincon.agregarItem(new Item("espejo",'M','S'));
		muelle.agregarPlace(rincon);

		
		// asignacion de location inicial
		ubicacionActual = muelle;
		
		//describirTest: mensaje inicial del juego
		ubicacionActual.describir();
	}
	
	public Inventario getInventario() {
		return this.inventario;
	}
	public void setNombreJugador(String nombre) {
		this.nombreJugador = nombre;
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
