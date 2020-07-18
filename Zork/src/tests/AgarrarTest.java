package tests;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Agarrar;
import acciones.Peticion;
import items.Item;

import jugadores.Jugador;

/** Probado con Patron */
public class AgarrarTest {

	Ubicacion actual;
	Item i1;
	Place p1;
	Jugador jugador = new Jugador("test");

	@Before
	public void before() {
		actual = new Ubicacion("pieza", 'F');
		p1 = new Place("mesa", 'F', 'S');
		i1 = new Item("miel", 'F', 'S', 10);
		actual.agregarPlace(p1);
		p1.agregarItem(i1);
		jugador.setUbicacionActual(actual);
	}

	@Test
	public void queSePuedaAgarrarUnObjetoExist() {
		Agarrar agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar", null, "miel", null, null), jugador, new JLabel());
		assertEquals(true, jugador.getInventario().buscarItem("miel"));
	}

	@Test
	public void queNoSePuedaAgarrarUnObjetoInexist() {

		Agarrar agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar", null, "zanahoria", null, null), jugador, new JLabel());
		assertEquals(false, jugador.getInventario().buscarItem("zanahoria"));
	}
}
