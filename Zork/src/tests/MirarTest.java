package tests;
import org.junit.Test;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Mirar;
import acciones.Peticion;
import items.Item;
import jugadores.Jugador;

public class MirarTest {
	
	@Test
	public void queSePuedaMirarUnPlace() {
		
		Jugador jugador = new Jugador("Havacu");
		Ubicacion casa = new Ubicacion("casa",'F');
		Place mesa = new Place("mesa",'F','S');
		Item botella = new Item("botella",'F','S');
		Item cuchillo = new Item("cuchillo",'M','S');
		
		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);
		
		casa.agregarPlace(mesa);
		
		jugador.setUbicacionActual(casa);
			
		Mirar mirar = new Mirar();
		mirar.ejecutar(new Peticion(mesa, "mirar"), jugador);
		/*TODO: comprobar salida por consola*/
		
	}
}


