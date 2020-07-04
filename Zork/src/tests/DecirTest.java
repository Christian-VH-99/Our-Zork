package tests;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Decir;
import acciones.Peticion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;

public class DecirTest {

	Ubicacion actual;
	Ubicacion u1;
	Item i1;
	Place p1;
	Debilidad d1;
	Npc pj1;
	Jugador jugador = new Jugador("test");

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
		/*Dialogos*/
		pj1.addSentenciaYRespuesta("opcionA", "pasare igual, forro", "Te voy a matar aashh");
		pj1.addSentenciaYRespuesta("opcionB", "Maldito Covit, movete!", "Te voy a matar aashh");
		/*-------------------------------------------------------*/
		
		actual.agregarNpc(pj1);
		jugador.setUbicacionActual(actual);
		jugador.getInventario().agregarItem(i1);
	}
	@Test
	public void queSePuedaHacerUnDialogoConUnNPC() {
		
		Decir decir = new Decir();
		decir.ejecutar(new Peticion("decir", "opcionA", "Covit"),jugador);
		
	}
}
