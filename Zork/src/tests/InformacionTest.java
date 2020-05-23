package tests;


import acciones.Informacion;
import main.Juego;


import org.junit.Test;

public class InformacionTest {

	@Test
	public void test() {
		Juego juego = new Juego("Havacu");
		juego.setNombreJugador("Havacu");
		Informacion informacion= new Informacion(juego);
		informacion.accionar();
	}

}
