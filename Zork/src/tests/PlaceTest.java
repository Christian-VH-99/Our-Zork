package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Place;
import items.Item;

public class PlaceTest {

	 private Item i1;
	 private Item i2;
	 private Item i3;
	 private Item i4;
	 private Place p1;

	@Before
	public void before() {
		i1 = new Item("botella",'F','S');
		i2 = new Item("tarro",'M','S');
		i3 = new Item("llaves",'F','P');
		
		p1 = new Place("mesa", 'F', 'S');
	
		p1.agregarItem(i1);
		p1.agregarItem(i2);
		p1.agregarItem(i3);

	}

	@Test
	public void listarItemsTest() {

		assertEquals("En la mesa hay una botella, un tarro, y unas llaves.", p1.listarItems());
		
	}

	@Test
	public void getItemTest() {
		i4 = p1.getItem("botella");
		assertEquals("En la mesa hay un tarro, y unas llaves.", p1.listarItems()); // valido que se saco del lugar
		assertEquals("botella", i4.getNombre()); // valido que se saco del lugar
	}

	@Test
	public void toStringTest() {
		assertEquals("una mesa", p1.toString());
	}
}



