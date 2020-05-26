package tests;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Moverse;
import acciones.Peticion;
import items.Item;
import jugadores.Jugador;
import main.Juego;

public class MoverseTest {

	static private Juego juego;
	static private Jugador jugador;
	private Moverse moverse;
	static private Ubicacion taberna;
	static private Ubicacion hotel;
	static private Ubicacion casa;

	@BeforeClass
	public static void before() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);


		taberna = new Ubicacion("taberna", 'F');
		hotel = new Ubicacion("hotel", 'M');
		casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("Suelo", 'M', 'S');
		Place cama = new Place("Cama", 'F', 'S');

		mesa.agregarItem(new Item("cuchillo", 'M', 'S'));
		mesa.agregarItem(new Item("cerveza", 'F', 'S'));

		taberna.agregarPlace(mesa);
		hotel.agregarPlace(cama);
	}

	@Test
	public void queSePuedaMoverAUnaUbicacionValida() {
		juego.generarEntorno();
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", hotel, null, null, null), jugador);
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals("Estas en el hotel. Hay una Cama.", ubicacion.describir());
	}

	@Test
	public void queNOPuedaMoverAUnaUbicacionInvalidaDebidoAUnObstaculo() {
		juego.generarEntorno();
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", taberna, null, null, null), jugador);
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals("Estas en el muelle. Hay un Rincon. Se ve a lo lejos una taberna, y un hotel.",
				ubicacion.describir());
		
		//TODO: agregar assert que compare la salida por consola.
	}

	@Test
	public void queNOPuedaMoverAUnaUbicacionInvalida() {
		juego.generarEntorno();
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", casa, null, null, null), jugador);
//		Ubicacion ubicacion = jugador.getUbicacionActual();
//		assertEquals("Estas en el muelle. Hay un Rincon. Se ve a lo lejos una taberna, y un hotel.", ubicacion.describir());
		/* deberia imprimir que no puedo moverme ahi */
	}

}
