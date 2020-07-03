package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import Ubicacion.Place;
import Ubicacion.Ubicacion;
import acciones.Agarrar;
import acciones.Peticion;
import items.Item;

import jugadores.Jugador;


/**Probado con Patron*/
public class AgarrarTest {

	Ubicacion actual;
	Item i1;
	Place p1;
	Jugador jugador=new Jugador("test");
	@Before
	public void before() {
		actual = new Ubicacion("pieza", 'F');
		p1 = new Place("mesa", 'F', 'S');
		i1 = new Item("miel", 'F', 'S');
		actual.agregarPlace(p1);
		p1.agregarItem(i1);
		jugador.setUbicacionActual(actual);
	}

	@Test
	public void queSePuedaAgarrarUnObjetoExist() {
		Agarrar agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar",null, "miel", null,null), jugador);
		assertEquals("En tu inventario hay: una miel.", jugador.getInventario().listarItems());
	}


	@Test
	public void queNoSePuedaAgarrarUnObjetoInexist() {
		
		Agarrar agarrar = new Agarrar();
		agarrar.ejecutar(new Peticion("agarrar", null, "asd", null ,null), jugador);//asd no existe
		assertEquals("No posees objetos en tu inventario.", jugador.getInventario().listarItems());
		/* no deberia agregar nada al inventario, e imprime que el objeto no existe */
		//TODO: agregar assert que compruebe la salida por consola
			//El objeto que quiere agarrar no existe
	}
}
