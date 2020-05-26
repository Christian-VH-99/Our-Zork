package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Ubicacion;
import acciones.Dar;
import acciones.Peticion;
import jugadores.Jugador;
import main.Juego;


// TODO: revisar esta accion, no esta claro lo que hace.
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
		dar = new Dar();
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());
		dar.ejecutar(new Peticion("dar",null,null, "espejo","fantasma"),jugador );
	}
	
	@Test
	public void testNpcVencido() {	
		juego.generarEntorno();
		dar = new Dar();		
		
		assertEquals("En tu inventario hay: una cerveza.",jugador.getInventario().listarItems());
		assertEquals("fantasma ", jugador.getUbicacionActual().getNpcs());
		dar.ejecutar(new Peticion("dar",null,null, "cerveza","fantasma"),jugador );

		assertEquals("No posees objetos en tu inventario.",jugador.getInventario().listarItems());
//		assertEquals("",juego.getUbicacion().getNpcs());
		
	}

	// TODO: agregar CP para "No posees ese objeto"
}
