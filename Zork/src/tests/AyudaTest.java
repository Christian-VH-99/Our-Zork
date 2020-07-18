package tests;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

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
		
		String salida = "estas ubicado en ";
		salida += jugador.getUbicacionActual().getNombreGenero();
		salida += ". Puedes interactuar con todos los sitios e items que hay en este lugar\n"
				+ "para poder ver los sitios podes usar MIRAR LUGAR y para ver los items MIRAR 'nombre del sitio' \n"
				+ "tambien podes agarra los items del lugar con AGARRAR 'nombre de item' \n."
				+ "recuerda que para pasar por ciertos lugares necesitas items especificos.";
		
		assertEquals(salida,ayuda.ejecutar(new Peticion("ayuda"), jugador,new JLabel()));
		
	}

}