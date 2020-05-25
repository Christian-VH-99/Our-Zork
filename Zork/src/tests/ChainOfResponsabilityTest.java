package tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Mirar;
import acciones.Peticion;
import jugadores.Jugador;
import main.Juego;

/*TODO: esta clase debe probar la cadena completa de acciones*/
public class ChainOfResponsabilityTest {

	static AccionBase accionBase;
	static Jugador jugador;
	
	@BeforeClass
	static public void before() {
		
		jugador = new Jugador("Juanito");
		Juego juego = new Juego(jugador);
		juego.generarEntorno();
		
		
		// creo acciones
		accionBase = new Agarrar();
		AccionBase mirar = new Mirar();
		
		//est sig
		accionBase.setSiguiente(mirar);
		
	}
	
	@Test
	public void queEjecuteAgarrar() {
		
		accionBase.ejecutar(new Peticion(null, null, "Espejo", "agarrar"), jugador);
//		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());

	}
	
	public void queEjecuteMirar() {
//		accionBase.ejecutar(new Peticion(null, null, null, "Mirar"), jugador);
	}
	
}
