package acciones;

import javax.swing.JLabel;

import Ubicacion.Ubicacion;
import jugadores.Jugador;

public class Ayuda extends AccionBase {

	public Ayuda() {
		nombre = "ayuda";
	}

	@Override
	public String ejecutar(Peticion peticion, Jugador jugador, JLabel imagen) {

		if (peticion.getNombreAccion() == this.nombre) {

			Ubicacion ubicacionActual = jugador.getUbicacionActual();

			/* String */ salida = "estas ubicado en ";
			salida += ubicacionActual.getNombreGenero();
			salida += ". Puedes interactuar con todos los sitios e items que hay en este lugar\n"
					+ "para poder ver los sitios podes usar MIRAR LUGAR y para ver los items MIRAR 'nombre del sitio' \n"
					+ "tambien podes agarra los items del lugar con AGARRAR 'nombre de item' \n."
					+ "recuerda que para pasar por ciertos lugares necesitas items especificos.";
			return salida;
		} else {
			return this.accionSiguiente.ejecutar(peticion, jugador, imagen);
		}
	}
}
