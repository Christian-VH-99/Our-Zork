package tests;


import acciones.Informacion;
import jugadores.Jugador;
import main.Juego;


import org.junit.Test;

public class InformacionTest {

	@Test
	public void test() {
		Jugador jugador = new Jugador("Havacu");
		Informacion informacion= new Informacion(jugador);
		informacion.accionar();
	}

}
