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
	static private Ubicacion hotel;
	static private Ubicacion casa;

	@BeforeClass
	public static void before() {

		juego = new Juego();
		juego.generarEntorno();

		taberna = new Ubicacion("taberna", 'F');
		hotel = new Ubicacion("hotel",'M');
		casa = new Ubicacion("casa",'F');
		Place mesa = new Place("Suelo", 'M', 'S');
		Place cama = new Place("Cama",'F','S');

		mesa.agregarItem(new Item("cuchillo", 'M', 'S'));
		mesa.agregarItem(new Item("cerveza", 'F', 'S'));

		taberna.agregarPlace(mesa);
		hotel.agregarPlace(cama);
	}

	@Test
	public void moverseNotOK() {
		
		moverse = new Moverse(juego);
		moverse.accionar(taberna);
		Ubicacion ubicacion =  juego.getUbicacion();
		assertEquals("Estas en el muelle. Hay un Rincon. Se ve a lo lejos una taberna, y un hotel.", ubicacion.describir());
	}
	
	@Test
	public void invalidaUbicacion() {
		moverse = new Moverse(juego);
		moverse.accionar(casa);
		Ubicacion ubicacion = juego.getUbicacion();
		assertEquals("Estas en el muelle. Hay un Rincon. Se ve a lo lejos una taberna, y un hotel.", ubicacion.describir());
		/* deberia imprimir que no puedo moverme ahi*/
	}
	@Test
	public void moverseOK() {
		moverse = new Moverse(juego);
		moverse.accionar(hotel);
		Ubicacion ubicacion = juego.getUbicacion();
		assertEquals("Estas en el hotel. Hay una Cama.", ubicacion.describir());
	}
	

}
