package tests;


import acciones.Informacion;
import acciones.Peticion;
import jugadores.Jugador;


import org.junit.Test;

public class InformacionTest {

	@Test
	public void queSeMuestreLaInformacionEnConsola() {
		Jugador jugador = new Jugador("Havacu");
		Informacion informacion= new Informacion();
		informacion.ejecutar(new Peticion("informacion", null, null, null,null),jugador);
	}

}
