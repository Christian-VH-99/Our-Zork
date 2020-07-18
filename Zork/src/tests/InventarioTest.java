package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Inventario;
import items.Item;

public class InventarioTest {

	@Test
	public void testInventory() {

		Inventario in = new Inventario();
		Item it1 = new Item("miel", 'F', 'S', 10);
		Item it2 = new Item("botella", 'F', 'S', 10);

		in.agregarItem(it1);
		in.agregarItem(it2);

		assertEquals(true, in.buscarItem("botella"));
		assertEquals(true, in.buscarItem("miel"));

		in.getItem("botella");
		assertEquals(false, in.buscarItem("botella"));

	}

}
