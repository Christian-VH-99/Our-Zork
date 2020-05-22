package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Npc;

public class UbicacionTest {

	@Test
	public void test() {
		
		Ubicacion actual = new Ubicacion("pieza", 'F');
		Ubicacion u1 = new Ubicacion("terraza",'F');
		Ubicacion u2 = new Ubicacion("baño",'M');
		Conexion c1 = new Conexion(u1,"norte");
		Conexion c2 = new Conexion(u2,"sur","Fantasma");
		Item i1 = new Item("botella",'F','S');
		Item i2 = new Item("tarro de miel",'M','S');
		Item i3 = new Item("llaves",'F','P');
		
		Place p1 = new Place("mesa",'F','S');
		
		p1.agregarItem(i1);
		p1.agregarItem(i2);
		p1.agregarItem(i3);
		
		String descripcion = "- '¡No puedes pasar!' El pirata fantasma no te dejará pasar";
		String frase = "¡No hay nada que me digas que me haga cambiar de opinión!";
		
		Debilidad d1 = new Debilidad(i2," Me encanta la miel, te dejare pasar solo por esta vez","remover");
		Npc pj1 = new Npc("Covit",'M',descripcion, frase, d1, 'S');
		Npc pj = new Npc("Fantasma",'M',descripcion, frase, d1,'S');
		
		actual.agregarConexion(c1);
		actual.agregarConexion(c2);
		actual.agregarPlace(p1);
		actual.agregarNpc(pj1);
		actual.agregarNpc(pj);
		
		assertEquals("Estas en la pieza. Hay una mesa. Se ve a lo lejos una terraza, y un baño.", actual.describir());
		
		actual.getConexiones();
		actual.getNpcs();
		
		actual.removeNpc("Fantasma");
		
		System.out.println("////saque al fantasma/////");
		
		actual.getNpcs();
		
		assertTrue(c2.getHabilitado());
	}

}
