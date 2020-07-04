package tests;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Decir;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
import acciones.Peticion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;
import main.EntornoGson;
import main.Interprete;
import main.Juego;

/*Este test no tiene mucho sentido mas alla de probar el caso hipotetico de ingresar cada comando*/
public class ChainConInterprete {

	static AccionBase accionBase;
	static Jugador jugador;
	static Juego juego;
	static Agarrar accion;
	static Informacion informacion;

	@BeforeClass
	static public void before() {
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
	}

	@Test
	public void queSiSeIngresaMoverseSeEjecuteLaAccion() {

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

		Ubicacion hotel = new Ubicacion("hotel", 'M');
		Place cama = new Place("Cama", 'F', 'S');

		hotel.agregarPlace(cama);

		juego.generarEntorno();
		/*************************/

		Interprete interprete = new Interprete("ir al hotel");
		Peticion peticion = interprete.generarPeticion();
		if (peticion != null) {
			accion.ejecutar(peticion, jugador);
		} else {
			System.out.println("Comando invalido");
		}

		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals("Estas en el hotel. Hay una Cama.", ubicacion.describir());

	}

	@Test // OK
	public void queSiSeIngresaAyudaSeEjecuteLaAccion() {

		Interprete interprete = new Interprete("ayuda");
		Peticion peticion = interprete.generarPeticion();

		Ubicacion casa = new Ubicacion("casa", 'F');
		jugador.setUbicacionActual(casa);
		accion.ejecutar(peticion, jugador);
	}

	@Test // OK
	public void queSiSeIngresaDarSeEjecuteLaAccion() {
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
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());

		Interprete interprete = new Interprete("darle la cerveza al fantasma");
		Peticion peticion = interprete.generarPeticion();

		accion.ejecutar(peticion, jugador);
		assertEquals("", jugador.getUbicacionActual().getNpcs());
	}

	@Test // OK
	public void queSiSeIngresaAgarrarSeEjecuteLaAccion() {

		juego.generarEntorno();

		/** Antes de agarrar algo */
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
		Interprete interprete = new Interprete("agarrar espejo");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
	}

	@Test
	public void queSeEjecuteMirar() {

		Ubicacion casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("mesa", 'F', 'S');
		Item botella = new Item("botella", 'F', 'S');
		Item cuchillo = new Item("cuchillo", 'M', 'S');

		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);

		casa.agregarPlace(mesa);

		jugador.setUbicacionActual(casa);
		Interprete interprete = new Interprete("mirar mesa");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);

	}

	/*Si se ejecuta usar GSon o descomentar seccion en interprete*/
	@Test
	public void queSeEjecuteDecir() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);
		EntornoGson entorno = null;
		Interprete interprete = new Interprete(entorno);
		
		Ubicacion actual;
		Ubicacion u1;
		Item i1;
		Place p1;
		Debilidad d1;
		Npc pj1;
		actual = new Ubicacion("pieza", 'F');
		u1 = new Ubicacion("terraza", 'F');
		i1 = new Item("miel", 'F', 'S');
		d1 = new Debilidad(i1, " Me encanta la miel, te dejare pasar solo por esta vez", "remover");
		pj1 = new Npc("Covit", 'M', "- No podras pasar", "a", d1, 'S');
		
		pj1.addSentenciaYRespuesta("opcionA", "pasare igual, forro", "Te voy a matar aashh");
		pj1.addSentenciaYRespuesta("opcionB", "Hola!!", "Te matare");

		actual.agregarNpc(pj1);
		
		jugador.setUbicacionActual(actual);
		accion = juego.cargarChainAcciones();

		interprete.separarComando("hablar a Covit");
		Peticion peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);
		/*----------------------------------------*/
		interprete.separarComando("decir opcionB a Covit");
		peticion = interprete.generarPeticion();
		accion.ejecutar(peticion, jugador);
	}

}
