package tests;

import org.junit.Test;
import Ubicacion.Ubicacion;
import acciones.Ayuda;
import acciones.Peticion;
import jugadores.Jugador;

public class AyudaTest {

	@Test
	public void queSeMuestreMensajeDeAyuda() {
		
		Jugador jugador = new Jugador("Juanito");
		Ubicacion casa = new Ubicacion("casa",'F');
		jugador.setUbicacionActual(casa);
		jugador.setNombre("Havacu");
		Ayuda ayuda = new Ayuda();
		ayuda.ejecutar(new Peticion("ayuda", null, null, null,null),jugador);
		
		//TODO: probar salida por consola.
	}

}