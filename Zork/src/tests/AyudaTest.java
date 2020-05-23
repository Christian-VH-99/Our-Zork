package tests;

import org.junit.Test;
import Ubicacion.Ubicacion;
import acciones.Ayuda;

import main.Juego;

public class AyudaTest {

	@Test
	public void test() {
		Juego juego = new Juego("Havacu");
		Ubicacion casa = new Ubicacion("casa",'F');
		juego.setLocation(casa);
		juego.setNombreJugador("Havacu");
		Ayuda ayuda = new Ayuda(juego);
		ayuda.accionar();
	}

}