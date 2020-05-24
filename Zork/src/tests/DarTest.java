package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Ubicacion;
import acciones.Dar;
import jugadores.Jugador;
import main.Juego;

public class DarTest {
	static private Jugador jugador;
	static private Dar dar;
	static private Juego juego;
	
	@BeforeClass
	public static void before() {
		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);
	}

	@Test
	public void testNpcNoVencido() {
		juego.generarEntorno();
		dar = new Dar(jugador);
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());
		dar.accionar("espejo", "fantasma");
		assertEquals("fantasma ",jugador.getUbicacionActual().getNpcs());
	}
	@Test
	public void testNpcVencido() {	
		juego.generarEntorno();
		dar = new Dar(jugador);		
		
		assertEquals("En tu inventario hay: una cerveza.",jugador.getInventario().listarItems());
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());
		dar.accionar("cerveza", "fantasma");
		
		assertEquals("No posees objetos en tu inventario.",jugador.getInventario().listarItems());
		
//		assertEquals("",juego.getUbicacion().getNpcs());
		
	}

}
