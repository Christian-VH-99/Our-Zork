package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import acciones.Peticion;
import jugadores.Jugador;
import main.EntornoGson;
import main.Juego;

public class FinalTest {

	private Jugador player;
	private Juego juego;
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

}
