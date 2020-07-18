package tests;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Moverse;
import acciones.Peticion;
import items.Item;
import jugadores.Jugador;
import main.Interprete;

public class MoverseTest {

	private Jugador jugador;
	private Moverse moverse;
	private Ubicacion taberna;
	private Ubicacion hotel;
	private Ubicacion casa;
	private Ubicacion playa;
	Interprete interprete;

	@Before
	public void before() {

		jugador = new Jugador("Juanito");

		taberna = new Ubicacion("taberna", 'F');
		hotel = new Ubicacion("hotel", 'M');
		casa = new Ubicacion("casa", 'F');
		playa = new Ubicacion("playa", 'F');
		Place mesa = new Place("Suelo", 'M', 'S');
		Place cama = new Place("Cama", 'F', 'S');

		mesa.agregarItem(new Item("cuchillo", 'M', 'S', 10));
		mesa.agregarItem(new Item("cerveza", 'F', 'S', 10));

		taberna.agregarPlace(mesa);
		hotel.agregarPlace(cama);

		Conexion conexion = new Conexion(hotel, Direcciones.NORTE);
		Conexion conexion2 = new Conexion(casa, Direcciones.SUR, "fantasma");
		taberna.agregarConexion(conexion);
		taberna.agregarConexion(conexion2);
		jugador.setUbicacionActual(taberna);
	}

	@Test
	public void queSePuedaMoverAUnaUbicacionValida() {
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", "hotel", null, null, null), jugador, new JLabel());
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals(ubicacion.equals(hotel), true);
	}

	@Test
	public void queNOPuedaMoverAUnaUbicacionInvalidaDebidoAUnObstaculo() {
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", "casa", null, null, null), jugador, new JLabel());
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals(ubicacion.equals(casa), false);
		assertEquals(ubicacion.equals(taberna), true);
	}

	@Test
	public void queNOPuedaMoverAUnaUbicacionInvalida() {
		moverse = new Moverse();
		moverse.ejecutar(new Peticion("moverse", "playa", null, null, null), jugador, new JLabel());
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals(ubicacion.equals(playa), false);
		assertEquals(ubicacion.equals(taberna), true);

	}
}