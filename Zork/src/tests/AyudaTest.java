package tests;

import org.junit.Test;
import Ubicacion.Ubicacion;
import acciones.Ayuda;
import jugadores.Jugador;
import main.Juego;

public class AyudaTest {

	@Test
	public void test() {
//		Juego juego = new Juego("Havacu");
//		Juego juego = new Juego(jugador);
		Jugador jugador = new Jugador("Juanito");
		Ubicacion casa = new Ubicacion("casa",'F');
		jugador.setUbicacionActual(casa);
		jugador.setNombre("Havacu");
		Ayuda ayuda = new Ayuda(jugador);
		ayuda.accionar();
	}

}