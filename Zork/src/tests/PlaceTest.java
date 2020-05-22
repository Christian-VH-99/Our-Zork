package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Place;
import items.Item;

public class PlaceTest {

	static private Item i1;
	static private Item i2;
	static private Item i3;
	static private Item i4;
	static private Place p1;
	static private Place p2;

	@BeforeClass
	public static void before() {
		i1 = new Item("botella", 'F', 'S');
		i2 = new Item("tarro", 'M', 'S');
		i3 = new Item("llaves", 'F', 'P');
	}

	@Test
	public void listarItemsTest() {

		p1 = new Place("mesa", 'F', 'S');
		p2 = new Place("suelo", 'M', 'S');

		p1.agregarItem(i1);
		p1.agregarItem(i2);
		p1.agregarItem(i3);

		assertEquals("En la mesa hay una botella, un tarro, y unas llaves.", p1.listarItems());

		i4 = p1.getItem("botella");
		assertEquals("En la mesa hay un tarro, y unas llaves.", p1.listarItems());

		p2.agregarItem(i4);
		assertEquals("En el suelo hay una botella.", p2.listarItems());
	}

	@Test
	public void getItemTest() {

		p1 = new Place("mesa", 'F', 'S');
		p2 = new Place("suelo", 'M', 'S');

		p1.agregarItem(i1);
		p1.agregarItem(i2);
		p1.agregarItem(i3);

		i4 = p1.getItem("botella");
		assertEquals("En la mesa hay un tarro, y unas llaves.", p1.listarItems()); // valido que se saco del lugar
		assertEquals("botella", i4.getNombre()); // valido que se saco del lugar

	}

	@Test
	public void toStringTest() {
		
		p1 = new Place("mesa", 'F', 'S');
		
		p1.agregarItem(i1);
		p1.agregarItem(i2);
		p1.agregarItem(i3);
		
		assertEquals("una mesa", p1.toString());
	}
}
