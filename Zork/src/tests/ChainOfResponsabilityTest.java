package tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Mirar;
import acciones.Peticion;
import items.Item;
import jugadores.Jugador;
import main.Juego;

/*TODO: esta clase debe probar la cadena completa de acciones*/
public class ChainOfResponsabilityTest {

	static AccionBase accionBase;
	static Jugador jugador;
	static Juego juego;
	static Agarrar accion;

	@BeforeClass
	static public void before() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();//incial
		accion.setSiguiente(mirar);		
		
		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

	}

	@Test
	public void queSeEjecuteAgarrar() {
		juego.generarEntorno();

		/**Antes de agarrar algo*/
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
		
		accion.ejecutar(new Peticion("agarrar",null, null, "espejo"), jugador);
		assertEquals("En tu inventario hay: una cerveza, y un espejo.", jugador.getInventario().listarItems());

	}

	@Test
	public void queSeEjecuteMirar() {
		juego.generarEntorno();

		Ubicacion casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("mesa", 'F', 'S');
		Item botella = new Item("botella", 'F', 'S');
		Item cuchillo = new Item("cuchillo", 'M', 'S');

		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);

		casa.agregarPlace(mesa);

		jugador.setUbicacionActual(casa);
		accion.ejecutar(new Peticion(mesa, "mirar"), jugador);
	}
	
	@Test
	public void queSeEjecuteAyuda() {
		
		Ubicacion casa = new Ubicacion("casa",'F');
		jugador.setUbicacionActual(casa);
		jugador.setNombre("Havacu");
		accion.ejecutar(new Peticion("ayuda", null, null, null),jugador);
	}
	
}
