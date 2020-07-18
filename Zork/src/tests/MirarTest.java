package tests;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

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
		Ubicacion casa = new Ubicacion("casa", 'F');
		Place mesa = new Place("mesa", 'F', 'S');
		Item botella = new Item("botella", 'F', 'S', 10);
		Item cuchillo = new Item("cuchillo", 'M', 'S', 10);

		mesa.agregarItem(botella);
		mesa.agregarItem(cuchillo);

		casa.agregarPlace(mesa);

		jugador.setUbicacionActual(casa);

		Mirar mirar = new Mirar();

		assertEquals("En la mesa hay una botella, y un cuchillo.",
				mirar.ejecutar(new Peticion("mirar", null, null, null, "mesa"), jugador, new JLabel()));

	}
}
