package tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import acciones.Peticion;
import jugadores.Jugador;
import main.Juego;

public class FinalTest {

	private Jugador player;
	private Juego juego;

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



}
