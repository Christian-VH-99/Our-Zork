package tests;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Moverse;
import items.Item;
import main.Juego;

public class MoverseTest {

	static private Juego juego;
	private Moverse moverse;
	static private Ubicacion taberna;

	@BeforeClass
	public static void before() {

		juego = new Juego();
		juego.generarEntorno();

		taberna = new Ubicacion("taberna", 'F');
		Place mesa = new Place("Suelo", 'M', 'S');

		mesa.agregarItem(new Item("cuchillo", 'M', 'S'));
		mesa.agregarItem(new Item("cerveza", 'F', 'S'));

		taberna.agregarPlace(mesa);
	}

	@Test
	public void moverseATabernaOK() {
		
		moverse = new Moverse(juego);
		moverse.accionar(taberna);
		Ubicacion ubicacion =  juego.getUbicacion();
		assertEquals("Estas en la taberna. Hay un Suelo.", ubicacion.describir());
	}
	
	//TODO: agregar caso negarivo 

}
