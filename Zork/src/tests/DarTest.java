package tests;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import Ubicacion.Conexion;
import Ubicacion.Direcciones;
import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Dar;
import acciones.Peticion;
import items.Item;
import jugadores.Debilidad;
import jugadores.Jugador;
import jugadores.Npc;

// TODO: revisar esta accion, no esta claro lo que hace.
public class DarTest {
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
		i1 = new Item("miel", 'F', 'S', 10);
		actual.agregarPlace(p1);
		actual.agregarConexion(new Conexion(u1, Direcciones.NORTE));
		d1 = new Debilidad(i1, " Me encanta la miel, te dejare pasar solo por esta vez", "remover");
		pj1 = new Npc("Covit", 'M', "- No podras pasar", "a", d1, 'S');
		p1.agregarItem(i1);
		actual.agregarNpc(pj1);
		jugador.setUbicacionActual(actual);
		jugador.getInventario().agregarItem(i1);
	}

	@Test
	public void testDarAlgoQueNoTenes() {

		Dar dar = new Dar();
		dar.ejecutar(new Peticion("dar", null, "cerveza", "Covit", null), jugador, new JLabel());
		assertEquals("Covit ", jugador.getUbicacionActual().listarNpcs());
	}

	@Test
	public void testDarAlgoQueTenes() {

		Dar dar = new Dar();
		assertEquals(true, jugador.getInventario().buscarItem("miel"));
		dar.ejecutar(new Peticion("dar", null, "miel", "Covit", null), jugador, new JLabel());
		assertEquals(false, jugador.getInventario().buscarItem("miel"));

	}

}
