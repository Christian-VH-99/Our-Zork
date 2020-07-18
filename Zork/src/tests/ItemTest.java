package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Item;

public class ItemTest {

	@Test
	public void mascuinoSingular() {
		Item cuchillo = new Item("cuchillo", 'M', 'S', 10);

		assertEquals("cuchillo", cuchillo.getNombre());
		assertEquals("un cuchillo", cuchillo.toString());

	}

	@Test
	public void masculinoPlural() {
		Item platos = new Item("platos", 'M', 'P', 10);

		assertEquals("platos", platos.getNombre());
		assertEquals("unos platos", platos.toString());

	}

	@Test
	public void femeninoSingular() {
		Item botella = new Item("botella", 'F', 'S', 10);

		assertEquals("botella", botella.getNombre());
		assertEquals("una botella", botella.toString());

	}

	@Test
	public void femeninoPlural() {
		Item llaves = new Item("llaves", 'F', 'P', 10);

		assertEquals("llaves", llaves.getNombre());
		assertEquals("unas llaves", llaves.toString());

	}

}