package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Npc;


public class UbicacionTest {
	Ubicacion actual;
	Ubicacion u1;
	Item i1;
	Place p1;
	Debilidad d1;
	Npc pj1;
	@Before
	public void before() {
		actual = new Ubicacion("pieza", 'F');
		u1 = new Ubicacion("terraza", 'F');
		p1 = new Place("mesa", 'F', 'S');
		i1 = new Item("miel", 'F', 'S');
		actual.agregarPlace(p1);
		actual.agregarConexion(new Conexion(u1, Direcciones.NORTE));
		d1 = new Debilidad(i1, " Me encanta la miel, te dejare pasar solo por esta vez", "remover");
		pj1 = new Npc("Covit", 'M', "- No podras pasar", "a", d1, 'S');
		p1.agregarItem(i1);
		actual.agregarNpc(pj1);
	}
	
	@Test
	public void testDescripcion() {
		assertEquals("Estas en la pieza. Hay una mesa. Se ve a lo lejos una terraza. - No podras pasar.",actual.describir());
		actual.getConexiones();
		actual.listarNpcs();
		

		System.out.println("////saque al fantasma/////");

		actual.listarNpcs();
	}

	@Test
	public void testEliminarNPC() {
		actual.removeNpc("Covit");
		assertEquals("Estas en la pieza. Hay una mesa. Se ve a lo lejos una terraza.",actual.describir());
	}
}
