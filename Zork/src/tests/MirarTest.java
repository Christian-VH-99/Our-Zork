package tests;
import org.junit.Test;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Mirar;
import items.Item;
import jugadores.Jugador;


public class MirarTest {
	
	@Test
	public void test() {
		System.out.println("test1");
		Jugador jugador = new Jugador("Havacu");
		Ubicacion casa = new Ubicacion("casa",'F');
		Place mesa = new Place("mesa",'F','S');
		Place mueble = new Place("mueble",'M','S');
		Item botella = new Item("botella",'F','S');
		Item cuchillo = new Item("cuchillo",'M','S');
		Item pintura = new Item("pintura",'F','S');
		
		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);
		mueble.agregarItem(pintura);
		casa.agregarPlace(mesa);
		casa.agregarPlace(mueble);
		jugador.setUbicacionActual(casa);
		Mirar mirar = new Mirar(jugador);
		
		mirar.accionar();
		mirar.accionar(mesa);		
	}
}


