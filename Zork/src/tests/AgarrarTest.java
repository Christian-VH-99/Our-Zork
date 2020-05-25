package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import acciones.Agarrar;
import acciones.Peticion;
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
		
		/*Prueba sin patron*/
//		juego.generarEntorno();
//		agarrar = new Agarrar(jugador);
//		agarrar.accionar(jugador.getUbicacionActual(), "espejo");
//		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
//	
		/*Prueba con patron*/
		juego.generarEntorno();
		agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion(null, null, "espejo", "agarrar"), jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
	
	}

	/*TODO:Probarlo con patron*/
	@Test
	public void objetoInexistente() {
		
		/*Prueba sin patron*/
		juego.generarEntorno();
		agarrar = new Agarrar(jugador);
		agarrar.accionar(jugador.getUbicacionActual(), "cuchillo");
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
		/* no deberia agregar nada al inventario, e imprime que el objeto no existe */
		//TODO: agregar assert que compruebe la salida por consola
	}
}
