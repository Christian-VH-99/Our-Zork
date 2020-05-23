package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import acciones.Agarrar;
import main.Juego;

public class AgarrarTest {

	static private Juego juego;
	private Agarrar agarrar;
	
	@BeforeClass
	public static void before() {

		juego = new Juego();

	}
	
	@Test
	public void objetoExistente() {
		juego.generarEntorno();
		agarrar = new Agarrar(juego);
		agarrar.accionar(juego.ubicacionActual, "espejo");
		
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", juego.getInventario().listarItems());
		
		
	}
	
	@Test
	public void objetoInexistente() {
		juego.generarEntorno();
		agarrar = new Agarrar(juego);
		agarrar.accionar(juego.ubicacionActual, "cuchillo");
		
		/* no deberia agregar nada al inventario, e imprime que el objeto no existe */
		assertEquals("En tu inventario hay: una cerveza.", juego.getInventario().listarItems());
		
	}

}
