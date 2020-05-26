package tests;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.AccionBase;
import acciones.Agarrar;
import acciones.Ayuda;
import acciones.Dar;
import acciones.Informacion;
import acciones.Mirar;
import acciones.Moverse;
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
	static Informacion informacion; 

	@BeforeClass
	static public void before() {

		jugador = new Jugador("Juanito");
		juego = new Juego(jugador);

		Mirar mirar = new Mirar();

		accion = new Agarrar();//incial
		accion.setSiguiente(mirar);		
		
		Ayuda ayuda = new Ayuda();
		mirar.setSiguiente(ayuda);

		informacion = new Informacion();
		ayuda.setSiguiente(informacion);

		Moverse moverse = new Moverse();
		informacion.setSiguiente(moverse);
		
		// probar luego de revisar Dar.
//		Dar dar = new Dar();
//		informacion.setSiguiente(dar);

	}

	@Test
	public void queSeEjecuteAgarrar() {
		juego.generarEntorno();

		/**Antes de agarrar algo*/
		assertEquals("En tu inventario hay: una cerveza.", jugador.getInventario().listarItems());
		
		accion.ejecutar(new Peticion("agarrar",null, null, "espejo",null), jugador);
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
	}
	
	@Test
	public void queSeEjecuteInformacion() {
		
		Ubicacion casa = new Ubicacion("casa",'F');
		jugador.setUbicacionActual(casa);
		accion.ejecutar(new Peticion("informacion", null, null, null,null),jugador);
		
		//TODO: agregar assert que valide la salida por consola.
	}
	
	@Test
	public void queSeEjecuteMoverse() {
		
		Ubicacion hotel = new Ubicacion("hotel", 'M');
		Place cama = new Place("Cama", 'F', 'S');

		hotel.agregarPlace(cama);
		
		juego.generarEntorno();
		accion.ejecutar(new Peticion("moverse", hotel, null, null, null), jugador);
		Ubicacion ubicacion = jugador.getUbicacionActual();
		assertEquals("Estas en el hotel. Hay una Cama.", ubicacion.describir());
		
	}
	
// TODO: hay que revisar la accion dar pero Chain esta OK.
//	@Test
//	public void queSeEjecuteDar() {
//		
//		accion.ejecutar(new Peticion("dar",null,null, "espejo","fantasma"),jugador );
//	}
	
	
	
}
