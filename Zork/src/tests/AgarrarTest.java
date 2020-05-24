package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import acciones.Agarrar;
import jugadores.Jugador;
import main.Juego;

public class AgarrarTest {

	static private Juego juego;
	private Agarrar agarrar;
	private static Jugador jugador;

	@BeforeClass
	public static void before() {
		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);
	}

	@Test
	public void objetoExistente() {
		juego.generarEntorno();
		agarrar = new Agarrar(jugador);/// TODO: ojo
		agarrar.accionar(jugador.getUbicacionActual(), "espejo");
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
	}

	@Test
	public void objetoInexistente() {
		juego.generarEntorno();
		agarrar = new Agarrar(jugador);
		agarrar.accionar(jugador.getUbicacionActual(), "cuchillo");
		/* no deberia agregar nada al inventario, e imprime que el objeto no existe */
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
	}
}
