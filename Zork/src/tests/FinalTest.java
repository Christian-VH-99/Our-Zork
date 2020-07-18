package tests;

import static org.junit.Assert.*;

<<<<<<< HEAD
=======

>>>>>>> Ramiro
import org.junit.Before;
import org.junit.Test;

import acciones.Peticion;
import jugadores.Jugador;
<<<<<<< HEAD
import main.EntornoGson;
=======
>>>>>>> Ramiro
import main.Juego;

public class FinalTest {

	private Jugador player;
	private Juego juego;
<<<<<<< HEAD
	@Before
	public void before() {
		player = new Jugador("pepito");
		juego = new Juego(player);
		EntornoGson entorno = new EntornoGson();
		entorno.deserializar();
		juego.setFinales(entorno.getFinales());
	}
	@Test
	public void final1() {
	Peticion p1 = new Peticion("dar", null, "Exodia", "Yugi", null);
	assertEquals(juego.getEsFinDeJuego(p1,player),true);
	}
	@Test
	public void final2() {
		Peticion p1 = new Peticion("dar",null,"Anj","Isis",null);
		assertEquals(juego.getEsFinDeJuego(p1,player),true);
	}
	@Test
	public void final3() {
		Peticion p1 = new Peticion("usar",null,"espada",null,null);
		assertEquals(juego.getEsFinDeJuego(p1,player),true);
	}
	@Test
	public void final4() {
		Peticion p1 = new Peticion("usar",null,"daga",null,null);
		assertEquals(juego.getEsFinDeJuego(p1,player),true);
	}

=======

	@Before
	public void before() {
		juego = new Juego("pepito", "muelle.json");
	}

	@Test
	public void finalValido() {
		juego.setPeticion(new Peticion("agarrar", null, "espejo", null, null));
		juego.procesarComando(player);
		Peticion queseyo=new Peticion("usar", null, "espejo", null, null);
		queseyo.setEjecuto(true);
		assertTrue(juego.getEsFinDeJuego(queseyo, juego.getJugador()));
	}

	@Test
	public void finalInvalidoNoTenes() {
		assertFalse(juego.getEsFinDeJuego(new Peticion("usar", null, "espejo", null, null),juego.getJugador()));
	}

	@Test
	public void finalInvalidoNoSeValido() {
		juego.setPeticion(new Peticion("agarrar", null, "espejo", null, null));
		juego.procesarComando(player);
		Peticion queseyo=new Peticion("usar", null, "espejo", null, null);
		assertFalse(juego.getEsFinDeJuego(queseyo, juego.getJugador()));
	}



>>>>>>> Ramiro
}
