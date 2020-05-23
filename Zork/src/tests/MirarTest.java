package tests;

import org.junit.Test;

import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Mirar;
import items.Item;
import main.Juego;

public class MirarTest {

	
	@Test
	public void test() {
		System.out.println("test1");
		Juego juego = new Juego("Havacu");
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
		juego.setLocation(casa);
		Mirar mirar = new Mirar(juego);
		
		mirar.accionar();
		mirar.accionar(mesa);		
	}
}


