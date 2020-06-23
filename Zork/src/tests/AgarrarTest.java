package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import acciones.Agarrar;
import acciones.Peticion;
import jugadores.Jugador;
import main.Juego;

/**Probado con Patron*/
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
	public void queSePuedaAgarrarUnObjetoExist() {
		
		juego.generarEntorno();
		agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar",null, "espejo", null,null), jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
	}


	@Test
	public void queNoSePuedaAgarrarUnObjetoInexist() {
		
		juego.generarEntorno();
		agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar", null, "asd", null ,null), jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());
		/* no deberia agregar nada al inventario, e imprime que el objeto no existe */
		//TODO: agregar assert que compruebe la salida por consola
			//El objeto que quiere agarrar no existe
	}
}
